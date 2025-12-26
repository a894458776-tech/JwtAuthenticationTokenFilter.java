/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.utils.ipInfo;

import java.util.HashMap;
import java.util.Map;

public class RegionUtils {
    private static final Map<String, ContinentInfo> regionMap = new HashMap<String, ContinentInfo>();
    public static ContinentInfo ContinentInfo;

    public static ContinentInfo getContinentInfo(String country) {
        return regionMap.getOrDefault(country, new ContinentInfo("Unknown", "Unknown"));
    }

    public static void main(String[] args) {
        System.out.println(RegionUtils.getContinentInfo("TW"));
        System.out.println(RegionUtils.getContinentInfo("HK"));
        System.out.println(RegionUtils.getContinentInfo("US"));
    }

    static {
        regionMap.put("HK", new ContinentInfo("Eastern Asia", "Asia"));
        regionMap.put("TW", new ContinentInfo("Eastern Asia", "Asia"));
        regionMap.put("KR", new ContinentInfo("Eastern Asia", "Asia"));
        regionMap.put("JP", new ContinentInfo("Eastern Asia", "Asia"));
        regionMap.put("ID", new ContinentInfo("South-Eastern Asia", "Asia"));
        regionMap.put("VN", new ContinentInfo("South-Eastern Asia", "Asia"));
        regionMap.put("MY", new ContinentInfo("South-Eastern Asia", "Asia"));
        regionMap.put("TH", new ContinentInfo("South-Eastern Asia", "Asia"));
        regionMap.put("SG", new ContinentInfo("South-Eastern Asia", "Asia"));
        regionMap.put("PH", new ContinentInfo("South-Eastern Asia", "Asia"));
        regionMap.put("AE", new ContinentInfo("Western Europe", "Europe"));
        regionMap.put("US", new ContinentInfo("North America", "North America"));
        regionMap.put("MX", new ContinentInfo("North America", "North America"));
        regionMap.put("GB", new ContinentInfo("Northern Europe", "Europe"));
        regionMap.put("EE", new ContinentInfo("Northern Europe", "Europe"));
        regionMap.put("BR", new ContinentInfo("South America", "South America"));
        regionMap.put("IT", new ContinentInfo("Southern Europe", "Europe"));
        regionMap.put("FR", new ContinentInfo("Western Europe", "Europe"));
        regionMap.put("DE", new ContinentInfo("Western Europe", "Europe"));
        regionMap.put("RU", new ContinentInfo("Eastern Europe", "Europe"));
    }

    public static class ContinentInfo {
        private final String subContinent;
        private final String continent;

        public ContinentInfo(String subContinent, String continent) {
            this.subContinent = subContinent;
            this.continent = continent;
        }

        public String getSubContinent() {
            return this.subContinent;
        }

        public String getContinent() {
            return this.continent;
        }

        public String toString() {
            return "SubContinent: " + this.subContinent + ", Continent: " + this.continent;
        }
    }
}

