/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.service.IKtonTicketService
 */
package com.kylin.kton.client.ticket.service;

import com.kylin.kton.client.ticket.entity.dto.ClientTicketDTO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketAddVO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketEditVO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketSearchVO;
import com.kylin.kton.system.service.IKtonTicketService;
import java.util.List;

public interface ClientTicketService
extends IKtonTicketService {
    public List<ClientTicketDTO> list(ClientTicketSearchVO var1);

    public Integer add(ClientTicketAddVO var1);

    public Integer edit(ClientTicketEditVO var1);
}

