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
import com.kylin.kton.system.domain.KtonApiConfig;
import com.kylin.kton.system.mapper.KtonApiConfigMapper;
import com.kylin.kton.system.service.IKtonApiConfigService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonApiConfigServiceImpl
implements IKtonApiConfigService {
    @Autowired
    private KtonApiConfigMapper ktonApiConfigMapper;

    @Override
    public KtonApiConfig selectKtonApiConfigByUserId(Long userId) {
        return this.ktonApiConfigMapper.selectKtonApiConfigByUserId(userId);
    }

    @Override
    public List<KtonApiConfig> selectKtonApiConfigList(KtonApiConfig ktonApiConfig) {
        return this.ktonApiConfigMapper.selectKtonApiConfigList(ktonApiConfig);
    }

    @Override
    public int insertKtonApiConfig(KtonApiConfig ktonApiConfig) {
        ktonApiConfig.setCreateTime(DateUtils.getNowDate());
        return this.ktonApiConfigMapper.insertKtonApiConfig(ktonApiConfig);
    }

    @Override
    public int updateKtonApiConfig(KtonApiConfig ktonApiConfig) {
        ktonApiConfig.setUpdateTime(DateUtils.getNowDate());
        return this.ktonApiConfigMapper.updateKtonApiConfig(ktonApiConfig);
    }

    @Override
    public int deleteKtonApiConfigByUserIds(Long[] userIds) {
        return this.ktonApiConfigMapper.deleteKtonApiConfigByUserIds(userIds);
    }

    @Override
    public int deleteKtonApiConfigByUserId(Long userId) {
        return this.ktonApiConfigMapper.deleteKtonApiConfigByUserId(userId);
    }

    @Override
    public int insertOrUpdateKtonApiConfig(KtonApiConfig ktonApiConfig) {
        KtonApiConfig existingConfig = this.ktonApiConfigMapper.selectKtonApiConfigByUserId(ktonApiConfig.getUserId());
        if (existingConfig == null) {
            ktonApiConfig.setCreateTime(DateUtils.getNowDate());
            return this.ktonApiConfigMapper.insertKtonApiConfig(ktonApiConfig);
        }
        ktonApiConfig.setUpdateTime(DateUtils.getNowDate());
        return this.ktonApiConfigMapper.updateKtonApiConfig(ktonApiConfig);
    }
}

