package com.study;

import com.study.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;
import java.util.Scanner;


public class SpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringMain springMain = (SpringMain) context.getBean("springMain");
        springMain.menu(context);

    }
    public void menu(ApplicationContext context) {
        Scanner sc = new Scanner(System.in);
        UserService userService = (UserService) context.getBean("userServiceImpl");
        int num;
        while (true) {
            System.out.println();
            System.out.println("***************************");
            System.out.println("   1. 회원 정보 입력");
            System.out.println("   2. 회원 정보 출력");
            System.out.println("   3. 회원 정보 수정");
            System.out.println("   4. 회원 정보 삭제");
            System.out.println("   5. 종료");
            System.out.println("***************************");
            System.out.print("선택 : ");
            num = sc.nextInt();
            if(num == 5) break;
            if(num==1){
                userService.write();
            }
            if(num==2){
                userService.getUserList();
            }
        }
    }
}
