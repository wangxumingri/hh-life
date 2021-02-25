package com.wxss.hhlife.base;

public enum RestResultCode {
    SUCCESS("000000","操作成功"),
    SYSTEM_ERROR("999999","系统异常");
    private String code;
    private String message;

    RestResultCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
