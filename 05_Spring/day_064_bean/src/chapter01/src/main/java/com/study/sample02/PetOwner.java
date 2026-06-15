package com.study.sample02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PetOwner {

    @Autowired // 스프링 컨테이너가 가지고 있는 Animal 타입의 객체(bean)를 자동으로 전달
    private Animal animal;
    public void play(){
        System.out.println("반려동물과 놀기");
        animal.sound();
    }
}
