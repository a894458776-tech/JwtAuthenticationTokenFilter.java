/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.annotation.PreDestroy
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.framework.manager;

import com.kylin.kton.framework.manager.AsyncManager;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ShutdownManager {
    private static final Logger logger = LoggerFactory.getLogger((String)"sys-user");

    @PreDestroy
    public void destroy() {
        this.shutdownAsyncManager();
    }

    private void shutdownAsyncManager() {
        try {
            logger.info("====\u5173\u95ed\u540e\u53f0\u4efb\u52a1\u4efb\u52a1\u7ebf\u7a0b\u6c60====");
            AsyncManager.me().shutdown();
        }
        catch (Exception e) {
            logger.error(e.getMessage(), (Throwable)e);
        }
    }
}

