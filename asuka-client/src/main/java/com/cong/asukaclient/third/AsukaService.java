package com.cong.asukaclient.third;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "asuka-service",fallback = Fallback.class)
public interface AsukaService {

    @GetMapping("asuka/test/get")
     String getTest();
}
