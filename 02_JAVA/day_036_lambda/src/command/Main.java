package day_036_lambda.src.command;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        WorkServie service = new WorkServie();

        // Command  인터페이스의 excute와 동일한 모양의 메서드 참조
        Command[] commands = {
                service::add,
                service::open,
                service::print,
                Main::exit
        };

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1. add, 2. open, 3. print, 4. exit");
            System.out.print("선택: ");
            int sel = scanner.nextInt();
            commands[sel-1].execute();
        }
    }
    public static void exit() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("종료할까요?(y/n) ");
        String answer = scanner.nextLine();
        if(answer.isEmpty() || answer.equalsIgnoreCase("y")) {
            System.exit(0);
        }
    }
}
