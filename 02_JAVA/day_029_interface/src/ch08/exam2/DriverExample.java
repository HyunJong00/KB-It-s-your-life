package day_029_interface.src.ch08.exam2;

import java.util.Scanner;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();
        // 사용자 선택 1)택시, 2)버스
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
//        if (num==1){
//            driver.drive(taxi);
//        } else {
//            driver.drive(bus);
//        }
        driver.drive(new Bus());
        driver.drive(new Taxi());
        Vehicle cars[] = {new Taxi(), new Bus()};
        driver.drive(cars[num-1]); // 운영부 수정할 필요 없음
    }
}
