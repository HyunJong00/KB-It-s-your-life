package com.study.sample01;

public class MessageBeanImpl implements MessageBean {
    private int num;

    public MessageBeanImpl(int num) {
        this.num = num;
    }

    @Override
    public void sayHello(String name) {
        System.out.println("안녕하세요"+name+"님");
    }
}
