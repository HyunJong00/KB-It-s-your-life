package org.scoula.travel.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TravelImageVO {
    private Long no;
    private String filename;
    private Long travelNo;
}
