package day_035_collection.src.test;

import java.util.*;

public class PersonSort {
    public static void main(String[] args) {
        List<PersonDTO> list = new ArrayList<>();

        String[] ar = {"orange", "apple", "banana", "pear", "peach", "applemango"};
        System.out.println(Arrays.toString(ar));
        Arrays.sort(ar);
        System.out.println(Arrays.toString(ar));


        PersonDTO aa = new PersonDTO("홍길동", 25);
        PersonDTO bb = new PersonDTO("프로도", 45);
        PersonDTO cc = new PersonDTO("라이온", 35);

        list.add(aa);
        list.add(bb);
        list.add(cc);
        System.out.println();
        for (PersonDTO data : list) {
            System.out.println(data.getName());
        }

        Collections.sort(list);
        for (PersonDTO data : list){
            System.out.println(data.getName());
        }

        Comparator<PersonDTO> com = new Comparator<PersonDTO>() {
            @Override
            public int compare(PersonDTO o1, PersonDTO o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };

        list.sort(com);
        System.out.println();
        for (PersonDTO data : list) {
            System.out.println(data.getName());
        }
    } 
}
