/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.system.domain.KtonMerchantIpSource
 *  lombok.Generated
 */
package com.kylin.kton.admin.merchant.base.entity.dto;

import com.kylin.kton.system.domain.KtonMerchantIpSource;
import lombok.Generated;

public class AdminMerchantSourceDTO
extends KtonMerchantIpSource {
    private Long id;
    private String sourceCode;
    private String sourceUsername;
    private String sourcePassword;
    private Long isStatic;
    private Long isDynamics;
    private Long isIdc;

    @Generated
    public AdminMerchantSourceDTO() {
    }

    @Generated
    public Long getId() {
        return this.id;
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public String getSourceUsername() {
        return this.sourceUsername;
    }

    @Generated
    public String getSourcePassword() {
        return this.sourcePassword;
    }

    @Generated
    public Long getIsStatic() {
        return this.isStatic;
    }

    @Generated
    public Long getIsDynamics() {
        return this.isDynamics;
    }

    @Generated
    public Long getIsIdc() {
        return this.isIdc;
    }

    @Generated
    public void setId(Long id) {
        this.id = id;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public void setSourceUsername(String sourceUsername) {
        this.sourceUsername = sourceUsername;
    }

    @Generated
    public void setSourcePassword(String sourcePassword) {
        this.sourcePassword = sourcePassword;
    }

    @Generated
    public void setIsStatic(Long isStatic) {
        this.isStatic = isStatic;
    }

    @Generated
    public void setIsDynamics(Long isDynamics) {
        this.isDynamics = isDynamics;
    }

    @Generated
    public void setIsIdc(Long isIdc) {
        this.isIdc = isIdc;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof AdminMerchantSourceDTO)) {
            return false;
        }
        AdminMerchantSourceDTO other = (AdminMerchantSourceDTO)((Object)o);
        if (!other.canEqual((Object)this)) {
            return false;
        }
        Long this$id = this.getId();
        Long other$id = other.getId();
        if (this$id == null ? other$id != null : !((Object)this$id).equals(other$id)) {
            return false;
        }
        Long this$isStatic = this.getIsStatic();
        Long other$isStatic = other.getIsStatic();
        if (this$isStatic == null ? other$isStatic != null : !((Object)this$isStatic).equals(other$isStatic)) {
            return false;
        }
        Long this$isDynamics = this.getIsDynamics();
        Long other$isDynamics = other.getIsDynamics();
        if (this$isDynamics == null ? other$isDynamics != null : !((Object)this$isDynamics).equals(other$isDynamics)) {
            return false;
        }
        Long this$isIdc = this.getIsIdc();
        Long other$isIdc = other.getIsIdc();
        if (this$isIdc == null ? other$isIdc != null : !((Object)this$isIdc).equals(other$isIdc)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        if (this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode)) {
            return false;
        }
        String this$sourceUsername = this.getSourceUsername();
        String other$sourceUsername = other.getSourceUsername();
        if (this$sourceUsername == null ? other$sourceUsername != null : !this$sourceUsername.equals(other$sourceUsername)) {
            return false;
        }
        String this$sourcePassword = this.getSourcePassword();
        String other$sourcePassword = other.getSourcePassword();
        return !(this$sourcePassword == null ? other$sourcePassword != null : !this$sourcePassword.equals(other$sourcePassword));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof AdminMerchantSourceDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $id = this.getId();
        result = result * 59 + ($id == null ? 43 : ((Object)$id).hashCode());
        Long $isStatic = this.getIsStatic();
        result = result * 59 + ($isStatic == null ? 43 : ((Object)$isStatic).hashCode());
        Long $isDynamics = this.getIsDynamics();
        result = result * 59 + ($isDynamics == null ? 43 : ((Object)$isDynamics).hashCode());
        Long $isIdc = this.getIsIdc();
        result = result * 59 + ($isIdc == null ? 43 : ((Object)$isIdc).hashCode());
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $sourceUsername = this.getSourceUsername();
        result = result * 59 + ($sourceUsername == null ? 43 : $sourceUsername.hashCode());
        String $sourcePassword = this.getSourcePassword();
        result = result * 59 + ($sourcePassword == null ? 43 : $sourcePassword.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "AdminMerchantSourceDTO(id=" + this.getId() + ", sourceCode=" + this.getSourceCode() + ", sourceUsername=" + this.getSourceUsername() + ", sourcePassword=" + this.getSourcePassword() + ", isStatic=" + this.getIsStatic() + ", isDynamics=" + this.getIsDynamics() + ", isIdc=" + this.getIsIdc() + ")";
    }
}

