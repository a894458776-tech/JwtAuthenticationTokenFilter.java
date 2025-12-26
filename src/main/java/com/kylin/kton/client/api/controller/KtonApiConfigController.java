/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.common.utils.sign.Md5Utils
 *  com.kylin.kton.system.domain.KtonApiConfig
 *  com.kylin.kton.system.service.IKtonApiConfigService
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  lombok.Generated
 *  org.springframework.beans.BeanUtils
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.api.controller;

import com.kylin.kton.client.api.entity.ApiConfigDvo;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.sign.Md5Utils;
import com.kylin.kton.system.domain.KtonApiConfig;
import com.kylin.kton.system.service.IKtonApiConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.UUID;
import lombok.Generated;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u5f00\u653e\u5e73\u53f0\u6a21\u5757"})
@RestController
@RequestMapping(value={"/system/apiconfig"})
public class KtonApiConfigController
extends BaseController {
    @Autowired
    private IKtonApiConfigService ktonApiConfigService;

    @ApiOperation(value="\u83b7\u53d6API\u63a5\u53e3\u914d\u7f6e\u8be6\u7ec6\u4fe1\u606f")
    @GetMapping(value={"/detail"})
    public AjaxResult getInfo() {
        Long userId = SecurityUtils.getUserId();
        KtonApiConfig config = this.ktonApiConfigService.selectKtonApiConfigByUserId(userId);
        if (config == null) {
            return this.success(null);
        }
        ApiConfigDvo vo = new ApiConfigDvo();
        BeanUtils.copyProperties((Object)config, (Object)vo);
        return this.success(vo);
    }

    @ApiOperation(value="\u91cd\u7f6eAPI\u63a5\u53e3\u914d\u7f6e")
    @GetMapping(value={"/reset"})
    public AjaxResult reset() {
        boolean result;
        Long userId = SecurityUtils.getUserId();
        KtonApiConfig ktonApiConfig = new KtonApiConfig();
        ktonApiConfig.setUserId(userId);
        String code = Md5Utils.hash((String)(userId + UUID.randomUUID().toString()));
        String token = Md5Utils.hash((String)(userId + UUID.randomUUID().toString()));
        ktonApiConfig.setMerchantCode(code);
        ktonApiConfig.setMerchantToken(token);
        boolean bl = result = this.ktonApiConfigService.insertOrUpdateKtonApiConfig(ktonApiConfig) > 0;
        if (result) {
            ApiConfigDvo vo = new ApiConfigDvo();
            BeanUtils.copyProperties((Object)ktonApiConfig, (Object)vo);
            return this.success(vo);
        }
        return this.error("\u64cd\u4f5c\u5931\u8d25");
    }

    @Generated
    public KtonApiConfigController() {
    }
}

