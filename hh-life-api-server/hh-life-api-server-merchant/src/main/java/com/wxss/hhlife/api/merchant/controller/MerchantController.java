package com.wxss.hhlife.api.merchant.controller;

import com.wxss.hhlife.api.merchant.request.MerchatCreateRequest;
import com.wxss.hhlife.api.merchant.service.MerchantService;
import com.wxss.hhlife.base.BaseResponse;
import com.wxss.hhlife.base.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("merchant")
@Slf4j  // TODO 写个切面记录HTTP日志
public class MerchantController {

    @Autowired
    private MerchantService merchantService;

    @PostMapping("save")
    public BaseResponse saveMerchantInfo(@RequestBody MerchatCreateRequest merchatCreateRequest){
        log.info("MerchantController#saveMerchantInfo 收到请求:{}", JsonUtils.toJsonStr(merchatCreateRequest));
        BaseResponse response = merchantService.saveMerchantInfo(merchatCreateRequest);
        log.info("MerchantController#saveMerchantInfo 返回响应:{}", JsonUtils.toJsonStr(response));

        return response;
    }

    @GetMapping("test")
    public String test(){
        return "YES";
    }
}
