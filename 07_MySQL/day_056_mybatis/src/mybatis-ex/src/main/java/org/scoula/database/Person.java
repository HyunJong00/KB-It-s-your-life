package org.scoula.database;

import lombok.Builder;
import lombok.ToString;

@ToString
@Builder
public class Person {
    private final String name;
    private final int age;

    @Builder.Default
    private final String role = "USER";

    public static void main(String[] args) {
        Person p = Person.builder()
                .name("hh")
                .build();
        System.out.println(p);
    }
}
