package day_035_collection.src.command;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();

        set.add("java");
        set.add("python");
        set.add("css");

        int size = set.size();
        System.out.println(size);
    }
}
