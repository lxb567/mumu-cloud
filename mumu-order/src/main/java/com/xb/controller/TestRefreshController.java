package com.xb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Spring Cloud Alibaba 2021.0.1.0 升级指南
 * https://github.com/alibaba/spring-cloud-alibaba/blob/2021.x/spring-cloud-alibaba-docs/src/main/asciidoc-zh/sca-upgrade-guide.adoc
 */

@RestController
@RefreshScope
public class TestRefreshController {
    @Value("${user.name}")
    private String username;

    @Value("${user.age}")
    private Integer age;


    @RequestMapping("/user/test")
    public String test(){
        return username + "----------" + age;
    }
}
