package com.wxss.hhlife.api.opcenter.request;

import com.wxss.hhlife.dubbo.opcenter.bean.MerchantListInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MerchantListRespVO {
    private int pageSize;
    private int pageNum;
    private int rowTotal;

    private List<MerchantListInfoVO> merchantInfo;
}
