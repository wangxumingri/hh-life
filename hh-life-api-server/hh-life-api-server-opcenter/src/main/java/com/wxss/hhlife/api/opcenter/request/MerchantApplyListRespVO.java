package com.wxss.hhlife.api.opcenter.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MerchantApplyListRespVO {
    private int pageSize;
    private int pageNum;
    private int rowTotal;

    private List<MerchantApplyListInfoVO> merchantApplyInfo;
}
