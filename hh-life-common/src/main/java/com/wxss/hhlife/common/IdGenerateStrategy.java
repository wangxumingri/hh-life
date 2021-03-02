package com.wxss.hhlife.common;

public interface IdGenerateStrategy {
    String MERCHANT = "MERCHANT";

    String seqType();
    String generateId(String uid,String orderType);
}
