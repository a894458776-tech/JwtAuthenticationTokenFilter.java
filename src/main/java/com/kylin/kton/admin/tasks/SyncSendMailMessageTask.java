/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.mail.EmailUtils
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  com.kylin.kton.system.domain.KtonMessageRecords
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.transaction.annotation.Transactional
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.tasks.mapper.TaskIpStaticMerchantMapper;
import com.kylin.kton.admin.tasks.mapper.TaskMerchantMapper;
import com.kylin.kton.admin.tasks.mapper.TaskMessageRecordMapper;
import com.kylin.kton.common.utils.mail.EmailUtils;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import com.kylin.kton.system.domain.KtonMessageRecords;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SimpleTimeZone;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SyncSendMailMessageTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncSendMailMessageTask.class);
    @Autowired
    private EmailUtils emailUtils;
    @Autowired
    private TaskIpStaticMerchantMapper merchantIpMapper;
    @Autowired
    private TaskMerchantMapper merchantMapper;
    @Autowired
    private TaskMessageRecordMapper messageRecordMapper;

    public void toSendMailMessage() {
        log.info("start sync send mail message start  ...");
        this.checkAndSendExpiryNotifications();
        log.info("start sync  send mail message end ...");
    }

    @Transactional
    public void checkAndSendExpiryNotifications() {
        LocalDateTime cutoffDate = LocalDateTime.now().plus(3L, ChronoUnit.DAYS);
        List<Long> merchantIds = this.merchantIpMapper.findMerchantIdsWithExpiringIps(cutoffDate);
        Set<Long> notifiedMerchants = this.getNotifiedMerchants(merchantIds);
        merchantIds.removeIf(notifiedMerchants::contains);
        if (merchantIds.isEmpty()) {
            System.out.println("\u6ca1\u6709\u9700\u8981\u901a\u77e5\u7684\u5546\u6237");
            return;
        }
        Map<Long, String> merchantEmails = this.getMerchantEmails(merchantIds);
        List<KtonIpStaticMerchant> expiringIps = this.merchantIpMapper.findExpiringIpsByMerchantIds(merchantIds, cutoffDate);
        Map<Long, List<KtonIpStaticMerchant>> expiringIpsByMerchant = this.groupIpsByMerchant(expiringIps);
        for (Long merchantId : merchantIds) {
            String email = merchantEmails.get(merchantId);
            if (email == null || email.trim().isEmpty()) {
                System.out.println("\u5546\u6237ID " + merchantId + " \u6ca1\u6709\u6709\u6548\u7684\u90ae\u7bb1\u5730\u5740");
                continue;
            }
            List<KtonIpStaticMerchant> ips = expiringIpsByMerchant.getOrDefault(merchantId, Collections.emptyList());
            if (ips.isEmpty()) continue;
            String content = this.buildExpiryEmailContent(ips);
            boolean sendResult = this.emailUtils.sendSimpleMail(email, "IP\u5730\u5740\u5373\u5c06\u8fc7\u671f\u63d0\u9192", content);
            if (sendResult) {
                this.recordNotification(merchantId, content);
                System.out.println("\u5df2\u53d1\u9001\u63d0\u9192\u90ae\u4ef6\u81f3: " + email + " (\u5546\u6237ID: " + merchantId + ")");
                continue;
            }
            System.out.println("\u90ae\u4ef6\u53d1\u9001\u5931\u8d25\uff0c\u5546\u6237ID: " + merchantId);
        }
    }

    private String buildExpiryEmailContent(List<KtonIpStaticMerchant> expiringIps) {
        StringBuilder content = new StringBuilder("\u5c0a\u656c\u7684\u5546\u6237\uff0c\u60a8\u6709\u4ee5\u4e0bIP\u5730\u5740\u5373\u5c06\u8fc7\u671f\uff1a\n\n");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(SimpleTimeZone.getDefault());
        for (KtonIpStaticMerchant ip : expiringIps) {
            content.append("- ").append(ip.getIp()).append(" (\u8fc7\u671f\u65f6\u95f4: ").append(sdf.format(ip.getExpireDatetime())).append(")\n");
        }
        content.append("\n\u8bf7\u53ca\u65f6\u5904\u7406\u4ee5\u907f\u514d\u670d\u52a1\u4e2d\u65ad\u3002");
        return content.toString();
    }

    private void recordNotification(Long merchantId, String content) {
        KtonMessageRecords record = new KtonMessageRecords();
        record.setContent(content);
        record.setSourceId(merchantId.toString());
        record.setMessageType("EMAIL_EXPIRE");
        record.setCreateTime(new Date());
        this.messageRecordMapper.insertMessageRecord(record);
    }

    private Map<Long, String> getMerchantEmails(List<Long> merchantIds) {
        if (merchantIds.isEmpty()) {
            return Collections.emptyMap();
        }
        List<Map<String, Object>> results = this.merchantMapper.findEmailsByIds(merchantIds);
        HashMap<Long, String> emailMap = new HashMap<Long, String>();
        for (Map<String, Object> result : results) {
            Long merchantId = ((Number)result.get("id")).longValue();
            String email = (String)result.get("email");
            emailMap.put(merchantId, email);
        }
        return emailMap;
    }

    private Set<Long> getNotifiedMerchants(List<Long> merchantIds) {
        if (merchantIds.isEmpty()) {
            return Collections.emptySet();
        }
        List<Long> notifiedIds = this.messageRecordMapper.findMerchantIdsWithNotificationType(merchantIds, "EMAIL_EXPIRE");
        return new HashSet<Long>(notifiedIds);
    }

    private Map<Long, List<KtonIpStaticMerchant>> groupIpsByMerchant(List<KtonIpStaticMerchant> ips) {
        HashMap<Long, List<KtonIpStaticMerchant>> result = new HashMap<Long, List<KtonIpStaticMerchant>>();
        for (KtonIpStaticMerchant ip : ips) {
            result.computeIfAbsent(ip.getMerchantId(), k -> new ArrayList()).add(ip);
        }
        return result;
    }

    @Generated
    public SyncSendMailMessageTask() {
    }
}

