package com.wxss.hhlife.api.opcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.opcenter.request.MerchantCreateReqVO;
import com.wxss.hhlife.api.opcenter.request.MerchantListInfoVO;
import com.wxss.hhlife.api.opcenter.request.MerchantListReqVO;
import com.wxss.hhlife.api.opcenter.request.MerchantListRespVO;
import com.wxss.hhlife.base.BaseFacadePageResp;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.base.RestResultVO;
import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.dubbo.opcenter.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResponse;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("merchant")
@Slf4j  // TODO 写个切面记录HTTP日志
public class MerchantController {

//    @Autowired
//    private MerchantService merchantService;

    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    @PostMapping("save")
    public RestResultVO<MerchantCreateResponse> saveMerchantInfo(@RequestBody MerchantCreateReqVO merchantCreateRequest){
        MerchantCreateRequest merchantCreateParam = new MerchantCreateRequest();
        BeanUtils.copyProperties(merchantCreateRequest, merchantCreateParam);
        BaseFacadeResp<MerchantCreateResponse> facadeResp = apiMerchantService.saveMerchantInfo(merchantCreateParam);
        return facadeResp.getSuccess() ? RestResultBuilder.success() : RestResultBuilder.failure();
    }

    @PostMapping("list")
    public RestResultVO<MerchantListRespVO> selectMerchantList(@RequestBody MerchantListReqVO reqVO){
        MerchantListRequest apiRequest = new MerchantListRequest();
        BeanUtils.copyProperties(reqVO,apiRequest);
        BaseFacadePageResp<MerchantListResponse> facadePageResp = apiMerchantService.getMerchantList(apiRequest);

        MerchantListRespVO respVO = new MerchantListRespVO();
        MerchantListResponse data = facadePageResp.getData();
        List<MerchantListInfoVO> infoVOList = JsonUtils.copyList(data.getMerInfoList(), MerchantListInfoVO.class);
        respVO.setMerchantInfo(infoVOList);
        respVO.setPageNum(facadePageResp.getPageNum());
        respVO.setPageSize(facadePageResp.getPageSize());
        respVO.setRowTotal(facadePageResp.getRowTotal());
        return  RestResultBuilder.success(respVO);

    }
    @GetMapping("test")
    public String test(){
        return "YES";
    }
}
