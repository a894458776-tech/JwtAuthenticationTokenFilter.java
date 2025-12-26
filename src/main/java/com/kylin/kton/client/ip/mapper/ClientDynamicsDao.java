/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.client.ip.entity.dto.DynamicPlanConfigDTO;
import com.kylin.kton.client.ip.entity.vo.DynamicsConfListVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDynamicsDao {
    @Select(value={"<script>SELECT * FROM kton_ip_dynamics_config_plan WHERE merchant_id IN (    SELECT IF(EXISTS(SELECT 1 FROM kton_ip_dynamics_config_plan WHERE merchant_id = #{vo.merchantId}), #{vo.merchantId}, 0) )  <when test='vo.title!=null'> AND title = #{vo.title} </when> <when test='vo.capacity!=null'> AND capacity = #{vo.capacity} </when> <when test='vo.status!=null'> AND status = #{vo.status} </when>ORDER BY capacity ASC </script>"})
    public List<DynamicPlanConfigDTO> planConfig(@Param(value="vo") DynamicsConfListVO var1);

    @Select(value={"<script>SELECT *  FROM kton_ip_dynamics_config_plan  WHERE 1 = 1  <when test='vo.title!=null'> AND title = #{vo.title} </when> <when test='vo.capacity!=null'> AND capacity = #{vo.capacity} </when> <when test='vo.status!=null'> AND status = #{vo.status} </when> ORDER BY capacity ASC</script>"})
    public List<DynamicPlanConfigDTO> planConfigWithOutAuth(@Param(value="vo") DynamicsConfListVO var1);
}

