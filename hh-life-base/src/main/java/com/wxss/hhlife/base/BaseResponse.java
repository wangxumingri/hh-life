package com.wxss.hhlife.base;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class BaseResponse<T> {
    private Boolean success;
    private String resultCode;
    private String resultMessage;
    private T data;
}
