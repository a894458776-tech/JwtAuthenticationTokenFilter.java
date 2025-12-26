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
package com.kylin.kton.client.ip.mapper;

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
public interface ClientStaticMerchantDao
extends KtonIpStaticMerchantMapper {
    @Select(value={"<script> SELECT *  FROM kton_ip_static_merchant   WHERE ip = #{ip} AND merchant_id = #{merchantId}   LIMIT 1  </script>"})
    public KtonIpStaticMerchant selectByIpAndMerchantId(@Param(value="ip") String var1, @Param(value="merchantId") Long var2);

    @Update(value={"<script> UPDATE kton_ip_static_merchant  SET status = #{status},     update_time = NOW() WHERE id = #{id} </script>"})
    public void updateStatus(@Param(value="id") Long var1, @Param(value="status") Integer var2);

    @Update(value={"<script> UPDATE kton_ip_static_merchant  SET status = 3,     unsubscribe_time = NOW() WHERE id = #{id} </script>"})
    public void refund(@Param(value="id") Long var1);

    @Update(value={"<script> UPDATE kton_ip_static_merchant  SET status = 1,      expire_datetime = #{vo.expireDatetime} ,     last_pool_id = #{vo.lastPoolId}     last_order_id = #{vo.lastOrderId}     unsubscribe_time = null      update_time = NOW()  WHERE ip = #{vo.ip}  AND merchant_id = #{vo.merchantId}</script>"})
    public void reBuy(@Param(value="vo") KtonIpStaticMerchant var1);

    @Select(value={"<script>  select * from kton_order_item_static a left join kton_order b on a.order_id = b.id  where b.merchant_id = #{merchantId}    and a.ip in <foreach collection='ipList' item='ip' separator=',' open='(' close=')'>#{ip}</foreach>    and a.expire_datetime is not null </script>"})
    public List<KtonOrderItemStatic> getListByIpList(@Param(value="ipList") List<String> var1, @Param(value="merchantId") Long var2);

    @Update(value={" update kton_ip_static_merchant  set expire_datetime = #{expireDatetime} ,subscribe_datetime = #{subscribeDatetime} , status = 1,last_order_id = #{orderId}  where ip = #{ip}  and merchant_id = #{merchantId}"})
    public void updateExpireDate(@Param(value="orderId") Long var1, @Param(value="expireDatetime") Date var2, @Param(value="subscribeDatetime") Date var3, @Param(value="ip") String var4, @Param(value="merchantId") Long var5);

    @Select(value={"SELECT count(*)     FROM kton_ip_static_merchant     WHERE merchant_id = #{merchantId} AND ip = #{ip}  "})
    public Integer checkIsExists(@Param(value="merchantId") Long var1, @Param(value="ip") String var2);

    @Select(value={"<script>SELECT count(*)     FROM kton_ip_static_source     WHERE  ip = #{ip}  AND expire_datetime &gt; NOW() and status !=2  </script>"})
    public Integer checkIsExpire(@Param(value="ip") String var1);
}

