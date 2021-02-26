package com.wxss.hhlife.dubbo.opcenter.api;

import com.wxss.hhlife.base.ApiResult;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResult;

/**
 * 商户服务dubbo接口定义
 */
public interface ApiMerchantService {
    /**
     * 保存商户信息
     * @param merchantCreateParam
     * @return
     */
    BaseFacadeResp<MerchantCreateResult> saveMerchantInfo(MerchantCreateParam merchantCreateParam);
}
