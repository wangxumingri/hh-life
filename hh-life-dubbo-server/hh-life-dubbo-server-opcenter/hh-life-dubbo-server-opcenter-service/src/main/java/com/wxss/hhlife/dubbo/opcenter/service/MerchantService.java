package com.wxss.hhlife.dubbo.opcenter.service;

import com.wxss.hhlife.base.PageData;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantListBO;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.opcenter.dto.MerchantInfoDTO;

/**
 * spring 商户服务接口
 */
public interface MerchantService {
    /**
     * 保存商户信息
     * @param merchantSaveBO 商户信息
     * @return true-保存成功，false-保存失败
     */
    boolean saveMerchantInfo(MerchantSaveBO merchantSaveBO) ;

    /**
     * 查询商户列表
     * @param merchantListBO
     * @return
     */
    PageData<MerchantInfoDTO> selectMerchantList(MerchantListBO merchantListBO);

}
