/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonOrder
 *  com.kylin.kton.system.domain.KtonOrderItemStatic
 *  org.apache.ibatis.annotations.Many
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.order.mapper;

import com.kylin.kton.admin.order.entity.dto.AdminOrderDTO;
import com.kylin.kton.admin.order.entity.dto.AdminOrderDetailDTO;
import com.kylin.kton.admin.order.entity.dto.AdminOrderItemStaticDTO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderSearchVO;
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
public interface AdminOrderDao {
    @Select(value={"<script> SELECT *  FROM kton_order as a WHERE 1 = 1  <when test='vo.orderNo!=null'> AND a.order_no = #{vo.orderNo} </when> <when test='vo.domain!=null'> AND a.domain = #{vo.domain} </when> <when test='vo.productName!=null'> AND a.product_name = #{vo.productName} </when> ORDER BY a.id DESC</script>"})
    @Results(value={@Result(column="order_id", property="orderId")})
    public List<AdminOrderDTO> list(@Param(value="vo") AdminOrderSearchVO var1);

    @Select(value={"<script> SELECT * from kton_order where product_type =2 and status != 20  and now() &gt; expire_datetime and (next_notify_time is null or now() &gt; next_notify_time)  </script>"})
    @Results(value={@Result(column="id", property="id"), @Result(column="id", property="itemStaticList", javaType=List.class, many=@Many(select="selectOrderItemStatic"))})
    public List<AdminOrderItemStaticDTO> expireList();

    @Select(value={"<script> SELECT sum(total_ips) AS total_ips ,merchant_id  FROM kton_order  WHERE product_type = 2   AND expire_datetime &gt;= DATE_ADD(CURDATE(), INTERVAL 1 DAY)   AND expire_datetime &lt; DATE_ADD(CURDATE(), INTERVAL 2 DAY)   GROUP BY merchant_id </script>"})
    public List<KtonOrder> listTomorrowExpirationAccount();

    @Select(value={"<script> SELECT *  FROM kton_order as a WHERE 1 = 1 and order_id = #{orderId} </script>"})
    @Results(value={@Result(column="order_id", property="orderId"), @Result(column="order_id", property="orderItems", javaType=List.class, many=@Many(select="selectOrderItemStatic"))})
    public AdminOrderDetailDTO detail(@Param(value="orderId") Long var1);

    @Select(value={"select * from kton_order_item_static where order_id = #{orderId}"})
    public KtonOrderItemStatic selectOrderItemStatic(@Param(value="orderId") Long var1);
}

