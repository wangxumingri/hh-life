package com.wxss.hhlife.dubbo.opcenter;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubbo
@MapperScan(basePackages = "com.wxss.hhlife.dubbo.opcenter.mapper")
@ComponentScan(basePackages = {"com.wxss.hhlife.dubbo.opcenter.*","com.wxss.hhlife.common"})
public class OpcenterDubboProviderApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(OpcenterDubboProviderApplication.class)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}
