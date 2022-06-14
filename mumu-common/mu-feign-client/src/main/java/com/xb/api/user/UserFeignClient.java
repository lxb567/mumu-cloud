package com.xb.api.user;

import com.xb.api.fallback.UserClientFallbackFactory;
import com.xb.config.MuFeignConfig;
import com.xb.domain.User;
import com.xb.domain.UserQueryParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//@FeignClient(name = "mu-user",fallback = UserClientFallback.class)
@FeignClient(name = "mu-user",path = "/user",configuration = MuFeignConfig.class,fallbackFactory = UserClientFallbackFactory.class)
public interface UserFeignClient {
    @GetMapping("/{userId}/info")
    String getUserInfo(@PathVariable("userId") Long userId);

    @GetMapping("/less")
    String useless();

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") Long id);

    @GetMapping("/list")
    List<User> queryUserList(@SpringQueryMap UserQueryParam userQueryParam);

    @GetMapping("/default/{ok}")
    String defaultConfig(@PathVariable("ok") boolean ok);
}