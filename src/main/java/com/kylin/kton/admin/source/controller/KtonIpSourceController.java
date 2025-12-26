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
 *  com.kylin.kton.system.domain.KtonSource
 *  javax.servlet.http.HttpServletResponse
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
package com.kylin.kton.admin.source.controller;

import com.kylin.kton.admin.ip.entity.vo.AdminWithOutMerchantlistSearchVO;
import com.kylin.kton.admin.source.service.IpSourceService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonSource;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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

@RestController
@RequestMapping(value={"/admin/ip/source"})
public class KtonIpSourceController
extends BaseController {
    @Autowired
    private IpSourceService ktonIpSourceService;

    @PreAuthorize(value="@ss.hasPermi('system:source:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonSource ktonIpSource) {
        this.startPage();
        List list = this.ktonIpSourceService.selectKtonSourceList(ktonIpSource);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:list')")
    @GetMapping(value={"/withOutMerchantlist"})
    public TableDataInfo withOutMerchantlist(AdminWithOutMerchantlistSearchVO searchVO) {
        this.startPage();
        List<KtonSource> list = this.ktonIpSourceService.withOutMerchantlist(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:export')")
    @Log(title="IP\u6e90\uff08\u6765\u6e90\u914d\u7f6e\uff09", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonSource ktonIpSource) {
        List list = this.ktonIpSourceService.selectKtonSourceList(ktonIpSource);
        ExcelUtil util = new ExcelUtil(KtonSource.class);
        util.exportExcel(response, list, "IP\u6e90\uff08\u6765\u6e90\u914d\u7f6e\uff09\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpSourceService.selectKtonSourceById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:add')")
    @Log(title="IP\u6e90\uff08\u6765\u6e90\u914d\u7f6e\uff09", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonSource ktonIpSource) {
        return this.toAjax(this.ktonIpSourceService.insertKtonSource(ktonIpSource));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:edit')")
    @Log(title="IP\u6e90\uff08\u6765\u6e90\u914d\u7f6e\uff09", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonSource ktonIpSource) {
        return this.toAjax(this.ktonIpSourceService.updateKtonSource(ktonIpSource));
    }

    @PreAuthorize(value="@ss.hasPermi('system:source:remove')")
    @Log(title="IP\u6e90\uff08\u6765\u6e90\u914d\u7f6e\uff09", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpSourceService.deleteKtonSourceByIds(ids));
    }
}

