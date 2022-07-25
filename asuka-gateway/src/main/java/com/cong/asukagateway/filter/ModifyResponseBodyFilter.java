package com.cong.asukagateway.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Locale;

@Slf4j
@Configuration
public class ModifyResponseBodyFilter {


    private final static String uri="http://127.0.0.1:12001";
    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder,ObjectMapper objectMapper) {
        log.info("修改响应值");
        return builder.routes()
                .route("rewrite_response_upper", r -> r.path("/asuka/**")
                        .filters(f -> f
                                .modifyResponseBody(String.class, String.class,
                                (exchange, s) -> Mono.just(s))).uri(uri))
                .build();

    }


}
