package day_028_extends.src.ch07;

public class Coumputer extends Calculator {
//    @Override
//    public double areaCircle(double r){
//        System.out.println("Coumputer 객체의 areaCircle() 실행");
//        return Math.PI*r*r;
//    }

    @Override
    public double areaCircle(double r) {
        return super.areaCircle(r);
    }
}
