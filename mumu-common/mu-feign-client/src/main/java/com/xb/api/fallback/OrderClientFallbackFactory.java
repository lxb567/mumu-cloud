package com.xb.api.fallback;

import com.xb.api.order.OrderFeignClient;
import org.springframework.cloud.openfeign.FallbackFactory;

public class OrderClientFallbackFactory implements FallbackFactory<OrderFeignClient> {
    @Override
    public OrderFeignClient create(Throwable cause) {
        return null;
    }
}
