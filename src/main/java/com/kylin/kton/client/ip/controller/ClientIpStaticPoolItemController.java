/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  io.swagger.annotations.Api
 *  lombok.Generated
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.ip.controller;

import com.kylin.kton.client.ip.entity.dto.ClientIpStaticPoolMerchantDTO;
import com.kylin.kton.client.ip.entity.vo.IpStaticPoolItemSearchVO;
import com.kylin.kton.client.ip.service.ClientIpStaticPoolItemService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import java.util.List;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"\u5ba2\u6237\u7aef-\u5546\u6237\u8d2d\u4e70IP\u6c60\u660e\u7ec6"})
@RestController
@RequestMapping(value={"/client/ip/pool/item"})
public class ClientIpStaticPoolItemController
extends BaseController {
    private final ClientIpStaticPoolItemService ipStaticPoolItemService;

    @GetMapping(value={"/merchantIpList"})
    @OpenPlatform
    public TableDataInfo merchantIpList(IpStaticPoolItemSearchVO searchVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<ClientIpStaticPoolMerchantDTO> list = this.ipStaticPoolItemService.merchantIpList(searchVO);
        return this.getDataTable(list);
    }

    @Generated
    public ClientIpStaticPoolItemController(ClientIpStaticPoolItemService ipStaticPoolItemService) {
        this.ipStaticPoolItemService = ipStaticPoolItemService;
    }
}

