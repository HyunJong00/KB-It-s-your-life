package com.study.sample02;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 그냥 자바 아닌 스프링
// new 하지 않고 context에 Bean으로 등록해서 사용
@Configuration
@ComponentScan(basePackages = "com.study.sample02")
public class Main {
    public static void main(String[] args) {
        // 스프링 컨테이너
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        // 빈 얻기

        PetOwner owner = context.getBean(PetOwner.class);
        owner.play();
    }
}
