//package com.xb.config;
//
//import okhttp3.ConnectionPool;
//import okhttp3.OkHttpClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class OKHttpClientPoolConfig {
//
//    @Bean
//    public OkHttpClient okHttpClient() {
//
//        return new OkHttpClient.Builder()
//                //  设置连接超时
//                .connectTimeout(5, TimeUnit.SECONDS)
//                //  设置读取超时
//                .readTimeout(5, TimeUnit.SECONDS)
//                //  设置写入超时
//                .writeTimeout(5, TimeUnit.SECONDS)
//                //  设置连接失败重试
//                .retryOnConnectionFailure(true)
//                //  设置最大连接数 和 保持连接时间
//                .connectionPool(new ConnectionPool(100, 30L, TimeUnit.SECONDS))
//                .build();
//    }
//
//}