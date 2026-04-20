package day_029_interface.src.ch08.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.run();
        myCar.setTire1(new KumhoTire());
        myCar.run();
    }
}
