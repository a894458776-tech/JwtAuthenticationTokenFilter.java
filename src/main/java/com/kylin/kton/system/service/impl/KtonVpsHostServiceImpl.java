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
import com.kylin.kton.system.domain.KtonVpsHost;
import com.kylin.kton.system.mapper.KtonVpsHostMapper;
import com.kylin.kton.system.service.IKtonVpsHostService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonVpsHostServiceImpl
implements IKtonVpsHostService {
    @Autowired
    private KtonVpsHostMapper ktonVpsHostMapper;

    @Override
    public KtonVpsHost selectKtonVpsHostById(Long id) {
        return this.ktonVpsHostMapper.selectKtonVpsHostById(id);
    }

    @Override
    public List<KtonVpsHost> selectKtonVpsHostList(KtonVpsHost ktonVpsHost) {
        return this.ktonVpsHostMapper.selectKtonVpsHostList(ktonVpsHost);
    }

    @Override
    public int insertKtonVpsHost(KtonVpsHost ktonVpsHost) {
        ktonVpsHost.setCreateTime(DateUtils.getNowDate());
        return this.ktonVpsHostMapper.insertKtonVpsHost(ktonVpsHost);
    }

    @Override
    public int updateKtonVpsHost(KtonVpsHost ktonVpsHost) {
        ktonVpsHost.setUpdateTime(DateUtils.getNowDate());
        return this.ktonVpsHostMapper.updateKtonVpsHost(ktonVpsHost);
    }

    @Override
    public int deleteKtonVpsHostByIds(Long[] ids) {
        return this.ktonVpsHostMapper.deleteKtonVpsHostByIds(ids);
    }

    @Override
    public int deleteKtonVpsHostById(Long id) {
        return this.ktonVpsHostMapper.deleteKtonVpsHostById(id);
    }
}

