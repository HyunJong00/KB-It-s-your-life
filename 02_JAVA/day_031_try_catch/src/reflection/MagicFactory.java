package day_031_try_catch.src.reflection;

import java.lang.reflect.Method;
import java.util.Scanner;

public class MagicFactory {
    public static void main(String[] args) {
        Scanner sc  =  new Scanner(System.in);
        System.out.println("어떤 과자 맛을 만들까요? (이름 입력: Pocachip 또는 Shrmip)");
        String className = sc.next();

        try {
            Class<?> clazz = Class.forName("day_031_try_catch.src.reflection."+className);
            System.out.println("사용자가 원하는 클래스 이름 = "+clazz.getName());

            Object obj = clazz.getDeclaredConstructor().newInstance();

            Method method = clazz.getDeclaredMethod("taste");
            method.invoke(obj);
        }catch (Exception e){
            System.out.println("그런 과자 없어요");
        }
    }
}

class Pocachip{
    public void taste(){
        System.out.println("얇고 바삭한 정동 감자칩 맛!");
    }
}
class Shrimp{
    public void taste(){
        System.out.println("짭짤하고 고소한 새우 풍미 과자!");
    }
}