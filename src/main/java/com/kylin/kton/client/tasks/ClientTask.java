/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.client.tasks;

import com.kylin.kton.client.tasks.service.TaskClientService;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component(value="clientTask")
public class ClientTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(ClientTask.class);
    @Resource
    TaskClientService taskClientService;

    public void autoOverdueOrder() {
        log.info("autoOverdueOrder start...");
    }
}

