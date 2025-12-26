/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolDTO;
import com.kylin.kton.client.ip.entity.dto.RegionalAvailableIpsDTO;
import com.kylin.kton.client.ip.entity.vo.ClientRegionalAvailableIpsVO;
import com.kylin.kton.client.ip.entity.vo.ClientStaticPoolSearchVO;
import com.kylin.kton.client.ip.entity.vo.StaticPoolSearchVO;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaticPoolDao {
    @Select(value={"<script>", " SELECT *,  (SELECT COUNT(*)   FROM kton_ip_static_pool_item a   INNER JOIN kton_ip_static_source b ON a.ip = b.ip   LEFT JOIN kton_ip_static_merchant m     ON m.ip = a.ip     AND m.merchant_id = #{vo.merchantId}   WHERE a.pool_id = kton_ip_static_pool.id     AND a.merchant_id = #{vo.merchantId}     AND b.status != 2     AND b.assign_times &lt;= #{assignTimes}     AND b.expire_datetime &gt; NOW() ", "    <when test='assignTimes &gt; 0'> AND b.is_exclusive = 0 </when>    AND m.ip IS NULL  ) AS effective_totals  FROM kton_ip_static_pool  WHERE 1 = 1  <if test='vo.type != null'> AND type = #{vo.type} </if> <if test='vo.continent != null'> AND continent = #{vo.continent} </if> <if test='vo.countryCode != null'> AND country_code = #{vo.countryCode} </if> ORDER BY id DESC </script>"})
    public List<ClientIpStaticPoolDTO> list(@Param(value="vo") StaticPoolSearchVO var1, @Param(value="assignTimes") Integer var2);

    @Select(value={"<script>\nSELECT * FROM kton_ip_static_config_plan WHERE merchant_id IN (    SELECT IF(EXISTS(SELECT 1 FROM kton_ip_static_config_plan WHERE merchant_id = #{merchantId}), #{merchantId}, 0) ) AND ip_type = #{ipType} AND country_code = #{countryCode} AND is_exclusive = #{isExclusive} ORDER BY price ASC </script>"})
    public List<KtonIpStaticConfigPlan> selectConfigPlans(@Param(value="countryCode") String var1, @Param(value="ipType") Long var2, @Param(value="merchantId") Long var3, @Param(value="isExclusive") Long var4);

    @Select(value={"<script> SELECT *  FROM kton_ip_static_pool  WHERE 1 = 1  <if test='vo.type != null'> AND type = #{vo.type} </if> <if test='vo.continent != null and vo.continent != \"\"'> AND continent = #{vo.continent} </if> <if test='vo.countryCode != null and vo.countryCode != \"\"'> AND country_code = #{vo.countryCode} </if> <if test='vo.location != null and vo.location != \"\"'> AND location = #{vo.location} </if> LIMIT 1 </script>"})
    public KtonIpStaticPool getByCode(@Param(value="vo") ClientStaticPoolSearchVO var1);

    @Select(value={"<script> SELECT *,(SELECT COUNT(*)   FROM kton_ip_static_pool_item a   INNER JOIN kton_ip_static_source b ON a.ip = b.ip   LEFT JOIN kton_ip_static_merchant m     ON m.ip = a.ip     AND m.merchant_id = #{vo.merchantId}   WHERE a.pool_id = kton_ip_static_pool.id     AND a.merchant_id = #{vo.merchantId}     AND b.status != 2     AND b.assign_times &lt;= #{assignTimes}     AND b.expire_datetime &gt; NOW() ", "    <when test='assignTimes &gt; 0'> AND b.is_exclusive = 0 </when>    AND m.ip IS NULL  ) AS ip_totals  FROM kton_ip_static_pool  WHERE 1 = 1  <when test='vo.type!=null'> AND type = #{vo.type} </when> <when test='vo.continents!=null and !vo.continents.isEmpty()'>    AND continent IN    <foreach collection='vo.continents' item='item' open='(' separator=',' close=')'>      #{item}    </foreach>  </when> <when test='vo.countryCodes!=null and !vo.countryCodes.isEmpty()'>    AND country_code IN    <foreach collection='vo.countryCodes' item='item' open='(' separator=',' close=')'>      #{item}    </foreach>  </when> <when test='vo.locations!=null and !vo.locations.isEmpty()'>    AND location IN    <foreach collection='vo.locations' item='item' open='(' separator=',' close=')'>      #{item}    </foreach>  </when> ORDER BY id DESC</script>"})
    public List<RegionalAvailableIpsDTO> regionalAvailableIps(@Param(value="vo") ClientRegionalAvailableIpsVO var1, @Param(value="assignTimes") Integer var2);

    @Select(value={"<script> SELECT * FROM kton_ip_static_config_plan WHERE merchant_id IN (    SELECT IF(EXISTS(SELECT 1 FROM kton_ip_static_config_plan WHERE merchant_id = #{merchantId}), #{merchantId}, 0) ) AND ip_type = #{ipType} AND is_exclusive = #{isExclusive} AND country_code = #{countryCode} ORDER BY price ASC LIMIT 1 </script>"})
    public KtonIpStaticConfigPlan selectConfigPlanPrice(@Param(value="countryCode") String var1, @Param(value="ipType") Long var2, @Param(value="merchantId") Long var3, @Param(value="isExclusive") Long var4);

    @Select(value={" SELECT a.* FROM kton_ip_static_pool AS a  INNER JOIN kton_ip_static_pool_item AS b ON a.id = b.pool_id  WHERE   b.ip = #{ip} and b.merchant_id = #{merchantId} limit 1"})
    public KtonIpStaticPool getByIp(@Param(value="ip") String var1, @Param(value="merchantId") Long var2);
}

