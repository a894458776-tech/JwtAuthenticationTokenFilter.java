/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.exception.user;

import com.kylin.kton.common.exception.user.UserException;

public class UserPasswordRetryLimitExceedException
extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount, int lockTime) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount, lockTime});
    }
}

