package com.study.sample02;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@AllArgsConstructor
//@Component
public class CalcAdd implements Calc {
    private int x, y;

    public CalcAdd(@Value("25") int x, @Value("31") int y){
        this.x =x;
        this.y =y;
    }

    @Override
    public void calculate() {
        System.out.println(x + " + " + y + " = " + (x+y));
    }
}
