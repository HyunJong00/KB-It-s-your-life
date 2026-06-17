package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.util.Optional;

public interface TravelDao {
    void insert(TravelVO travel);

    void insertImage(TravelImageVO image);

    int getTotalCount();

    Optional<TravelVO> getTravel(Long no);
}
