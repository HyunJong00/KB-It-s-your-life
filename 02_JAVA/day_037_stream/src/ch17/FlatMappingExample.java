package day_037_stream.src.ch17;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FlatMappingExample {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        list1.add("this is java");
        list1.add("i am a best developer");
        list1.stream()
                .map(data -> Arrays.stream(data.split("")))
//                .flatMap(data -> Arrays.stream(data.split(" ")))
                .forEach(System.out::println);
    }
}
