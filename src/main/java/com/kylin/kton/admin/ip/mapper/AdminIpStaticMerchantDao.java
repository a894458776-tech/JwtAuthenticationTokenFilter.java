/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  com.kylin.kton.system.mapper.KtonIpStaticMerchantMapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticMerchantDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticMerchantSearchVO;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.mapper.KtonIpStaticMerchantMapper;
import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminIpStaticMerchantDao
extends KtonIpStaticMerchantMapper {
    @Select(value={"<script> SELECT c.account, c.password, c.port, c.ip,c.is_exclusive, a.effective_datetime,    a.expire_datetime,a.unsubscribe_time,a.create_time, a.status, b.is_native type, b.country_code, b.province location FROM kton_ip_static_merchant AS a  INNER JOIN kton_ip_detect AS b ON a.ip = b.ip INNER JOIN kton_ip_static_source AS c ON a.ip = c.ip WHERE 1 = 1     <when test='vo.merchantId!=null'> AND a.merchant_id = #{vo.merchantId} </when> <when test='vo.type!=null'> AND b.is_native = #{vo.type} </when> <when test='vo.ip!=null'> AND a.ip like concat('%', #{vo.ip}, '%') </when> <when test='vo.status!=null'> AND a.status = #{vo.status} </when> <when test='vo.countryCode!=null'> AND b.country_code = #{vo.countryCode} </when> <when test='vo.orderNo!=null'>   AND EXISTS (        SELECT 1        FROM kton_order_item_static AS ois        INNER JOIN kton_order AS o ON ois.order_id = o.id        WHERE ois.ip = a.ip          AND o.order_no = #{vo.orderNo}    )</when> ORDER BY a.expire_datetime  DESC,a.id desc </script>"})
    public List<AdminIpStaticMerchantDTO> list(@Param(value="vo") AdminIpStaticMerchantSearchVO var1);

    @Select(value={"<script> SELECT *  FROM kton_ip_static_merchant   WHERE ip = #{ip} AND merchant_id = #{merchantId}   LIMIT 1  </script>"})
    public KtonIpStaticMerchant selectByIpAndMerchantId(@Param(value="ip") String var1, @Param(value="merchantId") Long var2);

    @Update(value={"<script> UPDATE kton_ip_static_merchant  SET status = #{status},     update_time = NOW() WHERE id = #{id} </script>"})
    public void updateStatus(@Param(value="id") Long var1, @Param(value="status") Integer var2);

    @Update(value={"<script> UPDATE kton_ip_static_merchant  SET status = 3,     unsubscribe_time = NOW() WHERE id = #{id} </script>"})
    public void refund(@Param(value="id") Long var1);

    @Select(value={"<script>  select * from kton_order_item_static a left join kton_order b on a.order_id = b.id  where b.merchant_id = #{merchantId}    and a.ip in <foreach collection='ipList' item='ip' separator=',' open='(' close=')'>#{ip}</foreach>    and a.expire_datetime is not null </script>"})
    public List<KtonOrderItemStatic> getListByIpList(@Param(value="ipList") List<String> var1, @Param(value="merchantId") Long var2);

    @Select(value={"SELECT count(*)     FROM kton_ip_static_merchant     WHERE merchant_id = #{merchantId} AND ip = #{ip}  "})
    public Integer checkIsExists(@Param(value="merchantId") Long var1, @Param(value="ip") String var2);

    @Select(value={"<script>SELECT count(*)     FROM kton_ip_static_source     WHERE  ip = #{ip}  AND expire_datetime &gt; NOW() and status !=2  </script>"})
    public Integer checkIsExpire(@Param(value="ip") String var1);

    @Update(value={" update kton_ip_static_merchant  set expire_datetime = #{expireDatetime} ,subscribe_datetime = #{subscribeDatetime} , status = 1,last_order_id = #{orderId}  where ip = #{ip}  and merchant_id = #{merchantId}"})
    public void updateExpireDate(@Param(value="orderId") Long var1, @Param(value="expireDatetime") Date var2, @Param(value="subscribeDatetime") Date var3, @Param(value="ip") String var4, @Param(value="merchantId") Long var5);
}

