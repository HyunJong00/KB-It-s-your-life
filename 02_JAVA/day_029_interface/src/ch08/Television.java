package day_029_interface.src.ch08;

public class Television implements RemoteControl {
    @Override
    public void turnOn() {
        System.out.println("티비를 켭니다.");
    }
}