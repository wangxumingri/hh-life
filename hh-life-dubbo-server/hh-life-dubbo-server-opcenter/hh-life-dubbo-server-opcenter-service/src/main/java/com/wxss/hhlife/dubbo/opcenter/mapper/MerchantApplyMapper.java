package com.wxss.hhlife.dubbo.opcenter.mapper;

import com.wxss.hhlife.dubbo.opcenter.dao.MerchantListDAO;
import com.wxss.hhlife.dubbo.opcenter.model.MerchantApply;

import java.util.List;

public interface MerchantApplyMapper {
    int deleteByPrimaryKey(Long merchantApplyId);

    int insert(MerchantApply record);

    int insertSelective(MerchantApply record);

    MerchantApply selectByPrimaryKey(Long merchantApplyId);

    int updateByPrimaryKeySelective(MerchantApply record);

    int updateByPrimaryKey(MerchantApply record);

    List<MerchantApply> selectMerchantList(MerchantListDAO merchantListDAO);

    int selectMerchantCount(MerchantListDAO merchantListDAO);
}