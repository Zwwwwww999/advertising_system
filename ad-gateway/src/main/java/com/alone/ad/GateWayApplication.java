package com.alone.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName GeteWayApplication
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/19 19:48
 * @Description GeteWayApplication
 * @Version 1.0
 */

@SpringBootApplication
@EnableEurekaClient

public class GateWayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateWayApplication.class, args);
    }
}
