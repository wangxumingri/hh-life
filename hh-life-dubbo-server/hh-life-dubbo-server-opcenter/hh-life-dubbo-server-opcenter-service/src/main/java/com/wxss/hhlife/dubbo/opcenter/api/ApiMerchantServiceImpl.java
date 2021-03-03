package com.wxss.hhlife.dubbo.opcenter.api;

import com.alibaba.dubbo.config.annotation.Service;
import com.wxss.hhlife.base.*;
import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.dubbo.opcenter.bean.*;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantApplyListBO;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.opcenter.dto.MerchantApplyInfoDTO;
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
    public BaseFacadeResp<MerchantCreateResponse> saveMerchantInfo(MerchantCreateRequest merchantCreateRequest) {
        log.info("ApiMerchantServiceImpl#saveMerchantInfo 入参: {}", merchantCreateRequest);

        MerchantSaveBO merchantSaveBO = new MerchantSaveBO();
        BeanUtils.copyProperties(merchantCreateRequest, merchantSaveBO);
        MerchantCreateResponse result = new MerchantCreateResponse();

        boolean flag = merchantService.saveMerchantInfo(merchantSaveBO);
        log.info("ApiMerchantServiceImpl#saveMerchantInfo 返回: {}", JsonUtils.toJsonStr(result));
        if (flag) {
            return FacadeCommonRespBuilder.success(merchantCreateRequest, result);
        }

        return FacadeCommonRespBuilder.fail(merchantCreateRequest);
    }

    @Override
    public BaseFacadePageResp<MerchantApplyListResponse> getMerchantApplyList(MerchantApplyListRequest listParam) {
        log.info("ApiMerchantServiceImpl#getMerchantList 入参: {}", JsonUtils.toJsonStr(listParam));

        MerchantApplyListBO merchantApplyListBO = new MerchantApplyListBO();
        BeanUtils.copyProperties(listParam, merchantApplyListBO);
        PageData<MerchantApplyInfoDTO> pageData = merchantService.selectMerchantApplyList(merchantApplyListBO);
        List<MerchantApplyInfoDTO> merchantApplyInfoDTOS = pageData.getData();
        Page page = new Page();
        page.setPageNum(pageData.getPageNum());
        page.setPageSize(pageData.getPageSize());
        page.setRowTotal(pageData.getRowTotal());
        if (merchantApplyInfoDTOS.size() >0){
            MerchantApplyListResponse merApplyListResp = new MerchantApplyListResponse();
            // TODO
            List<MerchantApplyListInfo> merApplyListInfos = JsonUtils.copyList(merchantApplyInfoDTOS, MerchantApplyListInfo.class);
            merApplyListResp.setMerInfoList(merApplyListInfos);
            return FacadeCommonRespBuilder.successPage(listParam, merApplyListResp,page);
        }

        log.info("ApiMerchantServiceImpl#getMerchantList 返回: page {}", JsonUtils.toJsonStr(page));

        return FacadeCommonRespBuilder.failPage(listParam,null,page);
    }
}
