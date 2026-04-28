package day_035_collection.src.test;

import lombok.AllArgsConstructor;
import lombok.Getter;

// DTO.java or VO.java
// 1인용
@AllArgsConstructor
@Getter
public class PersonDTO implements Comparable<PersonDTO>{
    private String name;
    private int age;

    @Override
    public int compareTo(PersonDTO o) {
        return this.getAge() - o.getAge();
    }
}
