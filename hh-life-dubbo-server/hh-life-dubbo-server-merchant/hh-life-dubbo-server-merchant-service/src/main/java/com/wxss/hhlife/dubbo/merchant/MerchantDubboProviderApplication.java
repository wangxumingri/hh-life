package com.wxss.hhlife.dubbo.merchant;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
//@EnableDubbo
@EnableDubbo
//@org.apache.dubbo.config.spring.context.annotation.EnableDubbo
public class MerchantDubboProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(MerchantDubboProviderApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
