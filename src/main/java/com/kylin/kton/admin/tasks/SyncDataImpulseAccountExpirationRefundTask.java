/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.constant.MessageRecordsConstants$MESSAGE_TYPE
 *  com.kylin.kton.common.utils.WeChatWebhookUtil
 *  com.kylin.kton.common.utils.bean.BeanUtils
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.domain.KtonMessageRecords
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  com.kylin.kton.system.mapper.KtonIpStaticPoolItemMapper
 *  com.kylin.kton.system.mapper.KtonMerchantMapper
 *  com.kylin.kton.system.mapper.KtonMessageRecordsMapper
 *  com.kylin.kton.system.mapper.KtonOrderMapper
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 *  org.springframework.util.CollectionUtils
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.order.entity.dto.AdminOrderItemStaticDTO;
import com.kylin.kton.admin.order.mapper.AdminOrderDao;
import com.kylin.kton.admin.tasks.mapper.StaticPoolItemTaskMapper;
import com.kylin.kton.admin.tasks.mapper.TaskIpStaticMerchantMapper;
import com.kylin.kton.admin.tasks.mapper.TaskIpStaticSourceMapper;
import com.kylin.kton.common.constant.MessageRecordsConstants;
import com.kylin.kton.common.utils.WeChatWebhookUtil;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonMessageRecords;
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.mapper.KtonIpStaticPoolItemMapper;
import com.kylin.kton.system.mapper.KtonMerchantMapper;
import com.kylin.kton.system.mapper.KtonMessageRecordsMapper;
import com.kylin.kton.system.mapper.KtonOrderMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class SyncDataImpulseAccountExpirationRefundTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncDataImpulseAccountExpirationRefundTask.class);
    private final KtonMerchantMapper merchantMapper;
    private final KtonOrderMapper ktonOrderMapper;
    private final AdminOrderDao adminOrderDao;
    private final KtonMessageRecordsMapper messageRecordsMapper;
    private final KtonIpStaticPoolItemMapper ipStaticPoolItemMapper;
    private final TaskIpStaticMerchantMapper taskIpStaticMerchantMapper;
    private final TaskIpStaticSourceMapper taskIpStaticSourceMapper;
    @Resource
    StaticPoolItemTaskMapper staticPoolItemTaskMapper;

    public void syncAccountExpirationRefund() {
        log.info("start sync account expiration refund...");
        List<AdminOrderItemStaticDTO> expirationAccounts = this.listExpirationAccount();
        if (CollectionUtils.isEmpty(expirationAccounts)) {
            log.info("expiration account is empty....");
            return;
        }
        expirationAccounts.forEach(this::doSyncAccountExpirationRefund);
        log.info("finished start sync account expiration refund...");
    }

    public void syncAccountTomorrowExpiration() {
        log.info("start sync account tomorrow expiration ...");
        List<KtonOrder> tomorrowExpirationAccounts = this.listTomorrowExpirationAccount();
        if (CollectionUtils.isEmpty(tomorrowExpirationAccounts)) {
            log.info("tomorrow expiration account is empty....");
            return;
        }
        String tomorrowExpirationAccountStr = this.getTomorrowExpirationAccountStr(tomorrowExpirationAccounts);
        this.doSendTomorrowMessage(tomorrowExpirationAccountStr);
        log.info("finished start sync account tomorrow expiration ...");
    }

    private List<AdminOrderItemStaticDTO> listExpirationAccount() {
        return this.adminOrderDao.expireList();
    }

    private List<KtonOrder> listTomorrowExpirationAccount() {
        return this.adminOrderDao.listTomorrowExpirationAccount();
    }

    private void doSyncAccountExpirationRefund(AdminOrderItemStaticDTO staticDTO) {
        try {
            String accountStr = this.getAccountStr(staticDTO.getItemStaticList());
            if (accountStr != null) {
                // empty if block
            }
            KtonOrder order = new KtonOrder();
            BeanUtils.copyProperties((Object)((Object)staticDTO), (Object)order);
            Date currentTime = new Date();
            Date newNotifyTime = new Date(currentTime.getTime() + 3600000L);
            Long notifyCount = staticDTO.getNotifyCount();
            order.setNextNotifyTime(newNotifyTime);
            order.setUpdateTime(new Date());
            order.setNotifyCount(Long.valueOf(notifyCount + 1L));
            order.setStatus(Long.valueOf(20L));
            this.ktonOrderMapper.updateKtonOrder(order);
            this.releaseIp(staticDTO.getId());
            this.doSendMessage(staticDTO);
        }
        catch (Exception e) {
            log.error(e.getMessage(), (Throwable)e);
        }
    }

    private void releaseIp(Long orderId) {
        List<KtonIpStaticMerchant> items = this.taskIpStaticMerchantMapper.getByOrderId(orderId);
        for (KtonIpStaticMerchant item : items) {
            this.staticPoolItemTaskMapper.updateById(item.getId());
            this.taskIpStaticSourceMapper.updateByIp(item.getIp(), 0);
        }
    }

    private String getAccountStr(List<KtonOrderItemStatic> staticDTOS) {
        String accountStr = "";
        if (staticDTOS != null) {
            for (KtonOrderItemStatic itemStatic : staticDTOS) {
                if (itemStatic.getIp() == null || itemStatic.getPort() == null || itemStatic.getAccount() == null || itemStatic.getPassword() == null) continue;
                String account = "IP\u5730\u5740:" + itemStatic.getIp() + "\uff1b\u7aef\u53e3\uff1a" + itemStatic.getPort() + "\uff1b\u8d26\u53f7\uff1a" + itemStatic.getAccount() + "\uff1b\u5bc6\u7801\uff1a" + itemStatic.getPassword() + "\uff1b\n";
                accountStr = accountStr + account;
            }
        }
        return accountStr;
    }

    private String getTomorrowExpirationAccountStr(List<KtonOrder> orders) {
        String accountStr = "";
        if (orders != null) {
            for (KtonOrder order : orders) {
                Long merchantId = order.getMerchantId();
                KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
                String account = "\u5546\u6237:" + ktonMerchant.getName() + "\uff1b\u5546\u6237ID\uff1a" + ktonMerchant.getId() + "\uff1b\u5230\u671f\u7684IP\u603b\u6570\uff1a" + order.getTotalIps() + ";\n";
                accountStr = accountStr + account;
            }
        }
        return accountStr;
    }

    private void doSendTomorrowMessage(String tomorrowExpirationAccountStr) {
        try {
            Date today = new Date();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String todayStr = formatter.format(today);
            System.out.println("\u4eca\u5929\u7684\u65e5\u671f\u662f: " + todayStr);
            if (!this.checkRecods(MessageRecordsConstants.MESSAGE_TYPE.TOMORROW_EXPIRE.name(), todayStr).booleanValue()) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u660e\u65e5\u8d26\u53f7\u5230\u671f\u9884\u901a\u77e5\uff1a\n\u660e\u65e5\u5230\u671f\u8d26\u53f7\u5546\u6237\u53ca\u6570\u91cf\uff1a" + tomorrowExpirationAccountStr;
                WeChatWebhookUtil.sendMessage((String)msg);
                this.addRecods(todayStr, msg, MessageRecordsConstants.MESSAGE_TYPE.TOMORROW_EXPIRE.name());
            }
        }
        catch (Exception e) {
            log.error(e.getMessage(), (Throwable)e);
        }
    }

    private void doSendMessage(AdminOrderItemStaticDTO staticDTO) {
        try {
            if (!this.checkRecods(MessageRecordsConstants.MESSAGE_TYPE.EXPIRE.name(), staticDTO.getId().toString()).booleanValue()) {
                Date effectiveDatetime = staticDTO.getEffectiveDatetime();
                Date expireDatetime = staticDTO.getExpireDatetime();
                Long merchantId = staticDTO.getMerchantId();
                KtonMerchant ktonMerchant = this.merchantMapper.selectKtonMerchantById(merchantId);
                String accountStr = this.getAccountStr(staticDTO.getItemStaticList());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatEffectiveDatetime = sdf.format(effectiveDatetime);
                String formatExpireDatetime = sdf.format(expireDatetime);
                String msg = "\u4e1a\u52a1\u4e8b\u4ef6\u901a\u77e5\uff1a\n\u8d26\u53f7\u5230\u671f\u901a\u77e5\uff1a\n\u5546\u6237\u540d\uff1a" + ktonMerchant.getName() + "\n\u5546\u6237ID:" + ktonMerchant.getId() + "\n\u751f\u6548\u65f6\u95f4\uff1a" + formatEffectiveDatetime + "\n\u8fc7\u671f\u65f6\u95f4\uff1a" + formatExpireDatetime + "\n\u5230\u671f\u8d26\u53f7\uff1a" + accountStr;
                WeChatWebhookUtil.sendMessage((String)msg);
                this.addRecods(staticDTO.getId().toString(), msg, MessageRecordsConstants.MESSAGE_TYPE.EXPIRE.name());
            }
        }
        catch (Exception e) {
            log.error(e.getMessage(), (Throwable)e);
        }
    }

    private void addRecods(String sourceId, String content, String messageType) {
        KtonMessageRecords entity = new KtonMessageRecords();
        entity.setContent(content);
        entity.setSourceId(sourceId);
        entity.setMessageType(messageType);
        entity.setCreateTime(new Date());
        this.messageRecordsMapper.insertKtonMessageRecords(entity);
    }

    private Boolean checkRecods(String messageType, String sourceId) {
        KtonMessageRecords entity = new KtonMessageRecords();
        entity.setMessageType(messageType);
        entity.setSourceId(sourceId.toString());
        List records = this.messageRecordsMapper.selectKtonMessageRecordsList(entity);
        if (records.size() > 0) {
            return true;
        }
        return false;
    }

    @Generated
    public SyncDataImpulseAccountExpirationRefundTask(KtonMerchantMapper merchantMapper, KtonOrderMapper ktonOrderMapper, AdminOrderDao adminOrderDao, KtonMessageRecordsMapper messageRecordsMapper, KtonIpStaticPoolItemMapper ipStaticPoolItemMapper, TaskIpStaticMerchantMapper taskIpStaticMerchantMapper, TaskIpStaticSourceMapper taskIpStaticSourceMapper) {
        this.merchantMapper = merchantMapper;
        this.ktonOrderMapper = ktonOrderMapper;
        this.adminOrderDao = adminOrderDao;
        this.messageRecordsMapper = messageRecordsMapper;
        this.ipStaticPoolItemMapper = ipStaticPoolItemMapper;
        this.taskIpStaticMerchantMapper = taskIpStaticMerchantMapper;
        this.taskIpStaticSourceMapper = taskIpStaticSourceMapper;
    }
}

