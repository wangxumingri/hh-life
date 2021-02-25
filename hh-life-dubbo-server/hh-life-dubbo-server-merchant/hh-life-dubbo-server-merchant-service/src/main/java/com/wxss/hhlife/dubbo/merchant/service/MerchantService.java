package com.wxss.hhlife.dubbo.merchant.service;

import com.wxss.hhlife.dubbo.merchant.bo.MerchantSaveBO;

/**
 * spring 商户服务接口
 */
public interface MerchantService {
    /**
     * 保存商户信息
     * @param merchantSaveBO 商户信息
     * @return true-保存成功，false-保存失败
     */
    boolean saveMerchantInfo(MerchantSaveBO merchantSaveBO);

}
