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
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat
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
package com.kylin.kton.admin.account.controller;

import com.kylin.kton.admin.account.entity.dto.AdminAccountStatDTO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountStatSearchVO;
import com.kylin.kton.admin.account.service.IpDynamicsAccountUsageStatService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
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
@RequestMapping(value={"/admin/dynamics/account/stat"})
public class IpDynamicsAccountUsageStatController
extends BaseController {
    @Autowired
    private IpDynamicsAccountUsageStatService ktonIpDynamicsAccountUsageStatService;

    @PreAuthorize(value="@ss.hasPermi('system:stat:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminAccountStatSearchVO searchVO) {
        this.startPage();
        List<AdminAccountStatDTO> list = this.ktonIpDynamicsAccountUsageStatService.list(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:stat:export')")
    @Log(title="\u52a8\u6001IP-\u4f7f\u7528\u7edf\u8ba1", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        List list = this.ktonIpDynamicsAccountUsageStatService.selectKtonIpDynamicsAccountUsageStatList(ktonIpDynamicsAccountUsageStat);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccountUsageStat.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u4f7f\u7528\u7edf\u8ba1\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:stat:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountUsageStatService.selectKtonIpDynamicsAccountUsageStatById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:stat:add')")
    @Log(title="\u52a8\u6001IP-\u4f7f\u7528\u7edf\u8ba1", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageStatService.insertKtonIpDynamicsAccountUsageStat(ktonIpDynamicsAccountUsageStat));
    }

    @PreAuthorize(value="@ss.hasPermi('system:stat:edit')")
    @Log(title="\u52a8\u6001IP-\u4f7f\u7528\u7edf\u8ba1", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageStatService.updateKtonIpDynamicsAccountUsageStat(ktonIpDynamicsAccountUsageStat));
    }

    @PreAuthorize(value="@ss.hasPermi('system:stat:remove')")
    @Log(title="\u52a8\u6001IP-\u4f7f\u7528\u7edf\u8ba1", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageStatService.deleteKtonIpDynamicsAccountUsageStatByIds(ids));
    }
}

