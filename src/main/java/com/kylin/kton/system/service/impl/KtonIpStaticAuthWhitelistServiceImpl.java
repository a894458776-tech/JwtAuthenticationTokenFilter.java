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
import com.kylin.kton.system.domain.KtonIpStaticAuthWhitelist;
import com.kylin.kton.system.mapper.KtonIpStaticAuthWhitelistMapper;
import com.kylin.kton.system.service.IKtonIpStaticAuthWhitelistService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonIpStaticAuthWhitelistServiceImpl
implements IKtonIpStaticAuthWhitelistService {
    @Autowired
    private KtonIpStaticAuthWhitelistMapper ktonIpStaticAuthWhitelistMapper;

    @Override
    public KtonIpStaticAuthWhitelist selectKtonIpStaticAuthWhitelistById(Long id) {
        return this.ktonIpStaticAuthWhitelistMapper.selectKtonIpStaticAuthWhitelistById(id);
    }

    @Override
    public List<KtonIpStaticAuthWhitelist> selectKtonIpStaticAuthWhitelistList(KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        return this.ktonIpStaticAuthWhitelistMapper.selectKtonIpStaticAuthWhitelistList(ktonIpStaticAuthWhitelist);
    }

    @Override
    public int insertKtonIpStaticAuthWhitelist(KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        ktonIpStaticAuthWhitelist.setCreateTime(DateUtils.getNowDate());
        return this.ktonIpStaticAuthWhitelistMapper.insertKtonIpStaticAuthWhitelist(ktonIpStaticAuthWhitelist);
    }

    @Override
    public int updateKtonIpStaticAuthWhitelist(KtonIpStaticAuthWhitelist ktonIpStaticAuthWhitelist) {
        ktonIpStaticAuthWhitelist.setUpdateTime(DateUtils.getNowDate());
        return this.ktonIpStaticAuthWhitelistMapper.updateKtonIpStaticAuthWhitelist(ktonIpStaticAuthWhitelist);
    }

    @Override
    public int deleteKtonIpStaticAuthWhitelistByIds(Long[] ids) {
        return this.ktonIpStaticAuthWhitelistMapper.deleteKtonIpStaticAuthWhitelistByIds(ids);
    }

    @Override
    public int deleteKtonIpStaticAuthWhitelistById(Long id) {
        return this.ktonIpStaticAuthWhitelistMapper.deleteKtonIpStaticAuthWhitelistById(id);
    }
}

