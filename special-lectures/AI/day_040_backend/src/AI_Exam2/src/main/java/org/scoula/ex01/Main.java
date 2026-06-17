package org.scoula.ex01;

import org.scoula.cli.App;

/**
 * CLI 프레임워크 사용 예제를 보여주는 클래스입니다.
 */
public class Main {
    public static void main(String[] args) {
        App app = new App();

        // ex01 패키지에서의 사용 예시
        app.add("인사하기", () -> System.out.println("안녕하세요!"));
        app.add("종료", app::exit);

        app.run();
    }
}
