package com.study.service;

import com.study.bean.UserDTO;
import com.study.dao.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Scanner;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDTO userDTO;
    private final UserDAO userDAO;



    @Override
    @Transactional
    public void write() {
        System.out.println();
        Scanner scan = new Scanner(System.in);

        System.out.print("이름 입력 : ");
        String name = scan.next();
        System.out.print("아이디 입력 : ");
        String id = scan.next();
        System.out.print("비밀번호 입력 : ");
        String pwd = scan.next();

        userDTO.setName(name);
        userDTO.setId(id);
        userDTO.setPwd(pwd);

        // db 동작
        userDAO.write(userDTO);
        System.out.println("db 입력 완료");
    }

    @Override
    public void getUserList() {
        userDAO.getUserList();
        List<UserDTO> list = userDAO.getUserList();
        for (UserDTO userDTO : list) {
            System.out.println(userDTO.toString());
        }
    }

    @Override
    public void update() {
//        1. 데이터 가져오기
//        2. 수정할 이름, 비밀번호 입력
//        3. db 수정

    }

    @Override
    public void delete() {

    }

}
