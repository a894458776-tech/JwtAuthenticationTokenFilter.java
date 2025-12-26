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
import com.kylin.kton.system.domain.KtonTicket;
import com.kylin.kton.system.mapper.KtonTicketMapper;
import com.kylin.kton.system.service.IKtonTicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KtonTicketServiceImpl
implements IKtonTicketService {
    @Autowired
    private KtonTicketMapper ktonTicketMapper;

    @Override
    public KtonTicket selectKtonTicketById(Long id) {
        return this.ktonTicketMapper.selectKtonTicketById(id);
    }

    @Override
    public List<KtonTicket> selectKtonTicketList(KtonTicket ktonTicket) {
        return this.ktonTicketMapper.selectKtonTicketList(ktonTicket);
    }

    @Override
    public int insertKtonTicket(KtonTicket ktonTicket) {
        ktonTicket.setCreateTime(DateUtils.getNowDate());
        return this.ktonTicketMapper.insertKtonTicket(ktonTicket);
    }

    @Override
    public int updateKtonTicket(KtonTicket ktonTicket) {
        ktonTicket.setUpdateTime(DateUtils.getNowDate());
        return this.ktonTicketMapper.updateKtonTicket(ktonTicket);
    }

    @Override
    public int deleteKtonTicketByIds(Long[] ids) {
        return this.ktonTicketMapper.deleteKtonTicketByIds(ids);
    }

    @Override
    public int deleteKtonTicketById(Long id) {
        return this.ktonTicketMapper.deleteKtonTicketById(id);
    }
}

