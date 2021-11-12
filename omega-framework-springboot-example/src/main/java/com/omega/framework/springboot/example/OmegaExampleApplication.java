package com.omega.framework.springboot.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author lviter
 * @Description
 * @Date 12:09 2021/6/24
 * @Desc: Warning!Warning!!Warning!!!
 **/
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.omega.framework.**"})
@EnableEurekaClient
public class OmegaExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmegaExampleApplication.class, args);
    }
}
