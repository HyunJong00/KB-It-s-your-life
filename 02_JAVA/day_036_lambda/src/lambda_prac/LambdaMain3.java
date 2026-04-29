package day_036_lambda.src.lambda_prac;

import java.util.Arrays;
import java.util.List;

public class LambdaMain3 {
    public static void main(String[] args) {
        System.out.println("\nstatic 메서드 참조");
        System.out.println("\n정렬 전");
        List<Integer> list = Arrays.asList(3, 1, 2);
        System.out.println(list);

        System.out.println("lambda 정렬 후 ");
        list.sort((x, y) -> y.compareTo(x));
        System.out.println(list);

        System.out.println("메서드 참조");
        list.sort(Comparable::compareTo);
        System.out.println(list);


        List<PersonDTO> list2 = Arrays.asList(
                new PersonDTO("홍길동", 25),
                new PersonDTO("동홍길", 45),
                new PersonDTO("길동홍", 35)
        );

        list2.sort(((o1, o2) -> o1.getName().compareTo(o2.getName())));
        System.out.println(list2);
    }


}
