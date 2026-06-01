package org.scoula.jdbc_ex.dao;

import org.scoula.jdbc_ex.common.JDBCUtil;
import org.scoula.jdbc_ex.domain.UserVO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl implements UserDao {
    Connection conn = JDBCUtil.getConnection();

    //USER 테이블의 SQL 명령어
    private String USER_LIST = "select * from users";
    private String USER_GET = "select * from users where id = ?";
    private String USER_INSERT = "insert into user values(?,?,?,?)";
    private String USER_UPDATE = "update users set name = ?, role = ?, where i = ?";
    private String USER_DELETE = "delete from users where id = ?";

    @Override
    public int create(UserVO user) throws SQLException {
        try(PreparedStatement stmt = conn.prepareStatement(USER_INSERT)){
            stmt.setString(1,user.getId());
            stmt.setString(2,user.getPassword());
            stmt.setString(3,user.getName());
            stmt.setString(4,user.getRole());
            return stmt.executeUpdate();
        }
    }

    private UserVO map(ResultSet rs) throws SQLException{
        UserVO user = new UserVO();
        user.setId(rs.getString("ID"));
        user.setPassword(rs.getString("PASSWORD"));
        user.setName(rs.getString("NAME"));
        user.setRole(rs.getString("ROLE"));
        return user;
    }
    @Override
    public List<UserVO> getList() throws SQLException {
        List<UserVO> userList = new ArrayList<UserVO>();
        try(PreparedStatement stmt = conn.prepareStatement(USER_LIST);
            ResultSet rs = stmt.executeQuery()){
                while(rs.next()){
                    UserVO user = map(rs);
                    userList.add(user);
                }
            }
            return userList;
    }


    @Override
    public Optional<UserVO> get(String id) throws SQLException {
        return Optional.empty();
    }

    @Override
    public int update(UserVO user) throws SQLException {
        return 0;
    }

    @Override
    public int delete(String id) throws SQLException {
        return 0;
    }
}
