package com.study.sample01;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageBeanImpl implements MessageBean {
    private String fruit;
    private int cost;
    private int qty;

    public MessageBeanImpl(@Value("딸기") String fruit) {
        this.fruit = fruit;
    }

    @Autowired
    public void setCost(@Value("5000") int cost) {
        this.cost = cost;
    }

    public void setQty(@Value("5") int qty) {
        this.qty = qty;
    }

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
