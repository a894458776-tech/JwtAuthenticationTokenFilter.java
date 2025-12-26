/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.tasks.mapper.TaskIpStaticSourceMapper;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SyncSourceIpExpiredTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncSourceIpExpiredTask.class);
    @Resource
    TaskIpStaticSourceMapper ipStaticSourceMapper;
    private static final int BATCH_SIZE = 1000;

    public void sourceIpExpired() {
        log.info("start sync source ip expired start  ...");
        this.doSyncSourceIpExpiredStart();
        log.info("start sync  source ip expired end ...");
    }

    public void doSyncSourceIpExpiredStart() {
        List<KtonIpStaticSource> expiredIps = this.ipStaticSourceMapper.selectExpiredIps();
        if (expiredIps.size() > 0) {
            log.info("\u4f9b\u5e94\u5546 IP\u5b9a\u65f6\u8fc7\u671f\u4efb\u52a1\uff0c\u5f85\u5904\u7406IP\u6570 expiredIps ..." + expiredIps.size());
            for (int i = 0; i < expiredIps.size(); i += 1000) {
                int end = Math.min(i + 1000, expiredIps.size());
                List<KtonIpStaticSource> batch = expiredIps.subList(i, end);
                this.ipStaticSourceMapper.updateExpiredStatus(batch);
            }
        }
    }

    @Generated
    public SyncSourceIpExpiredTask() {
    }
}

