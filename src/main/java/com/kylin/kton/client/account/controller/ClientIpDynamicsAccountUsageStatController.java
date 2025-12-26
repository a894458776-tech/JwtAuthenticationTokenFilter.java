/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat
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

import com.kylin.kton.client.account.entity.dto.ClientAccountStatDTO;
import com.kylin.kton.client.account.entity.vo.AccountStatSearchVO;
import com.kylin.kton.client.account.service.ClientIpDynamicsAccountUsageStatService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageStat;
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
@RequestMapping(value={"/client/dynamics/account/stat"})
public class ClientIpDynamicsAccountUsageStatController
extends BaseController {
    @Autowired
    private ClientIpDynamicsAccountUsageStatService ktonIpDynamicsAccountUsageStatService;

    @GetMapping(value={"/list"})
    public AjaxResult list(AccountStatSearchVO searchVO) {
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<ClientAccountStatDTO> list = this.ktonIpDynamicsAccountUsageStatService.list(searchVO);
        return AjaxResult.success(list);
    }

    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountUsageStatService.selectKtonIpDynamicsAccountUsageStatById(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        Long merchantId = SecurityUtils.getUserId();
        ktonIpDynamicsAccountUsageStat.setMerchantId(merchantId);
        return this.toAjax(this.ktonIpDynamicsAccountUsageStatService.insertKtonIpDynamicsAccountUsageStat(ktonIpDynamicsAccountUsageStat));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountUsageStat ktonIpDynamicsAccountUsageStat) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageStatService.updateKtonIpDynamicsAccountUsageStat(ktonIpDynamicsAccountUsageStat));
    }

    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageStatService.deleteKtonIpDynamicsAccountUsageStatByIds(ids));
    }
}

