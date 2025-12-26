/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.boot.builder.SpringApplicationBuilder
 *  org.springframework.boot.web.servlet.support.SpringBootServletInitializer
 */
package com.kylin.kton.boot;

import com.kylin.kton.boot.KylinKtonApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class KylinKtonServletInitializer
extends SpringBootServletInitializer {
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(new Class[]{KylinKtonApplication.class});
    }
}
