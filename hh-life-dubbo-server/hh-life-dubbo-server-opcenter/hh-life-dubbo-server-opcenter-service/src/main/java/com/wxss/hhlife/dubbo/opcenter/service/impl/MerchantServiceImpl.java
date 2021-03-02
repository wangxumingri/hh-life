package com.wxss.hhlife.dubbo.opcenter.service.impl;

import com.wxss.hhlife.base.PageData;
import com.wxss.hhlife.base.utils.JsonUtils;
import com.wxss.hhlife.common.IdGenerateAdapter;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantListBO;
import com.wxss.hhlife.dubbo.opcenter.bo.MerchantSaveBO;
import com.wxss.hhlife.dubbo.opcenter.dao.MerchantListDAO;
import com.wxss.hhlife.dubbo.opcenter.dto.MerchantInfoDTO;
import com.wxss.hhlife.dubbo.opcenter.mapper.MerchantApplyMapper;
import com.wxss.hhlife.dubbo.opcenter.model.MerchantApply;
import com.wxss.hhlife.dubbo.opcenter.service.MerchantService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

import static com.wxss.hhlife.common.enums.SeqType.MERCHANT;


@Service("merchantService")
@Slf4j
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantApplyMapper merchantApplyMapper;

    @Autowired
    private IdGenerateAdapter idGenerateAdapter;

    /**
     * 返回结果需要改造
     * @param merchantSaveBO 商户信息
     * @return
     */
    @Override
    public boolean saveMerchantInfo(MerchantSaveBO merchantSaveBO)  {
        log.info("MerchantServiceImpl#saveMerchantInfo入参 :{}", JsonUtils.toJsonStr(merchantSaveBO));
        boolean verification = this.verification(merchantSaveBO);
        if (!verification){
            return false;
        }
        // TODO 数据校验
        // TODO 对接外部接口
        // 新增
        // TODO 调用服务，根据类型生成分布式全局唯一ID
        String merchantId = idGenerateAdapter.generateId(MERCHANT.getSeqType(),null,null);
        merchantSaveBO.setMerchantId(merchantId);
        MerchantApply merchantApply = new MerchantApply();
        BeanUtils.copyProperties(merchantSaveBO,merchantApply);
        int effectRows = merchantApplyMapper.insert(merchantApply);

        if (effectRows < 1){
            return false;
        }
        log.info("MerchantServiceImpl#saveMerchantInfo保存成功 {}",merchantId);

        return true;
    }

    private boolean verification(MerchantSaveBO merchantSaveBO){
        return true;
    }

    @Override
    public PageData<MerchantInfoDTO> selectMerchantList(MerchantListBO merchantListBO) {
        log.info("MerchantServiceImpl#selectMerchantList 入参 :{}", JsonUtils.toJsonStr(merchantListBO));

        // TODO 写一个工具类，去除首尾空字符串
        MerchantListDAO merchantListDAO = new MerchantListDAO();
        BeanUtils.copyProperties(merchantListBO,merchantListDAO);
        if (merchantListDAO.getPageNumber() < 1){
            merchantListDAO.setPageNumber(0);
        }else {
            merchantListDAO.setPageNumber(merchantListDAO.getPageNumber() -1);
        }
        if (merchantListDAO.getPageSize()< 10){
            merchantListDAO.setPageSize(10);
        }
        int rowTotal = merchantApplyMapper.selectMerchantCount(merchantListDAO);
        List<MerchantApply> merchantApplyList = merchantApplyMapper.selectMerchantList(merchantListDAO);
        PageData<MerchantInfoDTO> result = new PageData<>();
        result.setPageNum(merchantListDAO.getPageNumber());
        result.setPageSize(merchantListDAO.getPageSize());
        result.setRowTotal(rowTotal);
        result.setPageCount();
        List<MerchantInfoDTO> infoDTOList = new ArrayList<>();
        result.setData(infoDTOList);
        if (merchantApplyList != null && merchantApplyList.size() >0){
            // TODO 获取地址和门店数量优化成批量
            for (MerchantApply merchantApply : merchantApplyList) {
                MerchantInfoDTO merchantInfoDTO = new MerchantInfoDTO();
                merchantInfoDTO.setMerchantName(merchantApply.getMerchantName());
                merchantInfoDTO.setMerchantStatus(merchantApply.getMerchantStatus());
                merchantInfoDTO.setAuditStatus(merchantApply.getAuditStatus());
                merchantInfoDTO.setCreateTime(merchantApply.getCreateTime());
                merchantInfoDTO.setMerchantId(merchantApply.getMerchantId());
                merchantInfoDTO.setCreateTime(merchantApply.getCreateTime());
                // TODO 门店待实现
                merchantInfoDTO.setShopCount(0);
                merchantInfoDTO.setAddress("假的地址");
                infoDTOList.add(merchantInfoDTO);
            }
        }
        log.info("MerchantServiceImpl#selectMerchantList 返回 :{}", JsonUtils.toJsonStr(result));

        return result;
    }
}
