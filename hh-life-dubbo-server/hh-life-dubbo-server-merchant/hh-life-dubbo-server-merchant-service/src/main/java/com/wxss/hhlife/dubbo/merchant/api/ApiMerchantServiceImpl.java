package com.wxss.hhlife.dubbo.merchant.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.wxss.hhlife.dubbo.merchant.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.merchant.bean.MerchantCreateResult;
import com.wxss.hhlife.dubbo.merchant.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.merchant.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 */
@Service(version = "1.1.0") // dubbo的注解,对外进行服务暴露
@Slf4j
public class ApiMerchantServiceImpl implements ApiMerchantService {

    @Autowired
    private MerchantService merchantService;

    @Override
    public MerchantCreateResult saveMerchantInfo(MerchantCreateParam merchantCreateParam) {

        // 转成json字符串
        log.info("ApiMerchantServiceImpl#saveMerchantInfo 入参: {}",merchantCreateParam);

        MerchantSaveBO merchantSaveBO = new MerchantSaveBO();
        BeanUtils.copyProperties(merchantCreateParam,merchantSaveBO);
        boolean flag = merchantService.saveMerchantInfo(merchantSaveBO);

        log.info("ApiMerchantServiceImpl#saveMerchantInfo 返回: {}",merchantCreateParam);

        return null;
    }
}
