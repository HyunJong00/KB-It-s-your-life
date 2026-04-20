package day_029_interface.src.ch08.exam01;

public class Car {
    private Tire tire1 = new HankookTire();
    Tire tire2 = new KumhoTire();

    public void setTire1(Tire tire1) {
        this.tire1 = tire1;
    }

    void run(){
        this.tire1.roll();
    }
}
