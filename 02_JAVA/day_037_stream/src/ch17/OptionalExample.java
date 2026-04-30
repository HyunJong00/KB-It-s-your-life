package day_037_stream.src.ch17;

import java.util.ArrayList;
import java.util.List;

public class OptionalExample {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

//        double avg = list.stream()
//                .mapToInt(Integer::intValue)
//                .average()
//                .getAsDouble();

        double avg1 = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .ifPresent(a -> System.out.println("a"));
    }
}
