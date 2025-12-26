/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Anonymous
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  lombok.Generated
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.ip.controller;

import com.kylin.kton.client.ip.entity.dto.DynamicPlanConfigDTO;
import com.kylin.kton.client.ip.entity.vo.DynamicsConfListVO;
import com.kylin.kton.client.ip.entity.vo.DynamicsDaysConfigVO;
import com.kylin.kton.client.ip.service.ClientIpDynamicService;
import com.kylin.kton.common.annotation.Anonymous;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsConfigPeriod;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u5546\u6237\u7aef-\u52a8\u6001IP"})
@RestController
@RequestMapping(value={"/client/ip/dynamics"})
public class ClientIpDynamicsController
extends BaseController {
    private final ClientIpDynamicService ipDynamicService;

    @ApiOperation(value="\u4ef7\u683c\u8ba1\u5212\u914d\u7f6e")
    @GetMapping(value={"/planConfig"})
    @OpenPlatform
    public TableDataInfo planConfig(DynamicsConfListVO confListVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        confListVO.setMerchantId(merchantId);
        List<DynamicPlanConfigDTO> list = this.ipDynamicService.planConfig(confListVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5929\u6570\u914d\u7f6e")
    @GetMapping(value={"/dayConfig"})
    public TableDataInfo dayConfig(DynamicsDaysConfigVO daysConfigVO) {
        this.startPage();
        List<KtonIpDynamicsConfigPeriod> list = this.ipDynamicService.dayConfig(daysConfigVO);
        return this.getDataTable(list);
    }

    @Anonymous
    @ApiOperation(value="\u4ef7\u683c\u8ba1\u5212\u914d\u7f6e(\u514d\u9274\u6743)")
    @GetMapping(value={"/planConfigWithOutAuth"})
    public TableDataInfo planConfigWithAuth(DynamicsConfListVO confListVO) {
        this.startPage();
        List<DynamicPlanConfigDTO> list = this.ipDynamicService.planConfigWithOutAuth(confListVO);
        return this.getDataTable(list);
    }

    @Anonymous
    @ApiOperation(value="\u5929\u6570\u914d\u7f6e(\u514d\u9274\u6743)")
    @GetMapping(value={"/dayConfigWithOutAuth"})
    public TableDataInfo dayConfigWithAuth(DynamicsDaysConfigVO daysConfigVO) {
        this.startPage();
        List<KtonIpDynamicsConfigPeriod> list = this.ipDynamicService.dayConfig(daysConfigVO);
        return this.getDataTable(list);
    }

    @Generated
    public ClientIpDynamicsController(ClientIpDynamicService ipDynamicService) {
        this.ipDynamicService = ipDynamicService;
    }
}

