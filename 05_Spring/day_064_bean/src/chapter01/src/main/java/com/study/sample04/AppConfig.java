package com.study.sample04;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.study.sample04") // 빈 탐색
public class AppConfig {

    // 빈 등록
    @Bean
    public HelloService helloService(){
        return new HelloService();
    }
}
