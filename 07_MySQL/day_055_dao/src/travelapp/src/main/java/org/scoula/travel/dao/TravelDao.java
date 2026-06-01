package org.scoula.travel.dao;

import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.SQLException;

public interface TravelDao {
    void insert(TravelVO travel);

    void insertImage(TravelImageVO imageVO) throws SQLException;
}
