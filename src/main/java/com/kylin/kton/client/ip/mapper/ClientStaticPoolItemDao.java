/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolDTO;
import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolItemDTO;
import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolMerchantDTO;
import com.kylin.kton.client.ip.entity.dto.UpdateIpStaticPoolItemDTO;
import com.kylin.kton.client.ip.entity.dto.UpdateIpStaticPoolItemSingleDTO;
import com.kylin.kton.client.ip.entity.vo.IpStaticPoolItemSearchVO;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaticPoolItemDao {
    @Select(value={"select * from kton_ip_static_pool_item where pool_id = #{poolId} and status = #{status}  order by id asc limit #{num} "})
    public List<KtonIpStaticPoolItem> orderItems(@Param(value="poolId") Long var1, @Param(value="status") Long var2, @Param(value="num") Integer var3);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item  SET status =  #{status} ,     update_time = NOW() WHERE pool_id = #{poolId} and ip = #{ip} </script>"})
    public int updateByPoolIdAndIp(@Param(value="poolId") Long var1, @Param(value="ip") String var2, @Param(value="status") Integer var3);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item SET status = #{dto.status},     update_time = NOW() WHERE ip IN   <foreach collection='dto.ips' item='ip' index='index' open='(' close=')' separator=','>    #{ip}  </foreach>  AND status = 0 </script>"})
    public void batchEdit(@Param(value="dto") UpdateIpStaticPoolItemDTO var1);

    @Select(value={"<script> SELECT *,(SELECT COUNT(*) FROM kton_ip_static_pool_item WHERE pool_id = kton_ip_static_pool.id ) AS ip_totals,(SELECT COUNT(*) FROM kton_ip_static_pool_item WHERE pool_id = kton_ip_static_pool.id AND STATUS = 0 ) AS effective_totals  FROM kton_ip_static_pool  WHERE 1 = 1  <when test='vo.type!=null'> AND type = #{vo.type} </when> <when test='vo.continent!=null'> AND continent = #{vo.continent} </when> <when test='vo.countryCode!=null'> AND country_code = #{vo.countryCode} </when> ORDER BY id DESC</script>"})
    public List<ClientIpStaticPoolDTO> list(@Param(value="vo") KtonIpStaticPool var1);

    @Select(value={"<script> SELECT c.account, c.password, c.port, c.ip, a.effective_datetime,    a.expire_datetime,a.unsubscribe_time,a.create_time, a.status, b.is_native type, b.country_code, b.province location FROM kton_ip_static_merchant AS a  INNER JOIN kton_ip_detect AS b ON a.ip = b.ip INNER JOIN kton_ip_static_source AS c ON a.ip = c.ip WHERE a.merchant_id = #{vo.merchantId}    <when test='vo.type!=null'> AND b.is_native = #{vo.type} </when> <when test='vo.ip!=null'> AND a.ip like concat('%', #{vo.ip}, '%') </when> <when test='vo.status!=null'> AND a.status = #{vo.status} </when> <when test='vo.countryCode!=null'> AND b.country_code = #{vo.countryCode} </when> <when test='vo.orderNo!=null'>   AND EXISTS (        SELECT 1        FROM kton_order_item_static AS ois        INNER JOIN kton_order AS o ON ois.order_id = o.id        WHERE ois.ip = a.ip          AND o.order_no = #{vo.orderNo}    )</when> ORDER BY a.expire_datetime  DESC</script>"})
    public List<ClientIpStaticPoolMerchantDTO> merchantIpList(@Param(value="vo") IpStaticPoolItemSearchVO var1);

    @Select(value={"<script> SELECT *  FROM kton_ip_static_pool_item   WHERE ip = #{ip} AND merchant_id = #{merchantId}   LIMIT 1  </script>"})
    public KtonIpStaticPoolItem selectByIp(@Param(value="ip") String var1, @Param(value="merchantId") Long var2);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item  SET status = #{status},     update_time = NOW() WHERE id = #{id} </script>"})
    public void updateStatus(@Param(value="id") Long var1, @Param(value="status") Integer var2);

    @Select(value={"<script>SELECT * FROM kton_ip_static_pool_item AS a  INNER JOIN  kton_ip_static_source AS b  ON a.ip = b.ip  LEFT JOIN kton_ip_static_merchant m   ON m.ip = a.ip   AND m.merchant_id = #{merchantId}  WHERE a.pool_id = #{poolId}   AND a.merchant_id = #{merchantId}   AND b.status!=2    AND b.assign_times &lt;= #{assignTimes}   AND b.expire_datetime > NOW()     <when test='assignTimes &gt; 0'> AND b.is_exclusive = 0 </when>  AND m.ip IS NULL  order by b.assign_times asc,b.id asc limit 1 </script>"})
    public ClientIpStaticPoolItemDTO getIp(@Param(value="poolId") Long var1, @Param(value="merchantId") Long var2, @Param(value="assignTimes") Integer var3);

    @Select(value={"<script>SELECT * FROM kton_ip_static_pool_item AS a  INNER JOIN  kton_ip_static_source AS b  ON a.ip = b.ip  LEFT JOIN kton_ip_static_merchant m   ON m.ip = a.ip   AND m.merchant_id = #{merchantId}  WHERE a.pool_id = #{poolId}   AND a.merchant_id = #{merchantId}   AND b.status!=2    AND b.assign_times &lt;= #{assignTimes}   AND b.expire_datetime > NOW()     <when test='assignTimes &gt; 0'> AND b.is_exclusive = 0 </when>  AND m.ip IS NULL  order by b.assign_times asc,b.id asc  </script>"})
    public List<ClientIpStaticPoolItemDTO> listAvailableIps(@Param(value="poolId") Long var1, @Param(value="merchantId") Long var2, @Param(value="assignTimes") Integer var3);

    @Select(value={"<script>SELECT COUNT(*) ", "FROM kton_ip_static_pool_item a ", "INNER JOIN kton_ip_static_source b ON a.ip = b.ip ", "LEFT JOIN kton_ip_static_merchant m ", "  ON m.ip = a.ip ", "  AND m.merchant_id = #{merchantId} ", "WHERE a.pool_id = #{poolId} ", "  AND a.merchant_id = #{merchantId} ", "  AND b.status != 2 ", "  AND b.assign_times &lt;= #{assignTimes} ", "  AND b.expire_datetime > NOW() ", "    <when test='assignTimes &gt; 0'> AND b.is_exclusive = 0 </when>  AND m.ip IS NULL</script>"})
    public Integer getAvailableStock(@Param(value="poolId") Long var1, @Param(value="merchantId") Long var2, @Param(value="assignTimes") Integer var3);

    @Select(value={"SELECT * ", "FROM kton_ip_static_pool_item a ", "INNER JOIN kton_ip_static_source b ON a.ip = b.ip ", "LEFT JOIN kton_ip_static_merchant m ", "  ON m.ip = a.ip ", "  AND m.merchant_id = #{merchantId} ", "WHERE a.pool_id = #{poolId} ", "  AND a.merchant_id = #{merchantId} ", "  AND b.status != 2 ", "  AND m.ip IS NULL"})
    public List<KtonIpStaticPoolItem> selectByPoolAndMerchant(@Param(value="poolId") Long var1, @Param(value="merchantId") Long var2);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item SET status = #{dto.status},     update_time = NOW() WHERE ip = #{dto.ip} AND status = 0 </script>"})
    public void updateSingle(@Param(value="dto") UpdateIpStaticPoolItemSingleDTO var1);

    @Update(value={"<script> UPDATE kton_ip_static_pool_item SET status = #{dto.status},     update_time = NOW() WHERE ip = #{dto.ip} AND status = 0 </script>"})
    public void resetPoolItemStatusByIp(@Param(value="dto") KtonIpStaticPoolItem var1);
}

