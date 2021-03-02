package com.wxss.hhlife.common.enums;

public enum SeqType {
    MERCHANT("MERCHANT","01"),
    SHOP("SHOP","02");

    private final String seqType;
    private final String idPrefix;

    SeqType(String seqType, String idPrefix) {
        this.seqType = seqType;
        this.idPrefix = idPrefix;
    }

    public String getSeqType() {
        return seqType;
    }

    public String getIdPrefix() {
        return idPrefix;
    }
}
