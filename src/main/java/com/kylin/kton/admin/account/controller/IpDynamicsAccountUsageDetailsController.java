/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.SecurityUtils
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails
 *  javax.servlet.http.HttpServletResponse
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
package com.kylin.kton.admin.account.controller;

import com.kylin.kton.admin.account.entity.vo.AccountUsageDetailsSearchVO;
import com.kylin.kton.admin.account.service.IpDynamicsAccountUsageDetailsService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.SecurityUtils;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpDynamicsAccountUsageDetails;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
@RequestMapping(value={"/admin/dynamics/account/details"})
public class IpDynamicsAccountUsageDetailsController
extends BaseController {
    @Autowired
    private IpDynamicsAccountUsageDetailsService ktonIpDynamicsAccountUsageDetailsService;

    @GetMapping(value={"/list"})
    public TableDataInfo list(AccountUsageDetailsSearchVO searchVO) {
        this.startPage();
        Long merchantId = SecurityUtils.getUserId();
        searchVO.setMerchantId(merchantId);
        List<KtonIpDynamicsAccountUsageDetails> list = this.ktonIpDynamicsAccountUsageDetailsService.list(searchVO);
        return this.getDataTable(list);
    }

    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpDynamicsAccountUsageDetails ktonIpDynamicsAccountUsageDetails) {
        List list = this.ktonIpDynamicsAccountUsageDetailsService.selectKtonIpDynamicsAccountUsageDetailsList(ktonIpDynamicsAccountUsageDetails);
        ExcelUtil util = new ExcelUtil(KtonIpDynamicsAccountUsageDetails.class);
        util.exportExcel(response, list, "\u52a8\u6001IP-\u4f7f\u7528\u8be6\u60c5\u6570\u636e");
    }

    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpDynamicsAccountUsageDetailsService.selectKtonIpDynamicsAccountUsageDetailsById(id));
    }

    @PostMapping
    public AjaxResult add(@RequestBody KtonIpDynamicsAccountUsageDetails ktonIpDynamicsAccountUsageDetails) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageDetailsService.insertKtonIpDynamicsAccountUsageDetails(ktonIpDynamicsAccountUsageDetails));
    }

    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpDynamicsAccountUsageDetails ktonIpDynamicsAccountUsageDetails) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageDetailsService.updateKtonIpDynamicsAccountUsageDetails(ktonIpDynamicsAccountUsageDetails));
    }

    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpDynamicsAccountUsageDetailsService.deleteKtonIpDynamicsAccountUsageDetailsByIds(ids));
    }
}

