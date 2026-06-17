package com.study.sample01;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("messageBean")
@Scope("prototype")
public class MessageBeanImpl implements MessageBean {
    private int num;

    public MessageBeanImpl() {
        System.out.println("기본 생성자");
    }

    @Override
    public void sayHello(String name) {
        num++;
        System.out.println("num: " + num);
        System.out.println("안녕하세요 "+name+"님");
    }
}
