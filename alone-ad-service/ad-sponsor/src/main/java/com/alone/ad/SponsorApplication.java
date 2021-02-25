package com.alone.ad;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ClassName Application
 * @Author zzzzwwwwwwwwwwwwww
 * @Date 2021/2/24 23:44
 * @Description Application
 * @Version 1.0
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
@ComponentScan({"com.alone.ad.mapper"})
public class SponsorApplication {

    public static void main(String[] args) {
        SpringApplication.run(SponsorApplication.class,args);
    }
}
