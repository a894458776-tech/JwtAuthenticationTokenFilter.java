/*
 * Decompiled with CFR 0.152.
 */
package com.kylin.kton.common.constant;

public class OrderProductNameConstants {

    public static enum PRODUCT_TYPE {
        PRO_STATIC("Static Regular"),
        PRO_DYNAMICS("Residential Proxies"),
        PRO_VPS("Virtual VPS");

        private final String alias;

        private PRODUCT_TYPE(String alias) {
            this.alias = alias;
        }

        public String getAlias() {
            return this.alias;
        }
    }
}

