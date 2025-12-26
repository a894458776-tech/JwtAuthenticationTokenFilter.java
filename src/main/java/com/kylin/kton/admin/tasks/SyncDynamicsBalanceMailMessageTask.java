/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.common.utils.mail.EmailUtils
 *  com.kylin.kton.system.domain.KtonMessageRecords
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Component
 *  org.springframework.transaction.annotation.Transactional
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.account.service.IpDynamicsAccountBalanceService;
import com.kylin.kton.admin.tasks.entity.dto.MerchantInsufficientDataDTO;
import com.kylin.kton.admin.tasks.mapper.TaskAccountBalanceDao;
import com.kylin.kton.admin.tasks.mapper.TaskIpStaticMerchantMapper;
import com.kylin.kton.admin.tasks.mapper.TaskMerchantMapper;
import com.kylin.kton.admin.tasks.mapper.TaskMessageRecordMapper;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.common.utils.mail.EmailUtils;
import com.kylin.kton.system.domain.KtonMessageRecords;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

@Component
public class SyncDynamicsBalanceMailMessageTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncDynamicsBalanceMailMessageTask.class);
    @Autowired
    private EmailUtils emailUtils;
    @Autowired
    private TaskIpStaticMerchantMapper merchantIpMapper;
    @Autowired
    private TaskMerchantMapper merchantMapper;
    @Autowired
    private TaskMessageRecordMapper messageRecordMapper;
    @Autowired
    IpDynamicsAccountBalanceService dynamicsAccountBalanceService;
    @Autowired
    TaskAccountBalanceDao taskAccountBalanceDao;

    public void toSendMailMessage() {
        log.info("start sync send dynamics balance mail message start  ...");
        this.checkAndSendExpiryNotifications();
        log.info("start sync  send dynamics balance mail message end ...");
    }

    @Transactional
    public void checkAndSendExpiryNotifications() {
        this.dynamicsAccountBalanceService.listUnupdatedAccounts();
        List<MerchantInsufficientDataDTO> insufficientAccounts = this.taskAccountBalanceDao.listMerchantsWithInsufficientData();
        if (CollectionUtils.isEmpty(insufficientAccounts)) {
            log.info("\u6ca1\u6709\u53d1\u73b0\u6d41\u91cf\u4e0d\u8db3\u7684\u5b50\u8d26\u6237\uff0c\u65e0\u9700\u53d1\u9001\u901a\u77e5");
            return;
        }
        Map<Long, List<MerchantInsufficientDataDTO>> merchantsWithInsufficientAccounts = insufficientAccounts.stream().collect(Collectors.groupingBy(MerchantInsufficientDataDTO::getMerchantId));
        ArrayList<Long> merchantIds = new ArrayList<Long>(merchantsWithInsufficientAccounts.keySet());
        Set<Long> notifiedMerchants = this.getNotifiedMerchantsWithinThreeDays(merchantIds);
        merchantIds.removeAll(notifiedMerchants);
        if (merchantIds.isEmpty()) {
            log.info("\u6240\u6709\u6d41\u91cf\u4e0d\u8db3\u7684\u5546\u6237\u8fd1\u4e09\u5929\u5185\u90fd\u5df2\u53d1\u9001\u8fc7\u901a\u77e5\uff0c\u65e0\u9700\u91cd\u590d\u53d1\u9001");
            return;
        }
        Map<Long, String> merchantEmails = this.getMerchantEmails(merchantIds);
        for (Long merchantId : merchantIds) {
            String email = merchantEmails.get(merchantId);
            if (StringUtils.isEmpty((String)email)) {
                log.warn("\u5546\u6237ID:{} \u90ae\u7bb1\u5730\u5740\u4e3a\u7a7a\uff0c\u65e0\u6cd5\u53d1\u9001\u901a\u77e5", (Object)merchantId);
                continue;
            }
            List<MerchantInsufficientDataDTO> accounts = merchantsWithInsufficientAccounts.get(merchantId);
            String emailContent = this.buildEmailContent(accounts);
            try {
                this.emailUtils.sendSimpleMail(email, "\u6d41\u91cf\u4e0d\u8db3\u63d0\u9192", emailContent);
                this.recordNotification(merchantId, emailContent);
                log.info("\u5df2\u6210\u529f\u5411\u5546\u6237ID:{} \u53d1\u9001\u6d41\u91cf\u4e0d\u8db3\u901a\u77e5", (Object)merchantId);
            }
            catch (Exception e) {
                log.error("\u5411\u5546\u6237ID:{} \u53d1\u9001\u6d41\u91cf\u4e0d\u8db3\u901a\u77e5\u5931\u8d25", (Object)merchantId, (Object)e);
            }
        }
    }

    private String buildEmailContent(List<MerchantInsufficientDataDTO> accounts) {
        if (CollectionUtils.isEmpty(accounts)) {
            return "";
        }
        StringBuilder content = new StringBuilder();
        MerchantInsufficientDataDTO firstAccount = accounts.get(0);
        content.append("\u5c0a\u656c\u7684 ").append(firstAccount.getMerchantName()).append(" (").append(firstAccount.getCompanyName()).append(")\uff0c\u60a8\u597d\uff1a\n\n");
        content.append("\u60a8\u7684\u4ee5\u4e0b\u8d26\u53f7\u6d41\u91cf\u5373\u5c06\u7528\u5c3d\uff0c\u8bf7\u53ca\u65f6\u5904\u7406\uff1a\n\n");
        for (MerchantInsufficientDataDTO account : accounts) {
            content.append("- \u8d26\u53f7\uff1a").append(account.getAccountLabel()).append(" (").append(account.getChannelLabel()).append(")\n").append("  \u5f53\u524d\u6d41\u91cf\uff1a").append(account.getBalanceFormat()).append(" \n").append("  \u9608\u503c\uff1a").append(account.getThreshold()).append(" GB\n\n");
        }
        content.append("\u4e3a\u907f\u514d\u5f71\u54cd\u6b63\u5e38\u4f7f\u7528\uff0c\u8bf7\u53ca\u65f6\u4e3a\u8d26\u53f7\u5145\u503c\u6216\u8c03\u6574\u6d41\u91cf\u5957\u9910\u3002\n\n").append("\u5982\u6709\u7591\u95ee\uff0c\u8bf7\u8054\u7cfb\u5ba2\u670d\u3002\n").append("\u611f\u8c22\u60a8\u7684\u652f\u6301\uff01");
        return content.toString();
    }

    private void recordNotification(Long merchantId, String content) {
        KtonMessageRecords record = new KtonMessageRecords();
        record.setContent(content);
        record.setSourceId(merchantId.toString());
        record.setMessageType("DYNAMICS_BALANCE_EMAIL_EXPIRE");
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

    private Set<Long> getNotifiedMerchantsWithinThreeDays(List<Long> merchantIds) {
        if (merchantIds.isEmpty()) {
            return Collections.emptySet();
        }
        Date threeDaysAgo = Date.from(LocalDateTime.now().minus(3L, ChronoUnit.DAYS).atZone(ZoneId.systemDefault()).toInstant());
        List<Long> notifiedIds = this.messageRecordMapper.findMerchantIdsWithRecentNotification(merchantIds, "DYNAMICS_BALANCE_EMAIL_EXPIRE", threeDaysAgo);
        return new HashSet<Long>(notifiedIds);
    }

    @Generated
    public SyncDynamicsBalanceMailMessageTask() {
    }
}

