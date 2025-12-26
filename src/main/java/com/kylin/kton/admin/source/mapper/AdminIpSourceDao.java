/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonSource
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.source.mapper;

import com.kylin.kton.admin.ip.entity.vo.AdminWithOutMerchantlistSearchVO;
import com.kylin.kton.system.domain.KtonSource;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminIpSourceDao {
    @Select(value={"<script> SELECT * FROM kton_source    WHERE 1 = 1  <when test='vo.sourceCode!=null'> AND source_code = #{vo.sourceCode} </when> <when test='vo.sourceName!=null'> AND source_name = #{vo.sourceName} </when> AND id not in (SELECT source_id FROM kton_merchant_source where merchant_id = #{vo.merchantId} and ip_type = #{vo.ipType} )</script>"})
    public List<KtonSource> list(@Param(value="vo") AdminWithOutMerchantlistSearchVO var1);

    @Select(value={"<script> SELECT * FROM kton_source    WHERE 1 = 1  <when test='vo.sourceCode!=null'> AND source_code = #{vo.sourceCode} </when> <when test='vo.sourceName!=null'> AND source_name = #{vo.sourceName} </when> AND id not in (SELECT source_id FROM kton_merchant_source where merchant_id = #{vo.merchantId} and ip_type = #{vo.ipType} )</script>"})
    public List<KtonSource> withOutMerchantlist(@Param(value="vo") AdminWithOutMerchantlistSearchVO var1);

    @Select(value={"<script> SELECT * FROM kton_source    WHERE 1 = 1  <when test='sourceCode!=null'> AND source_code = #{sourceCode} </when></script>"})
    public KtonSource getBySourceCode(@Param(value="sourceCode") String var1);
}

