package com.xb.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.xb.api")
@EnableDiscoveryClient
public class MuFeignConfig {
    /**
     * 日志
     * @return
     */
    @Bean
    public Logger.Level level(){
        return Logger.Level.FULL;
    }

    /**
     * 重试
     * @return
     */
    @Bean
    public Retryer retryer (){
        return new Retryer.Default(30000,60000,3);
    }


}