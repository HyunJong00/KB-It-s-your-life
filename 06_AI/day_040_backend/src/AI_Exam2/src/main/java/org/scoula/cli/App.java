package org.scoula.cli;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * CLI 애플리케이션의 메뉴 관리 및 명령 실행을 담당하는 프레임워크 클래스입니다.
 */
public class App {
    private List<MenuItem> menu = new ArrayList<>(); // 메뉴 항목 리스트
    private Scanner scanner = new Scanner(System.in); // 사용자 입력 스캐너
    private boolean run = true; // 실행 여부 플래그

    /**
     * 메뉴 항목을 추가합니다.
     * @param label 메뉴 이름
     * @param command 실행할 명령 (Command 패턴 적용)
     */
    public void add(String label, Command command) {
        menu.add(new MenuItem(label, command));
    }

    /**
     * 애플리케이션의 메인 루프를 실행합니다.
     */
    public void run() {
        while (run) {
            printMenu();
            int choice = getChoice();
            executeCommand(choice);
        }
    }

    /**
     * 메뉴 목록을 인덱스와 함께 출력합니다.
     */
    private void printMenu() {
        System.out.println("\n==================================");
        for (int i = 0; i < menu.size(); i++) {
            System.out.printf("%d. %s | ", i + 1, menu.get(i).getLabel());
        }
        System.out.println("\n==================================");
    }

    /**
     * 사용자로부터 인덱스 번호를 입력받습니다.
     * @return 선택된 메뉴 번호
     */
    private int getChoice() {
        System.out.print("선택> ");
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // 잘못된 입력 처리용
        }
    }

    /**
     * 선택된 인덱스에 해당하는 명령을 실행합니다.
     * @param choice 선택된 번호
     */
    private void executeCommand(int choice) {
        int index = choice - 1;
        if (index >= 0 && index < menu.size()) {
            menu.get(index).getCommand().execute();
        } else {
            System.out.println("잘못된 선택입니다. 다시 입력해주세요.");
        }
    }

    /**
     * 애플리케이션을 안전하게 종료합니다.
     */
    public void exit() {
        this.run = false;
        System.out.println("애플리케이션을 종료합니다.");
    }

    /**
     * 메뉴의 이름과 명령을 캡슐화하는 내부 클래스입니다.
     */
    private static class MenuItem {
        private String label;
        private Command command;

        public MenuItem(String label, Command command) {
            this.label = label;
            this.command = command;
        }

        public String getLabel() { return label; }
        public Command getCommand() { return command; }
    }
}
