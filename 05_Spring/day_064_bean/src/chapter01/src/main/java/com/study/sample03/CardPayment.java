package com.study.sample03;

import org.springframework.stereotype.Component;

@Component
public class CardPayment implements Payment{
    @Override
    public void pay(int amount) {
        System.out.println("신용 카드로 " + amount + "원 결제");
    }
}
