/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  com.kylin.kton.common.utils.bean.BeanUtils
 *  com.kylin.kton.system.domain.KtonVpsHost
 *  com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper
 *  com.kylin.kton.system.mapper.KtonVpsHostMapper
 *  com.kylin.kton.system.service.impl.KtonVpsHostServiceImpl
 *  javax.annotation.Resource
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.vps.service.impl;

import com.kylin.kton.admin.tasks.mapper.ClusterStatisMapper;
import com.kylin.kton.admin.vps.entity.dto.VpsHostDTO;
import com.kylin.kton.admin.vps.entity.vo.AdminVpsHostAddVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostSearchVO;
import com.kylin.kton.admin.vps.mapper.VpsHostMapper;
import com.kylin.kton.admin.vps.service.VpsHostService;
import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.common.utils.bean.BeanUtils;
import com.kylin.kton.system.domain.KtonVpsHost;
import com.kylin.kton.system.mapper.KtonClusterStatisVpsMapper;
import com.kylin.kton.system.mapper.KtonVpsHostMapper;
import com.kylin.kton.system.service.impl.KtonVpsHostServiceImpl;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class VpsHostServiceImpl
extends KtonVpsHostServiceImpl
implements VpsHostService {
    @Resource
    VpsHostMapper vpsHostMapper;
    @Resource
    KtonVpsHostMapper ktonVpsHostMapper;
    @Resource
    KtonClusterStatisVpsMapper ktonClusterStatisVpsMapper;
    @Resource
    ClusterStatisMapper clusterStatisMapper;

    @Override
    public List<VpsHostDTO> list(VpsHostSearchVO searchVO) {
        return this.vpsHostMapper.list(searchVO);
    }

    @Override
    public int add(AdminVpsHostAddVO addVO) {
        KtonVpsHost ktonVpsHost = new KtonVpsHost();
        BeanUtils.copyProperties((Object)addVO, (Object)ktonVpsHost);
        ktonVpsHost.setCreateTime(DateUtils.getNowDate());
        int res = this.ktonVpsHostMapper.insertKtonVpsHost(ktonVpsHost);
        return res;
    }
}

