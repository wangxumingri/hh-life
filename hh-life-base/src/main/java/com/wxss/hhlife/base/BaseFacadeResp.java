package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class BaseFacadeResp<T> implements Serializable {
    private static final long serialVersionUID = -2635631514605171438L;


    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    private static final String DEFAULT_FAILURE_MESSAGE = "操作失败";
    private static final String DEFAULT_SUCCESS_CODE= "000000";
    private static final String DEFAULT_FAILURE_CODE = "999999";

    private Boolean success;
    private String resultCode;
    private String resultMsg;

    /**
     * 唯一请求ID
     */
    private String requestId;
    /**
     * 请求渠道
     */
    private String channelCode;

    private T data;

    public BaseFacadeResp() {
    }

    public BaseFacadeResp(Boolean success) {
        this.success = success;
        if (success){
            this.resultMsg = DEFAULT_SUCCESS_MESSAGE;
            this.resultCode = DEFAULT_SUCCESS_CODE;
        }else {
            this.resultMsg = DEFAULT_FAILURE_MESSAGE;
            this.resultCode = DEFAULT_FAILURE_CODE;
        }
    }

    public BaseFacadeResp(Boolean success, String requestId) {
        this(success);
        this.requestId = requestId;
    }

    public BaseFacadeResp(Boolean success, String requestId, T data) {
        this(success,requestId);
        this.data = data;
    }

    public BaseFacadeResp(Boolean success,  String requestId,T data,String resultCode, String resultMsg ) {
        this.success = success;
        this.resultCode = resultCode;
        this.resultMsg = resultMsg;
        this.requestId = requestId;
        this.data = data;
    }
}
