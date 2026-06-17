package com.study.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    void testAdd(){
        Calculator calc = new Calculator();
        int result = calc.add(25,35);
        Assertions.assertEquals(25+35,result);
    }
}
