/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  lombok.Generated
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.ip.controller;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolDTO;
import com.kylin.kton.client.ip.entity.dto.RegionalAvailableIpsDTO;
import com.kylin.kton.client.ip.entity.vo.ClientRegionalAvailableIpsVO;
import com.kylin.kton.client.ip.entity.vo.StaticPoolSearchVO;
import com.kylin.kton.client.ip.service.ClientIpStaticPoolService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u9759\u6001\u4f4f\u5b85IP\u6c60"})
@RestController
@RequestMapping(value={"/client/ip/pool"})
@OpenPlatform
public class ClientKtonIpStaticPoolController
extends BaseController {
    private final ClientIpStaticPoolService ipStaticPoolService;

    @ApiOperation(value="\u67e5\u8be2\u9759\u6001IP-IP\u6c60\u5217\u8868")
    @GetMapping(value={"/list"})
    public TableDataInfo list(StaticPoolSearchVO searchVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<ClientIpStaticPoolDTO> list = this.ipStaticPoolService.list(searchVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u67e5\u8be2\u9759\u6001IP-\u53ef\u7528IP\u5217\u8868(\u652f\u6301\u591a\u9009)")
    @GetMapping(value={"/regionalAvailableIps"})
    public TableDataInfo regionalAvailableIps(ClientRegionalAvailableIpsVO availableIpsVO) {
        Long merchantId = SecurityUtils.getUserId();
        availableIpsVO.setMerchantId(merchantId);
        List<RegionalAvailableIpsDTO> list = this.ipStaticPoolService.regionalAvailableIps(availableIpsVO);
        return this.getDataTable(list);
    }

    @Generated
    public ClientKtonIpStaticPoolController(ClientIpStaticPoolService ipStaticPoolService) {
        this.ipStaticPoolService = ipStaticPoolService;
    }
}

