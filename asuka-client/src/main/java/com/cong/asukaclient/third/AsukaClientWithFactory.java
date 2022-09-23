package com.cong.asukaclient.third;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "asukaClientWithFactory",url = "http://localhost:12002/",
fallbackFactory = TestFallbackFactory.class)
public interface AsukaClientWithFactory {
    @GetMapping("asuka/test/get")
    String test();
}
