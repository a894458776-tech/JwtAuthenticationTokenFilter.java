/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.tasks.mapper.TaskIpStaticMerchantMapper;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SyncMerchantIpExpiredTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncMerchantIpExpiredTask.class);
    @Resource
    TaskIpStaticMerchantMapper taskIpStaticMerchantMapper;
    private static final int BATCH_SIZE = 1000;

    public void merchantIpExpired() {
        log.info("start sync merchant ip expired start  ...");
        this.doSyncMerchantIpExpiredStart();
        log.info("start sync  merchant ip expired end ...");
    }

    public void doSyncMerchantIpExpiredStart() {
        List<KtonIpStaticMerchant> expiredIps = this.taskIpStaticMerchantMapper.selectExpiredIps();
        if (expiredIps.size() > 0) {
            log.info("\u5546\u6237\u5df2\u8d2d\u4e70IP\u5b9a\u65f6\u8fc7\u671f\u4efb\u52a1\uff0c\u5f85\u5904\u7406IP\u6570 expiredIps ..." + expiredIps.size());
            for (int i = 0; i < expiredIps.size(); i += 1000) {
                int end = Math.min(i + 1000, expiredIps.size());
                List<KtonIpStaticMerchant> batch = expiredIps.subList(i, end);
                this.taskIpStaticMerchantMapper.updateExpiredStatus(batch);
            }
        }
    }

    @Generated
    public SyncMerchantIpExpiredTask() {
    }
}

