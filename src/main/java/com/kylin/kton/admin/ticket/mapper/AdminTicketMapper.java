/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.domain.KtonTicket
 *  com.kylin.kton.system.mapper.KtonTicketMapper
 *  org.apache.ibatis.annotations.One
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ticket.mapper;

import com.kylin.kton.admin.ticket.entity.dto.AdminTicketDTO;
import com.kylin.kton.admin.ticket.entity.vo.AdminTicketSearchVO;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.domain.KtonTicket;
import com.kylin.kton.system.mapper.KtonTicketMapper;
import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminTicketMapper
extends KtonTicketMapper {
    @Select(value={"<script> SELECT *  FROM kton_ticket as a WHERE 1 = 1  <when test='vo.ticketNo!=null'> AND a.ticket_no = #{vo.ticketNo} </when> <when test='vo.ticketType!=null'> AND a.ticket_type = #{vo.ticketType} </when> <when test='vo.ticketTitle!=null'> AND a.ticket_title like concat('%', #{vo.ticketTitle}, '%') </when> <when test='vo.status!=null'> AND a.status = #{vo.status} </when> <when test='vo.merchantId!=null'> AND a.merchant_id = #{vo.merchantId} </when> ORDER BY a.id DESC</script>"})
    @Results(value={@Result(column="merchant_id", property="merchantId"), @Result(column="merchant_id", property="merchant", one=@One(select="selectMerchantInfo"))})
    public List<AdminTicketDTO> list(@Param(value="vo") AdminTicketSearchVO var1);

    @Select(value={"<script>", "SELECT * ", "FROM kton_ticket ", "WHERE ticket_no = #{ticketNo}  ", "LIMIT 1 ", "</script>"})
    public KtonTicket getByNo(@Param(value="ticketNo") String var1);

    @Select(value={"select * from kton_merchant where id = #{merchantId}"})
    public KtonMerchant selectMerchantInfo(@Param(value="merchantId") Long var1);
}

