package com.wxss.hhlife.api.opcenter.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MerchantListInfoVO {
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
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
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
