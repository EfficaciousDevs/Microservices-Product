package com.springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceCouponApplication {

    public static void main(String[] args) {

        SpringApplication.run(MicroserviceCouponApplication.class, args);
    }

}
