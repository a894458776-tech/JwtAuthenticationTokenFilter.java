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

public class KtonOrder
extends BaseEntity {
    private static final long serialVersionUID = 1L;
    private Long id;
    @Excel(name="t_merchant.id")
    private Long merchantId;
    @Excel(name="\u8ba2\u5355\u53f7")
    private String orderNo;
    @Excel(name="\u57df\u540d", readConverterExp="\u9759=\u6001ip\u65f6\u9700\u7ed1\u5b9a")
    private String domain;
    @Excel(name="\u4ea7\u54c1\u540d\u79f0")
    private String productName;
    @Excel(name="\u4ea7\u54c1\u7c7b\u522b", readConverterExp="1=-\u52a8\u6001ip\uff0c2-\u9759\u6001ip\uff0c3-vps")
    private Long productType;
    @Excel(name="\u6570\u91cf")
    private Long quantity;
    @Excel(name="\u91d1\u989d")
    private BigDecimal totalAmount;
    @Excel(name="\u8d27\u5e01")
    private String currency;
    @Excel(name="\u8ba2\u5355\u72b6\u6001\uff1a0-\u5f85\u751f\u6548\uff0c10-\u5df2\u751f\u6548\uff0c20-\u5df2\u5230\u671f")
    private Long status;
    @Excel(name="\u652f\u4ed8\u72b6\u6001(0-\u5df2\u53d6\u6d88,10-\u65b0\u8ba2\u5355-\u672a\u652f\u4ed8\uff0c20-\u5df2\u652f\u4ed8)")
    private Long paidStatus;
    @Excel(name="\u652f\u4ed8\u65b9\u5f0f", readConverterExp="V=ISA,MASTER,AMEX,ALIPAY,BALANCE")
    private String payMethod;
    @Excel(name="PAY_FIRST|PAY_LATER (\u5148\u4ed8|\u540e\u4ed8)")
    private String payMode;
    @Excel(name="ip\u6570\u91cf")
    private Long totalIps;
    @Excel(name="\u662f\u5426\u652f\u6301udp\uff0cN-\u5426\uff0cY-\u662f")
    private String udp;
    @Excel(name="\u9759\u6001IP \uff0c\u5404\u4e2a\u56fd\u5bb6\u57ce\u5e02\uff0c\u5bf9\u5e94IP\u6570\u91cf")
    private String staticCountryNums;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u751f\u6548\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date effectiveDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="\u8fc7\u671f\u65f6\u95f4", width=30.0, dateFormat="yyyy-MM-dd")
    private Date expireDatetime;
    @JsonFormat(pattern="yyyy-MM-dd")
    @Excel(name="", width=30.0, dateFormat="yyyy-MM-dd")
    private Date nextNotifyTime;
    @Excel(name="")
    private Long notifyCount;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public Long getMerchantId() {
        return this.merchantId;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNo() {
        return this.orderNo;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getDomain() {
        return this.domain;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setProductType(Long productType) {
        this.productType = productType;
    }

    public Long getProductType() {
        return this.productType;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Long getQuantity() {
        return this.quantity;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getTotalAmount() {
        return this.totalAmount;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getCurrency() {
        return this.currency;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Long getStatus() {
        return this.status;
    }

    public void setPaidStatus(Long paidStatus) {
        this.paidStatus = paidStatus;
    }

    public Long getPaidStatus() {
        return this.paidStatus;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod = payMethod;
    }

    public String getPayMethod() {
        return this.payMethod;
    }

    public void setPayMode(String payMode) {
        this.payMode = payMode;
    }

    public String getPayMode() {
        return this.payMode;
    }

    public void setTotalIps(Long totalIps) {
        this.totalIps = totalIps;
    }

    public Long getTotalIps() {
        return this.totalIps;
    }

    public void setUdp(String udp) {
        this.udp = udp;
    }

    public String getUdp() {
        return this.udp;
    }

    public void setStaticCountryNums(String staticCountryNums) {
        this.staticCountryNums = staticCountryNums;
    }

    public String getStaticCountryNums() {
        return this.staticCountryNums;
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

    public void setNextNotifyTime(Date nextNotifyTime) {
        this.nextNotifyTime = nextNotifyTime;
    }

    public Date getNextNotifyTime() {
        return this.nextNotifyTime;
    }

    public void setNotifyCount(Long notifyCount) {
        this.notifyCount = notifyCount;
    }

    public Long getNotifyCount() {
        return this.notifyCount;
    }

    public String toString() {
        return new ToStringBuilder((Object)this, ToStringStyle.MULTI_LINE_STYLE).append("id", (Object)this.getId()).append("merchantId", (Object)this.getMerchantId()).append("orderNo", (Object)this.getOrderNo()).append("domain", (Object)this.getDomain()).append("productName", (Object)this.getProductName()).append("productType", (Object)this.getProductType()).append("quantity", (Object)this.getQuantity()).append("totalAmount", (Object)this.getTotalAmount()).append("currency", (Object)this.getCurrency()).append("status", (Object)this.getStatus()).append("paidStatus", (Object)this.getPaidStatus()).append("payMethod", (Object)this.getPayMethod()).append("payMode", (Object)this.getPayMode()).append("totalIps", (Object)this.getTotalIps()).append("udp", (Object)this.getUdp()).append("staticCountryNums", (Object)this.getStaticCountryNums()).append("effectiveDatetime", (Object)this.getEffectiveDatetime()).append("expireDatetime", (Object)this.getExpireDatetime()).append("nextNotifyTime", (Object)this.getNextNotifyTime()).append("notifyCount", (Object)this.getNotifyCount()).append("createTime", (Object)this.getCreateTime()).append("updateTime", (Object)this.getUpdateTime()).toString();
    }
}

