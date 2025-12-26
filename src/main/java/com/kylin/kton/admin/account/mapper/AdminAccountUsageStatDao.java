/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.account.mapper;

import com.kylin.kton.admin.account.entity.dto.AdminAccountStatDTO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountStatSearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAccountUsageStatDao {
    @Select(value={"<script> SELECT *, SUM(requests) as requestsTotal, SUM(traffic) as trafficTotal  FROM kton_ip_dynamics_account_usage_stat  WHERE merchant_id = #{vo.merchantId}  <when test='vo.startTime!=null'> AND d_usage  &gt;= #{vo.startTime} </when> <when test='vo.endTime!=null'> AND d_usage &lt;= #{vo.endTime} </when> GROUP BY d_usage ORDER BY d_usage ASC </script>"})
    public List<AdminAccountStatDTO> list(@Param(value="vo") AdminAccountStatSearchVO var1);
}

