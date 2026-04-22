package ch11.sec02.exam01;

public class ExceptionHandlingExample1 {
    public static void printLength(String data) {
        try {
            int result = data.length(); // data=null 일시 오류 발생
            System.out.println("문자 수: " + result);
        } catch(NullPointerException e) {
            System.out.println(e.getMessage()); //예외 객체의 메시지 출력
            e.printStackTrace(); //스택 추적내용 출력
        }
    }

    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");
        printLength("ThisIsJava");
        printLength(null);
        System.out.println("[프로그램 종료]");
    }
}
