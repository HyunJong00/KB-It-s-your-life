package com.study.sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class MessageBeanImpl implements MessageBean {
    @NonNull
    private String fruit;
    // setter 주입
    @Setter
    private int cost;
    @Setter
    private int qty;

    // 생성자 주입
//    public MessageBeanImpl(String fruit) {
//        this.fruit = fruit;
//    }

    @Override
    public void sayHello() {
        System.out.println(fruit +"\t" + cost + "\t" + qty);
    }

    @Override
    public void sayHello(String fruit, int cost) {
        System.out.println(fruit +"\t" + cost + "\t" + qty);
    }

    @Override
    public void sayHello(String fruit, int cost, int qty) {
        System.out.println(fruit +"\t" + cost + "\t" + qty);
    }
}
