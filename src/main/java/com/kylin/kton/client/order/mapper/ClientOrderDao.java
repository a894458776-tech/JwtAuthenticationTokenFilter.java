package com.kylin.kton.client.order.mapper;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolMerchantDTO;
import com.kylin.kton.client.order.entity.dto.ClientOrderDetailDTO;
import com.kylin.kton.client.order.entity.vo.ClientOrderSearchVO;
import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.util.List;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientOrderDao {

    // 详情查询 (保持不变，或者你也可以加上 staticIp 逻辑)
    @Select({
            "<script>",
            "SELECT * FROM kton_order as a WHERE merchant_id = #{merchantId} and id = #{orderId} ORDER BY a.id DESC",
            "</script>"
    })
    @Results({
            @Result(column="id", property="id"),
            @Result(column="id", property="orderItems", javaType=List.class, many=@Many(select="selectOrderItemStatic"))
    })
    public ClientOrderDetailDTO detail(@Param("merchantId") Long merchantId, @Param("orderId") Long orderId);


    // =================================================================================
    // 【核心修改】在这里！修改了 SQL，增加了子查询获取 staticIp
    // =================================================================================
    @Select({
            "<script>",
            "SELECT a.*, ",
            // 👇👇👇 新增的子查询逻辑 👇👇👇
            "(SELECT GROUP_CONCAT(s.ip SEPARATOR ', ') FROM kton_order_item_static s WHERE s.order_id = a.id) AS staticIp ",
            // 👆👆👆 新增结束 👆👆👆
            "FROM kton_order as a ",
            "WHERE merchant_id = #{vo.merchantId} ",
            "<when test='vo.orderNo!=null'> AND a.order_no = #{vo.orderNo} </when> ",
            "<when test='vo.domain!=null'> AND a.domain = #{vo.domain} </when> ",
            "<when test='vo.productName!=null'> AND a.product_name = #{vo.productName} </when> ",
            "ORDER BY a.id DESC",
            "</script>"
    })
    @Results({
            @Result(column="id", property="id"),
            // 显式映射 staticIp (其实只要别名对上，这里不写通常也能自动映射，但写上最保险)
            @Result(column="staticIp", property="staticIp"),
            @Result(column="id", property="orderItems", javaType=List.class, many=@Many(select="selectOrderItemStatic"))
    })
    public List<ClientOrderDetailDTO> orderList(@Param("vo") ClientOrderSearchVO vo);


    // 内部调用 (保持不变)
    @Select("select * from kton_order_item_static where order_id = #{orderId}")
    public KtonOrderItemStatic selectOrderItemStatic(@Param("orderId") Long orderId);

    // 根据订单号获取 (保持不变)
    @Select({
            "<script>",
            "SELECT * FROM kton_order as a WHERE merchant_id = #{merchantId} ",
            "<when test='orderNo!=null'> AND a.order_no = #{orderNo} </when> ",
            "<when test='productType!=null'> AND a.product_type = #{productType} </when> ",
            "ORDER BY a.id DESC",
            "</script>"
    })
    public KtonOrder getByOrderNo(@Param("merchantId") Long merchantId, @Param("orderNo") String orderNo, @Param("productType") Integer productType);

    // 获取商户IP (保持不变)
    @Select({
            "<script>",
            "SELECT c.account, c.password, c.port, c.ip, a.effective_datetime, a.expire_datetime, a.status, b.is_native type, b.country_code, b.province location ",
            "FROM kton_ip_static_merchant AS a ",
            "INNER JOIN kton_ip_detect AS b ON a.ip = b.ip ",
            "INNER JOIN kton_ip_static_source AS c ON a.ip = c.ip ",
            "WHERE a.merchant_id = #{merchantId} ",
            "AND EXISTS (SELECT 1 FROM kton_order_item_static AS ois INNER JOIN kton_order AS o ON ois.order_id = o.id WHERE ois.ip = a.ip AND o.order_no = #{orderNo}) ",
            "ORDER BY a.expire_datetime DESC",
            "</script>"
    })
    public List<ClientIpStaticPoolMerchantDTO> getMerchantIpsByOrderNo(@Param("orderNo") String orderNo, @Param("merchantId") Long merchantId);
}