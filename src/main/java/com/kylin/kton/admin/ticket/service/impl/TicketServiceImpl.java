/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.constant.TicketConstants$TICKET_TYPE
 *  com.kylin.kton.system.domain.KtonTicket
 *  com.kylin.kton.system.service.impl.KtonTicketServiceImpl
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.stereotype.Service
 */
package com.kylin.kton.admin.ticket.service.impl;

import com.kylin.kton.admin.ticket.entity.dto.AdminTicketDTO;
import com.kylin.kton.admin.ticket.entity.vo.AdminAuditVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketAddVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketEditVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketSearchVO;
import com.kylin.kton.admin.ticket.mapper.AdminTicketMapper;
import com.kylin.kton.admin.ticket.service.TicketService;
import com.kylin.kton.common.constant.TicketConstants;
import com.kylin.kton.system.domain.KtonTicket;
import com.kylin.kton.system.service.impl.KtonTicketServiceImpl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl
extends KtonTicketServiceImpl
implements TicketService {
    @Autowired
    private AdminTicketMapper adminTicketMapper;

    @Override
    public List<AdminTicketDTO> list(AdminTicketSearchVO searchVO) {
        return this.adminTicketMapper.list(searchVO);
    }

    @Override
    public Integer add(AdminTicketAddVO addVO) {
        KtonTicket ticket = new KtonTicket();
        BeanUtils.copyProperties((Object)addVO, (Object)ticket);
        ticket.setTicketNo(this.getNoTime());
        ticket.setCreateTime(new Date());
        return this.adminTicketMapper.insertKtonTicket(ticket);
    }

    @Override
    public Integer edit(AdminTicketEditVO editVO) {
        KtonTicket ticket = new KtonTicket();
        BeanUtils.copyProperties((Object)editVO, (Object)ticket);
        ticket.setUpdateTime(new Date());
        return this.adminTicketMapper.updateKtonTicket(ticket);
    }

    @Override
    public Integer audit(AdminAuditVO auditVO) {
        KtonTicket ktonTicket = this.adminTicketMapper.getByNo(auditVO.getTicketNo());
        if (ktonTicket == null) {
            throw new RuntimeException("\u5de5\u5355\u4e0d\u5b58\u5728");
        }
        ktonTicket.setStatus(auditVO.getStatus());
        ktonTicket.setUpdateTime(new Date());
        if (TicketConstants.TICKET_TYPE.SUPLIER.name().equals(ktonTicket.getTicketType())) {
            // empty if block
        }
        return this.adminTicketMapper.updateKtonTicket(ktonTicket);
    }

    private String getNoTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate = sdf.format(new Date());
        String result = "";
        Random random = new Random();
        for (int i = 0; i < 5; ++i) {
            result = result + random.nextInt(10);
        }
        return "N" + newDate + result;
    }
}

