/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  lombok.Generated
 */
package com.kylin.kton.admin.account.entity.dto;

import lombok.Generated;

public class SubUserAccountResDTO {
    private String channelLabel;
    private Long accountId;
    private String sourceCode;
    private String sourceName;
    private String account;
    private String password;
    private String poolType;
    private String email;

    @Generated
    public SubUserAccountResDTO() {
    }

    @Generated
    public String getChannelLabel() {
        return this.channelLabel;
    }

    @Generated
    public Long getAccountId() {
        return this.accountId;
    }

    @Generated
    public String getSourceCode() {
        return this.sourceCode;
    }

    @Generated
    public String getSourceName() {
        return this.sourceName;
    }

    @Generated
    public String getAccount() {
        return this.account;
    }

    @Generated
    public String getPassword() {
        return this.password;
    }

    @Generated
    public String getPoolType() {
        return this.poolType;
    }

    @Generated
    public String getEmail() {
        return this.email;
    }

    @Generated
    public void setChannelLabel(String channelLabel) {
        this.channelLabel = channelLabel;
    }

    @Generated
    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    @Generated
    public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Generated
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Generated
    public void setAccount(String account) {
        this.account = account;
    }

    @Generated
    public void setPassword(String password) {
        this.password = password;
    }

    @Generated
    public void setPoolType(String poolType) {
        this.poolType = poolType;
    }

    @Generated
    public void setEmail(String email) {
        this.email = email;
    }

    @Generated
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof SubUserAccountResDTO)) {
            return false;
        }
        SubUserAccountResDTO other = (SubUserAccountResDTO)o;
        if (!other.canEqual(this)) {
            return false;
        }
        Long this$accountId = this.getAccountId();
        Long other$accountId = other.getAccountId();
        if (this$accountId == null ? other$accountId != null : !((Object)this$accountId).equals(other$accountId)) {
            return false;
        }
        String this$channelLabel = this.getChannelLabel();
        String other$channelLabel = other.getChannelLabel();
        if (this$channelLabel == null ? other$channelLabel != null : !this$channelLabel.equals(other$channelLabel)) {
            return false;
        }
        String this$sourceCode = this.getSourceCode();
        String other$sourceCode = other.getSourceCode();
        if (this$sourceCode == null ? other$sourceCode != null : !this$sourceCode.equals(other$sourceCode)) {
            return false;
        }
        String this$sourceName = this.getSourceName();
        String other$sourceName = other.getSourceName();
        if (this$sourceName == null ? other$sourceName != null : !this$sourceName.equals(other$sourceName)) {
            return false;
        }
        String this$account = this.getAccount();
        String other$account = other.getAccount();
        if (this$account == null ? other$account != null : !this$account.equals(other$account)) {
            return false;
        }
        String this$password = this.getPassword();
        String other$password = other.getPassword();
        if (this$password == null ? other$password != null : !this$password.equals(other$password)) {
            return false;
        }
        String this$poolType = this.getPoolType();
        String other$poolType = other.getPoolType();
        if (this$poolType == null ? other$poolType != null : !this$poolType.equals(other$poolType)) {
            return false;
        }
        String this$email = this.getEmail();
        String other$email = other.getEmail();
        return !(this$email == null ? other$email != null : !this$email.equals(other$email));
    }

    @Generated
    protected boolean canEqual(Object other) {
        return other instanceof SubUserAccountResDTO;
    }

    @Generated
    public int hashCode() {
        int PRIME = 59;
        int result = 1;
        Long $accountId = this.getAccountId();
        result = result * 59 + ($accountId == null ? 43 : ((Object)$accountId).hashCode());
        String $channelLabel = this.getChannelLabel();
        result = result * 59 + ($channelLabel == null ? 43 : $channelLabel.hashCode());
        String $sourceCode = this.getSourceCode();
        result = result * 59 + ($sourceCode == null ? 43 : $sourceCode.hashCode());
        String $sourceName = this.getSourceName();
        result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
        String $account = this.getAccount();
        result = result * 59 + ($account == null ? 43 : $account.hashCode());
        String $password = this.getPassword();
        result = result * 59 + ($password == null ? 43 : $password.hashCode());
        String $poolType = this.getPoolType();
        result = result * 59 + ($poolType == null ? 43 : $poolType.hashCode());
        String $email = this.getEmail();
        result = result * 59 + ($email == null ? 43 : $email.hashCode());
        return result;
    }

    @Generated
    public String toString() {
        return "SubUserAccountResDTO(channelLabel=" + this.getChannelLabel() + ", accountId=" + this.getAccountId() + ", sourceCode=" + this.getSourceCode() + ", sourceName=" + this.getSourceName() + ", account=" + this.getAccount() + ", password=" + this.getPassword() + ", poolType=" + this.getPoolType() + ", email=" + this.getEmail() + ")";
    }
}

