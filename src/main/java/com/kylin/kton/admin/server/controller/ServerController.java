package com.kylin.kton.admin.server.controller;

import com.kylin.kton.admin.server.domain.SysServer;
import com.kylin.kton.admin.server.service.ServerService;
import com.kylin.kton.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController("adminServerController")
@RequestMapping("/admin")
public class ServerController {

    @Autowired
    private ServerService serverService;

    @GetMapping("/server/list")
    public AjaxResult list() {
        List<SysServer> list = serverService.getServerList();
        return AjaxResult.success(list);
    }

    // 创建实例订单 (同时调用上游 API 开通)
    @PostMapping("/order/create_api_instance")
    public AjaxResult createApiInstance(@RequestBody Map<String, Object> params) {
        try {
            Long merchantId = Long.valueOf(params.get("merchantId").toString());
            String nodeIp = (String) params.get("nodeIp"); // 目标服务器IP
            String username = (String) params.get("username");
            String password = (String) params.get("password");
            Integer days = Integer.valueOf(params.get("days").toString());
            String remark = (String) params.get("remark");

            // ⭐ 新增：必须传入要开通的 IP，因为上游接口 /addStatic 需要 ips 参数
            // 如果是随机分配，您需要在 Service 内部处理，这里假设前端指定了 IP
            String assignedIp = (String) params.get("assignedIp");
            if (assignedIp == null) {
                // 如果前端没传，暂时用 "0.0.0.0" 或抛错，视业务而定
                assignedIp = "0.0.0.0";
            }

            serverService.createApiInstanceOrder(merchantId, nodeIp, username, password, assignedIp, days, remark);
            return AjaxResult.success("Order created and API provisioned successfully");
        } catch (Exception e) {
            e.printStackTrace();
            return AjaxResult.error("Failed to create order: " + e.getMessage());
        }
    }

    // 续费实例 (同时调用上游 API 续费)
    @PostMapping("/order/renew_api")
    public AjaxResult renewApiInstance(@RequestBody Map<String, Object> params) {
        try {
            String username = (String) params.get("username");
            Integer days = Integer.valueOf(params.get("days").toString());
            // 转换为月数 (上游接口是按月续费 monthCount，或者您可以修改 Service 逻辑适配天数)
            // 这里假设 days = 30 就是 1 个月
            int monthCount = days / 30;
            if (monthCount < 1) monthCount = 1;

            serverService.renewApiInstance(username, days, monthCount);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error("Renew failed: " + e.getMessage());
        }
    }

    @PostMapping("/order/update_api_info")
    public AjaxResult updateApiInfo(@RequestBody Map<String, Object> params) {
        String oldUsername = (String) params.get("oldUsername");
        String newUsername = (String) params.get("newUsername");
        String password = (String) params.get("password");
        String note = (String) params.get("note");

        if (oldUsername == null || oldUsername.isEmpty()) {
            oldUsername = newUsername;
        }
        if (oldUsername == null) {
            return AjaxResult.error("参数错误：用户名不能为空");
        }

        serverService.updateApiInstance(oldUsername, newUsername, password, note);
        return AjaxResult.success("Update successful");
    }

    // 退订实例 (同时调用上游 API 退订)
    @PostMapping("/order/unsubscribe_api")
    public AjaxResult unsubscribeApi(@RequestBody Map<String, Object> params) {
        try {
            String username = (String) params.get("username");
            serverService.unsubscribeApiInstance(username);
            return AjaxResult.success();
        } catch (Exception e) {
            return AjaxResult.error("Unsubscribe failed: " + e.getMessage());
        }
    }
}