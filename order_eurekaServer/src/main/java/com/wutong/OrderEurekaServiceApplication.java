package com.wutong;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OrderEurekaServiceApplication {
    public static void main(String args[]) {
        SpringApplication.run(OrderEurekaServiceApplication.class, args);
    }

}
