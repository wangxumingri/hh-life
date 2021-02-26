package com.wxss.hhlife.api.opcenter.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MerchantCreateRequest {
    private Long merchantApplyId;

    /**
     * 商户编号
     */
    private String merchantId;

    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 商户状态:NORMAL-正常 、EXPIRED-过期、FREEZED-过期
     */
    private String merchantStatus;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 联系人手机号
     */
    private String contactPhone;

    /**
     * 合同开始时间
     */

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date contractStartDate;

    /**
     * 合同截止时间
     */

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
    private Date contractEndDate;

    /**
     * 省/直辖市编号
     */
    private Integer provinceId;

    /**
     * 市/直辖市编号
     */
    private Integer cityId;

    /**
     * 县/区编号
     */
    private Integer areaId;

    /**
     * 商户详细地址
     */
    private String detailAddr;

    /**
     * 一级机构编号
     */
    private Long firstOrgId;

    /**
     * 二级机构编号
     */
    private Long secondOrgId;

    /**
     * 三级机构编号
     */
    private Long thirdOrgId;

    /**
     * 进件记录编号
     */
    private Long incomingId;

    /**
     * 进件记录类型
     */
    private String incomingType;

    /**
     * 审核批次
     */
    private Long auditJnlNo;

    /**
     * 审核状态
     */
    private String auditStatus;


    /**
     * 结算账号
     */
    private String acctNo;

    /**
     * 结算账号类型
     */
    private String acctType;

    /**
     * 结算账号开户名
     */
    private String acctName;

    /**
     * 结算账号开户银行
     */
    private String openBankName;

    /**
     * 结算账号开户银行编号
     */
    private String openBankId;

    private String openProvinceId;

    private String openProvinceName;

    private String openCityId;

    private String openCityName;

    private String openNetId;

    private String openNetName;

    /**
     * 是否支持优惠券
     */
    private Boolean isSignCoupon;

    /**
     * 是否支持在线买单
     */
    private Boolean isSignOnlinePay;
}
