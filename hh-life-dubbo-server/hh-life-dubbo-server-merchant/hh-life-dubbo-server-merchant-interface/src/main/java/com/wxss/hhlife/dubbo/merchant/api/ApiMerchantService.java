package com.wxss.hhlife.dubbo.merchant.api;

import com.wxss.hhlife.base.ApiResult;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateResult;

/**
 * 商户服务dubbo接口定义
 */
public interface ApiMerchantService {
    /**
     * 保存商户信息
     * @param merchantCreateParam
     * @return
     */
    ApiResult<MerchantCreateResult> saveMerchantInfo(MerchantCreateParam merchantCreateParam);
}
