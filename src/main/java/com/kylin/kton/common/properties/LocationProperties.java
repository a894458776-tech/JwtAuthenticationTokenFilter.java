/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 *  org.springframework.boot.context.properties.ConfigurationProperties
 *  org.springframework.context.annotation.Configuration
 */
package com.kylin.kton.common.properties;

import java.io.Serializable;
import java.util.List;
import lombok.Generated;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="continent")
public class LocationProperties
implements Serializable {
    private List<Continent> continents;

    @Generated
    public LocationProperties() {
    }

    @Generated
    public List<Continent> getContinents() {
        return this.continents;
    }

    @Generated
    public void setContinents(List<Continent> continents) {
        this.continents = continents;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof LocationProperties)) {
            return false;
        }
        LocationProperties other = (LocationProperties)o;
        if (!other.canEqual(this)) {
            return false;
        }
        List<Continent> this$continents = this.getContinents();
        List<Continent> other$continents = other.getContinents();
        return !(this$continents == null ? other$continents != null : !((Object)this$continents).equals(other$continents));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof LocationProperties;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        List<Continent> $continents = this.getContinents();
        result = result * 59 + ($continents == null ? 43 : ((Object)$continents).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "LocationProperties(continents=" + this.getContinents() + ")";
    }

    public static class CountryNode
    implements Serializable {
        private String code;
        private List<String> cities;

        @Generated
        public CountryNode() {
        }

        @Generated
        public String getCode() {
            return this.code;
        }

        @Generated
        public List<String> getCities() {
            return this.cities;
        }

        @Generated
        public void setCode(String code) {
            this.code = code;
        }

        @Generated
        public void setCities(List<String> cities) {
            this.cities = cities;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CountryNode)) {
                return false;
            }
            CountryNode other = (CountryNode)o;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$code = this.getCode();
            String other$code = other.getCode();
            if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
                return false;
            }
            List<String> this$cities = this.getCities();
            List<String> other$cities = other.getCities();
            return !(this$cities == null ? other$cities != null : !((Object)this$cities).equals(other$cities));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof CountryNode;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $code = this.getCode();
            result = result * 59 + ($code == null ? 43 : $code.hashCode());
            List<String> $cities = this.getCities();
            result = result * 59 + ($cities == null ? 43 : ((Object)$cities).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "LocationProperties.CountryNode(code=" + this.getCode() + ", cities=" + this.getCities() + ")";
        }
    }

    public static class Continent
    implements Serializable {
        private String code;
        private List<CountryNode> countries;

        @Generated
        public Continent() {
        }

        @Generated
        public String getCode() {
            return this.code;
        }

        @Generated
        public List<CountryNode> getCountries() {
            return this.countries;
        }

        @Generated
        public void setCode(String code) {
            this.code = code;
        }

        @Generated
        public void setCountries(List<CountryNode> countries) {
            this.countries = countries;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof Continent)) {
                return false;
            }
            Continent other = (Continent)o;
            if (!other.canEqual(this)) {
                return false;
            }
            String this$code = this.getCode();
            String other$code = other.getCode();
            if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
                return false;
            }
            List<CountryNode> this$countries = this.getCountries();
            List<CountryNode> other$countries = other.getCountries();
            return !(this$countries == null ? other$countries != null : !((Object)this$countries).equals(other$countries));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof Continent;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            String $code = this.getCode();
            result = result * 59 + ($code == null ? 43 : $code.hashCode());
            List<CountryNode> $countries = this.getCountries();
            result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "LocationProperties.Continent(code=" + this.getCode() + ", countries=" + this.getCountries() + ")";
        }
    }
}

