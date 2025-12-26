/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  lombok.Generated
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.api.controller;

import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u5f00\u653e\u5e73\u53f0-simple\u793a\u4f8b"})
@RestController
@RequestMapping(value={"/simple"})
@OpenPlatform
public class SimpleController
extends BaseController {
    @ApiOperation(value="\u5f00\u653e\u5e73\u53f0\u6587\u6863\u793a\u4f8b\u63a5\u53e3")
    @GetMapping(value={"/check"})
    public AjaxResult check() {
        return this.success("\u9a8c\u8bc1\u6210\u529f\uff0c\u6b22\u8fce\u4f7f\u7528IPKingStar api\uff0c");
    }

    @Generated
    public SimpleController() {
    }
}

