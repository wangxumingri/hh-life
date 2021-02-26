package com.wxss.hhlife.dubbo.opcenter.model;

import com.wxss.hhlife.base.BaseModel;

import java.util.Date;

public class MerchantApply extends BaseModel {
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
    private Date contractStartDate;

    /**
    * 合同截止时间
    */
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

    public Long getMerchantApplyId() {
        return merchantApplyId;
    }

    public void setMerchantApplyId(Long merchantApplyId) {
        this.merchantApplyId = merchantApplyId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantStatus() {
        return merchantStatus;
    }

    public void setMerchantStatus(String merchantStatus) {
        this.merchantStatus = merchantStatus;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getDetailAddr() {
        return detailAddr;
    }

    public void setDetailAddr(String detailAddr) {
        this.detailAddr = detailAddr;
    }

    public Long getFirstOrgId() {
        return firstOrgId;
    }

    public void setFirstOrgId(Long firstOrgId) {
        this.firstOrgId = firstOrgId;
    }

    public Long getSecondOrgId() {
        return secondOrgId;
    }

    public void setSecondOrgId(Long secondOrgId) {
        this.secondOrgId = secondOrgId;
    }

    public Long getThirdOrgId() {
        return thirdOrgId;
    }

    public void setThirdOrgId(Long thirdOrgId) {
        this.thirdOrgId = thirdOrgId;
    }

    public Long getIncomingId() {
        return incomingId;
    }

    public void setIncomingId(Long incomingId) {
        this.incomingId = incomingId;
    }

    public String getIncomingType() {
        return incomingType;
    }

    public void setIncomingType(String incomingType) {
        this.incomingType = incomingType;
    }

    public Long getAuditJnlNo() {
        return auditJnlNo;
    }

    public void setAuditJnlNo(Long auditJnlNo) {
        this.auditJnlNo = auditJnlNo;
    }

    public String getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
    }

//    public Date getCreateTime() {
//        return createTime;
//    }
//
//    public void setCreateTime(Date createTime) {
//        this.createTime = createTime;
//    }
//
//    public Date getUpdateTime() {
//        return updateTime;
//    }
//
//    public void setUpdateTime(Date updateTime) {
//        this.updateTime = updateTime;
//    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getAcctType() {
        return acctType;
    }

    public void setAcctType(String acctType) {
        this.acctType = acctType;
    }

    public String getAcctName() {
        return acctName;
    }

    public void setAcctName(String acctName) {
        this.acctName = acctName;
    }

    public String getOpenBankName() {
        return openBankName;
    }

    public void setOpenBankName(String openBankName) {
        this.openBankName = openBankName;
    }

    public String getOpenBankId() {
        return openBankId;
    }

    public void setOpenBankId(String openBankId) {
        this.openBankId = openBankId;
    }

    public String getOpenProvinceId() {
        return openProvinceId;
    }

    public void setOpenProvinceId(String openProvinceId) {
        this.openProvinceId = openProvinceId;
    }

    public String getOpenProvinceName() {
        return openProvinceName;
    }

    public void setOpenProvinceName(String openProvinceName) {
        this.openProvinceName = openProvinceName;
    }

    public String getOpenCityId() {
        return openCityId;
    }

    public void setOpenCityId(String openCityId) {
        this.openCityId = openCityId;
    }

    public String getOpenCityName() {
        return openCityName;
    }

    public void setOpenCityName(String openCityName) {
        this.openCityName = openCityName;
    }

    public String getOpenNetId() {
        return openNetId;
    }

    public void setOpenNetId(String openNetId) {
        this.openNetId = openNetId;
    }

    public String getOpenNetName() {
        return openNetName;
    }

    public void setOpenNetName(String openNetName) {
        this.openNetName = openNetName;
    }

    public Boolean getIsSignCoupon() {
        return isSignCoupon;
    }

    public void setIsSignCoupon(Boolean isSignCoupon) {
        this.isSignCoupon = isSignCoupon;
    }

    public Boolean getIsSignOnlinePay() {
        return isSignOnlinePay;
    }

    public void setIsSignOnlinePay(Boolean isSignOnlinePay) {
        this.isSignOnlinePay = isSignOnlinePay;
    }
}