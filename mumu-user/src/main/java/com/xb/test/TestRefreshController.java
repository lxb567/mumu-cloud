package com.xb.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试nacos config 配置刷新
 */
@RestController
@RefreshScope
@RequestMapping("/test")
public class TestRefreshController {
    @Value("${mu.author}")
    private String authorName;
    @Value("${mu.date}")
    private String date;

    @GetMapping("/refresh")
    public String testRefresh(){
        return "名字："+authorName +"--- 日期："+date;
    }
}
