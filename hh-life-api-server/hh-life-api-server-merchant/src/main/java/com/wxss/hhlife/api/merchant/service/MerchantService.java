package com.wxss.hhlife.api.merchant.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.merchant.request.MerchatCreateRequest;
import com.wxss.hhlife.base.BaseResponse;
import com.wxss.hhlife.base.ResponseBuilder;
import com.wxss.hhlife.dubbo.merchant.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    public BaseResponse saveMerchantInfo(MerchatCreateRequest merchatCreateRequest) {
        MerchantCreateParam merchantCreateParam = new MerchantCreateParam();
        BeanUtils.copyProperties(merchatCreateRequest, merchantCreateParam);
        MerchantCreateResult result = apiMerchantService.saveMerchantInfo(merchantCreateParam);

        return result.getSuccess() ? ResponseBuilder.success() : ResponseBuilder.failure();
    }
}
