/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.merchant.base.mapper;

import com.kylin.kton.admin.merchant.base.entity.dto.AdminMerchantSourceDTO;
import com.kylin.kton.admin.merchant.base.entity.dto.AdminMrtchantIpSourceDTO;
import com.kylin.kton.admin.merchant.base.entity.vo.AdminMerchantSourceSearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMerchantSourceDao {
    @Select(value={"<script> SELECT *  FROM kton_merchant_source as a LEFT JOIN kton_source as b ON a.source_id = b.id WHERE 1 = 1  <when test='vo.sourceCode!=null'> AND a.source_code = #{vo.sourceCode} </when> <when test='vo.merchantId!=null'> AND a.merchant_id = #{vo.merchantId} </when> ORDER BY a.id DESC</script>"})
    public List<AdminMerchantSourceDTO> list(@Param(value="vo") AdminMerchantSourceSearchVO var1);

    @Select(value={"<script> SELECT * FROM kton_merchant_source as a  LEFT JOIN kton_source as b ON a.source_id = b.id  WHERE merchant_id = #{merchantId} AND ip_type = #{ipType} </script>"})
    public AdminMrtchantIpSourceDTO merchantSource(@Param(value="merchantId") Long var1, @Param(value="ipType") String var2);
}

