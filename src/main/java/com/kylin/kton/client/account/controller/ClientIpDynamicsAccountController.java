/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService
 *  com.kylin.kton.api.netnut.service.NetnutSubUserApiService
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccount
 *  org.springframework.beans.factory.annotation.Autowired
 *  org.springframework.web.bind.annotation.DeleteMapping
 *  org.springframework.web.bind.annotation.GetMapping
 *  org.springframework.web.bind.annotation.PathVariable
 *  org.springframework.web.bind.annotation.PostMapping
 *  org.springframework.web.bind.annotation.PutMapping
 *  org.springframework.web.bind.annotation.RequestBody
 *  org.springframework.web.bind.annotation.RequestMapping
 *  org.springframework.web.bind.annotation.RestController
 */
package com.kylin.kton.client.account.controller;

import com.kylin.kton.api.dataimpulse.service.DataImpulseSubUserApiService;
import com.kylin.kton.api.netnut.service.NetnutSubUserApiService;
import com.kylin.kton.client.account.entity.vo.AccountAddVO;
import com.kylin.kton.client.account.entity.vo.AccountEditVO;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsAccount;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"/client/dynamics/account"})
@OpenPlatform
public class ClientIpDynamicsAccountController
extends BaseController {
    @Autowired
    private ClientIpDynamicsAccountService ktonIpDynamicsAccountService;
    @Autowired
    NetnutSubUserApiService netnutSubUserApiService;
    @Autowired
    DataImpulseSubUserApiService dataimpulseSubUserApiService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(KtonIpDynamicsAccount ktonIpDynamicsAccount) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        ktonIpDynamicsAccount.setMerchantId(merchantId);
        List list = this.ktonIpDynamicsAccountService.selectKtonIpDynamicsAccountList(ktonIpDynamicsAccount);
        return this.getDataTable(list);
    }

    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountService.selectKtonIpDynamicsAccountById(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody AccountAddVO addVO) {
        Long merchantId = SecurityUtils.getUserId();
        addVO.setMerchantId(merchantId);
        return this.toAjax(this.ktonIpDynamicsAccountService.add(addVO));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody AccountEditVO editVO) {
        Long merchantId = SecurityUtils.getUserId();
        editVO.setMerchantId(merchantId);
        return this.toAjax(this.ktonIpDynamicsAccountService.edit(editVO));
    }

    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        Long merchantId = SecurityUtils.getUserId();
        return this.toAjax(this.ktonIpDynamicsAccountService.remove(merchantId, ids));
    }
}

