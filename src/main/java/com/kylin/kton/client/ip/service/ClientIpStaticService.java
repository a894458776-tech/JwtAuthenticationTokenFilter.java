/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStatic
 *  com.kylin.kton.system.service.IKtonIpStaticService
 */
package com.kylin.kton.client.ip.service;

import com.kylin.kton.client.ip.entity.vo.ConfTypeListVO;
import com.kylin.kton.system.domain.KtonIpStatic;
import com.kylin.kton.system.service.IKtonIpStaticService;
import java.util.List;

public interface ClientIpStaticService
extends IKtonIpStaticService {
    public List<KtonIpStatic> list(ConfTypeListVO var1);
}

