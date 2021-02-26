package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class BaseFacadeReq implements Serializable {


    private static final long serialVersionUID = 1146000928614408279L;
    /**
     * 唯一请求ID
     */
    private String requestId;
    /**
     * 请求渠道
     */
    private String channelCode;

    /**
     * Model类型封装：减少字段构建
     */
    private String jsonEncapsulatedValue;
}
