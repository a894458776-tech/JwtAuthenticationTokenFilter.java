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
import com.kylin.kton.system.domain.KtonMerchantConfig;
import com.kylin.kton.system.mapper.KtonMerchantConfigMapper;
import com.kylin.kton.system.service.IKtonMerchantConfigService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantConfigServiceImpl
implements IKtonMerchantConfigService {
    @Autowired
    private KtonMerchantConfigMapper ktonMerchantConfigMapper;

    @Override
    public KtonMerchantConfig selectKtonMerchantConfigByMerchantConfigId(Long merchantConfigId) {
        return this.ktonMerchantConfigMapper.selectKtonMerchantConfigByMerchantConfigId(merchantConfigId);
    }

    @Override
    public List<KtonMerchantConfig> selectKtonMerchantConfigList(KtonMerchantConfig ktonMerchantConfig) {
        return this.ktonMerchantConfigMapper.selectKtonMerchantConfigList(ktonMerchantConfig);
    }

    @Override
    public int insertKtonMerchantConfig(KtonMerchantConfig ktonMerchantConfig) {
        ktonMerchantConfig.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantConfigMapper.insertKtonMerchantConfig(ktonMerchantConfig);
    }

    @Override
    public int updateKtonMerchantConfig(KtonMerchantConfig ktonMerchantConfig) {
        ktonMerchantConfig.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantConfigMapper.updateKtonMerchantConfig(ktonMerchantConfig);
    }

    @Override
    public int deleteKtonMerchantConfigByMerchantConfigIds(Long[] merchantConfigIds) {
        return this.ktonMerchantConfigMapper.deleteKtonMerchantConfigByMerchantConfigIds(merchantConfigIds);
    }

    @Override
    public int deleteKtonMerchantConfigByMerchantConfigId(Long merchantConfigId) {
        return this.ktonMerchantConfigMapper.deleteKtonMerchantConfigByMerchantConfigId(merchantConfigId);
    }
}

