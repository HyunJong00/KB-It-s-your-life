package com.study.sample03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderService {

    @Autowired
    private Payment payment;

    public void order(String menu, int price) {
        System.out.println("[주문접수] " + menu + "주문이 들어왔어요");
        payment.pay(price);
    }
}
