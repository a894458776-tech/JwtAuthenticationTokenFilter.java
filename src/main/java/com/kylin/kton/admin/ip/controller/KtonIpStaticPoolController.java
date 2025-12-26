/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.Log
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.enums.BusinessType
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonIpStaticPool
 *  io.swagger.annotations.Api
 *  io.swagger.annotations.ApiOperation
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
package com.kylin.kton.admin.ip.controller;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantAvailableIpListDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminMerchantInventoryIpsDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminRegionalAvailableIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminMerchantInventoryIpsVO;
import com.kylin.kton.admin.ip.entity.vo.AdminRegionalAvailableIpsVO;
import com.kylin.kton.admin.ip.entity.vo.MerchantAvailableIpListVO;
import com.kylin.kton.admin.ip.service.IpStaticPoolService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticPool;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

@Api(tags={"\u7ba1\u7406\u7aef-IP\u6c60"})
@RestController
@RequestMapping(value={"/admin/ip/pool"})
public class KtonIpStaticPoolController
extends BaseController {
    private final IpStaticPoolService ipStaticPoolService;

    @ApiOperation(value="\u5217\u8868")
    @PreAuthorize(value="@ss.hasPermi('system:pool:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpStaticPool ktonIpStaticPool) {
        this.startPage();
        List<AdminIpStaticPoolDTO> list = this.ipStaticPoolService.list(ktonIpStaticPool);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5bfc\u51fa")
    @PreAuthorize(value="@ss.hasPermi('system:pool:export')")
    @Log(title="\u9759\u6001IP-IP\u6c60", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticPool ktonIpStaticPool) {
        List list = this.ipStaticPoolService.selectKtonIpStaticPoolList(ktonIpStaticPool);
        ExcelUtil util = new ExcelUtil(KtonIpStaticPool.class);
        util.exportExcel(response, list, "\u9759\u6001IP-IP\u6c60\u6570\u636e");
    }

    @ApiOperation(value="\u8be6\u60c5")
    @PreAuthorize(value="@ss.hasPermi('system:pool:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ipStaticPoolService.selectKtonIpStaticPoolById(id));
    }

    @ApiOperation(value="\u6dfb\u52a0")
    @PreAuthorize(value="@ss.hasPermi('system:pool:add')")
    @Log(title="\u9759\u6001IP-IP\u6c60", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticPool ktonIpStaticPool) {
        return this.toAjax(this.ipStaticPoolService.insertKtonIpStaticPool(ktonIpStaticPool));
    }

    @ApiOperation(value="\u7f16\u8f91")
    @PreAuthorize(value="@ss.hasPermi('system:pool:edit')")
    @Log(title="\u9759\u6001IP-IP\u6c60", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticPool ktonIpStaticPool) {
        return this.toAjax(this.ipStaticPoolService.updateKtonIpStaticPool(ktonIpStaticPool));
    }

    @ApiOperation(value="\u5220\u9664")
    @PreAuthorize(value="@ss.hasPermi('system:pool:remove')")
    @Log(title="\u9759\u6001IP-IP\u6c60", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ipStaticPoolService.deleteKtonIpStaticPoolByIds(ids));
    }

    @GetMapping(value={"/ipNuxSync"})
    @OpenPlatform
    public AjaxResult ipNuxSync() {
        return this.ipStaticPoolService.ipNuxSync();
    }

    @GetMapping(value={"/ipIdeaSync"})
    @OpenPlatform
    public AjaxResult ipIdeaSync() {
        return this.ipStaticPoolService.ipIdeaSync();
    }

    @GetMapping(value={"/ipIdeaSync2"})
    @OpenPlatform
    public AjaxResult ipIdeaSync2() {
        return this.ipStaticPoolService.ipIdeaSync2();
    }

    @ApiOperation(value="\u67e5\u8be2\u9759\u6001IP-\u53ef\u7528IP\u5217\u8868(\u652f\u6301\u591a\u9009)")
    @GetMapping(value={"/regionalAvailableIps"})
    public TableDataInfo regionalAvailableIps(AdminRegionalAvailableIpsVO availableIpsVO) {
        List<AdminRegionalAvailableIpsDTO> list = this.ipStaticPoolService.regionalAvailableIps(availableIpsVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5546\u6237\u9759\u6001IP-\u53ef\u7528IP\u5217\u8868\uff08\u4e0a\u67b6\u672a\u8d2d\u4e70\uff0c\u652f\u6301\u6a21\u7cca\u67e5\u8be2\uff09")
    @GetMapping(value={"/merchantAvailableIpList"})
    public TableDataInfo merchantAvailableIpList(MerchantAvailableIpListVO merchantAvailableIpListVO) {
        this.startPage();
        List<AdminMerchantAvailableIpListDTO> list = this.ipStaticPoolService.merchantAvailableIpList(merchantAvailableIpListVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5546\u6237\u5e93\u5b58IP")
    @GetMapping(value={"/merchantInventoryIps"})
    public TableDataInfo merchantInventoryIps(AdminMerchantInventoryIpsVO inventoryIpsVO) {
        List<AdminMerchantInventoryIpsDTO> list = this.ipStaticPoolService.merchantInventoryIps(inventoryIpsVO);
        return this.getDataTable(list);
    }

    @Generated
    public KtonIpStaticPoolController(IpStaticPoolService ipStaticPoolService) {
        this.ipStaticPoolService = ipStaticPoolService;
    }
}

