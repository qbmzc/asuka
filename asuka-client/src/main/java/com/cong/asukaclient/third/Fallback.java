package com.cong.asukaclient.third;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Fallback implements AsukaService{
    @Override
    public String getTest() {
        log.error("服务不可用");
        throw new NoFallbackAvailableException("服务调用失败",new RuntimeException());
    }
}
