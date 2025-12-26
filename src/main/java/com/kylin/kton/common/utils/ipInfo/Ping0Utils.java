/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.microsoft.playwright.Browser
 *  com.microsoft.playwright.BrowserType$LaunchOptions
 *  com.microsoft.playwright.Page
 *  com.microsoft.playwright.Page$WaitForLoadStateOptions
 *  com.microsoft.playwright.Page$WaitForSelectorOptions
 *  com.microsoft.playwright.Playwright
 *  com.microsoft.playwright.options.LoadState
 *  com.microsoft.playwright.options.WaitForSelectorState
 *  lombok.Generated
 *  org.jsoup.Jsoup
 *  org.jsoup.nodes.Document
 *  org.jsoup.nodes.Element
 *  org.slf4j.Logger
 *  org.slf4j.LoggerFactory
 *  org.springframework.stereotype.Component
 */
package com.kylin.kton.common.utils.ipInfo;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.LoadState;
import com.microsoft.playwright.options.WaitForSelectorState;
import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import lombok.Generated;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class Ping0Utils {
    @Generated
    private static final Logger log = LoggerFactory.getLogger(Ping0Utils.class);
    private static final String BASE_URL = "https://ping0.cc/ip/";
    private static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36";
    private static final int DEFAULT_TIMEOUT = 90000;

    /*
     * Exception decompiling
     */
    public static IPGeoInfo getIPGeoInfo(String ipAddress) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [7[TRYBLOCK]], but top level block is 29[DOLOOP]
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

    private static IPGeoInfo parseIPGeoInfoFromHtml(String ipAddress, String html) throws Exception {
        Document doc = Jsoup.parse((String)html);
        String[] ipAddressData = Ping0Utils.parseIpAddress(doc);
        String countryCode = ipAddressData[0];
        String province = ipAddressData[1];
        String city = ipAddressData[2];
        String asn = Ping0Utils.parseAsnCode(doc);
        Map<String, String> asnData = Ping0Utils.parseAsn(doc);
        Integer asnIsIsp = "ISP".equals(asnData.get("type")) ? 1 : 0;
        String asnBelong = asnData.get("name");
        String asnBelongUrl = asnData.get("website_domain");
        Map<String, String> companyData = Ping0Utils.parseCompanyInfo(doc);
        String company = companyData.get("name");
        String companyUrl = companyData.get("website_domain");
        Integer companyIsIsp = "ISP".equals(companyData.get("type")) ? 1 : 0;
        BigDecimal latitude = Ping0Utils.parseLatitude(doc);
        BigDecimal longitude = Ping0Utils.parseLongitude(doc);
        String ipTypeData = Ping0Utils.parseIpType(doc);
        String ipType = "\u5bb6\u5ead\u5bbd\u5e26IP".equals(ipTypeData) ? "HOST" : "IDC";
        Long riskValue = Ping0Utils.parseRiskValue(doc);
        Integer isNative = Ping0Utils.parseNative(doc);
        return new IPGeoInfo(countryCode, province, city, asn, asnBelong, asnBelongUrl, asnIsIsp, company, companyUrl, companyIsIsp, latitude, longitude, ipType, riskValue, isNative);
    }

    private static String[] parseIpAddress(Document doc) {
        Element contentDiv = doc.select("div.line.loc div.content").first();
        if (contentDiv == null) {
            System.out.println("Debug - Document HTML:\n" + doc.html());
            return Ping0Utils.createUnknownLocation();
        }
        contentDiv.select("img").remove();
        contentDiv.select("span.report").remove();
        String locationText = contentDiv.text().replaceAll("\\s+", " ").trim();
        System.out.println("Debug - Extracted text: " + locationText);
        return Ping0Utils.parseLocationText(locationText);
    }

    private static String[] createUnknownLocation() {
        return new String[]{"\u672a\u77e5\u56fd\u5bb6", "\u672a\u77e5\u7701\u4efd", "\u672a\u77e5\u57ce\u5e02"};
    }

    private static String[] parseLocationText(String text) {
        if (text == null || text.isEmpty()) {
            return Ping0Utils.createUnknownLocation();
        }
        String[] parts = text.split(" ");
        if (parts.length >= 3) {
            if (parts[1].equals("\u53f0\u6e7e")) {
                return new String[]{"\u53f0\u6e7e", "\u53f0\u6e7e", parts[2]};
            }
            if (parts[1].equals("\u9999\u6e2f")) {
                return new String[]{"\u9999\u6e2f", "\u9999\u6e2f", parts[2]};
            }
            return new String[]{parts[0], parts[1], parts[2]};
        }
        if (parts.length == 2) {
            if (parts[1].equals("\u53f0\u6e7e")) {
                return new String[]{"\u53f0\u6e7e", "\u53f0\u6e7e", "\u53f0\u6e7e"};
            }
            if (parts[1].equals("\u9999\u6e2f")) {
                return new String[]{"\u9999\u6e2f", "\u9999\u6e2f", "\u9999\u6e2f"};
            }
            return new String[]{parts[0], parts[1], parts[1]};
        }
        if (parts.length == 1) {
            if (text.equals("\u65b0\u52a0\u5761") || text.equals("\u65e5\u672c") || text.equals("\u7f8e\u56fd")) {
                return new String[]{text, text, text};
            }
            return new String[]{"\u672a\u77e5\u56fd\u5bb6", text, text};
        }
        return Ping0Utils.createUnknownLocation();
    }

    private static String parseAsnCode(Document doc) {
        Element contentDiv = doc.select("div.line.asn > div.content").first();
        if (contentDiv != null) {
            String asn = contentDiv.select("a").text();
            return asn;
        }
        return null;
    }

    private static Map<String, String> parseAsn(Document doc) {
        HashMap<String, String> result = new HashMap<String, String>();
        Element ownerDiv = doc.select("div.line.asnname > div.content").first();
        if (ownerDiv != null) {
            Element typeSpan = ownerDiv.select("span.mini.label").first();
            if (typeSpan != null) {
                result.put("type", typeSpan.text().trim());
            }
            String fullText = ownerDiv.text().trim();
            String name = fullText.replaceAll("^BUS\\s*", "").replaceAll("\\s*\u2014.*$", "").trim();
            result.put("name", name);
            Element websiteLink = ownerDiv.select("a[href]").first();
            if (websiteLink != null) {
                String href = websiteLink.attr("href");
                result.put("website_url", href);
                String domain = href.replaceAll("^https?://", "").replaceAll("/.*$", "");
                result.put("website_domain", domain);
            }
        }
        return result;
    }

    private static Map<String, String> parseCompanyInfo(Document doc) {
        HashMap<String, String> result = new HashMap<String, String>();
        Element companyDiv = doc.select("div.line.orgname > div.content").first();
        if (companyDiv != null) {
            Element typeSpan = companyDiv.select("span.mini.label").first();
            if (typeSpan != null) {
                result.put("type", typeSpan.text().trim());
            }
            String fullText = companyDiv.text().trim();
            String companyName = fullText.replaceAll("^BUS\\s*", "").replaceAll("\\s*\u2014.*$", "").trim();
            result.put("name", companyName);
            Element websiteLink = companyDiv.select("a").first();
            if (websiteLink != null) {
                String candidate;
                String domainFromHref;
                String href;
                String domainCandidate = websiteLink.text().trim();
                if (Ping0Utils.isValidDomain(domainCandidate)) {
                    result.put("website_domain", domainCandidate);
                }
                if (!(result.containsKey("website_domain") || (href = websiteLink.attr("href")).isEmpty() || href.startsWith("javascript") || (domainFromHref = Ping0Utils.extractPureDomain(href)) == null)) {
                    result.put("website_domain", domainFromHref);
                }
                if (!result.containsKey("website_domain") && fullText.contains("\u2014") && Ping0Utils.isValidDomain(candidate = fullText.split("\u2014")[1].trim())) {
                    result.put("website_domain", candidate);
                }
            }
        }
        return result;
    }

    private static String extractPureDomain(String url) {
        try {
            URI uri;
            String domain;
            if (!url.startsWith("http")) {
                url = "http://" + url;
            }
            return (domain = (uri = new URI(url)).getHost()) == null ? null : domain.replaceFirst("^www\\.", "");
        }
        catch (URISyntaxException e) {
            return null;
        }
    }

    private static boolean isValidDomain(String domain) {
        return domain != null && domain.matches("^([a-z0-9-]+\\.)+[a-z]{2,}$");
    }

    private static BigDecimal parseLatitude(Document doc) {
        try {
            Element longitudeDiv = doc.select("div.line:has(div.name:containsOwn(\u7ecf\u5ea6)) > div.content").first();
            if (longitudeDiv != null) {
                String longitudeText = longitudeDiv.text().trim();
                return new BigDecimal(longitudeText);
            }
        }
        catch (Exception e) {
            System.err.println("\u89e3\u6790\u7ecf\u5ea6\u5931\u8d25: " + e.getMessage());
        }
        return null;
    }

    private static BigDecimal parseLongitude(Document doc) {
        try {
            Element latitudeElement = doc.select("div.line:has(div.name:containsOwn(\u7eac\u5ea6)) > div.content").first();
            if (latitudeElement != null) {
                String latitudeText = latitudeElement.text().trim();
                return new BigDecimal(latitudeText);
            }
        }
        catch (Exception e) {
            System.err.println("\u7eac\u5ea6\u89e3\u6790\u9519\u8bef: " + e.getMessage());
        }
        return null;
    }

    private static String parseIpType(Document doc) {
        try {
            Element ipTypeElement = doc.select("div.line.line-iptype div.content span.label").first();
            if (ipTypeElement != null) {
                return ipTypeElement.text().trim();
            }
        }
        catch (Exception e) {
            System.err.println("IP\u7c7b\u578b\u89e3\u6790\u9519\u8bef: " + e.getMessage());
        }
        return null;
    }

    private static Long parseRiskValue(Document doc) {
        try {
            Element riskValueElement = doc.select("div.line.line-risk div.riskitem.riskcurrent span.value").first();
            if (riskValueElement != null) {
                String riskText = riskValueElement.text().replace("%", "");
                return Long.parseLong(riskText);
            }
            Element riskItemElement = doc.select("div.line.line-risk div.riskitem.riskcurrent").first();
            if (riskItemElement != null) {
                String title = riskItemElement.attr("title");
                Pattern pattern = Pattern.compile("(\\d+)%?");
                Matcher matcher = pattern.matcher(title);
                if (matcher.find()) {
                    return Long.parseLong(matcher.group(1));
                }
            }
        }
        catch (Exception e) {
            System.err.println("\u98ce\u9669\u503c\u89e3\u6790\u9519\u8bef: " + e.getMessage());
        }
        return null;
    }

    private static Integer parseNative(Document doc) {
        try {
            Element ipTypeElement = doc.select("div.line.line-nativeip div.content span.label").first();
            if (ipTypeElement != null) {
                String ipTypeText = ipTypeElement.text().trim();
                if ("\u539f\u751f IP".equals(ipTypeText)) {
                    return 1;
                }
                if ("\u5e7f\u64ad IP".equals(ipTypeText)) {
                    return 0;
                }
            }
        }
        catch (Exception e) {
            System.err.println("IP\u539f\u751f\u7c7b\u578b\u89e3\u6790\u9519\u8bef: " + e.getMessage());
        }
        return null;
    }

    private static void waitForPageContent(Page page) {
        try {
            log.debug("\u7b49\u5f85\u5173\u952e\u5143\u7d20\u52a0\u8f7d...");
            page.waitForLoadState(LoadState.NETWORKIDLE, new Page.WaitForLoadStateOptions().setTimeout(65000.0));
            page.waitForSelector("div.line.loc", new Page.WaitForSelectorOptions().setTimeout(60000.0).setState(WaitForSelectorState.ATTACHED));
            page.waitForTimeout(6000.0);
            log.debug("\u5173\u952e\u5143\u7d20\u52a0\u8f7d\u5b8c\u6210");
        }
        catch (Exception e) {
            log.debug("\u7b49\u5f85\u5185\u5bb9\u8d85\u65f6\uff0c\u5c1d\u8bd5\u7ee7\u7eed\u5904\u7406......");
        }
    }

    private static String getSystemChromePath() {
        return null;
    }

    public static void saveHtmlToFile(String html, String filePath) throws Exception {
        Files.write(Paths.get(filePath, new String[0]), html.getBytes(), new OpenOption[0]);
    }

    public static void testProductionEnv() {
        try (Playwright playwright = Playwright.create();){
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(true).setArgs(Arrays.asList("--no-sandbox")));
            Page page = browser.newPage();
            HashMap<String, String> headers = new HashMap<String, String>();
            headers.put("Accept-Language", "en-US,en;q=0.9");
            headers.put("Sec-Fetch-Dest", "document");
            page.setExtraHTTPHeaders(headers);
            page.navigate("https://ping0.cc/ip/103.119.175.54");
            page.waitForTimeout(6000.0);
            String html = page.content();
            System.out.println(html);
        }
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

