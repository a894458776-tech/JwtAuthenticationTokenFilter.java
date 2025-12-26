package com.kylin.kton.client.order.entity.dto;

import com.kylin.kton.system.domain.KtonOrder;
import com.kylin.kton.system.domain.KtonOrderItemStatic;
import java.util.List;

/**
 * 客户端订单详情 DTO
 * 必须包含 staticIp 字段，否则前端收不到 IP 数据
 */
public class ClientOrderDetailDTO extends KtonOrder {

    /**
     * 原有的子项列表（保留）
     */
    private List<KtonOrderItemStatic> orderItems;

    /**
     * 【关键新增】静态 IP 字符串
     * 对应 SQL 里的: SELECT ... (子查询) AS staticIp
     */
    private String staticIp;

    // ==========================================
    // 手动加上 Getter 和 Setter，确保万无一失
    // ==========================================

    public String getStaticIp() {
        return staticIp;
    }

    public void setStaticIp(String staticIp) {
        this.staticIp = staticIp;
    }

    public List<KtonOrderItemStatic> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<KtonOrderItemStatic> orderItems) {
        this.orderItems = orderItems;
    }
}