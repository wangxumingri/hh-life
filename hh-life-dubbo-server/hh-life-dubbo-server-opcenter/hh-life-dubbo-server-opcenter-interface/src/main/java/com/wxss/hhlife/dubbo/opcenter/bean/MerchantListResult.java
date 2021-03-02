package com.wxss.hhlife.dubbo.opcenter.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class MerchantListResult implements Serializable {
    private static final long serialVersionUID = -7357502580114535765L;
    private List<MerchantListInfo> merInfoList;
}
