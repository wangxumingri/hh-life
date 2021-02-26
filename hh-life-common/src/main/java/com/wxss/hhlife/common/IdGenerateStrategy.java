package com.wxss.hhlife.common;

public interface IdGenerateStrategy {
    final String MERCHANT = "MERCHANT";

    String seqType();
    String generateId(String uid,String orderType);
}
