package com.example;

/**
 * Created by huanglei on 17/4/7.
 */
public class Ruckus {
    public static void main(String[] args) {
        Dog dog = new Dog();
        dog.woof();
        Cat cat = new Cat();
        cat.meow();
        System.out.println(dog.getCount() + "woof");
        System.out.println(cat.getCount() + "meow");

    }
}

class Dog extends Counter {
    private String count;

    public void woof() {
        increment();
    }


}

class Cat extends Counter{
    private String count;

    public void meow() {
        increment();
    }


}
class Counter {
    private static int count;
    public static void increment(){
        count++;
    }
    public static int getCount(){
        return count;
    }
}