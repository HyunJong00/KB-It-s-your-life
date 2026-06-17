package com.study.sample01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringMain {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        MessageBeanImpl messageBean = (MessageBeanImpl) context.getBean("messageBeanImpl");
        messageBean.sayHello();
        messageBean.sayHello("사과", 10000);
        messageBean.sayHello("수박", 25000, 1);

    }
}
