package com.xb.api.fallback;


import com.xb.api.user.UserFeignClient;
import com.xb.domain.User;
import com.xb.domain.UserQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class UserClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    public UserFeignClient create(Throwable cause) {
        log.error("<<<<< user feign client fallback: {} >>>>>",cause.getMessage());
        return new UserFeignClient() {
            public String getUserInfo(Long userId) {
                return "userInfoFallBack";
            }

            public String useless() {
                return null;
            }

            public User getUserById(Long id) {
                return User.builder().avatar("http://fb.com").createTime(new Date()).id(1L).password("fb").username("fb").build();
            }

            public List<User> queryUserList(UserQueryParam userQueryParam) {
                List<User> list = new ArrayList<>();
                User userById = getUserById(1L);
                list.add(userById);
                return list;
            }
        };
    }


}
