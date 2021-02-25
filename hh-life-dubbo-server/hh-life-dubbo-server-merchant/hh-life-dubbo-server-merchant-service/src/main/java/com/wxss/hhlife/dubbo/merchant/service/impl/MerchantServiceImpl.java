package com.wxss.hhlife.dubbo.merchant.service.impl;

import com.wxss.hhlife.dubbo.merchant.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.merchant.service.MerchantService;
import org.springframework.stereotype.Service;


@Service("merchantService")
public class MerchantServiceImpl implements MerchantService {
    @Override
    public boolean saveMerchantInfo(MerchantSaveBO merchantSaveBO) {
        System.out.println("MerchantServiceImpl#saveMerchantInfo执行...");
        return true;
    }
}
