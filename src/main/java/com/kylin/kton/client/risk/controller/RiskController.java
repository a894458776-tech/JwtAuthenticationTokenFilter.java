package com.kylin.kton.client.risk.controller;

import com.kylin.kton.client.risk.service.RiskService;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/client/risk")
public class RiskController extends BaseController {

    @Autowired
    private RiskService riskService;

    @GetMapping("/check")
    public AjaxResult checkRisk(String ip) {
        // 【修复】修复泛型推断错误
        Object result = riskService.checkRisk(null, ip);
        return AjaxResult.success(result);
    }
}