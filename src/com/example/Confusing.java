package com.example;

/**
 * Created by huanglei on 17/4/7.
 */
public class Confusing {

    public Confusing(Object obj){
        System.out.println("Object");
    }

    public Confusing(String str){
        System.out.println("String");
    }

    public static void main(String[] args) {
        new Confusing(null);
    }
}
