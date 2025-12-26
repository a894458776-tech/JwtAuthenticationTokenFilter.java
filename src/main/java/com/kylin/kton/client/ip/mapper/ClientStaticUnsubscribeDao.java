/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Param
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.ip.mapper;

import com.kylin.kton.client.order.entity.vo.UnsubscribeStaticIpVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientStaticUnsubscribeDao {
    @Insert(value={"<script>", "INSERT INTO kton_ip_unsubscribe (merchant_id, ip, unsubscribe_time, create_time) ", "VALUES ", "<foreach collection='vo.ipList' item='ip' separator=','>", "(#{vo.merchantId}, #{ip}, NOW(), NOW())", "</foreach>", " ON DUPLICATE KEY UPDATE update_time = NOW()", "</script>"})
    public void saveUnsubscribeBatch(@Param(value="vo") UnsubscribeStaticIpVO var1);
}

