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
 *  com.kylin.kton.system.domain.KtonVpsIpPool
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

import com.kylin.kton.admin.vps.entity.vo.VpsIpPoolAddVO;
import com.kylin.kton.admin.vps.service.VpsIpPoolService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonVpsIpPool;
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
@RequestMapping(value={"/admin/vps/ip/pool"})
public class KtonVpsIpPoolController
extends BaseController {
    @Autowired
    private VpsIpPoolService ktonVpsIpPoolService;

    @PreAuthorize(value="@ss.hasPermi('system:pool:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonVpsIpPool ktonVpsIpPool) {
        this.startPage();
        List list = this.ktonVpsIpPoolService.selectKtonVpsIpPoolList(ktonVpsIpPool);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:pool:export')")
    @Log(title="vps-\u9759\u6001ip\u6c60", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonVpsIpPool ktonVpsIpPool) {
        List list = this.ktonVpsIpPoolService.selectKtonVpsIpPoolList(ktonVpsIpPool);
        ExcelUtil util = new ExcelUtil(KtonVpsIpPool.class);
        util.exportExcel(response, list, "vps-\u9759\u6001ip\u6c60\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:pool:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonVpsIpPoolService.selectKtonVpsIpPoolById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:pool:add')")
    @Log(title="vps-\u9759\u6001ip\u6c60", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody VpsIpPoolAddVO addVO) {
        return this.toAjax(this.ktonVpsIpPoolService.add(addVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:pool:edit')")
    @Log(title="vps-\u9759\u6001ip\u6c60", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonVpsIpPool ktonVpsIpPool) {
        return this.toAjax(this.ktonVpsIpPoolService.updateKtonVpsIpPool(ktonVpsIpPool));
    }

    @PreAuthorize(value="@ss.hasPermi('system:pool:remove')")
    @Log(title="vps-\u9759\u6001ip\u6c60", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonVpsIpPoolService.deleteKtonVpsIpPoolByIds(ids));
    }
}

