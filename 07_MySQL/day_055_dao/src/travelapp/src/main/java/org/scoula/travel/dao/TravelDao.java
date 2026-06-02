package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.SQLException;
import java.util.List;

public interface TravelDao {
    void insert(TravelVO travel);

    void insertImage(TravelImageVO imageVO) throws SQLException;

    int getTotalCount();

    List<String> geDistricts(); //
    List<TravelVO> getTravels();
    List<TravelVO> getTravels(int page);
}
