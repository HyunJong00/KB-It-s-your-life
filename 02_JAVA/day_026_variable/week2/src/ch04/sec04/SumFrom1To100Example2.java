package day_026_variable.week2.src.ch04.sec04;

public class SumFrom1To100Example2 {
    public static void main(String[] args) {
        int i = 0;
        int sum =0;
        while(i<=100){
            sum += i++;
        }
        System.out.println("1~100 합 : "+sum);
    }
}
