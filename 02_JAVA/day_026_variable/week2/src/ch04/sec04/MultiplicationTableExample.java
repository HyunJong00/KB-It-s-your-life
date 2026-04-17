package day_026_variable.week2.src.ch04.sec04;

public class MultiplicationTableExample {
    public static void main(String[] args) {
        for(int i=2;i<10;i++){
            System.out.printf("*** %d단 ***",i);
            for(int j=1;j<10;j++){
                System.out.printf("%d x %d = %d\n",i,j,i*j);
            }
        }
    }
}
