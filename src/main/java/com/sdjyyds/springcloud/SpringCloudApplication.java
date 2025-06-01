package com.sdjyyds.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer//开启Eureka服务端功能
public class SpringCloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudApplication.class, args);
    }

}
