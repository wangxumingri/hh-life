package com.wxss.hhlife.api.merchant;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubbo
public class MerchantDubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerchantDubboConsumerApplication.class,args);
    }
}
