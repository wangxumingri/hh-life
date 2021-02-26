package com.wxss.hhlife.api.opcenter.support;

import com.wxss.hhlife.base.RestResultBuilder;
import com.wxss.hhlife.base.RestResultVO;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({Throwable.class,Exception.class})
    public RestResultVO handlerException(){
        return RestResultBuilder.failure();
    }
}
