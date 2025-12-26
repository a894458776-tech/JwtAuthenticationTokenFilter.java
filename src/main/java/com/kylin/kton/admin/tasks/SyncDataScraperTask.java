/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.constant.IpDetectConstants$DATASOURCE
 *  com.kylin.kton.common.core.domain.entity.SysDictData
 *  com.kylin.kton.common.utils.ipInfo.IpInfoUtils
 *  com.kylin.kton.common.utils.ipInfo.IpInfoUtils$IPGeoInfo
 *  com.kylin.kton.common.utils.ipInfo.Ping0Utils
 *  com.kylin.kton.common.utils.ipInfo.Ping0Utils$IPGeoInfo
 *  com.kylin.kton.system.domain.KtonIpDetect
 *  javax.annotation.Resource
 *  lombok.Generated
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.admin.tasks;

import com.kylin.kton.admin.tasks.mapper.IpDetectMapper;
import com.kylin.kton.admin.tasks.mapper.SysDictDataDao;
import com.kylin.kton.common.constant.IpDetectConstants;
import com.kylin.kton.common.core.domain.entity.SysDictData;
import com.kylin.kton.common.utils.ipInfo.IpInfoUtils;
import com.kylin.kton.common.utils.ipInfo.Ping0Utils;
import com.kylin.kton.system.domain.KtonIpDetect;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import lombok.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SyncDataScraperTask {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(SyncDataScraperTask.class);
    @Resource
    IpDetectMapper ipDetectMapper;
    @Resource
    SysDictDataDao sysDictDataDao;
    @Resource
    private Ping0Utils ping0Utils;

    public void syncDataScraper() {
        log.info("start sync ip base data scraper start  ...");
        this.updateIpDataByPing0();
        log.info("start sync ip base data scraper end ...");
    }

    private void updateIpDataByPing0() {
        log.info("\u5f00\u59cb\u540c\u6b65IP\u57fa\u7840\u6570\u636e ping0...");
        int totalCount = this.ipDetectMapper.selectTotalCount(IpDetectConstants.DATASOURCE.ping0.name());
        log.info("\u5f85\u5904\u7406IP\u603b\u6570: {}", (Object)totalCount);
        List<String> ipList = this.ipDetectMapper.selectIpGroupList(IpDetectConstants.DATASOURCE.ping0.name());
        log.info("\u5f85\u5904\u7406IP\u6bb5\u6570: {}", (Object)ipList.size());
        ipList.forEach(ip -> {
            log.info("\u5f00\u59cb\u5904\u7406IP\u6bb5: {}", ip);
            Ping0Utils.IPGeoInfo geoInfo = Ping0Utils.getIPGeoInfo((String)ip);
            if (geoInfo == null) {
                log.error("\u91c7\u96c6\u5931\u8d25 \u5931\u8d25IP: {}", ip);
                return;
            }
            KtonIpDetect ipDetect = new KtonIpDetect();
            ipDetect.setIp(ip);
            if (!"\u672a\u77e5\u56fd\u5bb6".equals(geoInfo.getCountryCode())) {
                this.updateIpDetectWithGeoInfo(ipDetect, geoInfo, IpDetectConstants.DATASOURCE.ping0.name());
                this.ipDetectMapper.updateByIpGroup(ipDetect);
                log.debug("IP\u6bb5 {} \u6570\u636e\u66f4\u65b0\u6210\u529f", (Object)ipDetect.getIp());
            }
            try {
                Thread.sleep(1000L);
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        log.info("\u540c\u6b65IP\u57fa\u7840\u6570\u636e ping0...\u5b8c\u6210");
    }

    private void getIpinfoDataViaCrawlerPlatformPing0() {
        log.info("\u5f00\u59cb\u540c\u6b65IP\u57fa\u7840\u6570\u636e ping0...");
        int totalCount = this.ipDetectMapper.selectTotalCount(IpDetectConstants.DATASOURCE.ping0.name());
        log.info("\u5f85\u5904\u7406IP\u603b\u6570: {}", (Object)totalCount);
        int pageSize = 100;
        int totalPages = (int)Math.ceil((double)totalCount / (double)pageSize);
        for (int pageNum = 1; pageNum <= totalPages; ++pageNum) {
            log.info("\u6b63\u5728\u5904\u7406\u7b2c {}/{} \u9875\u6570\u636e...", (Object)pageNum, (Object)totalPages);
            List<KtonIpDetect> ipList = this.ipDetectMapper.pendingListWithPage(IpDetectConstants.DATASOURCE.ping0.name(), (pageNum - 1) * pageSize, pageSize);
            for (KtonIpDetect ipDetect : ipList) {
                try {
                    Ping0Utils.IPGeoInfo geoInfo = Ping0Utils.getIPGeoInfo((String)ipDetect.getIp());
                    if (geoInfo != null) {
                        System.out.println("Country Code: " + geoInfo.getCountryCode());
                        System.out.println("Province: " + geoInfo.getProvince());
                        System.out.println("City: " + geoInfo.getCity());
                        System.out.println("ASN: " + geoInfo.getAsn());
                        System.out.println("ASN Belong: " + geoInfo.getAsnBelong());
                        System.out.println("ASN Belong URL: " + geoInfo.getAsnBelongUrl());
                        System.out.println("ASN Is ISP: " + geoInfo.getAsnIsIsp());
                        System.out.println("Company: " + geoInfo.getCompany());
                        System.out.println("Company URL: " + geoInfo.getCompanyUrl());
                        System.out.println("Company Is ISP: " + geoInfo.getCompanyIsIsp());
                        System.out.println("Latitude: " + geoInfo.getLatitude());
                        System.out.println("Longitude: " + geoInfo.getLongitude());
                        System.out.println("IP Type: " + geoInfo.getIpType());
                        System.out.println("Risk Value: " + geoInfo.getRiskValue() + "%");
                        System.out.println("Is Native: " + geoInfo.getIsNative());
                        if (!"\u672a\u77e5\u56fd\u5bb6".equals(geoInfo.getCountryCode())) {
                            this.updateIpDetectWithGeoInfo(ipDetect, geoInfo, IpDetectConstants.DATASOURCE.ping0.name());
                            this.ipDetectMapper.updateKtonIpDetect(ipDetect);
                        }
                        log.debug("IP {} \u6570\u636e\u66f4\u65b0\u6210\u529f", (Object)ipDetect.getIp());
                        continue;
                    }
                    log.warn("IP {} \u65e0\u6cd5\u83b7\u53d6\u5730\u7406\u4fe1\u606f", (Object)ipDetect.getIp());
                }
                catch (Exception e) {
                    log.error("\u5904\u7406IP {} \u65f6\u53d1\u751f\u5f02\u5e38: {}", (Object)ipDetect.getIp(), (Object)e.getMessage());
                }
            }
            try {
                Thread.sleep(1000L);
                continue;
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        log.info("ping0  IP\u6570\u636e\u540c\u6b65\u5b8c\u6210");
    }

    private void getIpinfoDataViaCrawlerPlatformIpinfo() {
        log.info("\u5f00\u59cb\u540c\u6b65IP\u57fa\u7840\u6570\u636e ipinfo...");
        int totalCount = this.ipDetectMapper.selectTotalCount(IpDetectConstants.DATASOURCE.ipinfo.name());
        log.info("\u5f85\u5904\u7406IP\u603b\u6570: {}", (Object)totalCount);
        int pageSize = 100;
        int totalPages = (int)Math.ceil((double)totalCount / (double)pageSize);
        for (int pageNum = 1; pageNum <= totalPages; ++pageNum) {
            log.info("\u6b63\u5728\u5904\u7406\u7b2c {}/{} \u9875\u6570\u636e...", (Object)pageNum, (Object)totalPages);
            List<KtonIpDetect> ipList = this.ipDetectMapper.pendingListWithPage(IpDetectConstants.DATASOURCE.ipinfo.name(), (pageNum - 1) * pageSize, pageSize);
            for (KtonIpDetect ipDetect : ipList) {
                try {
                    IpInfoUtils.IPGeoInfo geoInfo = IpInfoUtils.getIPGeoInfo((String)ipDetect.getIp());
                    if (geoInfo != null) {
                        System.out.println("Country Code: " + geoInfo.getCountryCode());
                        System.out.println("Province: " + geoInfo.getProvince());
                        System.out.println("City: " + geoInfo.getCity());
                        System.out.println("ASN: " + geoInfo.getAsn());
                        System.out.println("ASN Belong: " + geoInfo.getAsnBelong());
                        System.out.println("ASN Belong URL: " + geoInfo.getAsnBelongUrl());
                        System.out.println("ASN Is ISP: " + geoInfo.getAsnIsIsp());
                        System.out.println("Company: " + geoInfo.getCompany());
                        System.out.println("Company URL: " + geoInfo.getCompanyUrl());
                        System.out.println("Company Is ISP: " + geoInfo.getCompanyIsIsp());
                        System.out.println("Latitude: " + geoInfo.getLatitude());
                        System.out.println("Longitude: " + geoInfo.getLongitude());
                        System.out.println("IP Type: " + geoInfo.getIpType());
                        System.out.println("Risk Value: " + geoInfo.getRiskValue() + "%");
                        System.out.println("Is Native: " + geoInfo.getIsNative());
                        this.updateIpDetectWithIpInfo(ipDetect, geoInfo, IpDetectConstants.DATASOURCE.ipinfo.name());
                        if (ipDetect.getCountryCode() != null) {
                            this.ipDetectMapper.updateKtonIpDetect(ipDetect);
                        } else {
                            log.warn("IP {} \u83b7\u53d6\u9875\u9762dom\u8d85\u65f6", (Object)ipDetect.getIp());
                        }
                        log.debug("IP {} \u6570\u636e\u66f4\u65b0\u6210\u529f", (Object)ipDetect.getIp());
                        continue;
                    }
                    log.warn("IP {} \u65e0\u6cd5\u9875\u9762\u4fe1\u606f", (Object)ipDetect.getIp());
                }
                catch (Exception e) {
                    log.error("\u5904\u7406IP {} \u65f6\u53d1\u751f\u5f02\u5e38: {}", (Object)ipDetect.getIp(), (Object)e.getMessage());
                }
            }
            try {
                Thread.sleep(1000L);
                continue;
            }
            catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        log.info("ipinfo IP\u6570\u636e\u540c\u6b65\u5b8c\u6210");
    }

    private void updateIpDetectWithGeoInfo(KtonIpDetect ipDetect, Ping0Utils.IPGeoInfo geoInfo, String dateSource) {
        Map<String, String> countryCodeDataMap = this.getDictDataListByType("countrycodeChineseToEnglish");
        Map<String, String> provinceDataMap = this.getDictDataListByType("provinceChineseToEnglish");
        Map<String, String> cityDataMap = this.getDictDataListByType("cityChineseToEnglish");
        Map<String, String> subContinentDataMap = this.getDictDataListByType("countryCodeToSubContinent");
        Map<String, String> continentDataMap = this.getDictDataListByType("countryCodeToContinent");
        ipDetect.setDatasource(dateSource);
        String countryCode = Optional.ofNullable(countryCodeDataMap.get(geoInfo.getCountryCode())).orElse(geoInfo.getCountryCode());
        ipDetect.setCountryCode(countryCode);
        String province = Optional.ofNullable(provinceDataMap.get(geoInfo.getProvince())).orElse(geoInfo.getProvince());
        ipDetect.setProvince(province);
        String city = Optional.ofNullable(cityDataMap.get(geoInfo.getCity())).orElse(geoInfo.getCity());
        ipDetect.setCity(city);
        String continent = Optional.ofNullable(continentDataMap.get(countryCode)).orElse(countryCode);
        ipDetect.setContinent(continent);
        String subContinent = Optional.ofNullable(subContinentDataMap.get(countryCode)).orElse(countryCode);
        ipDetect.setSubContinent(subContinent);
        ipDetect.setAsn(geoInfo.getAsn());
        ipDetect.setAsnBelong(geoInfo.getAsnBelong());
        ipDetect.setAsnBelongUrl(geoInfo.getAsnBelongUrl());
        ipDetect.setAsnIsIsp(geoInfo.getAsnIsIsp());
        ipDetect.setCompany(geoInfo.getCompany());
        ipDetect.setCompanyUrl(geoInfo.getCompanyUrl());
        ipDetect.setCompanyIsIsp(geoInfo.getCompanyIsIsp());
        ipDetect.setLatitude(geoInfo.getLatitude());
        ipDetect.setLongitude(geoInfo.getLongitude());
        ipDetect.setIpType(geoInfo.getIpType());
        ipDetect.setRiskValue(geoInfo.getRiskValue());
        ipDetect.setIsNative(geoInfo.getIsNative());
        ipDetect.setUpdateTime(new Date());
    }

    private Map<String, String> getDictDataListByType(String dictType) {
        List<SysDictData> sysDictDataList = this.sysDictDataDao.selectListByType(dictType);
        Map<String, String> locationMap = sysDictDataList.stream().collect(Collectors.toMap(SysDictData::getDictValue, SysDictData::getDictLabel, (i1, i2) -> i2));
        return locationMap;
    }

    private void updateIpDetectWithIpInfo(KtonIpDetect ipDetect, IpInfoUtils.IPGeoInfo geoInfo, String dateSource) {
        ipDetect.setDatasource(dateSource);
        ipDetect.setCountryCode(geoInfo.getCountryCode());
        ipDetect.setProvince(geoInfo.getProvince());
        ipDetect.setCity(geoInfo.getCity());
        ipDetect.setAsn(geoInfo.getAsn());
        ipDetect.setAsnBelong(geoInfo.getAsnBelong());
        ipDetect.setAsnBelongUrl(geoInfo.getAsnBelongUrl());
        ipDetect.setAsnIsIsp(geoInfo.getAsnIsIsp());
        ipDetect.setCompany(geoInfo.getCompany());
        ipDetect.setCompanyUrl(geoInfo.getCompanyUrl());
        ipDetect.setCompanyIsIsp(geoInfo.getCompanyIsIsp());
        ipDetect.setLatitude(geoInfo.getLatitude());
        ipDetect.setLongitude(geoInfo.getLongitude());
        ipDetect.setIpType(geoInfo.getIpType());
        ipDetect.setRiskValue(geoInfo.getRiskValue());
        ipDetect.setIsNative(geoInfo.getIsNative());
        ipDetect.setUpdateTime(new Date());
    }

    public static void main(String[] args) {
    }

    @Generated
    public SyncDataScraperTask() {
    }
}

