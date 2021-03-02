package com.wxss.hhlife.dubbo.opcenter.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.wxss.hhlife.base.*;
import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.dubbo.opcenter.bean.*;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantListBO;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.opcenter.dto.MerchantInfoDTO;
import com.wxss.hhlife.dubbo.opcenter.exception.ServiceException;
import com.wxss.hhlife.dubbo.opcenter.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 *
 */
@Service(version = "1.1.0") // dubbo的注解,对外进行服务暴露
@Slf4j
public class ApiMerchantServiceImpl implements ApiMerchantService {

    @Autowired
    private MerchantService merchantService;

    @Override
    public BaseFacadeResp<MerchantCreateResult> saveMerchantInfo(MerchantCreateParam merchantCreateParam) {
        log.info("ApiMerchantServiceImpl#saveMerchantInfo 入参: {}", merchantCreateParam);

        MerchantSaveBO merchantSaveBO = new MerchantSaveBO();
        BeanUtils.copyProperties(merchantCreateParam, merchantSaveBO);
        MerchantCreateResult result = new MerchantCreateResult();

        boolean flag = merchantService.saveMerchantInfo(merchantSaveBO);
        log.info("ApiMerchantServiceImpl#saveMerchantInfo 返回: {}", JsonUtils.toJsonStr(result));
        if (flag) {
            return FacadeCommonRespBuilder.success(merchantCreateParam, result);
        }

        return FacadeCommonRespBuilder.fail(merchantCreateParam);
    }

    @Override
    public BaseFacadePageResp<MerchantListResult> getMerchantList(MerchantListParam listParam) {
        MerchantListBO merchantListBO = new MerchantListBO();
        BeanUtils.copyProperties(listParam,merchantListBO);
        PageData<MerchantInfoDTO> pageData = merchantService.selectMerchantList(merchantListBO);
        List<MerchantInfoDTO> merchantInfoDTOS = pageData.getData();
        Page page = new Page();
        page.setPageNum(pageData.getPageNum());
        page.setPageSize(pageData.getPageSize());
        page.setRowTotal(pageData.getRowTotal());
        if (merchantInfoDTOS.size() >0){
            MerchantListResult merchantListResult = new MerchantListResult();
            // TODO
            JsonUtils.copy(merchantInfoDTOS, MerchantListInfo.class)
            return FacadeCommonRespBuilder.successPage(listParam,null,page);
        }

        return null;
    }
}
