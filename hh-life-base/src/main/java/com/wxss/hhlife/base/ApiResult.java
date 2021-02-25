package com.wxss.hhlife.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class ApiResult<T> implements Serializable {
    private static final String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    private static final String DEFAULT_FAILURE_MESSAGE = "操作失败";

    private Boolean success;
    private String message;
    private T data;

    public static  ApiResult buildSuccess(){
        ApiResult apiResult = new ApiResult();
        apiResult.setSuccess(true);
        apiResult.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return apiResult;
    }

    public static <T> ApiResult buildSuccess(T data){
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setSuccess(true);
        apiResult.setMessage(DEFAULT_SUCCESS_MESSAGE);
        apiResult.setData(data);
        return apiResult;
    }

    public static <T> ApiResult buildFailure(String message){
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setSuccess(false);
        apiResult.setMessage(message);
        return apiResult;
    }

    public static <T> ApiResult buildFailure(){
        ApiResult<T> apiResult = new ApiResult<T>();
        apiResult.setSuccess(false);
        apiResult.setMessage(DEFAULT_FAILURE_MESSAGE);
        return apiResult;
    }
}
