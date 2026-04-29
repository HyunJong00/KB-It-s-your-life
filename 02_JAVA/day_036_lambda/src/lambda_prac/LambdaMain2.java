package day_036_lambda.src.lambda_prac;

public class LambdaMain2 {
    //스레드 생성
    public static void main(String[] args) {
        Thread t = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("스레드 실행");
            }
        });
        //스레드 실행 - 운영체제에 의해서 run 실행
        t.start();


        System.out.println("람다식");
        Thread t1 = new Thread(() -> System.out.println("스레드 실행2"));
        t1.start();
    }
}
