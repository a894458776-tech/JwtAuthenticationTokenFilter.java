/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  com.kylin.kton.system.domain.KtonMerchant
 *  org.apache.ibatis.annotations.One
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Result
 *  org.apache.ibatis.annotations.Results
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.account.mapper;

import com.kylin.kton.admin.account.entity.dto.AdminIpDynamicsAccountDTO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountSearchVO;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import com.kylin.kton.system.domain.KtonMerchant;
import java.util.List;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAccountDao {
    @Select(value={"<script> SELECT * FROM kton_ip_dynamics_account WHERE merchant_id = #{merchantId} AND account_id = #{accountId} </script>"})
    public KtonIpDynamicsAccount detail(@Param(value="merchantId") Long var1, @Param(value="accountId") Long var2);

    @Select(value={"<script> SELECT *  FROM kton_ip_dynamics_account  WHERE 1 = 1  <when test='vo.accountId!=null'> AND accoun_id = #{vo.accountId} </when> <when test='vo.merchantId!=null'> AND merchant_id = #{vo.merchantId} </when> <when test='vo.channelCode!=null'> AND channel_code = #{vo.channelCode} </when> <when test='vo.label!=null'> AND label = #{vo.label} </when> ORDER BY id DESC</script>"})
    @Results(value={@Result(column="merchant_id", property="merchantId"), @Result(column="merchant_id", property="merchant", one=@One(select="selectMerchantInfo"))})
    public List<AdminIpDynamicsAccountDTO> list(@Param(value="vo") AdminAccountSearchVO var1);

    @Select(value={"select * from kton_merchant where id = #{merchantId}"})
    public KtonMerchant selectMerchantInfo(@Param(value="merchantId") Long var1);
}

