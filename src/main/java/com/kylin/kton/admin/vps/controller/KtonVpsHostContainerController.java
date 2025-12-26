/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonVpsHostContainer
 *  javax.servlet.http.HttpServletResponse
 *  javax.validation.Valid
 *  lombok.Generated
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.admin.vps.controller;

import com.kylin.kton.admin.vps.entity.vo.AddVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.QueryVpsHostContainerVO;
import com.kylin.kton.admin.vps.entity.vo.UpdateVpsStatusVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostContainerVO;
import com.kylin.kton.admin.vps.service.VpsHostContainerService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonVpsHostContainer;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.Generated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/admin/vps/container"})
public class KtonVpsHostContainerController
extends BaseController {
    private final VpsHostContainerService vpsHostContainerService;

    @PreAuthorize(value="@ss.hasPermi('system:container:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(QueryVpsHostContainerVO queryVpsHostContainerVO) {
        this.startPage();
        List<VpsHostContainerVO> list = this.vpsHostContainerService.queryVpsHostContainer(queryVpsHostContainerVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:edit')")
    @PostMapping(value={"/stop"})
    public AjaxResult stopVps(@Valid @RequestBody UpdateVpsStatusVO updateVpsStatusVO) {
        this.vpsHostContainerService.openStopVps(updateVpsStatusVO);
        return AjaxResult.success();
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:edit')")
    @PostMapping(value={"/start"})
    public AjaxResult startVps(@Valid @RequestBody UpdateVpsStatusVO updateVpsStatusVO) {
        this.vpsHostContainerService.openStopVps(updateVpsStatusVO);
        return AjaxResult.success();
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:edit')")
    @PostMapping(value={"/delete"})
    public AjaxResult deleteVps(@Valid @RequestBody UpdateVpsStatusVO updateVpsStatusVO) {
        this.vpsHostContainerService.openStopVps(updateVpsStatusVO);
        return AjaxResult.success();
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:export')")
    @Log(title="vps-\u5bb9\u5668-\u5bb9\u5668\u5b9e\u4f8b", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonVpsHostContainer ktonVpsHostContainer) {
        List list = this.vpsHostContainerService.selectKtonVpsHostContainerList(ktonVpsHostContainer);
        ExcelUtil util = new ExcelUtil(KtonVpsHostContainer.class);
        util.exportExcel(response, list, "vps-\u5bb9\u5668-\u5bb9\u5668\u5b9e\u4f8b\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.vpsHostContainerService.selectKtonVpsHostContainerById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:add')")
    @Log(title="vps-\u5bb9\u5668-\u5bb9\u5668\u5b9e\u4f8b", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AddVpsHostContainerVO addVpsHostContainerVO) {
        return this.toAjax(this.vpsHostContainerService.addHostContainer(addVpsHostContainerVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:edit')")
    @Log(title="vps-\u5bb9\u5668-\u5bb9\u5668\u5b9e\u4f8b", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonVpsHostContainer ktonVpsHostContainer) {
        return this.toAjax(this.vpsHostContainerService.updateKtonVpsHostContainer(ktonVpsHostContainer));
    }

    @PreAuthorize(value="@ss.hasPermi('system:container:remove')")
    @Log(title="vps-\u5bb9\u5668-\u5bb9\u5668\u5b9e\u4f8b", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.vpsHostContainerService.deleteKtonVpsHostContainerByIds(ids));
    }

    @Generated
    public KtonVpsHostContainerController(VpsHostContainerService vpsHostContainerService) {
        this.vpsHostContainerService = vpsHostContainerService;
    }
}

