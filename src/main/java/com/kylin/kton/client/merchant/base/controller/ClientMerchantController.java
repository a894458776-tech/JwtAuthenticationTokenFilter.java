package com.kylin.kton.client.merchant.base.controller;

import com.kylin.kton.client.merchant.base.entity.MerchantEditVO;
import com.kylin.kton.client.merchant.base.entity.vo.MerchantSourceVO;
import com.kylin.kton.client.merchant.base.service.ClientMerchantService;
import com.kylin.kton.client.merchant.base.service.ClientMerchantWalletService;
import com.kylin.kton.common.annotation.OpenPlatform;
import com.kylin.kton.common.core.controller.BaseController;
import com.kylin.kton.common.core.domain.AjaxResult;
// import com.kylin.kton.common.utils.MessageUtils; // [修改] 不再需要
import com.kylin.kton.common.utils.SecurityUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
// import java.util.Locale; // [修改] 不再需要
import lombok.Generated;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.MessageSource; // [修改] 不再需要
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags={"商户模块"})
@RestController
@RequestMapping(value={"/client/merchant"})
public class ClientMerchantController extends BaseController {

    @Autowired
    private ClientMerchantService merchantService;

    @Autowired
    private ClientMerchantWalletService walletService;

    // @Autowired
    // private MessageSource messageSource; // [修改] 既然字典丢了，这个注入也没用了，注释掉防止报错

    @ApiOperation(value="账户详情信息")
    @GetMapping(value={"/detail"})
    public AjaxResult detail() {
        // [关键修复] 之前报错就是因为这一行 System.out.println 调用了 MessageUtils
        // 我们直接把它删掉，或者注释掉
        // System.out.println(MessageUtils.message((String)"user.logout.success", (Object[])new Object[0]));

        Long merchantId = SecurityUtils.getUserId();
        return this.success(this.merchantService.selectKtonMerchantById(merchantId));
    }

    @ApiOperation(value="message")
    @GetMapping(value={"/message"})
    public AjaxResult message() {
        // [修改] 这个方法看起来是测试用的，也直接硬编码返回，防止报错
        /*
        String lang = "en_US";
        Locale locale = new Locale(lang.split("_")[0], lang.split("_")[1]);
        String welcomeMessage = this.messageSource.getMessage("user.logout.success", null, locale);
        return AjaxResult.success((String)welcomeMessage);
        */
        return AjaxResult.success("Test Message OK");
    }

    @ApiOperation(value="仪表盘余额信息")
    @GetMapping(value={"/walletInfo"})
    @OpenPlatform
    public AjaxResult walletInfo() {
        Long merchantId = SecurityUtils.getUserId();
        return this.success(this.walletService.selectKtonMerchantWalletByMerchantId(merchantId));
    }

    @ApiOperation(value="账户信息修改")
    @PutMapping(value={"/editMerchant"})
    public AjaxResult editMerchant(@RequestBody MerchantEditVO merchantEditVO) {
        Long merchantId = SecurityUtils.getUserId();
        merchantEditVO.setId(merchantId);
        return this.success(this.merchantService.editMerchant(merchantEditVO));
    }

    @ApiOperation(value="获取商户配置的服务商")
    @GetMapping(value={"/merchantSource"})
    public AjaxResult merchantSource(MerchantSourceVO sourceVO) {
        Long merchantId = SecurityUtils.getUserId();
        sourceVO.setMerchantId(merchantId);
        return this.success((Object)this.merchantService.merchantSource(sourceVO));
    }

    @Generated
    public ClientMerchantController() {
    }
}