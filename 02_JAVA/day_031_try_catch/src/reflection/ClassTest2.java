package day_031_try_catch.src.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person{
    private String name;
    private int age;

    public Person(){}

    public void disp(){
        System.out.println("Hello !!");

    }
}

public class ClassTest2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Class<?> clazz = Class.forName("day_031_try_catch.src.reflection.Person");
        System.out.println("클래스 이름= "+clazz.getName());
        Field[] ar=  clazz.getDeclaredFields();
        for (Field data: ar){
            System.out.println(data.getName());

            Object obj = clazz.getDeclaredConstructor().newInstance();
            Field name = clazz.getDeclaredField("name");
            name.setAccessible(true);
            name.set(obj, "홍길동");
            System.out.println("name = " + name.get(obj));
            Method method = clazz.getDeclaredMethod("disp");
            method.invoke(obj);
        }

    }
}
