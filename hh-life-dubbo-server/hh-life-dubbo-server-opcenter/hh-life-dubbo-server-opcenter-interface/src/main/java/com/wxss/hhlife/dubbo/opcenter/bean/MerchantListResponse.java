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
public class MerchantListResponse implements Serializable {

    private static final long serialVersionUID = -8473976234890718026L;
    private List<MerchantListInfo> merInfoList;

}
