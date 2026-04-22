package day_031_try_catch.src.reflection;

import java.lang.reflect.Method;

public class ClassTest {
    public static void main(String[] args) {
        Class<String> clazz = String.class;
        System.out.println("clazz = " + clazz);
        Method[] arr = clazz.getMethods();
        for (int i=0;i<5;i++) {
            System.out.println(arr[i].getName());
        }
    }
}
/*
Class 클래스?
    - 클래스 자체에 대한 정보를 담고 있는 클래스
    - 클래스 구조(이름,필드,메서드 ...)
 */