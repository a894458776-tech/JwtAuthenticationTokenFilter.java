/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminMerchantAvailableIpListDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantInventoryIpsDTO;
import com.kylin.kton.admin.ip.entity.dto.ContinentDto;
import com.kylin.kton.admin.ip.entity.vo.AdminMerchantInventoryIpsVO;
import com.kylin.kton.admin.ip.entity.vo.MerchantAvailableIpListVO;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IpStaticPoolMapper {
    @Insert(value={"<script>insert into kton_ip_static_pool(`type`,continent,country_code,location) values <foreach collection='list' item='p' separator=','>(#{type}, #{p.continent}, #{p.countryCode}, #{p.location})</foreach>on duplicate key update continent=values(continent)</script>"})
    public Integer batchSaveOrUpdatePool(@Param(value="list") List<ContinentDto> var1, @Param(value="type") Integer var2);

    @Insert(value={"<script>INSERT INTO kton_ip_static_source(source_id, account, password, port, ip, effective_datetime, expire_datetime) VALUES <foreach collection='list' item='p' separator=','>(#{sourceId}, #{p.account}, #{p.password}, #{p.port}, #{p.ip}, #{p.effectiveDatetime}, #{p.expireDatetime})</foreach> ON DUPLICATE KEY UPDATE effective_datetime = VALUES(effective_datetime), expire_datetime = VALUES(expire_datetime)</script>"})
    public Integer batchSaveOrUpdateSource(@Param(value="list") List<KtonIpStaticSource> var1, @Param(value="sourceId") Long var2);

    @Insert(value={"<script>insert into kton_ip_static_pool_item(account,password,port,ip,effective_datetime,expire_datetime) values <foreach collection='list' item='p' separator=','>( #{p.account}, #{p.password}, #{p.port}, #{p.ip}, #{p.effectiveDatetime}, #{p.expireDatetime})</foreach>on duplicate key update effective_datetime=values(effective_datetime),expire_datetime=values(expire_datetime)</script>"})
    public Integer batchSaveOrUpdate(@Param(value="list") List<KtonIpStaticPoolItem> var1);

    @Select(value={"<script> SELECT *  FROM kton_ip_static_pool  WHERE 1 = 1  <when test='type!=null'> AND type = #{type} </when> <when test='continent!=null'> AND continent = #{continent} </when> <when test='countryCode!=null'> AND country_code = #{countryCode} </when> <when test='location!=null'> AND location = #{location} </when> LIMIT 1 </script>"})
    public KtonIpStaticPool getByCode(@Param(value="type") Long var1, @Param(value="continent") String var2, @Param(value="countryCode") String var3, @Param(value="location") String var4);

    @Select(value={"<script> SELECT a.ip,a.pool_id    FROM kton_ip_static_pool_item a    JOIN kton_ip_static_source b    ON a.ip = b.ip      AND b.status != 2      AND b.assign_times &lt;= #{assignTimes}      AND b.expire_datetime &gt; NOW()  <when test='assignTimes &gt; 0'> AND b.is_exclusive=0 </when> WHERE 1 = 1  <when test='vo.ipFuzzyField!=null'> AND a.ip like concat('%', #{vo.ipFuzzyField}, '%') </when>     AND  a.pool_id = #{vo.poolId}      AND a.merchant_id = #{vo.merchantId}      AND NOT EXISTS (        SELECT 1 FROM kton_ip_static_merchant m        WHERE m.ip = a.ip          AND m.merchant_id = #{vo.merchantId}      ) </script>"})
    public List<AdminMerchantAvailableIpListDTO> getMerchantAvailableIpList(@Param(value="vo") MerchantAvailableIpListVO var1, @Param(value="assignTimes") Integer var2);

    @Select(value={"<script>", " SELECT *,  (SELECT COUNT(*)   FROM kton_ip_static_pool_item a   INNER JOIN kton_ip_static_source b ON a.ip = b.ip   LEFT JOIN kton_ip_static_merchant m     ON m.ip = a.ip     AND m.merchant_id = #{vo.merchantId}   WHERE a.pool_id = kton_ip_static_pool.id     AND a.merchant_id = #{vo.merchantId}     AND b.status != 2     AND b.assign_times &lt;= #{assignTimes}     <when test='assignTimes &gt; 0'> AND b.is_exclusive=0 </when>    AND m.ip IS NULL  ) AS effective_totals  FROM kton_ip_static_pool  WHERE 1 = 1  <if test='vo.type != null'> AND type = #{vo.type} </if> <if test='vo.continent != null'> AND continent = #{vo.continent} </if> <if test='vo.countryCode != null'> AND country_code = #{vo.countryCode} </if> ORDER BY id DESC </script>"})
    public List<AdminMerchantInventoryIpsDTO> merchantInventoryIps(@Param(value="vo") AdminMerchantInventoryIpsVO var1, @Param(value="assignTimes") Integer var2);
}

