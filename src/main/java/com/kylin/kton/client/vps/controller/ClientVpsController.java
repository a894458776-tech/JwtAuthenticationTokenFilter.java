/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  javax.validation.Valid
 *  lombok.Generated
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.vps.controller;

import com.kylin.kton.client.vps.entity.vo.ClientImagesSearchVO;
import com.kylin.kton.client.vps.entity.vo.ContaineDetailVO;
import com.kylin.kton.client.vps.entity.vo.ContainerParamListSearchVO;
import com.kylin.kton.client.vps.entity.vo.HostListSearchVO;
import com.kylin.kton.client.vps.entity.vo.PerformanceListSearchVO;
import com.kylin.kton.client.vps.entity.vo.QueryVpsContainer;
import com.kylin.kton.client.vps.entity.vo.UpdateStatusVO;
import com.kylin.kton.client.vps.service.ClientVpsService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import javax.validation.Valid;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/vps"})
@OpenPlatform
public class ClientVpsController
extends BaseController {
    private final ClientVpsService clientVpsService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(QueryVpsContainer queryVpsContainer) {
        return this.getDataTable(this.clientVpsService.query(queryVpsContainer));
    }

    @GetMapping(value={"/containerDetail"})
    public AjaxResult containerDetail(ContaineDetailVO containeDetailVO) {
        return AjaxResult.success((Object)this.clientVpsService.containerDetail(containeDetailVO.getContainerId()));
    }

    @PostMapping(value={"/stop"})
    public AjaxResult stop(@Valid @RequestBody UpdateStatusVO updateStatusVO) {
        this.clientVpsService.openStopVps(updateStatusVO);
        return AjaxResult.success();
    }

    @PostMapping(value={"/start"})
    public AjaxResult start(@Valid @RequestBody UpdateStatusVO updateStatusVO) {
        this.clientVpsService.openStopVps(updateStatusVO);
        return AjaxResult.success();
    }

    @GetMapping(value={"/hostList"})
    public TableDataInfo hostList(HostListSearchVO searchVO) {
        return this.getDataTable(this.clientVpsService.hostList(searchVO));
    }

    @GetMapping(value={"/performanceList"})
    public TableDataInfo performanceList(PerformanceListSearchVO searchVO) {
        return this.getDataTable(this.clientVpsService.performanceList(searchVO));
    }

    @GetMapping(value={"/containerParamList"})
    public TableDataInfo containerParamList(ContainerParamListSearchVO searchVO) {
        return this.getDataTable(this.clientVpsService.containerParamList(searchVO));
    }

    @GetMapping(value={"/imagesList"})
    public TableDataInfo imagesList(ClientImagesSearchVO searchVO) {
        return this.getDataTable(this.clientVpsService.imagesList(searchVO));
    }

    @Generated
    public ClientVpsController(ClientVpsService clientVpsService) {
        this.clientVpsService = clientVpsService;
    }
}

