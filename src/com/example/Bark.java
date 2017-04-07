package com.example;

/**
 * Created by huanglei on 17/4/7.
 */
public class Bark {
    public static void main(String[] args) {
        Car car = new Car();
        Car subCar =  new SubCar();
        car.bark();;
        subCar.bark();
    }
}


class Car {
    public static void bark(){
        System.out.println("Dodo");
    }
}

class SubCar extends Car{
    public static void bark(){
        System.out.println("sadss");
    }
}
