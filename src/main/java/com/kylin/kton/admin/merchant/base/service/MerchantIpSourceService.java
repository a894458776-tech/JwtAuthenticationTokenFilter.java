/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonMerchantIpSourceService
 */
package com.kylin.kton.admin.merchant.base.service;

import com.kylin.kton.admin.merchant.base.entity.dto.AdminMerchantSourceDTO;
import com.kylin.kton.admin.merchant.base.entity.vo.AdminMerchantSourceSearchVO;
import com.kylin.kton.system.service.IKtonMerchantIpSourceService;
import java.util.List;

public interface MerchantIpSourceService
extends IKtonMerchantIpSourceService {
    public List<AdminMerchantSourceDTO> list(AdminMerchantSourceSearchVO var1);
}

