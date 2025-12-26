/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.utils;

public class LogUtils {
    public static String getBlock(Object msg) {
        if (msg == null) {
            msg = "";
        }
        return "[" + msg.toString() + "]";
    }
}

