package com.wxss.hhlife.base;

@SuppressWarnings("unchecked")
public class RestResultBuilder {

    private static final Boolean SUCCESS = true;
    private static final Boolean FAILURE = false;

    public static RestResultVO success(){
        RestResultVO response = new RestResultVO();
        response.setSuccess(SUCCESS);
        response.setResultCode(RestResultCode.SUCCESS.getCode());
        response.setResultMessage(RestResultCode.SUCCESS.getMessage());

        return response;
    }

    public static <T> RestResultVO<T> success(T data){
        RestResultVO<T>  response = RestResultBuilder.success();
        response.setData(data);
        return response;
    }

    public static RestResultVO failure(){
        RestResultVO response = new RestResultVO();
        response.setSuccess(false);
        response.setResultCode(RestResultCode.SYSTEM_ERROR.getCode());
        response.setResultMessage(RestResultCode.SYSTEM_ERROR.getMessage());

        return response;
    }

    public static <T> RestResultVO failure(RestResultCode responseInfo){
        RestResultVO<T> response = new RestResultVO();
        response.setSuccess(false);
        response.setResultCode(responseInfo.getCode());
        response.setResultMessage(responseInfo.getMessage());

        return response;
    }

    public static  RestResultVO failure(String message,String code){
        RestResultVO response = new RestResultVO();
        response.setSuccess(false);
        response.setResultCode(code);
        response.setResultMessage(message);

        return response;
    }
}
