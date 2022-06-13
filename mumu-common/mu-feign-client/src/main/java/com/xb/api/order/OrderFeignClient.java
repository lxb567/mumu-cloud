package com.xb.api.order;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "mu-order")
public interface OrderFeignClient {
}