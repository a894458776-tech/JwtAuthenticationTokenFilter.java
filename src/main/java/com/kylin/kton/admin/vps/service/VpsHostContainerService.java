/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonVpsHostContainerService
 */
package com.kylin.kton.admin.vps.service;

import com.kylin.kton.admin.vps.entity.vo.AddVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.QueryVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.UpdateVpsStatusVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostContainerVO;
import com.kylin.kton.system.service.IKtonVpsHostContainerService;
import java.util.List;

public interface VpsHostContainerService
extends IKtonVpsHostContainerService {
    public List<VpsHostContainerVO> queryVpsHostContainer(QueryVpsHostContainerVO var1);

    public void openStopVps(UpdateVpsStatusVO var1);

    public Integer addHostContainer(AddVpsHostContainerVO var1);
}

