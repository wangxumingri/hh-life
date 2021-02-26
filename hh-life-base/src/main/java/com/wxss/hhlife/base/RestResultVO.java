package com.wxss.hhlife.base;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class RestResultVO<T> {
    private Boolean success;
    private String resultCode;
    private String resultMessage;
    private T data;
}
