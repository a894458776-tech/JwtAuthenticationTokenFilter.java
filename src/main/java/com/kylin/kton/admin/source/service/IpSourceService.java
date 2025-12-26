/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonSource
 *  com.kylin.kton.system.service.IKtonSourceService
 */
package com.kylin.kton.admin.source.service;

import com.kylin.kton.admin.ip.entity.vo.AdminWithOutMerchantlistSearchVO;
import com.kylin.kton.system.domain.KtonSource;
import com.kylin.kton.system.service.IKtonSourceService;
import java.util.List;

public interface IpSourceService
extends IKtonSourceService {
    public List<KtonSource> withOutMerchantlist(AdminWithOutMerchantlistSearchVO var1);
}

