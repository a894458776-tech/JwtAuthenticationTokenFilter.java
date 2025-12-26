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
import com.kylin.kton.system.domain.KtonIpStaticPrices;
import com.kylin.kton.system.mapper.KtonIpStaticPricesMapper;
import com.kylin.kton.system.service.IKtonIpStaticPricesService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticPricesServiceImpl
implements IKtonIpStaticPricesService {
    @Autowired
    private KtonIpStaticPricesMapper ktonIpStaticPricesMapper;

    @Override
    public KtonIpStaticPrices selectKtonIpStaticPricesById(Long id) {
        return this.ktonIpStaticPricesMapper.selectKtonIpStaticPricesById(id);
    }

    @Override
    public List<KtonIpStaticPrices> selectKtonIpStaticPricesList(KtonIpStaticPrices ktonIpStaticPrices) {
        return this.ktonIpStaticPricesMapper.selectKtonIpStaticPricesList(ktonIpStaticPrices);
    }

    @Override
    public int insertKtonIpStaticPrices(KtonIpStaticPrices ktonIpStaticPrices) {
        ktonIpStaticPrices.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticPricesMapper.insertKtonIpStaticPrices(ktonIpStaticPrices);
    }

    @Override
    public int updateKtonIpStaticPrices(KtonIpStaticPrices ktonIpStaticPrices) {
        ktonIpStaticPrices.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticPricesMapper.updateKtonIpStaticPrices(ktonIpStaticPrices);
    }

    @Override
    public int deleteKtonIpStaticPricesByIds(Long[] ids) {
        return this.ktonIpStaticPricesMapper.deleteKtonIpStaticPricesByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticPricesById(Long id) {
        return this.ktonIpStaticPricesMapper.deleteKtonIpStaticPricesById(id);
    }
}

