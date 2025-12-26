/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.fasterxml.jackson.annotation.JsonProperty
 *  com.kylin.kton.common.utils.StringUtils
 *  lombok.Generated
 */
package com.kylin.kton.api.ipnux.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kylin.kton.common.utils.StringUtils;
import java.io.Serializable;
import lombok.Generated;

public class BaseResponse
implements Serializable {
    @JsonProperty(value="Code")
    private Integer code;
    @JsonProperty(value="Message")
    private String message;

    public Boolean isSuccess() {
        return this.code == 1000 && StringUtils.equals((CharSequence)this.message, (CharSequence)"Successful");
    }

    @Generated
    public BaseResponse() {
    }

    @Generated
    public Integer getCode() {
        return this.code;
    }

    @Generated
    public String getMessage() {
        return this.message;
    }

    @JsonProperty(value="Code")
    @Generated
    public void setCode(Integer code) {
        this.code = code;
    }

    @JsonProperty(value="Message")
    @Generated
    public void setMessage(String message) {
        this.message = message;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof BaseResponse)) {
            return false;
        }
        BaseResponse other = (BaseResponse)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$code = this.getCode();
        Integer other$code = other.getCode();
        if (this$code == null ? other$code != null : !((Object)this$code).equals(other$code)) {
            return false;
        }
        String this$message = this.getMessage();
        String other$message = other.getMessage();
        return !(this$message == null ? other$message != null : !this$message.equals(other$message));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof BaseResponse;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $code = this.getCode();
        result = result * 59 + ($code == null ? 43 : ((Object)$code).hashCode());
        String $message = this.getMessage();
        result = result * 59 + ($message == null ? 43 : $message.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "BaseResponse(code=" + this.getCode() + ", message=" + this.getMessage() + ")";
    }
}

