/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.order.mapper;

import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminOrderItemStaticDao {
    @Insert(value={"<script>insert into kton_order_item_static (order_id,order_type,price,currency,days,discount,continent,country_code,  location,ip,pool_id,effective_datetime,expire_datetime,account,password,port,status) values <foreach collection='orderItems' item='dto' separator=','> (#{dto.orderId},#{dto.orderType},#{dto.price},#{dto.currency},#{dto.days},#{dto.discount},#{dto.continent},#{dto.countryCode},#{dto.location},#{dto.ip},#{dto.poolId},#{dto.effectiveDatetime},#{dto.expireDatetime},#{dto.account},#{dto.password},#{dto.port},#{dto.status} )</foreach></script>"})
    public void saveBatch(@Param(value="orderItems") List<KtonOrderItemStatic> var1);

    @Select(value={"<script> SELECT a.*  FROM kton_order_item_static as a  INNER JOIN  kton_order as b ON a.order_id  = b.id  WHERE a.ip = #{ip} AND b.merchant_id = #{merchantId} AND a.order_id = #{orderId}   LIMIT 1  </script>"})
    public KtonOrderItemStatic selectByIp(@Param(value="ip") String var1, @Param(value="merchantId") Long var2, @Param(value="orderId") Long var3);
}

