package com.wxss.hhlife.api.opcenter.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.opcenter.request.MerchantCreateReqVO;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.base.RestResultVO;
import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.dubbo.opcenter.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    public RestResultVO saveMerchantInfo(MerchantCreateReqVO merchatCreateRequest) {
        MerchantCreateRequest merchantCreateRequest = new MerchantCreateRequest();
        BeanUtils.copyProperties(merchatCreateRequest, merchantCreateRequest);
        BaseFacadeResp<MerchantCreateResponse> facadeResp = apiMerchantService.saveMerchantInfo(merchantCreateRequest);

        return facadeResp.getSuccess() ? RestResultBuilder.success() : RestResultBuilder.failure();
    }
}
