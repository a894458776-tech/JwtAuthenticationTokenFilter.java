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
import com.kylin.kton.system.domain.KtonIpStaticDiscount;
import com.kylin.kton.system.mapper.KtonIpStaticDiscountMapper;
import com.kylin.kton.system.service.IKtonIpStaticDiscountService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticDiscountServiceImpl
implements IKtonIpStaticDiscountService {
    @Autowired
    private KtonIpStaticDiscountMapper ktonIpStaticDiscountMapper;

    @Override
    public KtonIpStaticDiscount selectKtonIpStaticDiscountById(Long id) {
        return this.ktonIpStaticDiscountMapper.selectKtonIpStaticDiscountById(id);
    }

    @Override
    public List<KtonIpStaticDiscount> selectKtonIpStaticDiscountList(KtonIpStaticDiscount ktonIpStaticDiscount) {
        return this.ktonIpStaticDiscountMapper.selectKtonIpStaticDiscountList(ktonIpStaticDiscount);
    }

    @Override
    public int insertKtonIpStaticDiscount(KtonIpStaticDiscount ktonIpStaticDiscount) {
        ktonIpStaticDiscount.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticDiscountMapper.insertKtonIpStaticDiscount(ktonIpStaticDiscount);
    }

    @Override
    public int updateKtonIpStaticDiscount(KtonIpStaticDiscount ktonIpStaticDiscount) {
        ktonIpStaticDiscount.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticDiscountMapper.updateKtonIpStaticDiscount(ktonIpStaticDiscount);
    }

    @Override
    public int deleteKtonIpStaticDiscountByIds(Long[] ids) {
        return this.ktonIpStaticDiscountMapper.deleteKtonIpStaticDiscountByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticDiscountById(Long id) {
        return this.ktonIpStaticDiscountMapper.deleteKtonIpStaticDiscountById(id);
    }
}

