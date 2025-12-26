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
 *  com.kylin.kton.system.domain.KtonVpsHost
 *  javax.servlet.http.HttpServletResponse
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

import com.kylin.kton.admin.vps.entity.dto.VpsHostDTO;
import com.kylin.kton.admin.vps.entity.vo.AdminVpsHostAddVO;
import com.kylin.kton.admin.vps.entity.vo.VpsHostSearchVO;
import com.kylin.kton.admin.vps.service.VpsHostService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonVpsHost;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value={"/admin/vps/host"})
public class KtonVpsHostController
extends BaseController {
    private final VpsHostService vpsHostService;

    @PreAuthorize(value="@ss.hasPermi('system:host:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(VpsHostSearchVO searchVO) {
        this.startPage();
        List<VpsHostDTO> list = this.vpsHostService.list(searchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:host:export')")
    @Log(title="\u96c6\u7fa4\u4e3b\u673a", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonVpsHost ktonVpsHost) {
        List list = this.vpsHostService.selectKtonVpsHostList(ktonVpsHost);
        ExcelUtil util = new ExcelUtil(KtonVpsHost.class);
        util.exportExcel(response, list, "\u865a\u62df\u4e3b\u673a\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:host:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.vpsHostService.selectKtonVpsHostById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:host:add')")
    @Log(title="\u96c6\u7fa4\u4e3b\u673a", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdminVpsHostAddVO addVO) {
        return this.toAjax(this.vpsHostService.add(addVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:host:edit')")
    @Log(title="\u96c6\u7fa4\u4e3b\u673a", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonVpsHost ktonVpsHost) {
        return this.toAjax(this.vpsHostService.updateKtonVpsHost(ktonVpsHost));
    }

    @PreAuthorize(value="@ss.hasPermi('system:host:remove')")
    @Log(title="\u96c6\u7fa4\u4e3b\u673a", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{hostIps}"})
    public AjaxResult remove(@PathVariable Long[] hostIps) {
        return this.toAjax(this.vpsHostService.deleteKtonVpsHostByIds(hostIps));
    }

    @Generated
    public KtonVpsHostController(VpsHostService vpsHostService) {
        this.vpsHostService = vpsHostService;
    }
}

