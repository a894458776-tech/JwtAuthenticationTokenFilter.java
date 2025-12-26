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
 *  com.kylin.kton.system.domain.KtonIpStaticSource
 *  javax.servlet.http.HttpServletResponse
 *  javax.validation.Valid
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.security.access.prepost.PreAuthorize
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 *  org.springframework.web.multipart.MultipartFile
 */
package com.kylin.kton.admin.ip.controller;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticSourceDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminAddByIpPatternVO;
import com.kylin.kton.admin.ip.entity.vo.AdminImportIpSourceVO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticSourceSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminPutOffIpSourceVO;
import com.kylin.kton.admin.ip.entity.vo.AdminWithOutPoolSearchVO;
import com.kylin.kton.admin.ip.entity.vo.PutOnIpSourceVO;
import com.kylin.kton.admin.ip.service.IpStaticSourceService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticSource;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping(value={"/admin/ip/static/source"})
public class KtonIpStaticSourceController
extends BaseController {
    @Autowired
    private IpStaticSourceService ktonIpStaticSourceService;

    @PreAuthorize(value="@ss.hasPermi('system:source:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminIpStaticSourceSearchVO searchVO) {
        this.startPage();
        List<AdminIpStaticSourceDTO> list = this.ktonIpStaticSourceService.list(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:list')")
    @GetMapping(value={"/withOutPoolList"})
    public TableDataInfo withOutPoolList(AdminWithOutPoolSearchVO searchVO) {
        this.startPage();
        List<AdminIpStaticSourceDTO> list = this.ktonIpStaticSourceService.withOutPoolList(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:export')")
    @Log(title="\u9759\u6001IP\uff1aIP\u6e90", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticSource ktonIpStaticSource) {
        List list = this.ktonIpStaticSourceService.selectKtonIpStaticSourceList(ktonIpStaticSource);
        ExcelUtil util = new ExcelUtil(KtonIpStaticSource.class);
        util.exportExcel(response, list, "\u9759\u6001IP\uff1aIP\u6e90\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpStaticSourceService.selectKtonIpStaticSourceById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:add')")
    @Log(title="\u9759\u6001IP\uff1aIP\u6e90", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticSource ktonIpStaticSource) {
        return this.toAjax(this.ktonIpStaticSourceService.insertKtonIpStaticSource(ktonIpStaticSource));
    }

    @PostMapping(value={"/addByIpPattern"})
    public AjaxResult addByIpPattern(@RequestBody AdminAddByIpPatternVO adminAddByIpPatternVO) {
        return this.toAjax(this.ktonIpStaticSourceService.addByIpPattern(adminAddByIpPatternVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:edit')")
    @Log(title="\u9759\u6001IP\uff1aIP\u6e90", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticSource ktonIpStaticSource) {
        return this.toAjax(this.ktonIpStaticSourceService.updateKtonIpStaticSource(ktonIpStaticSource));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:remove')")
    @Log(title="\u9759\u6001IP\uff1aIP\u6e90", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpStaticSourceService.deleteKtonIpStaticSourceByIds(ids));
    }

    @PostMapping(value={"/importIpSource"})
    public AjaxResult importIpSource(@RequestBody AdminImportIpSourceVO importIpSourceVO) {
        Integer res = this.ktonIpStaticSourceService.importIpSource(importIpSourceVO);
        return AjaxResult.success((Object)res);
    }

    @PostMapping(value={"/putOnIpSource"})
    public AjaxResult putOnIpSource(@RequestBody PutOnIpSourceVO putOnIpSourceVO) {
        int res = this.ktonIpStaticSourceService.putOnIpSource(putOnIpSourceVO);
        return AjaxResult.success((String)("\u5df2\u6210\u529f\u4e0a\u67b6" + res + "\u6761"));
    }

    @PostMapping(value={"/putOffIpSource"})
    public AjaxResult putOffIpSource(@RequestBody @Valid AdminPutOffIpSourceVO putOffIpSourceVO) {
        this.ktonIpStaticSourceService.putOffIpSource(putOffIpSourceVO);
        return AjaxResult.success();
    }

    @PostMapping(value={"/importIpExcel"})
    public AjaxResult importIpExcel(MultipartFile file) {
        return this.ktonIpStaticSourceService.importIpExcel(file);
    }
}

