package com.wxss.hhlife.dubbo.opcenter.service.impl;

import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.common.IdGenerateAdapter;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.opcenter.constant.ExceptionMessage;
import com.wxss.hhlife.dubbo.opcenter.exception.ServiceException;
import com.wxss.hhlife.dubbo.opcenter.mapper.MerchantApplyMapper;
import com.wxss.hhlife.dubbo.opcenter.model.MerchantApply;
import com.wxss.hhlife.dubbo.opcenter.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import static com.wxss.hhlife.dubbo.opcenter.enums.SeqType.MERCHANT;


@Service("merchantService")
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantApplyMapper merchantApplyMapper;

    @Autowired
    private IdGenerateAdapter idGenerateAdapter;

    @Override
    public boolean saveMerchantInfo(MerchantSaveBO merchantSaveBO)  {
        log.info("MerchantServiceImpl#saveMerchantInfo入参 :{}", JsonUtils.toJsonStr(merchantSaveBO));

        // 新增
        // TODO 调用服务，根据类型生成分布式全局唯一ID
        String merchantId = idGenerateAdapter.generateId(MERCHANT.name(),"wxss",null);
        merchantSaveBO.setMerchantId(merchantId);

        if (merchantSaveBO.getContractStartDate() == null || merchantSaveBO.getContractEndDate() == null){
            // 抛出异常，还是返回封装的错误
            return false;
        }
        if (merchantSaveBO.getContractEndDate().before(merchantSaveBO.getContractStartDate())){
            return false;
        }

        MerchantApply merchantApply = new MerchantApply();
        BeanUtils.copyProperties(merchantSaveBO,merchantApply);
        int effectRows = merchantApplyMapper.insert(merchantApply);

        if (effectRows < 1){
            return false;
        }

        return true;
    }
}
