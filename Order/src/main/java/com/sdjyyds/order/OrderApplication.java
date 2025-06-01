package com.sdjyyds.order;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@MapperScan("com.sdjyyds.order.mapper")
@SpringBootApplication
public class OrderApplication {

    /**
     * 创建并配置一个带有负载均衡功能的 RestTemplate Bean。
     * 
     * RestTemplate 是 Spring 提供的一个用于执行 HTTP 请求的客户端工具。
     * 通过添加 @LoadBalanced 注解，可以为 RestTemplate 启用客户端负载均衡能力，
     * 这在使用服务发现（如 Eureka）时非常有用，可以让请求自动路由到可用的服务实例。
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

}
