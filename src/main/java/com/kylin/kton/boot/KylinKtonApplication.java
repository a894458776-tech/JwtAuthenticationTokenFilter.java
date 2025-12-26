/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.springframework.boot.SpringApplication
 *  org.springframework.boot.autoconfigure.SpringBootApplication
 *  org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
 *  org.springframework.context.ConfigurableApplicationContext
 *  org.springframework.scheduling.annotation.EnableAsync
 *  org.springframework.scheduling.annotation.EnableScheduling
 */
package com.kylin.kton.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages={"com.kylin.kton"}, exclude={DataSourceAutoConfiguration.class})
@EnableAsync
@EnableScheduling
public class KylinKtonApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(KylinKtonApplication.class, (String[])args);
        String port = context.getEnvironment().getProperty("server.port");
        System.out.println("\u5e94\u7528\u542f\u52a8\u6210\u529f\uff0c\u8bbf\u95ee\u7aef\u53e3\uff1a" + (port == null ? "8080" : port));
        System.out.println("(\u2665\u25e0\u203f\u25e0)\uff89\uff9e  IPKingStar running   \u10da(\u00b4\u06a1`\u10da)\uff9e  \n           _           _       \n  __ _  __| |_ __ ___ (_)_ __  \n / _` |/ _` | '_ ` _ \\| | '_ \\ \n| (_| | (_| | | | | | | | | | |\n \\__,_|\\__,_|_| |_| |_|_|_| |_|");
    }
}
