package com.wxss.hhlife.api.opcenter.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wxss.hhlife.api.opcenter.request.MerchantCreateReqVO;
import com.wxss.hhlife.api.opcenter.request.MerchantListReqVO;
import com.wxss.hhlife.api.opcenter.request.MerchantListRespVO;
import com.wxss.hhlife.base.BaseFacadePageResp;
import com.wxss.hhlife.base.BaseFacadeResp;
import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.base.RestResultVO;
import com.wxss.hhlife.dubbo.opcenter.api.ApiMerchantService;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateParam;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantCreateResult;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListParam;
import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("merchant")
@Slf4j  // TODO 写个切面记录HTTP日志
public class MerchantController {

//    @Autowired
//    private MerchantService merchantService;

    @Reference(version = "1.1.0")
    private ApiMerchantService apiMerchantService;

    @PostMapping("save")
    public RestResultVO<MerchantCreateResult> saveMerchantInfo(@RequestBody MerchantCreateReqVO merchantCreateRequest){
//        log.info("MerchantController#saveMerchantInfo 收到请求:{}", JsonUtils.toJsonStr(merchatCreateRequest));
        MerchantCreateParam merchantCreateParam = new MerchantCreateParam();
        BeanUtils.copyProperties(merchantCreateRequest, merchantCreateParam);
        BaseFacadeResp<MerchantCreateResult> facadeResp = apiMerchantService.saveMerchantInfo(merchantCreateParam);
        RestResultVO<MerchantCreateResult> resultVO = facadeResp.getSuccess() ? RestResultBuilder.success() : RestResultBuilder.failure();

//        log.info("MerchantController#saveMerchantInfo 返回响应:{}", JsonUtils.toJsonStr(resultVO));
        return resultVO;
    }

    @PostMapping("list")
    public RestResultVO<MerchantListRespVO> selectMerchantList(@RequestBody MerchantListReqVO request){
        MerchantListParam param = new MerchantListParam();
        BeanUtils.copyProperties(request,param);
        BaseFacadePageResp<MerchantListResult> merchantList = apiMerchantService.getMerchantList(param);

        return merchantList.getSuccess()  ? RestResultBuilder.success()

    }
    @GetMapping("test")
    public String test(){
        return "YES";
    }
}
