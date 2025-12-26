/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.merchant.base.mapper;

import com.kylin.kton.admin.order.entity.dto.AdminOrderDTO;
import com.kylin.kton.admin.order.entity.vo.AdminOrderSearchVO;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminMerchantDao {
    @Select(value={"<script> SELECT *  FROM kton_merchant as a WHERE 1 = 1  <when test='vo.companyName!=null'> AND a.company_name = #{vo.companyName} </when> <when test='vo.name!=null'> AND a.name = #{vo.name} </when> ORDER BY a.id DESC</script>"})
    public List<AdminOrderDTO> list(@Param(value="vo") AdminOrderSearchVO var1);
}

