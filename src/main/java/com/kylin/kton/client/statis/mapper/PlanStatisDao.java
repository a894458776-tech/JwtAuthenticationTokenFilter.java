/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.statis.mapper;

import com.kylin.kton.client.order.entity.dto.ClientOrderDetailDTO;
import com.kylin.kton.client.statis.entity.vo.PlanStatisSearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanStatisDao {
    @Select(value={"<script> SELECT *  FROM kton_ip_dynamics_plan_statis as a WHERE merchant_id = #{vo.merchantId}  <when test='vo.startTime!=null'> AND a.statis_date  &gt;= #{vo.startTime} </when> <when test='vo.endTime!=null'> AND a.statis_date  &lt;= #{vo.endTime} </when> ORDER BY a.statis_date DESC</script>"})
    public List<ClientOrderDetailDTO> orderList(@Param(value="vo") PlanStatisSearchVO var1);
}

