/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.client.risk.entity.dto;

import com.kylin.kton.client.risk.entity.dto.RiskData;
import lombok.Generated;

public class RiskApiResponse {
    private String code;
    private String message;
    private RiskData data;

    @Generated
    public RiskApiResponse() {
    }

    @Generated
    public String getCode() {
        return this.code;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @Generated
    public RiskData getData() {
        return this.data;
    }

    @Generated
    public void setCode(String code) {
        this.code = code;
    }

    @Generated
    public void setMessage(String message) {
        this.message = message;
    }

    @Generated
    public void setData(RiskData data) {
        this.data = data;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RiskApiResponse)) {
            return false;
        }
        RiskApiResponse other = (RiskApiResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        String this$code = this.getCode();
        String other$code = other.getCode();
        if (this$code == null ? other$code != null : !this$code.equals(other$code)) {
            return false;
        }
        String this$message = this.getMessage();
        String other$message = other.getMessage();
        if (this$message == null ? other$message != null : !this$message.equals(other$message)) {
            return false;
        }
        RiskData this$data = this.getData();
        RiskData other$data = other.getData();
        return !(this$data == null ? other$data != null : !((Object)this$data).equals(other$data));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof RiskApiResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        String $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : $code.hashCode());
        String $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        RiskData $data = this.getData();
        result = result * 59 + ($data == null ? 43 : ((Object)$data).hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "RiskApiResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ", data=" + this.getData() + ")";
    }
}

