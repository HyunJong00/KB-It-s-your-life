package com.study.validator;

public class PasswordValidator {

    public static boolean validate(String password){
        return password.length() >= 8;
    }
}
