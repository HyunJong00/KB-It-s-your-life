package day_036_lambda.src.command;

import java.util.Scanner;

public class WorkServie {
    // 각 메서드가 인터페이스의 시그니쳐와 같아야 함(매게변수, return)
    // 이름은 상관 없음
    public void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자 1: ");
        int num1 = scanner.nextInt();

        System.out.print("숫자 2: ");
        int num2 = scanner.nextInt();

        System.out.printf("%d + %d = %d\n",  num1, num2, num1 + num2);;
    }

    public void open() {
        System.out.println("=============");
        System.out.println("Opening command");
        System.out.println("=============");
        System.out.println();
    }

    public void print() {
        System.out.println("===========");
        System.out.println("Printing command");
        System.out.println("===========");
        System.out.println();
    }

}
