package com.xb.test;

import com.google.gson.JsonObject;
import com.xb.domain.User;
import com.xb.domain.UserQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试openFeign
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserInfoController {
    @GetMapping("/{userId}/info")
    public Object userInfo(@PathVariable("userId") long userId) throws InterruptedException {
//        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("id",userId);
//        jsonObject.addProperty("name","lxb");
//        jsonObject.addProperty("skill","java");
//        jsonObject.addProperty("age",30);
//        jsonObject.addProperty("sex","男");
//        return jsonObject.toString();
        throw new RuntimeException();
//        Thread.sleep(10000);
//        return "lxb";
    }

    @GetMapping("/use/less")
    public String useless(){
        return "useless";
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id) throws InterruptedException {

        if(id <1){
            throw new RuntimeException("参数有误");
        }
        return User.builder().username("xxx").password("xxx").id(2L).phone("152xxx").build();
    }

    @GetMapping("/list")
    public List<User> queryUserList(UserQueryParam userQueryParam){
        if(userQueryParam == null){
            throw new RuntimeException("参数都没有");
        }
        log.info("userQueryParam->: {}",userQueryParam);
        List<User> list = new ArrayList<>();
        list.add(User.builder().username("xxx").password("xxx").id(2L).phone("152xxx").build());
        return list;
    }

    @GetMapping("/default/{ok}")
    public String defaultTest(@PathVariable("ok") boolean ok) {
        if(ok) {
            return "ok";
        }
        throw new RuntimeException("不太ok啊");
    }

}
