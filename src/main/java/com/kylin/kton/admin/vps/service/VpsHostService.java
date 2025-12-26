/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonVpsHostService
 */
package com.kylin.kton.admin.vps.service;

import com.kylin.kton.admin.vps.entity.dto.VpsHostDTO;
import com.kylin.kton.admin.vps.entity.vo.AdminVpsHostAddVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostSearchVO;
import com.kylin.kton.system.service.IKtonVpsHostService;
import java.util.List;

public interface VpsHostService
extends IKtonVpsHostService {
    public List<VpsHostDTO> list(VpsHostSearchVO var1);

    public int add(AdminVpsHostAddVO var1);
}

