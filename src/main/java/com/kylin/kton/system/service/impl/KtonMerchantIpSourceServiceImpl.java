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
import com.kylin.kton.system.domain.KtonMerchantIpSource;
import com.kylin.kton.system.mapper.KtonMerchantIpSourceMapper;
import com.kylin.kton.system.service.IKtonMerchantIpSourceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonMerchantIpSourceServiceImpl
implements IKtonMerchantIpSourceService {
    @Autowired
    private KtonMerchantIpSourceMapper ktonMerchantIpSourceMapper;

    @Override
    public KtonMerchantIpSource selectKtonMerchantIpSourceById(Long id) {
        return this.ktonMerchantIpSourceMapper.selectKtonMerchantIpSourceById(id);
    }

    @Override
    public List<KtonMerchantIpSource> selectKtonMerchantIpSourceList(KtonMerchantIpSource ktonMerchantIpSource) {
        return this.ktonMerchantIpSourceMapper.selectKtonMerchantIpSourceList(ktonMerchantIpSource);
    }

    @Override
    public int insertKtonMerchantIpSource(KtonMerchantIpSource ktonMerchantIpSource) {
        ktonMerchantIpSource.setCreateTime(DateUtils.getNowDate());
        return this.ktonMerchantIpSourceMapper.insertKtonMerchantIpSource(ktonMerchantIpSource);
    }

    @Override
    public int updateKtonMerchantIpSource(KtonMerchantIpSource ktonMerchantIpSource) {
        ktonMerchantIpSource.setUpdateTime(DateUtils.getNowDate());
        return this.ktonMerchantIpSourceMapper.updateKtonMerchantIpSource(ktonMerchantIpSource);
    }

    @Override
    public int deleteKtonMerchantIpSourceByIds(Long[] ids) {
        return this.ktonMerchantIpSourceMapper.deleteKtonMerchantIpSourceByIds(ids);
    }

    @Override
    public int deleteKtonMerchantIpSourceById(Long id) {
        return this.ktonMerchantIpSourceMapper.deleteKtonMerchantIpSourceById(id);
    }
}

