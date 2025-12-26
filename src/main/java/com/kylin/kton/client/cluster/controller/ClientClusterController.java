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
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.cluster.controller;

import com.kylin.kton.client.cluster.entity.vo.ClusterHostListSearchVO;
import com.kylin.kton.client.cluster.entity.vo.ClusterListSearchVO;
import com.kylin.kton.client.cluster.entity.vo.TemplateDetailVO;
import com.kylin.kton.client.cluster.entity.vo.TemplateListSearchVO;
import com.kylin.kton.client.cluster.service.ClientClusterService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import javax.validation.Valid;
import lombok.Generated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/cluster"})
@OpenPlatform
public class ClientClusterController
extends BaseController {
    private final ClientClusterService clientClusterService;

    @GetMapping(value={"/clusterList"})
    public TableDataInfo clusterList(ClusterListSearchVO searchVO) {
        return this.getDataTable(this.clientClusterService.clusterList(searchVO));
    }

    @GetMapping(value={"/templateList"})
    public TableDataInfo templateList(@Valid TemplateListSearchVO searchVO) {
        return this.getDataTable(this.clientClusterService.templateList(searchVO));
    }

    @GetMapping(value={"/templateDetail"})
    public AjaxResult templateDetail(@Valid TemplateDetailVO detailVO) {
        return AjaxResult.success((Object)this.clientClusterService.templateDetail(detailVO));
    }

    @GetMapping(value={"/clusterHostList"})
    public TableDataInfo clusterHostList(ClusterHostListSearchVO searchVO) {
        return this.getDataTable(this.clientClusterService.clusterHostList(searchVO));
    }

    @Generated
    public ClientClusterController(ClientClusterService clientClusterService) {
        this.clientClusterService = clientClusterService;
    }
}

