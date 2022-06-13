//package com.xb.config;
//
//import org.apache.http.client.HttpClient;
//import org.apache.http.client.config.RequestConfig;
//import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
//import org.apache.http.impl.client.HttpClientBuilder;
//import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.concurrent.TimeUnit;
//
//@Configuration
//public class HttpClientPoolConfig {
//
//    @Bean
//    public HttpClient httpClient(){
//        // 生成默认请求配置
//        RequestConfig.Builder requestConfigBuilder = RequestConfig.custom();
//        // 超时时间 连接建立后，数据传输过程中数据包之间间隔的最大时间
//        requestConfigBuilder.setSocketTimeout(5000);
//        // 连接时间 连接建立时间，即三次握手完成时间
//        requestConfigBuilder.setConnectTimeout(5000);
//        RequestConfig defaultRequestConfig = requestConfigBuilder.build();
//        // 连接池配置
//        // 长连接保持多久
//        final PoolingHttpClientConnectionManager pollingConnectionManager =
//                new PoolingHttpClientConnectionManager(60, TimeUnit.SECONDS);
//        // 总连接数
//        pollingConnectionManager.setMaxTotal(5000);
//        // 同路由的并发数
//        pollingConnectionManager.setDefaultMaxPerRoute(500);
//
//        // httpclient 配置
//        HttpClientBuilder httpClientBuilder = HttpClientBuilder.create();
//        // 保持长连接配置，需要在头添加Keep-Alive
//        httpClientBuilder.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy());
//        httpClientBuilder.setConnectionManager(pollingConnectionManager);
//        httpClientBuilder.setDefaultRequestConfig(defaultRequestConfig);
//        HttpClient client = httpClientBuilder.build();
//
//
//        // 启动定时器，定时回收过期的连接
//        Timer timer = new Timer();
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                pollingConnectionManager.closeExpiredConnections();
//                pollingConnectionManager.closeIdleConnections(5, TimeUnit.SECONDS);
//            }
//        }, 10 * 1000, 5 * 1000);
//        return client;
//    }
//
//
//}