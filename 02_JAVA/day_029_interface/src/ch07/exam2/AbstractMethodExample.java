package day_029_interface.src.ch07.exam2;

public class AbstractMethodExample {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.sound();

        Cat cat = new Cat();
        cat.sound();

        animalSound(new Dog());
        animalSound(new Cat());

    }
    static void animalSound(Animal animal){
        animal.sound();
    }
}
