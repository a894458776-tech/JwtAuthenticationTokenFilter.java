/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  lombok.Generated
 */
package com.kylin.kton.api.netnut.entity.subuser;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Generated;

public class AllocateIPsRequest {
    @JsonProperty(value="access_point")
    private String accessPoint;
    @JsonProperty(value="zone")
    private String zone;
    @JsonProperty(value="ips")
    private int ips;
    @JsonProperty(value="bandwidth")
    private int bandwidth;

    @Generated
    public AllocateIPsRequest() {
    }

    @Generated
    public String getAccessPoint() {
        return this.accessPoint;
    }

    @Generated
    public String getZone() {
        return this.zone;
    }

    @Generated
    public int getIps() {
        return this.ips;
    }

    @Generated
    public int getBandwidth() {
        return this.bandwidth;
    }

    @JsonProperty(value="access_point")
    @Generated
    public void setAccessPoint(String accessPoint) {
        this.accessPoint = accessPoint;
    }

    @JsonProperty(value="zone")
    @Generated
    public void setZone(String zone) {
        this.zone = zone;
    }

    @JsonProperty(value="ips")
    @Generated
    public void setIps(int ips) {
        this.ips = ips;
    }

    @JsonProperty(value="bandwidth")
    @Generated
    public void setBandwidth(int bandwidth) {
        this.bandwidth = bandwidth;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AllocateIPsRequest)) {
            return false;
        }
        AllocateIPsRequest other = (AllocateIPsRequest)o;
        if (!other.canEqual(this)) {
            return false;
        }
        if (this.getIps() != other.getIps()) {
            return false;
        }
        if (this.getBandwidth() != other.getBandwidth()) {
            return false;
        }
        String this$accessPoint = this.getAccessPoint();
        String other$accessPoint = other.getAccessPoint();
        if (this$accessPoint == null ? other$accessPoint != null : !this$accessPoint.equals(other$accessPoint)) {
            return false;
        }
        String this$zone = this.getZone();
        String other$zone = other.getZone();
        return !(this$zone == null ? other$zone != null : !this$zone.equals(other$zone));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AllocateIPsRequest;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        result = result * 59 + this.getIps();
        result = result * 59 + this.getBandwidth();
        String $accessPoint = this.getAccessPoint();
        result = result * 59 + ($accessPoint == null ? 43 : $accessPoint.hashCode());
        String $zone = this.getZone();
        result = result * 59 + ($zone == null ? 43 : $zone.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AllocateIPsRequest(accessPoint=" + this.getAccessPoint() + ", zone=" + this.getZone() + ", ips=" + this.getIps() + ", bandwidth=" + this.getBandwidth() + ")";
    }
}

