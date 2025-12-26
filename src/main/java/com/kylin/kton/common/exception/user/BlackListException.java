/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.exception.user;

import com.kylin.kton.common.exception.user.UserException;

public class BlackListException
extends UserException {
    private static final long serialVersionUID = 1L;

    public BlackListException() {
        super("login.blocked", (Object[])null);
    }
}

