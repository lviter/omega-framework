package com.omega.framework.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author: lviter
 * @desc:
 * @date:2021/7/23
 */
@EnableEurekaServer
@SpringBootApplication
public class OmegaEurekaApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmegaEurekaApplication.class, args);
    }
}
