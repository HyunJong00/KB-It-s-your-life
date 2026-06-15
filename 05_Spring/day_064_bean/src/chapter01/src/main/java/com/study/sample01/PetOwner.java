package com.study.sample01;

public class PetOwner {
    private Animal animal = new Dog();
    public void play(){
        System.out.println("반려동물과 놀기");
        animal.sound();
    }
}
