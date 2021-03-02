package com.wxss.hhlife.api.opcenter.service;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.opcenter.request.MerchantCreateReqVO;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.base.RestResultVO;
import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.dubbo.opcenter.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    public RestResultVO saveMerchantInfo(MerchantCreateReqVO merchatCreateRequest) {
        MerchantCreateParam merchantCreateParam = new MerchantCreateParam();
        BeanUtils.copyProperties(merchatCreateRequest, merchantCreateParam);
        BaseFacadeResp<MerchantCreateResult> facadeResp = apiMerchantService.saveMerchantInfo(merchantCreateParam);

        return facadeResp.getSuccess() ? RestResultBuilder.success() : RestResultBuilder.failure();
    }
}
