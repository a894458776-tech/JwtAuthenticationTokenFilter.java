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
 *  com.kylin.kton.system.domain.KtonIpStaticPoolItem
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

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticPoolItemInfoDTO;
import com.kylin.kton.admin.ip.entity.dto.AdminUnassignedIpsDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolAllListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticPoolListSearchVO;
import com.kylin.kton.admin.ip.entity.vo.AdminUnassignedIpsVO;
import com.kylin.kton.admin.ip.entity.vo.PoolItemAddBatchVO;
import com.kylin.kton.admin.ip.service.IpStaticPoolItemService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticPoolItem;
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

@Api(tags={"\u7ba1\u7406\u7aef-IP\u6c60\u8be6\u60c5"})
@RestController
@RequestMapping(value={"/admin/ip/pool/item"})
public class KtonIpStaticPoolItemController
extends BaseController {
    private final IpStaticPoolItemService ipStaticPoolItemService;

    @ApiOperation(value="\u5217\u8868")
    @PreAuthorize(value="@ss.hasPermi('system:item:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminIpStaticPoolListSearchVO searchVO) {
        this.startPage();
        List<AdminIpStaticPoolItemInfoDTO> list = this.ipStaticPoolItemService.list(searchVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u67e5\u8be2\u6240\u6709\u5217\u8868")
    @PreAuthorize(value="@ss.hasPermi('system:item:list')")
    @GetMapping(value={"/allList"})
    public TableDataInfo allList(AdminIpStaticPoolAllListSearchVO searchVO) {
        this.startPage();
        List<AdminIpStaticPoolItemDTO> list = this.ipStaticPoolItemService.allList(searchVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5bfc\u51fa")
    @PreAuthorize(value="@ss.hasPermi('system:item:export')")
    @Log(title="\u9759\u6001IP-IP\u6c60-\u660e\u7ec6", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticPoolItem ktonIpStaticPoolItem) {
        List list = this.ipStaticPoolItemService.selectKtonIpStaticPoolItemList(ktonIpStaticPoolItem);
        ExcelUtil util = new ExcelUtil(KtonIpStaticPoolItem.class);
        util.exportExcel(response, list, "\u9759\u6001IP-IP\u6c60-\u660e\u7ec6\u6570\u636e");
    }

    @ApiOperation(value="\u8be6\u60c5")
    @PreAuthorize(value="@ss.hasPermi('system:item:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ipStaticPoolItemService.selectKtonIpStaticPoolItemById(id));
    }

    @ApiOperation(value="\u6dfb\u52a0")
    @PreAuthorize(value="@ss.hasPermi('system:item:add')")
    @Log(title="\u9759\u6001IP-IP\u6c60-\u660e\u7ec6", businessType=BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticPoolItem ktonIpStaticPoolItem) {
        return this.toAjax(this.ipStaticPoolItemService.insertKtonIpStaticPoolItem(ktonIpStaticPoolItem));
    }

    @ApiOperation(value="\u7f16\u8f91")
    @PreAuthorize(value="@ss.hasPermi('system:item:edit')")
    @Log(title="\u9759\u6001IP-IP\u6c60-\u660e\u7ec6", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticPoolItem ktonIpStaticPoolItem) {
        return this.toAjax(this.ipStaticPoolItemService.updateKtonIpStaticPoolItem(ktonIpStaticPoolItem));
    }

    @ApiOperation(value="\u5220\u9664")
    @PreAuthorize(value="@ss.hasPermi('system:item:remove')")
    @Log(title="\u9759\u6001IP-IP\u6c60-\u660e\u7ec6", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ipStaticPoolItemService.deleteKtonIpStaticPoolItemByIds(ids));
    }

    @ApiOperation(value="\u6279\u91cf\u6dfb\u52a0\u5230IP\u6c60")
    @PostMapping(value={"/addBatch"})
    public AjaxResult addBatch(@RequestBody PoolItemAddBatchVO addBatchVO) {
        return this.toAjax(this.ipStaticPoolItemService.addBatch(addBatchVO));
    }

    @GetMapping(value={"/unassignedIps"})
    public TableDataInfo unassignedIps(AdminUnassignedIpsVO unassignedIpsVO) {
        this.startPage();
        List<AdminUnassignedIpsDTO> list = this.ipStaticPoolItemService.unassignedIps(unassignedIpsVO);
        return this.getDataTable(list);
    }

    @Generated
    public KtonIpStaticPoolItemController(IpStaticPoolItemService ipStaticPoolItemService) {
        this.ipStaticPoolItemService = ipStaticPoolItemService;
    }
}

