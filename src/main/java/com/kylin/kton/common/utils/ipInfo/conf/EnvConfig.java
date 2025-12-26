/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.beans.factory.annotation.Value
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.common.utils.ipInfo.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class EnvConfig {
    @Value(value="${spring.profiles.active:dev}")
    private String activeProfile;

    public String getActiveProfile() {
        return this.activeProfile;
    }
}

