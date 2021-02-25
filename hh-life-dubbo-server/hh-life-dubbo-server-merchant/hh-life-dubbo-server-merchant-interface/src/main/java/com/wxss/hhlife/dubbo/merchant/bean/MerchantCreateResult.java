package com.wxss.hhlife.dubbo.merchant.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class MerchantCreateResult implements Serializable {
    private Boolean success;
    private String message;
    private Object data;
}
