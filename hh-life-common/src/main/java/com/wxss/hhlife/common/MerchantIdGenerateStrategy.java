package com.wxss.hhlife.common;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.UUID;

@Component
public class MerchantIdGenerateStrategy implements IdGenerateStrategy{

    @Override
    public String seqType() {
        return MERCHANT;
    }

    @Override
    public String generateId(String uid, String orderType) {
        // TODO 暂时使用UUID，待学习分布式ID再完善
        StringBuilder builder = new StringBuilder();
        String uuid = UUID.randomUUID().toString().replace("-","");
        String substring = uuid.substring(10);

        long currentTimeMillis = System.currentTimeMillis();
        String substring1 = String.valueOf(currentTimeMillis).substring(8);
        System.out.println(currentTimeMillis);
        return builder.append(substring).append(substring1).toString();
    }
}
