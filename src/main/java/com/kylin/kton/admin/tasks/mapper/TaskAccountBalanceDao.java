/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.admin.tasks.entity.dto.MerchantInsufficientDataDTO;
import java.util.List;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskAccountBalanceDao {
    @Select(value={"<script>", "SELECT mc.merchant_id AS merchantId, m.name AS merchantName, m.company_name AS companyName, ", "       kb.account_id AS accountId, ka.label AS accountLabel, ka.channel_label AS channelLabel, ", "       kb.balance_format, mc.data_usage_flow_threshold AS threshold ", "FROM kton_merchant_config mc ", "INNER JOIN kton_merchant m ON mc.merchant_id = m.id ", "INNER JOIN kton_ip_dynamics_account_balance kb ON mc.merchant_id = kb.merchant_id ", "INNER JOIN kton_ip_dynamics_account ka ON kb.account_id = ka.account_id ", "WHERE mc.data_usage_notify_enabled = 1 ", "  AND kb.balance_total &gt; 0 AND  kb.balance &lt;= mc.data_usage_flow_threshold * 1024 * 1024 * 1024", "</script>"})
    public List<MerchantInsufficientDataDTO> listMerchantsWithInsufficientData();
}

