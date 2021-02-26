package com.wxss.hhlife.base;

public class FacadeCommonRespBuilder {

    public static <T>  BaseFacadeResp<T>  successNoData(BaseFacadeReq req){
        return new BaseFacadeResp<>(Boolean.TRUE, req != null ? req.getRequestId() : null,null );
    }

    public static <T>  BaseFacadeResp<T>  success(BaseFacadeReq req,T data){
        return new BaseFacadeResp<>(Boolean.TRUE, req != null ? req.getRequestId() : null,data );
    }

    /**
     * 使用默认Code和Msg
     * @param req
     * @param <T>
     * @return
     */
    public static <T>  BaseFacadeResp<T>  fail(BaseFacadeReq req){
        return new BaseFacadeResp<>(Boolean.FALSE, req != null ? req.getRequestId() : null,null);
    }

    public static <T>  BaseFacadeResp<T>  fail(BaseFacadeReq req,String resultCode,String resultMsg,T data){
        return new BaseFacadeResp<>(Boolean.FALSE, req != null ? req.getRequestId() : null,data,resultCode,resultMsg );
    }

    public static <T>  BaseFacadeResp<T>  fail(BaseFacadeReq req,String resultCode,String resultMsg){
        return new BaseFacadeResp<>(Boolean.FALSE, req != null ? req.getRequestId() : null,null ,resultCode,resultMsg);
    }


    public static <T>  BaseFacadePageResp<T>  successPage(BaseFacadeReq req,T data,Page page){
        return new BaseFacadePageResp<>(Boolean.TRUE, req != null ? req.getRequestId() : null,data,page );
    }


    public static <T>  BaseFacadePageResp<T>  failPage(BaseFacadeReq req,T data,Page page){
        return new BaseFacadePageResp<>(Boolean.FALSE, req != null ? req.getRequestId() : null,data,page );
    }


}
