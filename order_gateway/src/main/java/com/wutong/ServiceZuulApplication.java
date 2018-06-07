package com.wutong;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by zzg on 2018/6/6.
 */

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
@EnableTurbine
@EnableCircuitBreaker
public class ServiceZuulApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(ServiceZuulApplication.class).web(true).run(args);
    }

}
