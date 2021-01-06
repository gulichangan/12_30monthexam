package com.hanyouli.app;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDubboConfig
@DubboComponentScan("com.hanyouli")
@ComponentScan("com.hanyouli")
@MapperScan("com.hanyouli.dao")
public class ServiceApp {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApp.class,args);
    }
}
