package day_034_generic.src.ch15;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
    List<String> list = new ArrayList<>();
    list.add("Test");

    List<String> list2 = List.of("Test", "Test2");
        System.out.println("list2 = " + list2);

    }
}
