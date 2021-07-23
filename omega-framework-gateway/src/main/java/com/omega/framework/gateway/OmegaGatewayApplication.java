package com.omega.framework.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author: lviter
 * @desc:
 * @date:2021/7/23
 */
@SpringBootApplication
@EnableEurekaClient
public class OmegaGatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmegaGatewayApplication.class, args);
    }
}
