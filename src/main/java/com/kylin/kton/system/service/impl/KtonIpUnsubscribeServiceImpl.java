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
import com.kylin.kton.system.domain.KtonIpUnsubscribe;
import com.kylin.kton.system.mapper.KtonIpUnsubscribeMapper;
import com.kylin.kton.system.service.IKtonIpUnsubscribeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpUnsubscribeServiceImpl
implements IKtonIpUnsubscribeService {
    @Autowired
    private KtonIpUnsubscribeMapper ktonIpUnsubscribeMapper;

    @Override
    public KtonIpUnsubscribe selectKtonIpUnsubscribeById(Long id) {
        return this.ktonIpUnsubscribeMapper.selectKtonIpUnsubscribeById(id);
    }

    @Override
    public List<KtonIpUnsubscribe> selectKtonIpUnsubscribeList(KtonIpUnsubscribe ktonIpUnsubscribe) {
        return this.ktonIpUnsubscribeMapper.selectKtonIpUnsubscribeList(ktonIpUnsubscribe);
    }

    @Override
    public int insertKtonIpUnsubscribe(KtonIpUnsubscribe ktonIpUnsubscribe) {
        ktonIpUnsubscribe.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpUnsubscribeMapper.insertKtonIpUnsubscribe(ktonIpUnsubscribe);
    }

    @Override
    public int updateKtonIpUnsubscribe(KtonIpUnsubscribe ktonIpUnsubscribe) {
        ktonIpUnsubscribe.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpUnsubscribeMapper.updateKtonIpUnsubscribe(ktonIpUnsubscribe);
    }

    @Override
    public int deleteKtonIpUnsubscribeByIds(Long[] ids) {
        return this.ktonIpUnsubscribeMapper.deleteKtonIpUnsubscribeByIds(ids);
    }

    @Override
    public int deleteKtonIpUnsubscribeById(Long id) {
        return this.ktonIpUnsubscribeMapper.deleteKtonIpUnsubscribeById(id);
    }
}

