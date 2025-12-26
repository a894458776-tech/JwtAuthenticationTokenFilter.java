/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.client.ip.entity.vo.DynamicsDaysConfigVO;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDynamicsConfigPeriodDao {
    @Select(value={"<script> WITH CombinedConfigs AS (     SELECT *     FROM kton_ip_dynamics_config_period     WHERE merchant_id = 0     UNION ALL     SELECT *     FROM kton_ip_dynamics_config_period     WHERE merchant_id = #{vo.merchantId} ) SELECT *  FROM CombinedConfigs  WHERE 1 = 1  <when test='vo.days!=null'> AND days = #{vo.days} </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> ORDER BY days ASC</script>"})
    public List<KtonIpDynamicsConfigPeriod> list(@Param(value="vo") DynamicsDaysConfigVO var1);

    @Select(value={"<script>SELECT *  FROM kton_ip_dynamics_config_period  WHERE 1 = 1  <when test='vo.days!=null'> AND days = #{vo.days} </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> ORDER BY days ASC</script>"})
    public List<KtonIpDynamicsConfigPeriod> dayConfigWithOutAuth(@Param(value="vo") DynamicsDaysConfigVO var1);
}

