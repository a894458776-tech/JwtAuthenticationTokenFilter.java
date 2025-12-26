/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpStaticMerchantService
 */
package com.kylin.kton.admin.ip.service;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticMerchantDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticMerchantSearchVO;
import com.kylin.kton.system.service.IKtonIpStaticMerchantService;
import java.util.List;

public interface IpStaticMerchantService
extends IKtonIpStaticMerchantService {
    public List<AdminIpStaticMerchantDTO> list(AdminIpStaticMerchantSearchVO var1);
}

