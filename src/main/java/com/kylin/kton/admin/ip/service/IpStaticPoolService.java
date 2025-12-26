/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  com.kylin.kton.system.service.IKtonIpStaticPoolService
 */
package com.kylin.kton.admin.ip.service;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantAvailableIpListDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantInventoryIpsDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminRegionalAvailableIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminMerchantInventoryIpsVO;
import com.kylin.kton.admin.ip.entity.vo.AdminRegionalAvailableIpsVO;
import com.kylin.kton.admin.ip.entity.vo.MerchantAvailableIpListVO;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import com.kylin.kton.system.service.IKtonIpStaticPoolService;
import java.util.List;

public interface IpStaticPoolService
extends IKtonIpStaticPoolService {
    public List<AdminIpStaticPoolDTO> list(KtonIpStaticPool var1);

    public AjaxResult ipNuxSync();

    public AjaxResult ipIdeaSync();

    public AjaxResult ipIdeaSync2();

    public List<AdminRegionalAvailableIpsDTO> regionalAvailableIps(AdminRegionalAvailableIpsVO var1);

    public List<AdminMerchantAvailableIpListDTO> merchantAvailableIpList(MerchantAvailableIpListVO var1);

    public List<AdminMerchantInventoryIpsDTO> merchantInventoryIps(AdminMerchantInventoryIpsVO var1);
}

