/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.system.mapper;

import com.kylin.kton.system.domain.KtonTicket;
import java.util.List;

public interface KtonTicketMapper {
    public KtonTicket selectKtonTicketById(Long var1);

    public List<KtonTicket> selectKtonTicketList(KtonTicket var1);

    public int insertKtonTicket(KtonTicket var1);

    public int updateKtonTicket(KtonTicket var1);

    public int deleteKtonTicketById(Long var1);

    public int deleteKtonTicketByIds(Long[] var1);
}

