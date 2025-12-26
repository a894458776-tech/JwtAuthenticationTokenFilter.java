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
 *  com.kylin.kton.system.domain.KtonMonitorHostDetails
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
package com.kylin.kton.admin.monitor.host.controller;

import com.kylin.kton.admin.monitor.host.entity.vo.MonitorHostDetailsSearchVO;
import com.kylin.kton.admin.monitor.host.service.AdminMonitorHostDetailsService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonMonitorHostDetails;
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
@RequestMapping(value={"/admin/monitor/details"})
public class KtonMonitorHostDetailsController
extends BaseController {
    @Autowired
    private AdminMonitorHostDetailsService ktonMonitorHostDetailsService;

    @PreAuthorize(value="@ss.hasPermi('system:details:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(MonitorHostDetailsSearchVO searchVO) {
        this.startPage();
        List<KtonMonitorHostDetails> list = this.ktonMonitorHostDetailsService.list(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:details:export')")
    @Log(title="\u76d1\u63a7-\u4e3b\u673a-\u660e\u7ec6\u8bb0\u5f55", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonMonitorHostDetails ktonMonitorHostDetails) {
        List list = this.ktonMonitorHostDetailsService.selectKtonMonitorHostDetailsList(ktonMonitorHostDetails);
        ExcelUtil util = new ExcelUtil(KtonMonitorHostDetails.class);
        util.exportExcel(response, list, "\u76d1\u63a7-\u4e3b\u673a-\u660e\u7ec6\u8bb0\u5f55\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:details:query')")
    @GetMapping(value={"/{hostIp}"})
    public AjaxResult getInfo(@PathVariable(value="hostIp") String hostIp) {
        return this.success(this.ktonMonitorHostDetailsService.selectKtonMonitorHostDetailsByHostIp(hostIp));
    }

    @PreAuthorize(value="@ss.hasPermi('system:details:add')")
    @Log(title="\u76d1\u63a7-\u4e3b\u673a-\u660e\u7ec6\u8bb0\u5f55", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonMonitorHostDetails ktonMonitorHostDetails) {
        return this.toAjax(this.ktonMonitorHostDetailsService.insertKtonMonitorHostDetails(ktonMonitorHostDetails));
    }

    @PreAuthorize(value="@ss.hasPermi('system:details:edit')")
    @Log(title="\u76d1\u63a7-\u4e3b\u673a-\u660e\u7ec6\u8bb0\u5f55", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonMonitorHostDetails ktonMonitorHostDetails) {
        return this.toAjax(this.ktonMonitorHostDetailsService.updateKtonMonitorHostDetails(ktonMonitorHostDetails));
    }

    @PreAuthorize(value="@ss.hasPermi('system:details:remove')")
    @Log(title="\u76d1\u63a7-\u4e3b\u673a-\u660e\u7ec6\u8bb0\u5f55", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{hostIps}"})
    public AjaxResult remove(@PathVariable String[] hostIps) {
        return this.toAjax(this.ktonMonitorHostDetailsService.deleteKtonMonitorHostDetailsByHostIps(hostIps));
    }
}

