package com.wxss.hhlife.api.merchant.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.merchant.request.MerchatCreateRequest;
import com.wxss.hhlife.base.ApiResult;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.base.RestResultVO;
import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.dubbo.opcenter.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("merchant")
@Slf4j  // TODO 写个切面记录HTTP日志
public class MerchantController {

//    @Autowired
//    private MerchantService merchantService;

    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    @PostMapping("save")
    public RestResultVO<MerchantCreateResult> saveMerchantInfo(@RequestBody MerchatCreateRequest merchatCreateRequest){
        log.info("MerchantController#saveMerchantInfo 收到请求:{}", JsonUtils.toJsonStr(merchatCreateRequest));

        MerchantCreateParam merchantCreateParam = new MerchantCreateParam();
        BeanUtils.copyProperties(merchatCreateRequest, merchantCreateParam);
        BaseFacadeResp<MerchantCreateResult> facadeResp = apiMerchantService.saveMerchantInfo(merchantCreateParam);
        RestResultVO<MerchantCreateResult> resultVO = facadeResp.getSuccess() ? RestResultBuilder.success() : RestResultBuilder.failure();

        log.info("MerchantController#saveMerchantInfo 返回响应:{}", JsonUtils.toJsonStr(resultVO));
        return resultVO;
    }

    @GetMapping("test")
    public String test(){
        return "YES";
    }
}
