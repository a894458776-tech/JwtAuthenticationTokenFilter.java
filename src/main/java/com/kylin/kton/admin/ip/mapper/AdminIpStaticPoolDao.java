/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolDTO;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminIpStaticPoolDao {
    @Select(value={"<script>", " SELECT *,", " (SELECT COUNT(*) ", "    FROM kton_ip_static_source AS a ", "    INNER JOIN kton_ip_detect AS b ON a.ip = b.ip ", "    WHERE b.country_code = kton_ip_static_pool.country_code ", "      AND b.province = kton_ip_static_pool.location ", " ) AS ip_totals,", " (SELECT COUNT(*) ", "    FROM kton_ip_static_source AS a ", "    INNER JOIN kton_ip_detect AS b ON a.ip = b.ip ", "    WHERE b.country_code = kton_ip_static_pool.country_code ", "      AND b.province = kton_ip_static_pool.location ", "      AND a.assign_times &lt;= #{assignTimes} ", "      AND a.expire_datetime &gt; NOW() ", "      AND a.status != 2  ", " ) AS effective_totals ", " FROM kton_ip_static_pool ", " WHERE 1 = 1 ", " <when test='vo.type != null'> AND type = #{vo.type} </when>", " <when test='vo.continent != null'> AND continent = #{vo.continent} </when>", " <when test='vo.countryCode != null'> AND country_code = #{vo.countryCode} </when>", " ORDER BY id DESC", "</script>"})
    public List<AdminIpStaticPoolDTO> list(@Param(value="vo") KtonIpStaticPool var1, @Param(value="assignTimes") Integer var2);

    @Select(value={" SELECT a.* FROM kton_ip_static_pool AS a  INNER JOIN kton_ip_static_pool_item AS b ON a.id = b.pool_id  WHERE   b.ip = #{ip} and b.merchant_id = #{merchantId} limit 1"})
    public KtonIpStaticPool getByIp(@Param(value="ip") String var1, @Param(value="merchantId") Long var2);
}

