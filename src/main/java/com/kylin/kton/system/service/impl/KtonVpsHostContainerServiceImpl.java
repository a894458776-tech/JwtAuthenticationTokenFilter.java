/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.utils.DateUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.system.service.impl;

import com.kylin.kton.common.utils.DateUtils;
import com.kylin.kton.system.domain.KtonVpsHostContainer;
import com.kylin.kton.system.mapper.KtonVpsHostContainerMapper;
import com.kylin.kton.system.service.IKtonVpsHostContainerService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsHostContainerServiceImpl
implements IKtonVpsHostContainerService {
    @Autowired
    private KtonVpsHostContainerMapper ktonVpsHostContainerMapper;

    @Override
    public KtonVpsHostContainer selectKtonVpsHostContainerById(Long id) {
        return this.ktonVpsHostContainerMapper.selectKtonVpsHostContainerById(id);
    }

    @Override
    public List<KtonVpsHostContainer> selectKtonVpsHostContainerList(KtonVpsHostContainer ktonVpsHostContainer) {
        return this.ktonVpsHostContainerMapper.selectKtonVpsHostContainerList(ktonVpsHostContainer);
    }

    @Override
    public int insertKtonVpsHostContainer(KtonVpsHostContainer ktonVpsHostContainer) {
        ktonVpsHostContainer.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsHostContainerMapper.insertKtonVpsHostContainer(ktonVpsHostContainer);
    }

    @Override
    public int updateKtonVpsHostContainer(KtonVpsHostContainer ktonVpsHostContainer) {
        ktonVpsHostContainer.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsHostContainerMapper.updateKtonVpsHostContainer(ktonVpsHostContainer);
    }

    @Override
    public int deleteKtonVpsHostContainerByIds(Long[] ids) {
        return this.ktonVpsHostContainerMapper.deleteKtonVpsHostContainerByIds(ids);
    }

    @Override
    public int deleteKtonVpsHostContainerById(Long id) {
        return this.ktonVpsHostContainerMapper.deleteKtonVpsHostContainerById(id);
    }
}

