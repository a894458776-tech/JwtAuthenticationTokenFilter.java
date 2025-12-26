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
import com.kylin.kton.system.domain.KtonIpStaticAuthorization;
import com.kylin.kton.system.mapper.KtonIpStaticAuthorizationMapper;
import com.kylin.kton.system.service.IKtonIpStaticAuthorizationService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticAuthorizationServiceImpl
implements IKtonIpStaticAuthorizationService {
    @Autowired
    private KtonIpStaticAuthorizationMapper ktonIpStaticAuthorizationMapper;

    @Override
    public KtonIpStaticAuthorization selectKtonIpStaticAuthorizationById(Long id) {
        return this.ktonIpStaticAuthorizationMapper.selectKtonIpStaticAuthorizationById(id);
    }

    @Override
    public List<KtonIpStaticAuthorization> selectKtonIpStaticAuthorizationList(KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        return this.ktonIpStaticAuthorizationMapper.selectKtonIpStaticAuthorizationList(ktonIpStaticAuthorization);
    }

    @Override
    public int insertKtonIpStaticAuthorization(KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        ktonIpStaticAuthorization.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticAuthorizationMapper.insertKtonIpStaticAuthorization(ktonIpStaticAuthorization);
    }

    @Override
    public int updateKtonIpStaticAuthorization(KtonIpStaticAuthorization ktonIpStaticAuthorization) {
        ktonIpStaticAuthorization.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticAuthorizationMapper.updateKtonIpStaticAuthorization(ktonIpStaticAuthorization);
    }

    @Override
    public int deleteKtonIpStaticAuthorizationByIds(Long[] ids) {
        return this.ktonIpStaticAuthorizationMapper.deleteKtonIpStaticAuthorizationByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticAuthorizationById(Long id) {
        return this.ktonIpStaticAuthorizationMapper.deleteKtonIpStaticAuthorizationById(id);
    }
}

