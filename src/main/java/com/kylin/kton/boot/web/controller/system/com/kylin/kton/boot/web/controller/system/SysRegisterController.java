/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.domain.model.RegisterBody
 *  com.kylin.kton.common.utils.StringUtils
 *  com.kylin.kton.framework.web.service.SysRegisterService
 *  com.kylin.kton.system.service.ISysConfigService
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.boot.web.controller.system.com.kylin.kton.boot.web.controller.system;

import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.domain.model.RegisterBody;
import com.kylin.kton.common.utils.StringUtils;
import com.kylin.kton.framework.web.service.SysRegisterService;
import com.kylin.kton.system.service.ISysConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SysRegisterController
extends BaseController {
    @Autowired
    private SysRegisterService registerService;
    @Autowired
    private ISysConfigService configService;

    @PostMapping(value={"/register"})
    public AjaxResult register(@RequestBody RegisterBody user) {
        if (!"true".equals(this.configService.selectConfigByKey("sys.account.registerUser"))) {
            return this.error("\u5f53\u524d\u7cfb\u7edf\u6ca1\u6709\u5f00\u542f\u6ce8\u518c\u529f\u80fd\uff01");
        }
        String msg = this.registerService.register(user);
        return StringUtils.isEmpty((String)msg) ? this.success() : this.error(msg);
    }
}
