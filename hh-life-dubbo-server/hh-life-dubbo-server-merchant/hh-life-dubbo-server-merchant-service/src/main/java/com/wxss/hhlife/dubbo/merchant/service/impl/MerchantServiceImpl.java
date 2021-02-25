package com.wxss.hhlife.dubbo.merchant.service.impl;

import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.dubbo.merchant.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.merchant.constant.ExceptionMessage;
import com.wxss.hhlife.dubbo.merchant.exception.ServiceException;
import com.wxss.hhlife.dubbo.merchant.mapper.MerchantApplyMapper;
import com.wxss.hhlife.dubbo.merchant.model.MerchantApply;
import com.wxss.hhlife.dubbo.merchant.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.rowset.serial.SerialException;
import java.util.UUID;


@Service("merchantService")
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantApplyMapper merchantApplyMapper;

    @Override
    public boolean saveMerchantInfo(MerchantSaveBO merchantSaveBO) throws ServiceException {
        log.info("MerchantServiceImpl#saveMerchantInfo入参 :{}", JsonUtils.toJsonStr(merchantSaveBO));

        // 新增
        // TODO 调用服务，根据类型生成分布式全局唯一ID
        String merchantId = UUID.randomUUID().toString();
        merchantSaveBO.setMerchantId(merchantId);

        if (merchantSaveBO.getContractStartDate() == null || merchantSaveBO.getContractEndDate() == null){
            // 抛出异常，还是返回封装的错误
            throw new ServiceException(ExceptionMessage.PARAM_ERROR);
        }
        if (merchantSaveBO.getContractEndDate().before(merchantSaveBO.getContractStartDate())){
            throw new ServiceException(ExceptionMessage.PARAM_ERROR);
        }

        MerchantApply merchantApply = new MerchantApply();
        BeanUtils.copyProperties(merchantSaveBO,merchantApply);
        int effectRows = merchantApplyMapper.insert(merchantApply);

        if (effectRows < 1){
            throw new ServiceException(ExceptionMessage.INSERT_ERROR);
        }

        return true;
    }
}
