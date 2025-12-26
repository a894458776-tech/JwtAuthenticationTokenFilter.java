/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonTicketService
 */
package com.kylin.kton.admin.ticket.service;

import com.kylin.kton.admin.ticket.entity.dto.AdminTicketDTO;
import com.kylin.kton.admin.ticket.entity.vo.AdminAuditVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketAddVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketEditVO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketSearchVO;
import com.kylin.kton.system.service.IKtonTicketService;
import java.util.List;

public interface TicketService
extends IKtonTicketService {
    public List<AdminTicketDTO> list(AdminTicketSearchVO var1);

    public Integer add(AdminTicketAddVO var1);

    public Integer edit(AdminTicketEditVO var1);

    public Integer audit(AdminAuditVO var1);
}

