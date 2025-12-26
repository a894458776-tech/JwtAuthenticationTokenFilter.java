/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.annotation.OpenPlatform
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance
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

import com.kylin.kton.client.account.entity.vo.AccountBalanceSearchVO;
import com.kylin.kton.client.account.entity.vo.BalanceAddVO;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountBalanceService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountBalance;
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
@RequestMapping(value={"/client/dynamics/account/balance"})
@OpenPlatform
public class ClientIpDynamicsAccountBalanceController
extends BaseController {
    @Autowired
    private ClientIpDynamicsAccountBalanceService ktonIpDynamicsAccountBalanceService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(AccountBalanceSearchVO accountBalanceSearchVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        accountBalanceSearchVO.setMerchantId(merchantId);
        List<KtonIpDynamicsAccountBalance> list = this.ktonIpDynamicsAccountBalanceService.list(accountBalanceSearchVO);
        return this.getDataTable(list);
    }

    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountBalanceService.selectKtonIpDynamicsAccountBalanceById(id));
    }

    @PostMapping(value={"/add"})
    public AjaxResult add(@RequestBody BalanceAddVO balanceAddVO) {
        Long merchantId = SecurityUtils.getUserId();
        balanceAddVO.setMerchantId(merchantId);
        return this.ktonIpDynamicsAccountBalanceService.addBalance(balanceAddVO);
    }

    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountBalance ktonIpDynamicsAccountBalance) {
        return this.toAjax(this.ktonIpDynamicsAccountBalanceService.updateKtonIpDynamicsAccountBalance(ktonIpDynamicsAccountBalance));
    }

    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountBalanceService.deleteKtonIpDynamicsAccountBalanceByIds(ids));
    }
}

