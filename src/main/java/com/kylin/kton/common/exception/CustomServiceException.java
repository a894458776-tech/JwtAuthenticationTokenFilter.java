/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.exception;

import com.kylin.kton.common.constant.GlobalErrorCode;

public class CustomServiceException
extends RuntimeException {
    private final int errorCode;

    public CustomServiceException(String message) {
        super(message);
        this.errorCode = GlobalErrorCode.SERVICE_EXCEPTION.getCode();
    }

    public CustomServiceException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public CustomServiceException(GlobalErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode.getCode();
    }

    public int getErrorCode() {
        return this.errorCode;
    }
}

