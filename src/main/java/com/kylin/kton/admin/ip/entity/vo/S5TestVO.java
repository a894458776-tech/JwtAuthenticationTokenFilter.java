/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  io.swagger.annotations.ApiModel
 *  io.swagger.annotations.ApiModelProperty
 *  javax.validation.constraints.NotBlank
 *  javax.validation.constraints.NotNull
 *  lombok.Generated
 */
package com.kylin.kton.admin.ip.entity.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Generated;

@ApiModel(value="S5\u4ee3\u7406\u6d4b\u8bd5\u8bf7\u6c42\u53c2\u6570")
public class S5TestVO {
    @ApiModelProperty(value="S5\u4ee3\u7406IP\u5730\u5740", required=true)
    @NotBlank(message="S5\u4ee3\u7406IP\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotBlank(message="S5\u4ee3\u7406IP\u4e0d\u80fd\u4e3a\u7a7a") String s5Ip;
    @ApiModelProperty(value="\u6d4b\u8bd5\u76ee\u6807URL", required=true)
    @NotBlank(message="\u6d4b\u8bd5URL\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotBlank(message="\u6d4b\u8bd5URL\u4e0d\u80fd\u4e3a\u7a7a") String testUrl;
    @ApiModelProperty(value="\u8fde\u63a5\u8d85\u65f6\u65f6\u95f4(\u6beb\u79d2)", required=false)
    @NotNull(message="\u8d85\u65f6\u65f6\u95f4\u4e0d\u80fd\u4e3a\u7a7a")
    private @NotNull(message="\u8d85\u65f6\u65f6\u95f4\u4e0d\u80fd\u4e3a\u7a7a") Integer timeout = 100000;

    @Generated
    public S5TestVO() {
    }

    @Generated
    public String getS5Ip() {
        return this.s5Ip;
    }

    @Generated
    public String getTestUrl() {
        return this.testUrl;
    }

    @Generated
    public Integer getTimeout() {
        return this.timeout;
    }

    @Generated
    public void setS5Ip(String s5Ip) {
        this.s5Ip = s5Ip;
    }

    @Generated
    public void setTestUrl(String testUrl) {
        this.testUrl = testUrl;
    }

    @Generated
    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof S5TestVO)) {
            return false;
        }
        S5TestVO other = (S5TestVO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Integer this$timeout = this.getTimeout();
        Integer other$timeout = other.getTimeout();
        if (this$timeout == null ? other$timeout != null : !((Object)this$timeout).equals(other$timeout)) {
            return false;
        }
        String this$s5Ip = this.getS5Ip();
        String other$s5Ip = other.getS5Ip();
        if (this$s5Ip == null ? other$s5Ip != null : !this$s5Ip.equals(other$s5Ip)) {
            return false;
        }
        String this$testUrl = this.getTestUrl();
        String other$testUrl = other.getTestUrl();
        return !(this$testUrl == null ? other$testUrl != null : !this$testUrl.equals(other$testUrl));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof S5TestVO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Integer $timeout = this.getTimeout();
        result = result * 59 + ($timeout == null ? 43 : ((Object)$timeout).hashCode());
        String $s5Ip = this.getS5Ip();
        result = result * 59 + ($s5Ip == null ? 43 : $s5Ip.hashCode());
        String $testUrl = this.getTestUrl();
        result = result * 59 + ($testUrl == null ? 43 : $testUrl.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "S5TestVO(s5Ip=" + this.getS5Ip() + ", testUrl=" + this.getTestUrl() + ", timeout=" + this.getTimeout() + ")";
    }
}

