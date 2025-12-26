/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.microsoft.playwright.Locator
 *  com.microsoft.playwright.Page
 *  com.microsoft.playwright.Page$NavigateOptions
 *  com.microsoft.playwright.Page$WaitForSelectorOptions
 *  com.microsoft.playwright.Page$WaitForURLOptions
 *  com.microsoft.playwright.options.WaitUntilState
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 *  org.jsoup.nodes.Element
 *  org.jsoup.select.Elements
 */
package com.kylin.kton.common.utils.ipInfo;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.WaitUntilState;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class IpInfoUtils {
    private static final String BASE_URL = "https://ipinfo.io/";
    private static final String SEARCH_URL = "https://ipinfo.io/account/search?query=";
    private static final String LOGIN_URL = "https://ipinfo.io/login";
    private static final String SEARCH_PAGE_URL = "https://ipinfo.io/account/search";
    private static final String EMAIL = "1580174359@qq.com";
    private static final String PASSWORD = "Aa@123456";
    private static final String TARGET_IP = "202.126.111.239";
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36";
    private static final int DEFAULT_TIMEOUT = 90000;

    /*
     * Exception decompiling
     */
    public static IPGeoInfo getIPGeoInfo(String ipAddress) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [2[TRYBLOCK]], but top level block is 24[DOLOOP]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    private static void loginToIPInfo(Page page) throws Exception {
        boolean isLoggedIn;
        page.navigate(LOGIN_URL, new Page.NavigateOptions().setWaitUntil(WaitUntilState.DOMCONTENTLOADED));
        page.fill("input[name='email']", EMAIL);
        page.fill("input[name='password']", PASSWORD);
        page.click("button[type='submit']");
        page.waitForURL(url -> url.contains("account"), new Page.WaitForURLOptions().setTimeout(60000.0));
        boolean bl = isLoggedIn = page.locator("text=Welcome").isVisible() || !page.locator("text=Sign In").isVisible();
        if (!isLoggedIn) {
            throw new Exception("\u767b\u5f55\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u51ed\u636e\u6216\u9875\u9762\u7ed3\u6784");
        }
    }

    private static void searchIP(Page page, String ip) {
        Locator searchInput = page.locator("input[placeholder='Search data on any IP address or ASN...']");
        searchInput.fill(ip);
        searchInput.press("Enter");
        page.waitForSelector("dt:has-text('is_anycast')", new Page.WaitForSelectorOptions().setTimeout(60000.0));
        page.waitForTimeout(2000.0);
    }

    public static IPGeoInfo parseIPGeoInfoFromHtml(String ipAddress, String html) {
        String value;
        String key;
        Element dd;
        Element dt;
        int i;
        Elements ddElements;
        Elements dtElements;
        String countryCode = null;
        String province = null;
        String city = null;
        String asn = null;
        String asnBelong = null;
        String asnBelongUrl = null;
        Integer asnIsIsp = 0;
        String company = null;
        String companyUrl = null;
        Integer companyIsIsp = 0;
        BigDecimal latitude = null;
        BigDecimal longitude = null;
        Document doc = Jsoup.parse((String)html);
        Elements dlElements = doc.select("dl");
        if (dlElements.size() > 0) {
            Element firstDl = (Element)dlElements.get(0);
            dtElements = firstDl.select("dt");
            ddElements = firstDl.select("dd");
            block36: for (i = 0; i < dtElements.size(); ++i) {
                if (i >= ddElements.size()) continue;
                dt = (Element)dtElements.get(i);
                dd = (Element)ddElements.get(i);
                key = dt.text().trim();
                value = dd.text().trim().replace("\"", "");
                switch (key) {
                    case "country": {
                        countryCode = value;
                        continue block36;
                    }
                    case "region": {
                        province = value;
                        continue block36;
                    }
                    case "city": {
                        city = value;
                        continue block36;
                    }
                    case "loc": {
                        String[] parts = value.split(",");
                        if (parts.length != 2) continue block36;
                        try {
                            latitude = new BigDecimal(parts[0]);
                            longitude = new BigDecimal(parts[1]);
                            continue block36;
                        }
                        catch (NumberFormatException numberFormatException) {
                            // empty catch block
                        }
                    }
                }
            }
        }
        if (dlElements.size() > 1) {
            Element secondDl = (Element)dlElements.get(1);
            dtElements = secondDl.select("dt");
            ddElements = secondDl.select("dd");
            block37: for (i = 0; i < dtElements.size(); ++i) {
                if (i >= ddElements.size()) continue;
                dt = (Element)dtElements.get(i);
                dd = (Element)ddElements.get(i);
                key = dt.text().trim();
                value = dd.text().trim().replace("\"", "");
                switch (key) {
                    case "asn": {
                        asn = value;
                        continue block37;
                    }
                    case "name": {
                        asnBelong = value;
                        continue block37;
                    }
                    case "domain": {
                        asnBelongUrl = value;
                        continue block37;
                    }
                    case "type": {
                        if (!"isp".equalsIgnoreCase(value)) continue block37;
                        asnIsIsp = 1;
                    }
                }
            }
        }
        if (dlElements.size() > 2) {
            Element thirdDl = (Element)dlElements.get(2);
            dtElements = thirdDl.select("dt");
            ddElements = thirdDl.select("dd");
            block38: for (i = 0; i < dtElements.size(); ++i) {
                if (i >= ddElements.size()) continue;
                dt = (Element)dtElements.get(i);
                dd = (Element)ddElements.get(i);
                key = dt.text().trim();
                value = dd.text().trim().replace("\"", "");
                switch (key) {
                    case "name": {
                        company = value;
                        continue block38;
                    }
                    case "domain": {
                        companyUrl = value;
                        continue block38;
                    }
                    case "type": {
                        if (!"isp".equalsIgnoreCase(value)) continue block38;
                        companyIsIsp = 1;
                    }
                }
            }
        }
        return new IPGeoInfo(countryCode, province, city, asn, asnBelong, asnBelongUrl, asnIsIsp, company, companyUrl, companyIsIsp, latitude, longitude, "IDC", 0L, 1);
    }

    private static String getSystemChromePath() {
        return null;
    }

    public static void saveHtmlToFile(String html, String filePath) throws Exception {
        Files.write(Paths.get(filePath, new String[0]), html.getBytes(), new OpenOption[0]);
    }

    public static class IPGeoInfo {
        private String countryCode;
        private String province;
        private String city;
        private String asn;
        private String asnBelong;
        private String asnBelongUrl;
        private Integer asnIsIsp;
        private String company;
        private String companyUrl;
        private Integer companyIsIsp;
        private BigDecimal latitude;
        private BigDecimal longitude;
        private String ipType;
        private Long riskValue;
        private Integer isNative;

        public IPGeoInfo(String countryCode, String province, String city, String asn, String asnBelong, String asnBelongUrl, Integer asnIsIsp, String company, String companyUrl, Integer companyIsIsp, BigDecimal latitude, BigDecimal longitude, String ipType, Long riskValue, Integer isNative) {
            this.countryCode = countryCode;
            this.province = province;
            this.city = city;
            this.asn = asn;
            this.asnBelong = asnBelong;
            this.asnBelongUrl = asnBelongUrl;
            this.asnIsIsp = asnIsIsp;
            this.company = company;
            this.companyUrl = companyUrl;
            this.companyIsIsp = companyIsIsp;
            this.latitude = latitude;
            this.longitude = longitude;
            this.ipType = ipType;
            this.riskValue = riskValue;
            this.isNative = isNative;
        }

        public String getCountryCode() {
            return this.countryCode;
        }

        public String getProvince() {
            return this.province;
        }

        public String getCity() {
            return this.city;
        }

        public String getAsn() {
            return this.asn;
        }

        public String getAsnBelong() {
            return this.asnBelong;
        }

        public String getAsnBelongUrl() {
            return this.asnBelongUrl;
        }

        public Integer getAsnIsIsp() {
            return this.asnIsIsp;
        }

        public String getCompany() {
            return this.company;
        }

        public String getCompanyUrl() {
            return this.companyUrl;
        }

        public Integer getCompanyIsIsp() {
            return this.companyIsIsp;
        }

        public BigDecimal getLatitude() {
            return this.latitude;
        }

        public BigDecimal getLongitude() {
            return this.longitude;
        }

        public String getIpType() {
            return this.ipType;
        }

        public Long getRiskValue() {
            return this.riskValue;
        }

        public Integer getIsNative() {
            return this.isNative;
        }

        public String toString() {
            return "IPGeoInfo{countryCode='" + this.countryCode + '\'' + ", province='" + this.province + '\'' + ", city='" + this.city + '\'' + ", asn='" + this.asn + '\'' + ", asnBelong='" + this.asnBelong + '\'' + ", asnBelongUrl='" + this.asnBelongUrl + '\'' + ", asnIsIsp=" + this.asnIsIsp + ", company='" + this.company + '\'' + ", companyUrl='" + this.companyUrl + '\'' + ", companyIsIsp=" + this.companyIsIsp + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", ipType='" + this.ipType + '\'' + ", riskValue=" + this.riskValue + ", isNative=" + this.isNative + '}';
        }
    }
}

