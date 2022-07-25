package com.cong.asukagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class AsukaGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsukaGatewayApplication.class, args);
    }

}
