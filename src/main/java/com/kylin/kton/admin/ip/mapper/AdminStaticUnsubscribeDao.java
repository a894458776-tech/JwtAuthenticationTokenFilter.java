/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Param
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.order.entity.vo.AdminUnsubscribeStaticIpVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminStaticUnsubscribeDao {
    @Insert(value={"<script>", "INSERT INTO kton_ip_unsubscribe (merchant_id, ip, unsubscribe_time, create_time) ", "VALUES ", "<foreach collection='vo.ipList' item='ip' separator=','>", "(#{vo.merchantId}, #{ip}, NOW(), NOW())", "</foreach>", " ON DUPLICATE KEY UPDATE update_time = NOW()", "</script>"})
    public void saveUnsubscribeBatch(@Param(value="vo") AdminUnsubscribeStaticIpVO var1);
}

