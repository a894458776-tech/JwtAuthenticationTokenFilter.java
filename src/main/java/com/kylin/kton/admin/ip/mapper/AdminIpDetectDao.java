/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonIpDetect
 *  org.apache.ibatis.annotations.Insert
 *  org.apache.ibatis.annotations.Param
 *  org.springframework.stereotype.Repository
 */
package com.kylin.kton.admin.ip.mapper;

import com.kylin.kton.system.domain.KtonIpDetect;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminIpDetectDao {
    @Insert(value={"<script>", "INSERT INTO kton_ip_detect (id, ip, datasource,continent,sub_continent, country_code, province, city, ", "asn, asn_belong, asn_belong_url, asn_is_isp, company, company_url, ", "company_is_isp, latitude, longitude, ip_type, risk_value, is_native) VALUES ", "<foreach collection='list' item='item' separator=','>", "(#{item.id}, #{item.ip}, #{item.datasource},#{item.continent},#{item.subContinent}, #{item.countryCode}, #{item.province}, #{item.city}, ", "#{item.asn}, #{item.asnBelong}, #{item.asnBelongUrl}, #{item.asnIsIsp}, #{item.company}, #{item.companyUrl}, ", "#{item.companyIsIsp}, #{item.latitude}, #{item.longitude}, #{item.ipType}, #{item.riskValue}, #{item.isNative})", "</foreach>", "ON DUPLICATE KEY UPDATE ", "datasource = VALUES(datasource), ", "country_code = VALUES(country_code), ", "continent = VALUES(continent), ", "sub_continent = VALUES(sub_continent), ", "province = VALUES(province), ", "city = VALUES(city), ", "asn = VALUES(asn), ", "asn_belong = VALUES(asn_belong), ", "asn_belong_url = VALUES(asn_belong_url), ", "asn_is_isp = VALUES(asn_is_isp), ", "company = VALUES(company), ", "company_url = VALUES(company_url), ", "company_is_isp = VALUES(company_is_isp), ", "latitude = VALUES(latitude), ", "longitude = VALUES(longitude), ", "ip_type = VALUES(ip_type), ", "risk_value = VALUES(risk_value), ", "is_native = VALUES(is_native)", "</script>"})
    public Integer batchInsertOrUpdate(@Param(value="list") List<KtonIpDetect> var1);

    @Insert(value={"<script>", "INSERT INTO kton_ip_detect (ip, datasource) VALUES ", "<foreach collection='list' item='item' separator=','>", "(#{item.ip}, #{item.datasource})", "</foreach>", "ON DUPLICATE KEY UPDATE ", "datasource = VALUES(datasource)", "</script>"})
    public Integer batchInsertOrUpdateIp(@Param(value="list") List<KtonIpDetect> var1);

    @Insert(value={"<script>", "INSERT INTO kton_ip_detect (ip, datasource) VALUES ", "<foreach collection='ipList' item='item' separator=','>", "   (#{item},'ping0')", "</foreach>", "ON DUPLICATE KEY UPDATE ", "ip = VALUES(ip) ", "</script>"})
    public void insertIpList(@Param(value="ipList") List<String> var1);
}

