package com.xb.controller;

import com.xb.api.user.UserFeignClient;
import com.xb.domain.User;
import com.xb.domain.UserQueryParam;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/test")
public class TestFeignController {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{id}/info")
    public String testFeign(@PathVariable Long id) {
        return userFeignClient.getUserInfo(id);
    }

    @GetMapping("/user/use/less")
    public String useless() {
        return userFeignClient.useless();
    }

    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Long id) {
        return userFeignClient.getUserById(id);
    }

    @GetMapping("/user/list")
    public List<User> queryUserList(UserQueryParam userQueryParam) {
        return userFeignClient.queryUserList(userQueryParam);
    }
    @GetMapping("/default/{ok}")
    public String testSentinel(@PathVariable("ok") boolean ok) {

        return userFeignClient.defaultConfig(ok);
    }
}
