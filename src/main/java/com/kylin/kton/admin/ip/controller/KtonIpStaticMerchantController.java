/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.kylin.kton.common.core.controller.BaseController
 *  com.kylin.kton.common.core.domain.AjaxResult
 *  com.kylin.kton.common.core.page.TableDataInfo
 *  com.kylin.kton.common.utils.poi.ExcelUtil
 *  com.kylin.kton.system.domain.KtonIpStaticMerchant
 *  io.swagger.annotations.ApiOperation
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
package com.kylin.kton.admin.ip.controller;

import com.kylin.kton.admin.ip.entity.dto.AdminIpStaticMerchantDTO;
import com.kylin.kton.admin.ip.entity.vo.AdminIpStaticMerchantSearchVO;
import com.kylin.kton.admin.ip.service.IpStaticMerchantService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import com.kylin.kton.common.core.page.TableDataInfo;
import com.kylin.kton.common.utils.poi.ExcelUtil;
import com.kylin.kton.system.domain.KtonIpStaticMerchant;
import io.swagger.annotations.ApiOperation;
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
@RequestMapping(value={"/admin/ip/merchant"})
public class KtonIpStaticMerchantController
extends BaseController {
    @Autowired
    private IpStaticMerchantService ktonIpStaticMerchantService;

    @ApiOperation(value="\u5217\u8868")
    @GetMapping(value={"/list"})
    public TableDataInfo list(AdminIpStaticMerchantSearchVO searchVO) {
        this.startPage();
        List<AdminIpStaticMerchantDTO> list = this.ktonIpStaticMerchantService.list(searchVO);
        return this.getDataTable(list);
    }

    @ApiOperation(value="\u5bfc\u51fa")
    @PostMapping(value={"/export"})
    public void export(HttpServletResponse response, KtonIpStaticMerchant ktonIpStaticMerchant) {
        List list = this.ktonIpStaticMerchantService.selectKtonIpStaticMerchantList(ktonIpStaticMerchant);
        ExcelUtil util = new ExcelUtil(KtonIpStaticMerchant.class);
        util.exportExcel(response, list, "\u9759\u6001IP-IP\u6c60-\u660e\u7ec6-\u5ba2\u6237\u4fa7\u6570\u636e");
    }

    @ApiOperation(value="\u8be6\u60c5")
    @GetMapping(value={"/{id}"})
    public AjaxResult getInfo(@PathVariable(value="id") Long id) {
        return this.success(this.ktonIpStaticMerchantService.selectKtonIpStaticMerchantById(id));
    }

    @ApiOperation(value="\u65b0\u589e")
    @PostMapping
    public AjaxResult add(@RequestBody KtonIpStaticMerchant ktonIpStaticMerchant) {
        return this.toAjax(this.ktonIpStaticMerchantService.insertKtonIpStaticMerchant(ktonIpStaticMerchant));
    }

    @ApiOperation(value="\u7f16\u8f91")
    @PutMapping
    public AjaxResult edit(@RequestBody KtonIpStaticMerchant ktonIpStaticMerchant) {
        return this.toAjax(this.ktonIpStaticMerchantService.updateKtonIpStaticMerchant(ktonIpStaticMerchant));
    }

    @ApiOperation(value="\u5220\u9664")
    @DeleteMapping(value={"/{ids}"})
    public AjaxResult remove(@PathVariable Long[] ids) {
        return this.toAjax(this.ktonIpStaticMerchantService.deleteKtonIpStaticMerchantByIds(ids));
    }
}

