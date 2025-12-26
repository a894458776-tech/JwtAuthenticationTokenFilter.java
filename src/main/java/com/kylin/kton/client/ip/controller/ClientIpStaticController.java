/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Anonymous
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.properties.LocationProperties
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPeriod
 *  com.kylin.kton.system.domain.KtonIpStaticConfigPlan
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  lombok.Generated
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.ip.controller;

import com.kylin.kton.client.ip.entity.vo.ConfDaysListVO;
import com.kylin.kton.client.ip.entity.vo.ConfNumListVO;
import com.kylin.kton.client.ip.service.ClientIpStaticConfigPeriodService;
import com.kylin.kton.client.ip.service.ClientIpStaticConfigPlanService;
import com.kylin.kton.client.ip.service.ClientIpStaticService;
import com.kylin.kton.common.annotation.Anonymous;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.properties.LocationProperties;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonIpStaticConfigPeriod;
import com.kylin.kton.system.domain.KtonIpStaticConfigPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u9759\u6001\u4f4f\u5b85IP\u914d\u7f6e"})
@RestController
@RequestMapping(value={"/client/ip/static"})
public class ClientIpStaticController
extends BaseController {
    @Autowired
    ClientIpStaticService ipStaticService;
    @Autowired
    ClientIpStaticConfigPeriodService ipStaticItemService;
    @Autowired
    ClientIpStaticConfigPlanService ipStaticItemDetailsService;
    @Autowired
    private LocationProperties locationProperties;

    @ApiOperation(value="\u9759\u6001Ip\u5929\u6570\u6298\u6263\u914d\u7f6e")
    @GetMapping(value={"/confDaysList"})
    public TableDataInfo confDaysList(ConfDaysListVO confDaysListVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        confDaysListVO.setMerchantId(merchantId);
        List<KtonIpStaticConfigPeriod> list = this.ipStaticItemService.list(confDaysListVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u9759\u6001Ip\u6570\u91cf\u7b49\u7ea7\u6298\u6263\u914d\u7f6e")
    @GetMapping(value={"/confNumList"})
    public TableDataInfo confNumList(ConfNumListVO confNumListVO) {
        this.startPage();
        List<KtonIpStaticConfigPlan> list = this.ipStaticItemDetailsService.list(confNumListVO);
        return this.getDataTable(list);
    }

    @Anonymous
    @ApiOperation(value="\u9759\u6001Ip\u5929\u6570\u6298\u6263\u914d\u7f6e(\u514d\u9274\u6743)")
    @GetMapping(value={"/confDaysListWithOutAuth"})
    public TableDataInfo confDaysListWithOutAuth(ConfDaysListVO confDaysListVO) {
        this.startPage();
        List<KtonIpStaticConfigPeriod> list = this.ipStaticItemService.listWithOutAuth(confDaysListVO);
        return this.getDataTable(list);
    }

    @Anonymous
    @ApiOperation(value="\u9759\u6001Ip\u6570\u91cf\u7b49\u7ea7\u6298\u6263\u914d\u7f6e(\u514d\u9274\u6743)")
    @GetMapping(value={"/confNumListWithOutAuth"})
    public TableDataInfo confNumListWithOutAuth(ConfNumListVO confNumListVO) {
        this.startPage();
        List<KtonIpStaticConfigPlan> list = this.ipStaticItemDetailsService.list(confNumListVO);
        return this.getDataTable(list);
    }

    @Anonymous
    @ApiOperation(value="\u56fd\u5bb6\u914d\u7f6e")
    @GetMapping(value={"/continentConfig"})
    public AjaxResult continentConfig() {
        return AjaxResult.success((Object)this.locationProperties.getContinents());
    }

    @Generated
    public ClientIpStaticController() {
    }
}

