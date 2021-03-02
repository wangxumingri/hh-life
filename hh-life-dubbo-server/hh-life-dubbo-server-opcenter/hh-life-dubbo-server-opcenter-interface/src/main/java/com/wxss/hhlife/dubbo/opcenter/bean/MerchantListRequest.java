package com.wxss.hhlife.dubbo.opcenter.bean;

import com.wxss.hhlife.base.BaseFacadeReq;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MerchantListRequest extends BaseFacadeReq {
    private int pageNumber ;
    private int pageSize ;

    /**商户编号*/
    private String merchantId;
    /**商户名称*/
    private String merchantName;
    /**
     * 商户状态:NORMAL-正常 、EXPIRED-过期、FREEZED-过期
     */
    private String merchantStatus;
    /**
     * 联系人手机号
     */
    private String contactPhone;

    /**
     * 审核状态
     */
    private String auditStatus;

    /**
     * 创建开始时间
     */
    private Date createStartTime;

    /**
     * 创建结束时间
     */
    private Date createEndTime;

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
}
