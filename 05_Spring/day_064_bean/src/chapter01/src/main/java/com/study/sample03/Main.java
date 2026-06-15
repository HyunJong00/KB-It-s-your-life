package com.study.sample03;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;


@Configuration
@ComponentScan(basePackages = "com.study.sample03")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        OrderService orderService = context.getBean(OrderService.class);
        orderService.order("햄벅", 5000);
    }
}
