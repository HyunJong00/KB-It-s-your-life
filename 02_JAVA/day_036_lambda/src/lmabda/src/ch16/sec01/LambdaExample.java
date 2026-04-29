package ch16.sec01;

public class LambdaExample {
    public static void main(String[] args) {
        action((x, y) -> {
            System.out.println("result: " + (x+y));
        });
        action((x, y) -> {
            System.out.println("result: " + (x-y));
        });
    }

    public static void action(Calculable calculable) {
        int x = 10;
        int y = 4;
        calculable.calculate(x,y);
    }
}
