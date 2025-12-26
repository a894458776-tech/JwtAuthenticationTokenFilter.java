/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  com.kylin.kton.system.domain.KtonOrderItemVps
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.apache.ibatis.annotations.Update
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.order.mapper;

import com.kylin.kton.client.order.entity.dto.ClientOrderItemStaticDTO;
import com.kylin.kton.client.order.entity.dto.ClientOrderItemVpsDTO;
import com.kylin.kton.client.order.entity.dto.DaysUntilExpireDTO;
import com.kylin.kton.client.order.entity.vo.BeenPurchasedVO;
import com.kylin.kton.client.order.entity.vo.PurchasedListSearchVO;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import com.kylin.kton.system.domain.KtonOrderItemVps;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderItemDao {
    @Insert(value={"<script>insert into kton_order_item_static (order_id,order_type,price,currency,days,discount,continent,country_code,  location,ip,pool_id,effective_datetime,expire_datetime,account,password,port,status) values <foreach collection='orderItems' item='dto' separator=','> (#{dto.orderId},#{dto.orderType},#{dto.price},#{dto.currency},#{dto.days},#{dto.discount},#{dto.continent},#{dto.countryCode},#{dto.location},#{dto.ip},#{dto.poolId},#{dto.effectiveDatetime},#{dto.expireDatetime},#{dto.account},#{dto.password},#{dto.port},#{dto.status} )</foreach></script>"})
    public void saveBatch(@Param(value="orderItems") List<KtonOrderItemStatic> var1);

    @Select(value={"<script> SELECT count(*) FROM kton_order_item_static AS a  LEFT JOIN kton_order AS b ON a.order_id = b.id WHERE b.merchant_id = #{merchantId} AND a.order_type = #{orderType} AND b.paid_status = 20 </script>"})
    public Integer ipTotal(@Param(value="merchantId") Long var1, @Param(value="orderType") Long var2);

    @Select(value={"<script> SELECT    DATEDIFF( expire_datetime,CURDATE()) AS days_until_expire FROM     kton_order      WHERE merchant_id = #{merchantId} and paid_status =20 ORDER BY     ABS(DATEDIFF( expire_datetime,CURDATE())) ASC LIMIT 1;</script>"})
    public DaysUntilExpireDTO daysUntilExpire(@Param(value="merchantId") Long var1);

    @Select(value={"<script> SELECT count(*) FROM kton_order_item_static AS a   LEFT JOIN kton_order AS b ON a.order_id = b.id  WHERE b.merchant_id = #{merchantId} AND a.order_type = #{orderType}  AND b.paid_status = 20  AND DATE(b.expire_datetime) BETWEEN DATE_SUB(CURDATE(), INTERVAL 7 DAY) AND CURDATE();</script>"})
    public Integer expiringSoonIps(@Param(value="merchantId") Long var1, @Param(value="orderType") Long var2);

    @Select(value={"<script> SELECT *  FROM kton_order_item_static as a LEFT JOIN kton_order as b ON a.order_id = b.id  WHERE b.merchant_id = #{vo.merchantId} and b.paid_status = 20  <when test='vo.continent!=null'> AND a.continent = #{vo.continent} </when> <when test='vo.countryCode!=null'> AND a.country_code = #{vo.countryCode} </when> <when test='vo.orderType!=null'> AND a.order_type = #{vo.orderType} </when> <when test='vo.location!=null'> AND a.location = #{vo.location} </when> <when test='vo.ip!=null'> AND a.ip = #{vo.ip} </when> <when test='vo.port!=null'> AND a.port = #{vo.port} </when> ORDER BY a.id DESC</script>"})
    public List<ClientOrderItemStaticDTO> purchasedList(@Param(value="vo") PurchasedListSearchVO var1);

    @Select(value={"<script> SELECT count(*)  FROM kton_order as a  WHERE merchant_id = #{vo.merchantId} and product_type =#{vo.productType}  and paid_status = 20  ORDER BY a.id DESC</script>"})
    public Integer beenPurchased(@Param(value="vo") BeenPurchasedVO var1);

    @Select(value={"<script> SELECT *  FROM kton_order_item_vps as a  WHERE order_id = #{orderId}</script>"})
    public List<KtonOrderItemVps> getVpsItemByOrderId(@Param(value="orderId") Long var1);

    @Select(value={"<script> SELECT a.*,b.ref_id as hostTemplateId,c.vps_ip as hostIp,c.container_id as containerId,d.order_no as orderNo  FROM kton_order_item_vps as a  LEFT JOIN kton_cluster_host_template b on a.host_template_id = b.id LEFT JOIN kton_vps_host_container c on a.vps_id = c.id LEFT JOIN kton_order d on d.id = a.order_id WHERE order_id = #{orderId}</script>"})
    public List<ClientOrderItemVpsDTO> getVpsItemByOrderId2(@Param(value="orderId") Long var1);

    @Select(value={"<script> SELECT a.*  FROM kton_order_item_static as a  INNER JOIN  kton_order as b ON a.order_id  = b.id  WHERE a.ip = #{ip} AND b.merchant_id = #{merchantId} AND a.order_id = #{orderId}   LIMIT 1  </script>"})
    public KtonOrderItemStatic selectByIp(@Param(value="ip") String var1, @Param(value="merchantId") Long var2, @Param(value="orderId") Long var3);

    @Update(value={"UPDATE kton_order_item_static SET ip = #{ip}, account = #{account}, password = #{password}, port = #{port}, protocolse = #{protocolse} WHERE id = #{id}"})
    public void updateSingleItem(KtonOrderItemStatic var1);

    @Update(value={"UPDATE kton_order_item_vps SET vps_id = #{vpsId},     order_id = #{orderId},     host_ip = #{hostIp},     host_id = #{hostId},     cluster_id = #{clusterId},     vps_ip = #{vpsIp},     host_template_id = #{hostTemplateId},     activation_duration_type = #{activationDurationType},     vps_type = #{vpsType},     continent = #{continent},     country_code = #{countryCode},     city = #{city},     effective_datetime = #{effectiveDatetime},     expire_datetime = #{expireDatetime},     model = #{model},     cpu_cores = #{cpuCores},     cpu_model = #{cpuModel},     memory = #{memory},     disk_capacity = #{diskCapacity},     disk_model = #{diskModel},     io_write = #{ioWrite},     io_read = #{ioRead},     bandwidth = #{bandwidth},     internet_traffic = #{internetTraffic},     ip_v4 = #{ipV4},     ip_v6 = #{ipV6} WHERE id = #{id}"})
    public void updateVpsItem(KtonOrderItemVps var1);

    @Select(value={"<script> SELECT a.*  FROM kton_order_item_vps as a   INNER JOIN  kton_order as b ON a.order_id  = b.id  WHERE a.vps_id = #{vpsId} AND b.merchant_id = #{merchantId}    LIMIT 1  </script>"})
    public KtonOrderItemVps selectVps(@Param(value="merchantId") Long var1, @Param(value="vpsId") Long var2);
}

