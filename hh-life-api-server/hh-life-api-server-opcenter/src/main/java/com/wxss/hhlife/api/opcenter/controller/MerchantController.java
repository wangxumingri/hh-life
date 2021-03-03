package com.wxss.hhlife.api.opcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.opcenter.request.MerchantCreateReqVO;
import com.wxss.hhlife.api.opcenter.request.MerchantApplyListInfoVO;
import com.wxss.hhlife.api.opcenter.request.MerchantApplyListReqVO;
import com.wxss.hhlife.api.opcenter.request.MerchantApplyListRespVO;
import com.wxss.hhlife.base.BaseFacadePageResp;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.base.RestResultVO;
import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.dubbo.opcenter.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResponse;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantApplyListRequest;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantApplyListResponse;
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
    public RestResultVO<MerchantApplyListRespVO> selectMerchantList(@RequestBody MerchantApplyListReqVO reqVO){
        MerchantApplyListRequest apiRequest = new MerchantApplyListRequest();
        BeanUtils.copyProperties(reqVO,apiRequest);
        BaseFacadePageResp<MerchantApplyListResponse> facadePageResp = apiMerchantService.getMerchantApplyList(apiRequest);

        MerchantApplyListRespVO respVO = new MerchantApplyListRespVO();
        MerchantApplyListResponse data = facadePageResp.getData();
        List<MerchantApplyListInfoVO> merApplyInfoVOList = JsonUtils.copyList(data.getMerInfoList(), MerchantApplyListInfoVO.class);
        respVO.setMerchantApplyInfo(merApplyInfoVOList);
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
