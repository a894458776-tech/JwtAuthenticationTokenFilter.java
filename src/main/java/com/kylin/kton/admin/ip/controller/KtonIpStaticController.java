/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.properties.LocationProperties
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonIpStatic
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
 *  javax.servlet.http.HttpServletResponse
 *  javax.validation.Valid
 *  lombok.Generated
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
 */
package com.kylin.kton.admin.ip.controller;

import com.kylin.kton.admin.ip.entity.vo.S5TestVO;
import com.kylin.kton.admin.ip.service.IpStaticService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.properties.LocationProperties;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStatic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import lombok.Generated;
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

@Api(tags={"\u7ba1\u7406\u7aef-\u9759\u6001IP\u7c7b\u578b\u914d\u7f6e"})
@RestController
@RequestMapping(value={"/admin/ip/static"})
public class KtonIpStaticController
extends BaseController {
    private final IpStaticService ipStaticService;
    @Autowired
    private LocationProperties locationProperties;

    @ApiOperation(value="\u5217\u8868")
    @PreAuthorize(value="@ss.hasPermi('system:static:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpStatic ktonIpStatic) {
        this.startPage();
        List list = this.ipStaticService.selectKtonIpStaticList(ktonIpStatic);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u56fd\u5bb6\u914d\u7f6e")
    @GetMapping(value={"/continentConfig"})
    public AjaxResult continentConfig() {
        return AjaxResult.success((Object)this.locationProperties.getContinents());
    }

    @PreAuthorize(value="@ss.hasPermi('system:static:export')")
    @Log(title="\u9759\u6001IP", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStatic ktonIpStatic) {
        List list = this.ipStaticService.selectKtonIpStaticList(ktonIpStatic);
        ExcelUtil util = new ExcelUtil(KtonIpStatic.class);
        util.exportExcel(response, list, "\u9759\u6001IP\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:static:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ipStaticService.selectKtonIpStaticById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:static:add')")
    @Log(title="\u9759\u6001IP", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStatic ktonIpStatic) {
        return this.toAjax(this.ipStaticService.insertKtonIpStatic(ktonIpStatic));
    }

    @PreAuthorize(value="@ss.hasPermi('system:static:edit')")
    @Log(title="\u9759\u6001IP", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStatic ktonIpStatic) {
        return this.toAjax(this.ipStaticService.updateKtonIpStatic(ktonIpStatic));
    }

    @PreAuthorize(value="@ss.hasPermi('system:static:remove')")
    @Log(title="\u9759\u6001IP", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ipStaticService.deleteKtonIpStaticByIds(ids));
    }

    @GetMapping(value={"/commonUrls"})
    public AjaxResult getCommonTestUrls() {
        return this.success(this.ipStaticService.getCommonTestUrls());
    }

    @ApiOperation(value="\u6d4b\u8bd5S5\u4ee3\u7406\u8bbf\u95ee\u6307\u5b9aURL")
    @PostMapping(value={"/testS5UrlAccess"})
    public AjaxResult testS5UrlAccess(@Valid @RequestBody S5TestVO s5TestVO) {
        try {
            return AjaxResult.success((String)"\u6d4b\u8bd5\u5b8c\u6210", this.ipStaticService.testS5UrlAccess(s5TestVO.getS5Ip(), s5TestVO.getTestUrl(), s5TestVO.getTimeout()));
        }
        catch (Exception e) {
            return AjaxResult.error((String)e.getMessage());
        }
    }

    @Generated
    public KtonIpStaticController(IpStaticService ipStaticService) {
        this.ipStaticService = ipStaticService;
    }
}

