/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminRegionalAvailableIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminRegionalAvailableIpsVO;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface IpStaticPoolSourceDao {
    @Insert(value={"<script>insert into kton_ip_static_source(source_id,account,password,port,ip,effective_datetime,expire_datetime) values <foreach collection='list' item='p' separator=','>(#{p.sourceId},#{p.account}, #{p.password}, #{p.port}, #{p.ip}, #{p.effectiveDatetime}, #{p.expireDatetime})</foreach>on duplicate key update effective_datetime=values(effective_datetime),expire_datetime=values(expire_datetime)</script>"})
    public Integer batchSaveOrUpdate(@Param(value="list") List<KtonIpStaticSource> var1);

    @Update(value={"<script> update kton_ip_static_source set status = 2  where source_id = #{sourceId}    and ip not in <foreach collection='ipList' item='ip' separator=',' open='(' close=')'>#{ip}</foreach> </script>"})
    public void updateExpireIpList(@Param(value="ipList") List<String> var1, @Param(value="sourceId") Long var2);

    @Update(value={"UPDATE kton_ip_static_source ", "SET assign_times = assign_times + 1 ", "WHERE ip = #{ip} "})
    public int incrementAssignTimes(String var1);

    @Update(value={"UPDATE kton_ip_static_source ", "SET assign_times = GREATEST(0, assign_times - 1) ", "WHERE ip = #{ip} AND assign_times > 0"})
    public int subtAssignTimes(String var1);

    @Select(value={"<script> SELECT *,(SELECT COUNT(*)   FROM kton_ip_static_pool_item a   INNER JOIN kton_ip_static_source b ON a.ip = b.ip   LEFT JOIN kton_ip_static_merchant m     ON m.ip = a.ip     AND m.merchant_id = #{vo.merchantId}   WHERE a.pool_id = kton_ip_static_pool.id     AND a.merchant_id = #{vo.merchantId}     AND b.status != 2     AND b.assign_times &lt;= #{assignTimes}     AND b.expire_datetime &gt; NOW() ", "    AND m.ip IS NULL  ) AS ip_totals  FROM kton_ip_static_pool  WHERE 1 = 1  <when test='vo.type!=null'> AND type = #{vo.type} </when> <when test='vo.continents!=null and !vo.continents.isEmpty()'>    AND continent IN    <foreach collection='vo.continents' item='item' open='(' separator=',' close=')'>      #{item}    </foreach>  </when> <when test='vo.countryCodes!=null and !vo.countryCodes.isEmpty()'>    AND country_code IN    <foreach collection='vo.countryCodes' item='item' open='(' separator=',' close=')'>      #{item}    </foreach>  </when> <when test='vo.locations!=null and !vo.locations.isEmpty()'>    AND location IN    <foreach collection='vo.locations' item='item' open='(' separator=',' close=')'>      #{item}    </foreach>  </when> ORDER BY id DESC</script>"})
    public List<AdminRegionalAvailableIpsDTO> regionalAvailableIps(@Param(value="vo") AdminRegionalAvailableIpsVO var1, @Param(value="assignTimes") Integer var2);

    @Select(value={"SELECT * FROM kton_ip_static_source WHERE ip = #{ip}  LIMIT 1"})
    public KtonIpStaticSource getAuthInfoByIp(@Param(value="ip") String var1);
}

