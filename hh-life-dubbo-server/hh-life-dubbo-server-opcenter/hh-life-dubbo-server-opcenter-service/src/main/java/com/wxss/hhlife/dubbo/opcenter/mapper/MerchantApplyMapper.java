package com.wxss.hhlife.dubbo.opcenter.mapper;

import com.wxss.hhlife.dubbo.opcenter.model.MerchantApply;

public interface MerchantApplyMapper {
    int deleteByPrimaryKey(Long merchantApplyId);

    int insert(MerchantApply record);

    int insertSelective(MerchantApply record);

    MerchantApply selectByPrimaryKey(Long merchantApplyId);

    int updateByPrimaryKeySelective(MerchantApply record);

    int updateByPrimaryKey(MerchantApply record);
}