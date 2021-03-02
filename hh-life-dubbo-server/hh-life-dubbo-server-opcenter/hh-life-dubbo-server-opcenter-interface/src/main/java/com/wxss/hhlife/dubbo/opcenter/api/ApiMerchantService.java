package com.wxss.hhlife.dubbo.opcenter.api;

import com.wxss.hhlife.base.BaseFacadePageResp;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResponse;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListResponse;

/**
 * 商户服务dubbo接口定义
 */
public interface ApiMerchantService {
    /**
     * 保存商户信息
     * @param merchantCreateRequest
     * @return
     */
    BaseFacadeResp<MerchantCreateResponse> saveMerchantInfo(MerchantCreateRequest merchantCreateRequest);

    /**
     * 查询商户进件列表
     * @param listParam
     * @return
     */
    BaseFacadePageResp<MerchantListResponse> getMerchantList(MerchantListRequest listParam);
}
