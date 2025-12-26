/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonIpStaticPoolItemService
 */
package com.kylin.kton.admin.ip.service;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemInfoDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminUnassignedIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolAllListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminUnassignedIpsVO;
import com.kylin.kton.admin.ip.entity.vo.PoolItemAddBatchVO;
import com.kylin.kton.system.service.IKtonIpStaticPoolItemService;
import java.util.List;

public interface IpStaticPoolItemService
extends IKtonIpStaticPoolItemService {
    public List<AdminIpStaticPoolItemDTO> allList(AdminIpStaticPoolAllListSearchVO var1);

    public List<AdminIpStaticPoolItemInfoDTO> list(AdminIpStaticPoolListSearchVO var1);

    public Integer addBatch(PoolItemAddBatchVO var1);

    public List<AdminUnassignedIpsDTO> unassignedIps(AdminUnassignedIpsVO var1);
}

