package com.study.sample02;

import lombok.Setter;

@Setter
public class CalcMul implements Calc {
    private int x,y;

    public CalcMul(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void calculate() {
        System.out.println(x + " * " + y + " = " + (x*y));
    }
}
