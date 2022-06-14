package com.xb.api.order;

import com.xb.api.fallback.OrderClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "mu-order",fallbackFactory = OrderClientFallbackFactory.class)
public interface OrderFeignClient {


}