// In Java we can achieve abstraction using Abstraction classes and Interfaces
// Abstraction
abstract class Car{
    Car(){
        System.out.println("Car constructor in called");
    }
    abstract public void start();
    public void noise(){
        System.out.println("Car makes a noise");
    }
}
abstract class Dealer extends Car{
    Dealer(){
        System.out.println("Dealer constructor is called");
    }
    int numberOfCars;
}
class ManualCar extends Car{
    public void start(){
        System.out.println("Manual car starts with a key");
    }
    public void printName(){
        System.out.println("This is a manual car class printName method");
    }
}
class AutomaticCar extends Car{
    public void start(){
        System.out.println("Automatic car starts with a button");
    }
}
// before java 8 we cant have method with body in interface
// from java 8 we can have method with body in interface using default keyword
// default method and static method in interface are not abstract methods 
// so we dont need to override them in the implementing class 
// but we can override them if we want to change the behavior of the method 
// static method can be called using interface name 
// default method can be called using object of the implementing class 
// but if we create object of interface then it will give error as we cannot create object of interface
// 
interface CarInterface{
    void start();
    void noise();
    void printName();
    default void defaultMethod(){
        System.out.println("This is a default method in interface");
    }
    static void staticMethod(){
        System.out.println("This is a static method in interface");
    }
}
class ManualCarInterface implements CarInterface{
    public void start(){
        System.out.println("Manual car starts with a key");
    }
    public void noise(){
        System.out.println("Manual car makes a noise");
    }
    public void printName(){
        System.out.println("This is a manual car class printName method");
    }
}
public class Abstraction {
    public static void main(String[] args) {
        Car manualCar = new ManualCar();
        manualCar.start();
        manualCar.noise();
        // manualCar.printName(); // this will give error as Car class doesn't have printName method
        // to access printName method we need to type cast
        ((ManualCar) manualCar).printName();

        Car automaticCar = new AutomaticCar();
        automaticCar.start();
        automaticCar.noise();
        // automaticCar.printName(); // this will give error as Car class doesn't have printName method
        // to access printName method we need to type cast
        // ((AutomaticCar) automaticCar).printName();

        CarInterface manualCarInterface = new ManualCarInterface();
        manualCarInterface.start();
        manualCarInterface.noise();
        // manualCarInterface.printName(); // this will give error as CarInterface doesn't have printName method
        // to access printName method we need to type cast
        ((ManualCarInterface) manualCarInterface).printName();
        manualCarInterface.defaultMethod();
        CarInterface.staticMethod();
    }
}
