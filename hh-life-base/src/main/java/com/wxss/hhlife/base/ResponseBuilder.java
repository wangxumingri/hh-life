package com.wxss.hhlife.base;

public class ResponseBuilder {

    public static BaseResponse success(){
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setResultCode(ResponseInfo.SUCCESS.getCode());
        response.setResultMessage(ResponseInfo.SUCCESS.getMessage());

        return response;
    }

    public static <T> BaseResponse success(T data){
        BaseResponse response = new BaseResponse();
        response.setSuccess(true);
        response.setResultCode(ResponseInfo.SUCCESS.getCode());
        response.setResultMessage(ResponseInfo.SUCCESS.getMessage());
        response.setData(data);
        return response;
    }

    public static  BaseResponse failure(){
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setResultCode(ResponseInfo.SYSTEM_ERROR.getCode());
        response.setResultMessage(ResponseInfo.SYSTEM_ERROR.getMessage());

        return response;
    }

    public static <T> BaseResponse failure(ResponseInfo responseInfo){
        BaseResponse response = new BaseResponse();
        response.setSuccess(false);
        response.setResultCode(responseInfo.getCode());
        response.setResultMessage(responseInfo.getMessage());

        return response;
    }
}
