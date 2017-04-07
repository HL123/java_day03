# 第三天
## 令人混淆的构造器
```java
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
```
### 分析
Java的重载解析过程可以分为两个阶段。第一阶段，选取所有可获得并且可应用的方法或构造器。第二阶段，在第一阶段选择的方法或构造器中选取最精确的一个。
### 建议
想要强制要求编译器选择一个精确的重载版本，需要将实参转型为形参所声明的类型。重载版本的解析可能会产生混淆，应该尽可能避免重载。如果确定进行了重载 ，请保证所有的重载版本所接受的参数类型都是互不兼容的。

## 狸猫变犬子
```java
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
```
### 分析
静态字段由声明它的类及其子类所共享。
### 建议
如果需要让每一个子类都具有某个单独副本，那么必须在每一个子类中声明一个单独的静态字段。
## 我所得到的都是静态的
```java
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
    public static void bark(){}
}
```
### 分析
静态方法是不能被覆写的，它们只能被隐藏。要用类名来修饰静态方法的调用
### 建议
①类名.方法名：SubCar.bark();

②删掉static

## 不是你的类型
```java
public class Type {
    public static void main(String[] args) {
        String s = null;
        System.out.println(s instanceof String);
    }
}
```
### 分析
instanceof操作符被定义为在做操作数为null时返回false。

### 续
```java
public class Type2 {
    public static void main(String[] args) {
        System.out.println(new Type() instanceof String);
    }
}
```
### 分析
错误。如果两个操作数的类型都是类，其中一个必须是另一个的子类型。
