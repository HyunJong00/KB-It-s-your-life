package com.study.dao;

import com.study.bean.UserDTO;

import java.util.List;

public interface UserDAO {
    public void write(UserDTO userDTO);

    List<UserDTO> getUserList();
}
