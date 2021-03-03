package com.wxss.hhlife.dubbo.opcenter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class MerchantApplyInfoDTO {
    private String merchantApplyId;
    /**商户编号*/
    private String merchantId;
    /**商户名称*/
    private String merchantName;
    /**
     * 商户状态:NORMAL-正常 、EXPIRED-过期、FREEZED-过期
     */
    private String merchantStatus;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 创建开始时间
     */
    private Date createTime;

    /**
     * 商户地址
     */
    private String address;

    /**
     * 下述门店数量
     */
    private int shopCount;
}
