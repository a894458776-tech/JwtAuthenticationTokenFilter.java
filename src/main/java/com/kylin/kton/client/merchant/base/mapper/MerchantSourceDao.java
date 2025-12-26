/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.merchant.base.mapper;

import com.kylin.kton.client.merchant.base.entity.dto.ClientMerchantSourceDTO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface MerchantSourceDao {
    @Select(value={"<script> SELECT * FROM kton_merchant_source as a  LEFT JOIN kton_source as b ON a.source_id = b.id  WHERE merchant_id = #{merchantId} AND ip_type = #{ipType} </script>"})
    public ClientMerchantSourceDTO merchantSource(@Param(value="merchantId") Long var1, @Param(value="ipType") String var2);
}

