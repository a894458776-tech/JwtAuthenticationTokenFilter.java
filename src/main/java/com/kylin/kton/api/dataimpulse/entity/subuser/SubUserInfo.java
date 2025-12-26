/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.dataimpulse.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import lombok.Generated;

public class SubUserInfo
implements Serializable {
    private Long id;
    private String label;
    private String login;
    private String password;
    private BigDecimal balance;
    @JsonProperty(value="balance_format")
    private String balanceFormat;
    private Integer threads;
    @JsonProperty(value="sticky_range")
    private StickyRange stickyRange;
    @JsonProperty(value="allowed_ips")
    private List<String> allowedIps;
    private Boolean blocked;
    @JsonProperty(value="pool_type")
    private String poolType = "residential";
    @JsonProperty(value="blocked_hosts")
    private String blockedHosts;
    @JsonProperty(value="default_pool_parameters")
    private DefaultPoolParameters defaultPoolParameters;

    @Generated
    public SubUserInfo() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getLabel() {
        return this.label;
    }

    @Generated
    public String getLogin() {
        return this.login;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public BigDecimal getBalance() {
        return this.balance;
    }

    @Generated
    public String getBalanceFormat() {
        return this.balanceFormat;
    }

    @Generated
    public Integer getThreads() {
        return this.threads;
    }

    @Generated
    public StickyRange getStickyRange() {
        return this.stickyRange;
    }

    @Generated
    public List<String> getAllowedIps() {
        return this.allowedIps;
    }

    @Generated
    public Boolean getBlocked() {
        return this.blocked;
    }

    @Generated
    public String getPoolType() {
        return this.poolType;
    }

    @Generated
    public String getBlockedHosts() {
        return this.blockedHosts;
    }

    @Generated
    public DefaultPoolParameters getDefaultPoolParameters() {
        return this.defaultPoolParameters;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setLabel(String label) {
        this.label = label;
    }

    @Generated
    public void setLogin(String login) {
        this.login = login;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    @JsonProperty(value="balance_format")
    @Generated
    public void setBalanceFormat(String balanceFormat) {
        this.balanceFormat = balanceFormat;
    }

    @Generated
    public void setThreads(Integer threads) {
        this.threads = threads;
    }

    @JsonProperty(value="sticky_range")
    @Generated
    public void setStickyRange(StickyRange stickyRange) {
        this.stickyRange = stickyRange;
    }

    @JsonProperty(value="allowed_ips")
    @Generated
    public void setAllowedIps(List<String> allowedIps) {
        this.allowedIps = allowedIps;
    }

    @Generated
    public void setBlocked(Boolean blocked) {
        this.blocked = blocked;
    }

    @JsonProperty(value="pool_type")
    @Generated
    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    @JsonProperty(value="blocked_hosts")
    @Generated
    public void setBlockedHosts(String blockedHosts) {
        this.blockedHosts = blockedHosts;
    }

    @JsonProperty(value="default_pool_parameters")
    @Generated
    public void setDefaultPoolParameters(DefaultPoolParameters defaultPoolParameters) {
        this.defaultPoolParameters = defaultPoolParameters;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserInfo)) {
            return false;
        }
        SubUserInfo other = (SubUserInfo)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Integer this$threads = this.getThreads();
        Integer other$threads = other.getThreads();
        if (this$threads == null ? other$threads != null : !((Object)this$threads).equals(other$threads)) {
            return false;
        }
        Boolean this$blocked = this.getBlocked();
        Boolean other$blocked = other.getBlocked();
        if (this$blocked == null ? other$blocked != null : !((Object)this$blocked).equals(other$blocked)) {
            return false;
        }
        String this$label = this.getLabel();
        String other$label = other.getLabel();
        if (this$label == null ? other$label != null : !this$label.equals(other$label)) {
            return false;
        }
        String this$login = this.getLogin();
        String other$login = other.getLogin();
        if (this$login == null ? other$login != null : !this$login.equals(other$login)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        BigDecimal this$balance = this.getBalance();
        BigDecimal other$balance = other.getBalance();
        if (this$balance == null ? other$balance != null : !((Object)this$balance).equals(other$balance)) {
            return false;
        }
        String this$balanceFormat = this.getBalanceFormat();
        String other$balanceFormat = other.getBalanceFormat();
        if (this$balanceFormat == null ? other$balanceFormat != null : !this$balanceFormat.equals(other$balanceFormat)) {
            return false;
        }
        StickyRange this$stickyRange = this.getStickyRange();
        StickyRange other$stickyRange = other.getStickyRange();
        if (this$stickyRange == null ? other$stickyRange != null : !((Object)this$stickyRange).equals(other$stickyRange)) {
            return false;
        }
        List<String> this$allowedIps = this.getAllowedIps();
        List<String> other$allowedIps = other.getAllowedIps();
        if (this$allowedIps == null ? other$allowedIps != null : !((Object)this$allowedIps).equals(other$allowedIps)) {
            return false;
        }
        String this$poolType = this.getPoolType();
        String other$poolType = other.getPoolType();
        if (this$poolType == null ? other$poolType != null : !this$poolType.equals(other$poolType)) {
            return false;
        }
        String this$blockedHosts = this.getBlockedHosts();
        String other$blockedHosts = other.getBlockedHosts();
        if (this$blockedHosts == null ? other$blockedHosts != null : !this$blockedHosts.equals(other$blockedHosts)) {
            return false;
        }
        DefaultPoolParameters this$defaultPoolParameters = this.getDefaultPoolParameters();
        DefaultPoolParameters other$defaultPoolParameters = other.getDefaultPoolParameters();
        return !(this$defaultPoolParameters == null ? other$defaultPoolParameters != null : !((Object)this$defaultPoolParameters).equals(other$defaultPoolParameters));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserInfo;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Integer $threads = this.getThreads();
        result = result * 59 + ($threads == null ? 43 : ((Object)$threads).hashCode());
        Boolean $blocked = this.getBlocked();
        result = result * 59 + ($blocked == null ? 43 : ((Object)$blocked).hashCode());
        String $label = this.getLabel();
        result = result * 59 + ($label == null ? 43 : $label.hashCode());
        String $login = this.getLogin();
        result = result * 59 + ($login == null ? 43 : $login.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        BigDecimal $balance = this.getBalance();
        result = result * 59 + ($balance == null ? 43 : ((Object)$balance).hashCode());
        String $balanceFormat = this.getBalanceFormat();
        result = result * 59 + ($balanceFormat == null ? 43 : $balanceFormat.hashCode());
        StickyRange $stickyRange = this.getStickyRange();
        result = result * 59 + ($stickyRange == null ? 43 : ((Object)$stickyRange).hashCode());
        List<String> $allowedIps = this.getAllowedIps();
        result = result * 59 + ($allowedIps == null ? 43 : ((Object)$allowedIps).hashCode());
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        String $blockedHosts = this.getBlockedHosts();
        result = result * 59 + ($blockedHosts == null ? 43 : $blockedHosts.hashCode());
        DefaultPoolParameters $defaultPoolParameters = this.getDefaultPoolParameters();
        result = result * 59 + ($defaultPoolParameters == null ? 43 : ((Object)$defaultPoolParameters).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserInfo(id=" + this.getId() + ", label=" + this.getLabel() + ", login=" + this.getLogin() + ", password=" + this.getPassword() + ", balance=" + this.getBalance() + ", balanceFormat=" + this.getBalanceFormat() + ", threads=" + this.getThreads() + ", stickyRange=" + this.getStickyRange() + ", allowedIps=" + this.getAllowedIps() + ", blocked=" + this.getBlocked() + ", poolType=" + this.getPoolType() + ", blockedHosts=" + this.getBlockedHosts() + ", defaultPoolParameters=" + this.getDefaultPoolParameters() + ")";
    }

    public static class StickyRange
    implements Serializable {
        private Integer start;
        private Integer end;

        @Generated
        public StickyRange() {
        }

        @Generated
        public Integer getStart() {
            return this.start;
        }

        @Generated
        public Integer getEnd() {
            return this.end;
        }

        @Generated
        public void setStart(Integer start) {
            this.start = start;
        }

        @Generated
        public void setEnd(Integer end) {
            this.end = end;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof StickyRange)) {
                return false;
            }
            StickyRange other = (StickyRange)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Integer this$start = this.getStart();
            Integer other$start = other.getStart();
            if (this$start == null ? other$start != null : !((Object)this$start).equals(other$start)) {
                return false;
            }
            Integer this$end = this.getEnd();
            Integer other$end = other.getEnd();
            return !(this$end == null ? other$end != null : !((Object)this$end).equals(other$end));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof StickyRange;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Integer $start = this.getStart();
            result = result * 59 + ($start == null ? 43 : ((Object)$start).hashCode());
            Integer $end = this.getEnd();
            result = result * 59 + ($end == null ? 43 : ((Object)$end).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "SubUserInfo.StickyRange(start=" + this.getStart() + ", end=" + this.getEnd() + ")";
        }
    }

    public static class DefaultPoolParameters
    implements Serializable {
        private List<String> countries;
        private List<String> cities;
        private List<String> states;
        private List<String> zipcodes;
        private List<String> asns;
        @JsonProperty(value="exclude_countries")
        private List<String> excludeCountries;
        @JsonProperty(value="exclude_asn")
        private List<String> excludeAsn;
        @JsonProperty(value="anonymous_filter")
        private Boolean anonymousFilter;
        @JsonProperty(value="rotation_interval")
        private Integer rotationInterval;

        @Generated
        public DefaultPoolParameters() {
        }

        @Generated
        public List<String> getCountries() {
            return this.countries;
        }

        @Generated
        public List<String> getCities() {
            return this.cities;
        }

        @Generated
        public List<String> getStates() {
            return this.states;
        }

        @Generated
        public List<String> getZipcodes() {
            return this.zipcodes;
        }

        @Generated
        public List<String> getAsns() {
            return this.asns;
        }

        @Generated
        public List<String> getExcludeCountries() {
            return this.excludeCountries;
        }

        @Generated
        public List<String> getExcludeAsn() {
            return this.excludeAsn;
        }

        @Generated
        public Boolean getAnonymousFilter() {
            return this.anonymousFilter;
        }

        @Generated
        public Integer getRotationInterval() {
            return this.rotationInterval;
        }

        @Generated
        public void setCountries(List<String> countries) {
            this.countries = countries;
        }

        @Generated
        public void setCities(List<String> cities) {
            this.cities = cities;
        }

        @Generated
        public void setStates(List<String> states) {
            this.states = states;
        }

        @Generated
        public void setZipcodes(List<String> zipcodes) {
            this.zipcodes = zipcodes;
        }

        @Generated
        public void setAsns(List<String> asns) {
            this.asns = asns;
        }

        @JsonProperty(value="exclude_countries")
        @Generated
        public void setExcludeCountries(List<String> excludeCountries) {
            this.excludeCountries = excludeCountries;
        }

        @JsonProperty(value="exclude_asn")
        @Generated
        public void setExcludeAsn(List<String> excludeAsn) {
            this.excludeAsn = excludeAsn;
        }

        @JsonProperty(value="anonymous_filter")
        @Generated
        public void setAnonymousFilter(Boolean anonymousFilter) {
            this.anonymousFilter = anonymousFilter;
        }

        @JsonProperty(value="rotation_interval")
        @Generated
        public void setRotationInterval(Integer rotationInterval) {
            this.rotationInterval = rotationInterval;
        }

        @Generated
        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DefaultPoolParameters)) {
                return false;
            }
            DefaultPoolParameters other = (DefaultPoolParameters)o;
            if (!other.canEqual(this)) {
                return false;
            }
            Boolean this$anonymousFilter = this.getAnonymousFilter();
            Boolean other$anonymousFilter = other.getAnonymousFilter();
            if (this$anonymousFilter == null ? other$anonymousFilter != null : !((Object)this$anonymousFilter).equals(other$anonymousFilter)) {
                return false;
            }
            Integer this$rotationInterval = this.getRotationInterval();
            Integer other$rotationInterval = other.getRotationInterval();
            if (this$rotationInterval == null ? other$rotationInterval != null : !((Object)this$rotationInterval).equals(other$rotationInterval)) {
                return false;
            }
            List<String> this$countries = this.getCountries();
            List<String> other$countries = other.getCountries();
            if (this$countries == null ? other$countries != null : !((Object)this$countries).equals(other$countries)) {
                return false;
            }
            List<String> this$cities = this.getCities();
            List<String> other$cities = other.getCities();
            if (this$cities == null ? other$cities != null : !((Object)this$cities).equals(other$cities)) {
                return false;
            }
            List<String> this$states = this.getStates();
            List<String> other$states = other.getStates();
            if (this$states == null ? other$states != null : !((Object)this$states).equals(other$states)) {
                return false;
            }
            List<String> this$zipcodes = this.getZipcodes();
            List<String> other$zipcodes = other.getZipcodes();
            if (this$zipcodes == null ? other$zipcodes != null : !((Object)this$zipcodes).equals(other$zipcodes)) {
                return false;
            }
            List<String> this$asns = this.getAsns();
            List<String> other$asns = other.getAsns();
            if (this$asns == null ? other$asns != null : !((Object)this$asns).equals(other$asns)) {
                return false;
            }
            List<String> this$excludeCountries = this.getExcludeCountries();
            List<String> other$excludeCountries = other.getExcludeCountries();
            if (this$excludeCountries == null ? other$excludeCountries != null : !((Object)this$excludeCountries).equals(other$excludeCountries)) {
                return false;
            }
            List<String> this$excludeAsn = this.getExcludeAsn();
            List<String> other$excludeAsn = other.getExcludeAsn();
            return !(this$excludeAsn == null ? other$excludeAsn != null : !((Object)this$excludeAsn).equals(other$excludeAsn));
        }

        @Generated
        protected boolean canEqual(Object other) {
            return other instanceof DefaultPoolParameters;
        }

        @Generated
        public int hashCode() {
            int PRIME = 59;
            int result = 1;
            Boolean $anonymousFilter = this.getAnonymousFilter();
            result = result * 59 + ($anonymousFilter == null ? 43 : ((Object)$anonymousFilter).hashCode());
            Integer $rotationInterval = this.getRotationInterval();
            result = result * 59 + ($rotationInterval == null ? 43 : ((Object)$rotationInterval).hashCode());
            List<String> $countries = this.getCountries();
            result = result * 59 + ($countries == null ? 43 : ((Object)$countries).hashCode());
            List<String> $cities = this.getCities();
            result = result * 59 + ($cities == null ? 43 : ((Object)$cities).hashCode());
            List<String> $states = this.getStates();
            result = result * 59 + ($states == null ? 43 : ((Object)$states).hashCode());
            List<String> $zipcodes = this.getZipcodes();
            result = result * 59 + ($zipcodes == null ? 43 : ((Object)$zipcodes).hashCode());
            List<String> $asns = this.getAsns();
            result = result * 59 + ($asns == null ? 43 : ((Object)$asns).hashCode());
            List<String> $excludeCountries = this.getExcludeCountries();
            result = result * 59 + ($excludeCountries == null ? 43 : ((Object)$excludeCountries).hashCode());
            List<String> $excludeAsn = this.getExcludeAsn();
            result = result * 59 + ($excludeAsn == null ? 43 : ((Object)$excludeAsn).hashCode());
            return result;
        }

        @Generated
        public String toString() {
            return "SubUserInfo.DefaultPoolParameters(countries=" + this.getCountries() + ", cities=" + this.getCities() + ", states=" + this.getStates() + ", zipcodes=" + this.getZipcodes() + ", asns=" + this.getAsns() + ", excludeCountries=" + this.getExcludeCountries() + ", excludeAsn=" + this.getExcludeAsn() + ", anonymousFilter=" + this.getAnonymousFilter() + ", rotationInterval=" + this.getRotationInterval() + ")";
        }
    }
}

