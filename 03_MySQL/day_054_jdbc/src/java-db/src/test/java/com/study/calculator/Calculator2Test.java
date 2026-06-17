package com.study.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Calculator2Test {

    @Test
    void mul() {
        Calculator2 calc = new Calculator2();
        int result = calc.mul(12,5);
        Assertions.assertEquals(60, result);
    }
}