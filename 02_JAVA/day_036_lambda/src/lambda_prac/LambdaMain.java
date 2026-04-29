package day_036_lambda.src.lambda_prac;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

public class LambdaMain {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(3, 1, 2);
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
//                return o1-o2;
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);

        System.out.println("\n람다식");
        list.sort((a, b) -> b.compareTo(a));
        System.out.println(list);

        System.out.println("\n메서드 참조");
//        list.sort(Integer::compareTo); 안되어야 하는데 됨
        list.sort(Comparable::compareTo);
        System.out.println(list);


        // 람다식 (x+y)
        InterA add = (x,y)->x+y;
        InterA sub = (x,y)->x-y;
        System.out.println(add.calc(3, 5));

        String str = "hello";
//        int len = str.length();
        Supplier<Integer> s = str::length;
        System.out.println(s.get());
    }
    interface InterA{
        int calc(int x, int y);
    }
}
