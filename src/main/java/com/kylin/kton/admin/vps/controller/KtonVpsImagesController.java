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
 *  com.kylin.kton.system.domain.KtonVpsImages
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
package com.kylin.kton.admin.vps.controller;

import com.kylin.kton.admin.vps.entity.vo.MerchantImagesListSearchVO;
import com.kylin.kton.admin.vps.service.VpsImagesService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonVpsImages;
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
@RequestMapping(value={"/admin/vps/images"})
public class KtonVpsImagesController
extends BaseController {
    @Autowired
    private VpsImagesService ktonVpsImagesService;

    @PreAuthorize(value="@ss.hasPermi('system:images:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonVpsImages ktonVpsImages) {
        this.startPage();
        List list = this.ktonVpsImagesService.selectKtonVpsImagesList(ktonVpsImages);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:images:export')")
    @Log(title="vps-\u955c\u50cf", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonVpsImages ktonVpsImages) {
        List list = this.ktonVpsImagesService.selectKtonVpsImagesList(ktonVpsImages);
        ExcelUtil util = new ExcelUtil(KtonVpsImages.class);
        util.exportExcel(response, list, "vps-\u955c\u50cf\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:images:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonVpsImagesService.selectKtonVpsImagesById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:images:add')")
    @Log(title="vps-\u955c\u50cf", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonVpsImages ktonVpsImages) {
        return this.toAjax(this.ktonVpsImagesService.add(ktonVpsImages));
    }

    @PreAuthorize(value="@ss.hasPermi('system:images:edit')")
    @Log(title="vps-\u955c\u50cf", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonVpsImages ktonVpsImages) {
        return this.toAjax(this.ktonVpsImagesService.updateKtonVpsImages(ktonVpsImages));
    }

    @PreAuthorize(value="@ss.hasPermi('system:images:remove')")
    @Log(title="vps-\u955c\u50cf", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonVpsImagesService.deleteKtonVpsImagesByIds(ids));
    }

    @GetMapping(value={"/merchantImagesList"})
    public TableDataInfo merchantImagesList(MerchantImagesListSearchVO searchVO) {
        return this.getDataTable(this.ktonVpsImagesService.merchantImagesList(searchVO));
    }
}

