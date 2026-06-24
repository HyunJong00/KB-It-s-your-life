package com.study.dao;

import com.study.bean.UserDTO;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class UserDAOMyBatis implements UserDAO {
    SqlSession sqlSession= null;

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public void write(UserDTO userDTO) {
        sqlSession.insert("userSQL.write", userDTO);

    }

    @Override
    public List<UserDTO> getUserList() {
        return sqlSession.selectList("userSQL.getUserList");
    }
}
