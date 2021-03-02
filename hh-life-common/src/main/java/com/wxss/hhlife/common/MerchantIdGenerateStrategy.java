package com.wxss.hhlife.common;

import com.wxss.hhlife.common.enums.SeqType;
import org.springframework.stereotype.Component;


@Component
public class MerchantIdGenerateStrategy implements IdGenerateStrategy{

    @Override
    public String seqType() {
        return MERCHANT;
    }

    @Override
    public String generateId(String uid, String orderType) {
        // 雪花算术生成的ID
        String snowflakeId = SnowflakeUtils.generateId();
        return SeqType.MERCHANT.getIdPrefix() + snowflakeId;
    }
}
