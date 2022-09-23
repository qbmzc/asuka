package com.cong.asukaclient.third;

import org.springframework.cloud.client.circuitbreaker.NoFallbackAvailableException;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class TestFallbackFactory implements FallbackFactory<AsukaClientWithFactory> {


    @Override
    public AsukaClientWithFactory create(Throwable cause) {
        return new FallbackWithFactory();
    }

    static class FallbackWithFactory implements AsukaClientWithFactory {

        @Override
        public String test() {
            throw new RuntimeException("服务调用失败");
        }
    }
}
