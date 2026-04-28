package day_035_collection.src.test;

import java.util.TreeSet;

public class TreeSetMain {
    public static void main(String[] args) {
        int[] arr = {19, 123, 24, 12, 15};
        TreeSet<Integer> set = new TreeSet<>();
        // TreeSet은 자동 정렬
        for(int data: arr){
            set.add(data);
            Integer lower = set.floor(data);
            System.out.println("작은 값: "+lower);
        }

        System.out.println("TreeSet: "+set);
    }
}
