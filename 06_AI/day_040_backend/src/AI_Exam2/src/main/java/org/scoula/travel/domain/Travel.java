package org.scoula.travel.domain;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 여행지 정보를 담는 도메인 클래스입니다.
 * travel.csv의 구조(no, district, title, description, address, phone)를 반영합니다.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Travel {

    @CsvBindByName(column = "no")
    private Long no; // 순번

    @CsvBindByName(column = "district")
    private String district; // 지역 (수도권, 충청권 등)

    @CsvBindByName(column = "title")
    private String title; // 여행지 명칭

    @CsvBindByName(column = "description")
    private String description; // 상세 설명

    @CsvBindByName(column = "address")
    private String address; // 주소

    @CsvBindByName(column = "phone")
    private String phone; // 전화번호
}
