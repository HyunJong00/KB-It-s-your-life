package com.study.sample03;

import org.springframework.stereotype.Component;

//@Component
public class TossPayment implements Payment {
    @Override
    public void pay(int amount) {
        System.out.println("토스페이로 " + amount + "원 결제");
    }
}
