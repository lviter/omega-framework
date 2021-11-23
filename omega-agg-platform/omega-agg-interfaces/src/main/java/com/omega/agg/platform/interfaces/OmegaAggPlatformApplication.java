package com.omega.agg.platform.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author: lviter
 * @desc:
 * @date:2021/11/23
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.omega.**"})
@EnableEurekaClient
public class OmegaAggPlatformApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmegaAggPlatformApplication.class, args);
    }
}
