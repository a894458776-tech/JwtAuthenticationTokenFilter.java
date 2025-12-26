/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.domain.KtonMerchant
 *  com.kylin.kton.system.mapper.KtonIpStaticConfigPlanMapper
 *  org.apache.ibatis.annotations.One
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticConfigPlanDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticConfigPlanSearchVO;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.domain.KtonMerchant;
import com.kylin.kton.system.mapper.KtonIpStaticConfigPlanMapper;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStaticConfigPlanDao
extends KtonIpStaticConfigPlanMapper {
    @Select(value={"<script> SELECT *   FROM kton_ip_static_config_plan  AS a  WHERE 1 = 1  <when test='vo.ipType!=null'>  AND ip_type =   #{vo.ipType} </when> <when test='vo.isExclusive!=null'>  AND is_exclusive =   #{vo.isExclusive} </when> <when test='vo.merchantId!=null'>  AND merchant_id =   #{vo.merchantId} </when> ORDER BY price DESC</script>"})
    @Results(value={@Result(column="merchant_id", property="merchantId"), @Result(column="merchant_id", property="merchant", one=@One(select="selectMerchantInfo"))})
    public List<AdminIpStaticConfigPlanDTO> list(@Param(value="vo") AdminIpStaticConfigPlanSearchVO var1);

    @Select(value={"select * from kton_merchant where id = #{merchantId}"})
    public KtonMerchant selectMerchantInfo(@Param(value="merchantId") Long var1);

    @Select(value={"<script>SELECT * FROM kton_ip_static_config_plan WHERE country_code = #{countryCode}   AND ip_type =  #{ipType}   AND is_exclusive =  #{isExclusive}   AND merchant_id = #{merchantId} LIMIT 1</script>"})
    public KtonIpStaticConfigPlan getByCountryCode(@Param(value="merchantId") Long var1, @Param(value="countryCode") String var2, @Param(value="ipType") Integer var3, @Param(value="isExclusive") Long var4);

    @Select(value={"select * from kton_ip_static_config_plan where merchant_id = #{merchantId} limit 1"})
    public KtonIpStaticConfigPlan getByMerchantId(@Param(value="merchantId") Long var1);

    @Select(value={"<script> SELECT * FROM kton_ip_static_config_plan WHERE merchant_id =   #{merchantId} AND ip_type = #{ipType} AND country_code = #{countryCode} AND is_exclusive = #{isExclusive} ORDER BY price ASC LIMIT 1 </script>"})
    public KtonIpStaticConfigPlan selectConfigPlanPrice(@Param(value="countryCode") String var1, @Param(value="ipType") Long var2, @Param(value="merchantId") Long var3, @Param(value="isExclusive") Long var4);

    @Select(value={"<script>\nSELECT * FROM kton_ip_static_config_plan WHERE merchant_id IN (    SELECT IF(EXISTS(SELECT 1 FROM kton_ip_static_config_plan WHERE merchant_id = #{merchantId}), #{merchantId}, 0) ) AND ip_type = #{ipType} AND country_code = #{countryCode} AND is_exclusive = #{isExclusive} ORDER BY price ASC </script>"})
    public List<KtonIpStaticConfigPlan> selectConfigPlans(@Param(value="countryCode") String var1, @Param(value="ipType") Long var2, @Param(value="merchantId") Long var3, @Param(value="isExclusive") Long var4);

    @Select(value={"<script> select sum(b.price) from kton_ip_detect a  left join kton_ip_static_config_plan b on a.country_code = b.country_code   where b.merchant_id = #{merchantId}  and a.ip in <foreach collection='ipList' item='ip' separator=',' open='(' close=')'>#{ip}</foreach>  ;</script>"})
    public BigDecimal calIpListTotalAmount(@Param(value="merchantId") Long var1, @Param(value="ipList") List<String> var2);

    @Select(value={"<script> SELECT * FROM kton_ip_static_config_plan WHERE merchant_id =   #{merchantId} AND ip_type = #{ipType} AND country_code = #{countryCode} AND is_exclusive = #{isExclusive} ORDER BY id ASC LIMIT 1 </script>"})
    public KtonIpStaticConfigPlan checkConfig(@Param(value="countryCode") String var1, @Param(value="ipType") Long var2, @Param(value="merchantId") Long var3, @Param(value="isExclusive") Long var4);
}

