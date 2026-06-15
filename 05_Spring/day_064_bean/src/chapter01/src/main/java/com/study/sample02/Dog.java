package com.study.sample02;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {
    @Override
    public void sound() {
        System.out.println("멍멍");
    }
}
