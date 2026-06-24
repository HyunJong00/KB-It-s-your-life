package com.study.dao;

import com.study.bean.UserDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository // DB와 관련한 COMPONENT(BEAN)
public class UserDAOMyBatis implements UserDAO {

//    @Autowired // 필드 주입 - 비권장
//    private SqlSession sqlSession= null;

    private final SqlSession sqlSession; // 생성자 주입 - 권장(아래 생성자 코드 or lombok)
//    public UserDAOMyBatis(SqlSession sqlSession) {
//        this.sqlSession = sqlSession;
//    }

    @Override
    public void write(UserDTO userDTO) {
        sqlSession.insert("userSQL.write", userDTO);

    }

    @Override
    public List<UserDTO> getUserList() {
        return sqlSession.selectList("userSQL.getUserList");
    }
}
