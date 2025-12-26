/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.mapper.KtonTicketMapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ticket.mapper;

import com.kylin.kton.client.ticket.entity.dto.ClientTicketDTO;
import com.kylin.kton.client.ticket.entity.vo.ClientTicketSearchVO;
import com.kylin.kton.system.mapper.KtonTicketMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTicketMapper
extends KtonTicketMapper {
    @Select(value={"<script> SELECT *  FROM kton_ticket as a WHERE merchant_id = #{vo.merchantId}  <when test='vo.ticketNo!=null'> AND a.ticket_no = #{vo.ticketNo} </when> <when test='vo.ticketType!=null'> AND a.ticket_type = #{vo.ticketType} </when> <when test='vo.ticketTitle!=null'> AND a.ticket_title like concat('%', #{vo.ticketTitle}, '%') </when> <when test='vo.status!=null'> AND a.status = #{vo.status} </when> ORDER BY a.id DESC</script>"})
    public List<ClientTicketDTO> list(@Param(value="vo") ClientTicketSearchVO var1);
}

