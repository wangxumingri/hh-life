package com.wxss.hhlife.common;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class IdGenerateAdapter implements InitializingBean {
    private Map<String,IdGenerateStrategy>  idGenerateStrategy = Collections.synchronizedMap(new HashMap<>());
    @Autowired
    private ApplicationContext applicationContext;

    public String generateId(String seqType,String userId,String orderType){
        return idGenerateStrategy.get(seqType).generateId(userId,orderType);
    }

    @Override
    public void afterPropertiesSet() {
        for (IdGenerateStrategy strategy : applicationContext.getBeansOfType(IdGenerateStrategy.class).values()) {
            idGenerateStrategy.put(strategy.seqType(),strategy);
        }
    }
}
