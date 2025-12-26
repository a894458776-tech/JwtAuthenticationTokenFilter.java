/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpStaticService
 */
package com.kylin.kton.admin.ip.service;

import com.kylin.kton.system.service.IKtonIpStaticService;
import java.util.List;
import java.util.Map;

public interface IpStaticService
extends IKtonIpStaticService {
    public Map<String, Object> testS5UrlAccess(String var1, String var2, Integer var3) throws Exception;

    public List<String> getCommonTestUrls();
}

