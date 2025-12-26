/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.constant;

public enum GlobalErrorCode {
    BAD_REQUEST_PARAM(1000, "Invalid request parameters, please check your input"),
    MISSING_PATH_VARIABLE(1001, "Required path variable is missing"),
    METHOD_ARGUMENT_TYPE_MISMATCH(1002, "Request parameter type mismatch"),
    HTTP_MESSAGE_NOT_READABLE(1003, "Invalid request body, please check your request"),
    INTERNAL_SERVER_ERROR(2000, "Internal server error, please try again later"),
    NULL_POINTER_EXCEPTION(2001, "Internal server error, please try again later"),
    RUNTIME_EXCEPTION(2002, "Internal server error, please try again later"),
    DATABASE_EXCEPTION(2003, "Database operation failed, please try again later"),
    UNKNOWN_EXCEPTION(2004, "Unknown error occurred, please try again later"),
    SERVICE_EXCEPTION(3000, "Business processing exception"),
    ACCESS_DENIED(4000, "Permission denied, please contact administrator"),
    RESOURCE_NOT_FOUND(5000, "API endpoint not found"),
    METHOD_NOT_SUPPORTED(6000, "Request method not supported"),
    VALIDATION_FAILED(7000, "Parameter validation failed"),
    DEMO_MODE_FORBIDDEN(8000, "Demo mode does not allow this operation");

    private final int code;
    private final String message;

    private GlobalErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}

