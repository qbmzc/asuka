package com.cong.asukaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;


@EnableEurekaClient
@SpringBootApplication
public class AsukaServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsukaServiceApplication.class, args);
    }


}
