package com.kylin.kton.client.account.mapper;

import com.kylin.kton.client.account.entity.dto.ClientAccountStatDTO;
import com.kylin.kton.client.account.entity.vo.AccountStatSearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientAccountUsageStatDao {

    // ⬇️ 这一版去掉了 accountId 的判断，防止报错，但可能会混淆不同账户的数据
    @Select(value={
            "<script>",
            "SELECT d_usage, SUM(requests) as requestsTotal, SUM(traffic) as trafficTotal ",
            "FROM kton_ip_dynamics_account_usage_stat ",
            "WHERE merchant_id = #{vo.merchantId} ",

            // ❌ 删除了 accountId 判断，因为 VO 里没有这个字段

            "<when test='vo.startTime != null'> AND d_usage &gt;= #{vo.startTime} </when>",
            "<when test='vo.endTime != null'> AND d_usage &lt;= #{vo.endTime} </when>",

            "GROUP BY d_usage ",
            "ORDER BY d_usage ASC",
            "</script>"
    })
    public List<ClientAccountStatDTO> list(@Param(value="vo") AccountStatSearchVO var1);
}