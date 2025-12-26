/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.oxylabs.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class SubUserResponseItem {
    private Integer id;
    private String username;
    private String status;
    @JsonProperty(value="created_at")
    private String createdAt;
    private Double traffic;
    @JsonProperty(value="traffic_limit")
    private Double trafficLimit;
    @JsonProperty(value="auto_disable")
    private Boolean autoDisable;
    private Boolean lifetime;

    @Generated
    public SubUserResponseItem() {
    }

    @Generated
    public Integer getId() {
        return this.id;
    }

    @Generated
    public String getUsername() {
        return this.username;
    }

    @Generated
    public String getStatus() {
        return this.status;
    }

    @Generated
    public String getCreatedAt() {
        return this.createdAt;
    }

    @Generated
    public Double getTraffic() {
        return this.traffic;
    }

    @Generated
    public Double getTrafficLimit() {
        return this.trafficLimit;
    }

    @Generated
    public Boolean getAutoDisable() {
        return this.autoDisable;
    }

    @Generated
    public Boolean getLifetime() {
        return this.lifetime;
    }

    @Generated
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated
    public void setUsername(String username) {
        this.username = username;
    }

    @Generated
    public void setStatus(String status) {
        this.status = status;
    }

    @JsonProperty(value="created_at")
    @Generated
    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    @Generated
    public void setTraffic(Double traffic) {
        this.traffic = traffic;
    }

    @JsonProperty(value="traffic_limit")
    @Generated
    public void setTrafficLimit(Double trafficLimit) {
        this.trafficLimit = trafficLimit;
    }

    @JsonProperty(value="auto_disable")
    @Generated
    public void setAutoDisable(Boolean autoDisable) {
        this.autoDisable = autoDisable;
    }

    @Generated
    public void setLifetime(Boolean lifetime) {
        this.lifetime = lifetime;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserResponseItem)) {
            return false;
        }
        SubUserResponseItem other = (SubUserResponseItem)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$id = this.getId();
        Integer other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Double this$traffic = this.getTraffic();
        Double other$traffic = other.getTraffic();
        if (this$traffic == null ? other$traffic != null : !((Object)this$traffic).equals(other$traffic)) {
            return false;
        }
        Double this$trafficLimit = this.getTrafficLimit();
        Double other$trafficLimit = other.getTrafficLimit();
        if (this$trafficLimit == null ? other$trafficLimit != null : !((Object)this$trafficLimit).equals(other$trafficLimit)) {
            return false;
        }
        Boolean this$autoDisable = this.getAutoDisable();
        Boolean other$autoDisable = other.getAutoDisable();
        if (this$autoDisable == null ? other$autoDisable != null : !((Object)this$autoDisable).equals(other$autoDisable)) {
            return false;
        }
        Boolean this$lifetime = this.getLifetime();
        Boolean other$lifetime = other.getLifetime();
        if (this$lifetime == null ? other$lifetime != null : !((Object)this$lifetime).equals(other$lifetime)) {
            return false;
        }
        String this$username = this.getUsername();
        String other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) {
            return false;
        }
        String this$status = this.getStatus();
        String other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) {
            return false;
        }
        String this$createdAt = this.getCreatedAt();
        String other$createdAt = other.getCreatedAt();
        return !(this$createdAt == null ? other$createdAt != null : !this$createdAt.equals(other$createdAt));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserResponseItem;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Double $traffic = this.getTraffic();
        result = result * 59 + ($traffic == null ? 43 : ((Object)$traffic).hashCode());
        Double $trafficLimit = this.getTrafficLimit();
        result = result * 59 + ($trafficLimit == null ? 43 : ((Object)$trafficLimit).hashCode());
        Boolean $autoDisable = this.getAutoDisable();
        result = result * 59 + ($autoDisable == null ? 43 : ((Object)$autoDisable).hashCode());
        Boolean $lifetime = this.getLifetime();
        result = result * 59 + ($lifetime == null ? 43 : ((Object)$lifetime).hashCode());
        String $username = this.getUsername();
        result = result * 59 + ($username == null ? 43 : $username.hashCode());
        String $status = this.getStatus();
        result = result * 59 + ($status == null ? 43 : $status.hashCode());
        String $createdAt = this.getCreatedAt();
        result = result * 59 + ($createdAt == null ? 43 : $createdAt.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserResponseItem(id=" + this.getId() + ", username=" + this.getUsername() + ", status=" + this.getStatus() + ", createdAt=" + this.getCreatedAt() + ", traffic=" + this.getTraffic() + ", trafficLimit=" + this.getTrafficLimit() + ", autoDisable=" + this.getAutoDisable() + ", lifetime=" + this.getLifetime() + ")";
    }
}

