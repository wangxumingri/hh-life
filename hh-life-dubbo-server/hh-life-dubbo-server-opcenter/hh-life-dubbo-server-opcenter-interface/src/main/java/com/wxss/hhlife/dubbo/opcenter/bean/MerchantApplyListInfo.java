package com.wxss.hhlife.dubbo.opcenter.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

//
@Getter
@Setter
@ToString
@NoArgsConstructor
public class MerchantApplyListInfo implements Serializable {

    private static final long serialVersionUID = -4464169960931301968L;
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
