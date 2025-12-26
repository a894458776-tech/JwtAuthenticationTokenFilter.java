/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.client.ip.entity.vo.ConfNumListVO;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import java.math.BigDecimal;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaticConfigPlanDao {
    @Select(value={"<script> SELECT *  FROM kton_ip_static_config_plan as a WHERE 1 = 1  <when test='vo.ipType!=null'> AND a.ip_type = #{vo.ipType} </when> <when test='vo.totalIps!=null'> AND a.total_ips = #{vo.totalIps} </when> <when test='vo.price!=null'> AND a.price = #{vo.price} </when> ORDER BY a.total_ips ASC </script>"})
    public List<KtonIpStaticConfigPlan> list(@Param(value="vo") ConfNumListVO var1);

    @Select(value={"<script>SELECT * FROM kton_ip_static_config_plan WHERE country_code = #{countryCode}   AND ip_type =  #{ipType}   AND is_exclusive =  #{isExclusive}   AND merchant_id = #{merchantId} LIMIT 1</script>"})
    public KtonIpStaticConfigPlan getByCountryCode(@Param(value="merchantId") Long var1, @Param(value="countryCode") String var2, @Param(value="ipType") Integer var3, @Param(value="isExclusive") Long var4);

    @Select(value={"select * from kton_ip_static_config_plan where merchant_id = #{merchantId}  limit 1"})
    public KtonIpStaticConfigPlan getByMerchantId(@Param(value="merchantId") Long var1);

    @Select(value={"<script> select sum(b.price) from kton_ip_detect a  left join kton_ip_static_config_plan b on a.country_code = b.country_code   where b.merchant_id = #{merchantId}  and a.ip in <foreach collection='ipList' item='ip' separator=',' open='(' close=')'>#{ip}</foreach>  ;</script>"})
    public BigDecimal calIpListTotalAmount(@Param(value="merchantId") Long var1, @Param(value="ipList") List<String> var2);
}

