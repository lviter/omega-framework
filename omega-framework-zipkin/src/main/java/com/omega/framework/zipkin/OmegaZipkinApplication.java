package com.omega.framework.zipkin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * @author: lviter
 * @desc:
 * @date:2021/7/27
 */
@EnableZipkinServer
@SpringBootApplication
public class OmegaZipkinApplication {
    public static void main(String[] args) {
        SpringApplication.run(OmegaZipkinApplication.class,args);
    }
}
