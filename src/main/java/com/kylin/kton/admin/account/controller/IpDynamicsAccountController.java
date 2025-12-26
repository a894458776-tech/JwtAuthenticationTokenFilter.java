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
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
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

import com.kylin.kton.admin.account.entity.dto.AdminIpDynamicsAccountDTO;
import com.kylin.kton.admin.account.entity.vo.AccountAddVO;
import com.kylin.kton.admin.account.entity.vo.AccountEditVO;
import com.kylin.kton.admin.account.entity.vo.AdminAccountSearchVO;
import com.kylin.kton.admin.account.service.IpDynamicsAccountService;
import com.kylin.kton.common.annotation.Log;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.enums.BusinessType;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
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
@RequestMapping(value={"/admin/dynamics/account"})
public class IpDynamicsAccountController
extends BaseController {
    @Autowired
    private IpDynamicsAccountService ktonIpDynamicsAccountService;

    @PreAuthorize(value="@ss.hasPermi('system:account:list')")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminAccountSearchVO adminAccountSearchVO) {
        this.startPage();
        List<AdminIpDynamicsAccountDTO> list = this.ktonIpDynamicsAccountService.list(adminAccountSearchVO);
        return this.getDataTable(list);
    }

    @PreAuthorize(value="@ss.hasPermi('system:account:export')")
    @Log(title="\u52a8\u6001IP-\u8d26\u53f7", businessType=BusinessType.EXPORT)
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccount ktonIpDynamicsAccount) {
        List list = this.ktonIpDynamicsAccountService.selectKtonIpDynamicsAccountList(ktonIpDynamicsAccount);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccount.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u8d26\u53f7\u6570\u636e");
    }

    @PreAuthorize(value="@ss.hasPermi('system:account:query')")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountService.selectKtonIpDynamicsAccountById(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody AccountAddVO addVO) {
        return this.toAjax(this.ktonIpDynamicsAccountService.add(addVO));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody AccountEditVO editVO) {
        return this.toAjax(this.ktonIpDynamicsAccountService.edit(editVO));
    }

    @PreAuthorize(value="@ss.hasPermi('system:account:remove')")
    @Log(title="\u52a8\u6001IP-\u8d26\u53f7", businessType=BusinessType.DELETE)
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountService.deleteKtonIpDynamicsAccountByIds(ids));
    }
}

