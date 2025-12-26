package com.kylin.kton.admin.server.service;

import com.kylin.kton.admin.server.domain.SysApiInstance;
import com.kylin.kton.admin.server.domain.SysServer;
import com.kylin.kton.admin.server.mapper.ApiInstanceMapper;
import com.kylin.kton.admin.server.mapper.ServerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class ServerService {

    @Autowired
    private ServerMapper serverMapper;

    @Autowired
    private ApiInstanceMapper apiInstanceMapper;

    // 建议把 RestTemplate 放在配置类里，这里暂时由 Service 自身管理
    private RestTemplate restTemplate = new RestTemplate();

    public List<SysServer> getServerList() {
        return serverMapper.selectServerList();
    }

    // ⭐ 1. 创建订单 (修正：调用节点的 /api/add)
    @Transactional
    public void createApiInstanceOrder(Long merchantId, String nodeIp, String username, String password, String assignedIp, int days, String remark) {
        // 1. 查找目标服务器信息
        SysServer server = serverMapper.selectServerByIp(nodeIp);
        if (server == null) {
            throw new RuntimeException("Target server node (" + nodeIp + ") does not exist.");
        }

        // ⭐⭐⭐ 修正点：这里的 URL 必须是 Python 节点的真实路径 /api/add
        String url = String.format("http://%s:%d/api/add", server.getIp(), server.getPort());

        // 2. 构造 Python 节点需要的参数 (根据您之前的 openAPI 定义)
        Map<String, Object> payload = new HashMap<>();
        payload.put("token", server.getToken()); // 服务器 Token

        // 模式判断：如果指定了IP，使用 batch_fixed，否则用 manual 或 batch
        if (assignedIp != null && !assignedIp.isEmpty() && !"0.0.0.0".equals(assignedIp)) {
            payload.put("mode", "batch_fixed");
            payload.put("ip", assignedIp);
        } else {
            payload.put("mode", "manual"); // 或者 "batch"
        }

        payload.put("merchant_id", String.valueOf(merchantId));
        payload.put("username", username);
        payload.put("password", password);
        payload.put("days", days);
        payload.put("count", 1);
        payload.put("note", remark);

        // 3. 发送请求
        Map response = sendPostRequest(url, payload);

        // Python 节点通常返回 status code 200 或 JSON 里的 code
        // 这里根据您的报错信息，看起来是直接根据 HTTP 状态码判断的
        // 如果没有抛出异常，说明 http 请求成功

        // 4. 上游成功后，写入本地数据库
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, days);
        Date expireTime = c.getTime();

        SysApiInstance instance = new SysApiInstance();
        instance.setMerchantId(merchantId);
        instance.setServerId(server.getId());
        instance.setUsername(username);
        instance.setPassword(password);
        instance.setAssignedIp(assignedIp);
        instance.setNote(remark);
        instance.setExpireTime(expireTime);

        apiInstanceMapper.insertInstance(instance);
    }

    // ⭐ 2. 续费 (修正：调用节点的 /api/renew)
    public void renewApiInstance(String username, int addDays, int monthCount) {
        SysApiInstance instance = apiInstanceMapper.selectByUsername(username);
        if (instance == null) throw new RuntimeException("Local instance not found for user: " + username);

        SysServer server = serverMapper.selectServerById(instance.getServerId());
        if (server == null) throw new RuntimeException("Associated server not found.");

        // ⭐⭐⭐ 修正点：路径改为 /api/renew
        String url = String.format("http://%s:%d/api/renew", server.getIp(), server.getPort());

        Map<String, Object> payload = new HashMap<>();
        payload.put("token", server.getToken());
        payload.put("username", username);
        payload.put("days", addDays); // 注意：Python节点如果是按天续费传days，按月传months，请根据实际情况调整

        sendPostRequest(url, payload);

        // 更新本地
        Calendar c = Calendar.getInstance();
        c.setTime(instance.getExpireTime());
        c.add(Calendar.DAY_OF_MONTH, addDays);
        apiInstanceMapper.renewInstance(username, c.getTime());
    }

    public void updateApiInstance(String oldUsername, String newUsername, String password, String note) {
        // 编辑操作通常先更本地，Python端如果有 /api/update 也可以在这里调
        apiInstanceMapper.updateInstanceInfo(oldUsername, newUsername, password, note);
    }

    // ⭐ 3. 退订 (修正：调用节点的 /api/del)
    public void unsubscribeApiInstance(String username) {
        SysApiInstance instance = apiInstanceMapper.selectByUsername(username);
        if (instance == null) throw new RuntimeException("Local instance not found.");

        SysServer server = serverMapper.selectServerById(instance.getServerId());
        if (server == null) throw new RuntimeException("Server not found.");

        // ⭐⭐⭐ 修正点：路径改为 /api/del
        String url = String.format("http://%s:%d/api/del", server.getIp(), server.getPort());

        Map<String, Object> payload = new HashMap<>();
        payload.put("token", server.getToken());
        payload.put("username", username);
        payload.put("ip", instance.getAssignedIp());

        sendPostRequest(url, payload);

        apiInstanceMapper.deleteInstance(username);
    }

    // --- HTTP 工具方法 ---
    private Map sendPostRequest(String url, Map<String, Object> params) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Map<String, Object>> request = new HttpEntity<>(params, headers);
        try {
            // 这里仅仅是发送请求，如果对方返回 200 OK，就认为成功
            // 如果对方返回 422/500，restTemplate 会抛出 HttpClientErrorException
            return restTemplate.postForEntity(url, request, Map.class).getBody();
        } catch (Exception e) {
            // 打印日志以便调试
            System.err.println("Error calling upstream: " + url);
            e.printStackTrace();
            throw new RuntimeException("Network error calling " + url + ": " + e.getMessage());
        }
    }
}