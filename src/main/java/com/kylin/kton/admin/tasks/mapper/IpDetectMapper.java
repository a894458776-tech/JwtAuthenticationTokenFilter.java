/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDetect
 *  com.kylin.kton.system.mapper.KtonIpDetectMapper
 *  org.apache.ibatis.annotations.Mapper
 *  org.apache.ibatis.annotations.Param
 *  org.apache.ibatis.annotations.Select
 */
package com.kylin.kton.admin.tasks.mapper;

import com.kylin.kton.system.domain.KtonIpDetect;
import com.kylin.kton.system.mapper.KtonIpDetectMapper;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface IpDetectMapper
extends KtonIpDetectMapper {
    @Select(value={"SELECT COUNT(*) FROM kton_ip_detect WHERE datasource = #{datasource} AND province is null ORDER BY id DESC"})
    public int selectTotalCount(@Param(value="datasource") String var1);

    @Select(value={"SELECT * FROM kton_ip_detect WHERE datasource = #{datasource} AND (update_time IS NULL OR DATE(update_time) < CURRENT_DATE()) ORDER BY id DESC LIMIT #{offset}, #{limit}"})
    public List<KtonIpDetect> pendingListWithPage(@Param(value="datasource") String var1, @Param(value="offset") int var2, @Param(value="limit") int var3);

    @Select(value={"SELECT concat(SUBSTRING_INDEX(ip, '.', 3),'.1') FROM kton_ip_detect WHERE datasource = #{datasource} and province is null GROUP BY SUBSTRING_INDEX(ip, '.', 3)"})
    public List<String> selectIpGroupList(@Param(value="datasource") String var1);

    @Select(value={"<script>UPDATE kton_ip_detect SET <if test= 'ipDetect.countryCode != null'>country_code = #{ipDetect.countryCode},</if><if test= 'ipDetect.continent != null'>continent = #{ipDetect.continent},</if><if test= 'ipDetect.subContinent != null'>sub_continent = #{ipDetect.subContinent},</if><if test= 'ipDetect.province != null '>province = #{ipDetect.province},</if> <if test= 'ipDetect.city != null '>city = #{ipDetect.city},</if> <if test= 'ipDetect.asn != null '>asn = #{ipDetect.asn},</if> <if test= 'ipDetect.asnBelong != null '>asn_belong = #{ipDetect.asnBelong},</if> <if test= 'ipDetect.asnBelongUrl != null '>asn_belong_url = #{ipDetect.asnBelongUrl},</if> <if test= 'ipDetect.asnIsIsp != null '>asn_is_isp = #{ipDetect.asnIsIsp},</if> <if test= 'ipDetect.company != null '>company = #{ipDetect.company},</if> <if test= 'ipDetect.companyUrl != null '>company_url = #{ipDetect.companyUrl},</if> <if test= 'ipDetect.companyIsIsp != null '>company_is_isp = #{ipDetect.companyIsIsp},</if> <if test= 'ipDetect.latitude != null '>latitude = #{ipDetect.latitude},</if> <if test= 'ipDetect.longitude != null '>longitude = #{ipDetect.longitude},</if> <if test= 'ipDetect.ipType != null '>ip_type = #{ipDetect.ipType},</if> <if test= 'ipDetect.riskValue != null '>risk_value = #{ipDetect.riskValue},</if> is_native = #{ipDetect.isNative} WHERE ip like concat(SUBSTRING_INDEX(#{ipDetect.ip}, '.', 3),'%')</script>"})
    public void updateByIpGroup(@Param(value="ipDetect") KtonIpDetect var1);
}

