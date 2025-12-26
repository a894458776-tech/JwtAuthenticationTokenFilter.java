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
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
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

import com.kylin.kton.admin.account.entity.vo.AccountBalanceSearchVO;
import com.kylin.kton.admin.account.entity.vo.BalanceAddVO;
import com.kylin.kton.admin.account.service.IpDynamicsAccountBalanceService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
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
@RequestMapping(value={"/admin/dynamics/account/balance"})
public class IpDynamicsAccountBalanceController
extends BaseController {
    @Autowired
    private IpDynamicsAccountBalanceService ktonIpDynamicsAccountBalanceService;

    @PreAuthorize(value="@ss.hasPermi('system:balance:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AccountBalanceSearchVO accountBalanceSearchVO) {
        this.startPage();
        List<KtonIpDynamicsAccountBalance> list = this.ktonIpDynamicsAccountBalanceService.list(accountBalanceSearchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:balance:export')")
    @Log(title="\u52a8\u6001IP-\u4f59\u989d", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccountBalance ktonIpDynamicsAccountBalance) {
        List list = this.ktonIpDynamicsAccountBalanceService.selectKtonIpDynamicsAccountBalanceList(ktonIpDynamicsAccountBalance);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccountBalance.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u4f59\u989d\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:balance:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountBalanceService.selectKtonIpDynamicsAccountBalanceById(id));
    }

    @PreAuthorize(value="@ss.hasPermi('system:balance:add')")
    @Log(title="\u52a8\u6001IP-\u4f59\u989d", businessType=BusinessType.INSERT)
    @PostMapping(value={"/add"})
    public AjaxResult add(@RequestBody BalanceAddVO addVO) {
        return AjaxResult.success((Object)this.ktonIpDynamicsAccountBalanceService.addBalance(addVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:balance:edit')")
    @Log(title="\u52a8\u6001IP-\u4f59\u989d", businessType=BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountBalance ktonIpDynamicsAccountBalance) {
        return this.toAjax(this.ktonIpDynamicsAccountBalanceService.updateKtonIpDynamicsAccountBalance(ktonIpDynamicsAccountBalance));
    }

    @PreAuthorize(value="@ss.hasPermi('system:balance:remove')")
    @Log(title="\u52a8\u6001IP-\u4f59\u989d", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountBalanceService.deleteKtonIpDynamicsAccountBalanceByIds(ids));
    }
}

