/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantConfig
 *  com.kylin.kton.system.mapper.KtonMerchantConfigMapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.client.merchant.config.mapper;

import com.kylin.kton.system.domain.KtonMerchantConfig;
import com.kylin.kton.system.mapper.KtonMerchantConfigMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientMerchantConfigDao
extends KtonMerchantConfigMapper {
    @Select(value={"<script> SELECT *  FROM kton_merchant_config  WHERE merchant_id = #{merchantId}  </script>"})
    public KtonMerchantConfig detail(@Param(value="merchantId") Long var1);
}

