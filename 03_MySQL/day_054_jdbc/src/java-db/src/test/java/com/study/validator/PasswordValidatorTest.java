package com.study.validator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    @Test
    public void under_8(){
        String password = "abcde";
        boolean result = PasswordValidator.validate(password);
        Assertions.assertFalse(result);
    }


    @Test
    public void over_8(){
        String password = "abcd12345";
        boolean result = PasswordValidator.validate(password);
        Assertions.assertTrue(result);
    }
}
