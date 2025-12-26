/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonFormat
 *  com.kylin.kton.common.annotation.Excel
 *  com.kylin.kton.common.core.domain.BaseEntity
 *  org.apache.commons.lang3.builder.ToStringBuilder
 *  org.apache.commons.lang3.builder.ToStringStyle
 */
package com.kylin.kton.system.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kylin.kton.common.annotation.Excel;
import com.kylin.kton.common.core.domain.BaseEntity;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class KtonOrderItemStatic
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="t_order.id")
    private Long orderId;
    @Excel(name="\u7c7b\u578b:1-\u666e\u901a\uff0c2-\u9ad8\u7ea7")
    private Long orderType;
    @Excel(name="\u6765\u6e90IP\u6c60\u7684id,kton_ip_static_pool.id")
    private Long poolId;
    @Excel(name="\u5355\u4ef7")
    private BigDecimal price;
    @Excel(name="\u8d27\u5e01")
    private String currency;
    @Excel(name="\u6709\u6548\u5929\u6570")
    private Long days;
    @Excel(name="\u6298\u6263")
    private BigDecimal discount;
    @Excel(name="\u6d32(Asia-\u4e9a\u6d32\uff0cNorth America-\u5317\u7f8e\u6d32, Europe-\u6b27\u6d32)")
    private String continent;
    @Excel(name="\u56fd\u5bb6\u7f16\u7801")
    private String countryCode;
    @Excel(name="ip\u5f52\u5c5e\u5730")
    private String location;
    @Excel(name="ip\u5730\u5740")
    private String ip;
    @Excel(name="\u534f\u8bae")
    private String protocolse;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date expireDatetime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @Excel(name="\u9000\u8ba2\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd HH:mm:ss")
    private Date unsubscribeTime;
    @Excel(name="\u8d26\u53f7")
    private String account;
    @Excel(name="\u5bc6\u7801")
    private String password;
    @Excel(name="\u7aef\u53e3")
    private String port;
    @Excel(name="\u72b6\u6001:Y-\u6b63\u5e38\uff0cN-\u8fc7\u671f, T:\u5df2\u9000\u8ba2")
    private String status;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return this.orderId;
    }

    public void setOrderType(Long orderType) {
        this.orderType = orderType;
    }

    public Long getOrderType() {
        return this.orderType;
    }

    public void setPoolId(Long poolId) {
        this.poolId = poolId;
    }

    public Long getPoolId() {
        return this.poolId;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setDays(Long days) {
        this.days = days;
    }

    public Long getDays() {
        return this.days;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public BigDecimal getDiscount() {
        return this.discount;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getContinent() {
        return this.continent;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return this.location;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return this.ip;
    }

    public void setProtocolse(String protocolse) {
        this.protocolse = protocolse;
    }

    public String getProtocolse() {
        return this.protocolse;
    }

    public void setEffectiveDatetime(Date effectiveDatetime) {
        this.effectiveDatetime = effectiveDatetime;
    }

    public Date getEffectiveDatetime() {
        return this.effectiveDatetime;
    }

    public void setExpireDatetime(Date expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    public Date getExpireDatetime() {
        return this.expireDatetime;
    }

    public void setUnsubscribeTime(Date unsubscribeTime) {
        this.unsubscribeTime = unsubscribeTime;
    }

    public Date getUnsubscribeTime() {
        return this.unsubscribeTime;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPort() {
        return this.port;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("orderId", (Object)this.getOrderId()).append("orderType", (Object)this.getOrderType()).append("poolId", (Object)this.getPoolId()).append("price", (Object)this.getPrice()).append("currency", (Object)this.getCurrency()).append("days", (Object)this.getDays()).append("discount", (Object)this.getDiscount()).append("continent", (Object)this.getContinent()).append("countryCode", (Object)this.getCountryCode()).append("location", (Object)this.getLocation()).append("ip", (Object)this.getIp()).append("protocolse", (Object)this.getProtocolse()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("unsubscribeTime", (Object)this.getUnsubscribeTime()).append("account", (Object)this.getAccount()).append("password", (Object)this.getPassword()).append("port", (Object)this.getPort()).append("status", (Object)this.getStatus()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

