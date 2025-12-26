/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Anonymous
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.openapi.controller;

import com.kylin.kton.common.annotation.Anonymous;
import com.kylin.kton.common.core.domain.AjaxResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Anonymous
@RestController
@RequestMapping(value={"/test/openapi"})
public class OpenapiTestController {
    @RequestMapping(value={"/index"})
    public AjaxResult index() {
        return AjaxResult.success();
    }
}

