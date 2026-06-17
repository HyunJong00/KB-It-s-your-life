package org.scoula.travel.dao;

import org.scoula.database.JDBCUtil;
import org.scoula.travel.domain.TravelImageVO;
import org.scoula.travel.domain.TravelVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TravelDaoImpl implements TravelDao {
    Connection conn = JDBCUtil.getConnection();

    @Override
    public void insert(TravelVO travel) {
        String sql = "insert into tbl_travel(no, district,title,description, address, phone) values(?,?,?,?,?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setLong(1, travel.getNo());
            pstmt.setString(2, travel.getDistrict());
            pstmt.setString(3, travel.getTitle());
            pstmt.setString(4, travel.getDescription());
            pstmt.setString(5, travel.getAddress());
            pstmt.setString(6, travel.getPhone());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void insertImage(TravelImageVO image) {
        String sql = "insert into tbl_travel_image(filename, travel_no) values(?,?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, image.getFilename());
            pstmt.setLong(2, image.getTravelNo());

            int count = pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private TravelVO map(ResultSet rs) throws SQLException {
        return TravelVO.builder()
                .no(rs.getLong("no"))
                .district(rs.getString("district"))
                .title(rs.getString("title"))
                .description(rs.getString("description"))
                .address(rs.getString("address"))
                .phone(rs.getString("phone"))
                .build();
    }

    private TravelImageVO mapImage(ResultSet rs) throws SQLException {
        return TravelImageVO.builder()
                .no(rs.getLong("no"))
                .filename(rs.getString("filename"))
                .travelNo(rs.getLong("tino"))
                .build();
    }
    @Override
    public Optional<TravelVO> getTravel(Long no) {
        TravelVO travel;
        String sql = """
                SELECT * 
                FROM tbl_travel T
                    LEFT OUTER JOIN tbl_travel_image Ti
                        ON T.no = Ti.travel_no
                WHERE T.no = ?
                """;
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setLong(1,no);
            try(ResultSet rs = pstmt.executeQuery()){
                if (rs.next()){
                travel = map(rs);
                List<TravelImageVO> images = new ArrayList<>();
                try{
                    do{
                        TravelImageVO image = mapImage(rs);
                        images.add(image);
                    } while(rs.next());
                } catch(SQLException e){
                    throw new RuntimeException(e);
                }
                    return Optional.of(travel);
                } else{
                    return Optional.empty();
                }
            }
        }catch(SQLException e){
            throw new RuntimeException(e);
        }
    }

}
