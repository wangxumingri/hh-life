package com.wxss.hhlife.api.merchant.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.dubbo.merchant.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateResult;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    public boolean saveMerchantInfo(){
        MerchantCreateParam merchantCreateParam = new MerchantCreateParam();
        MerchantCreateResult result = apiMerchantService.saveMerchantInfo(merchantCreateParam);

        return true;
    }
}
