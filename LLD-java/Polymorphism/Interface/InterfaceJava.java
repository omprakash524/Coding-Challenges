// concept of Abstraction (100%) using interface
// we can achieve multiple inheritance using interface
// we can implement multiple interfaces in a class
// Interface dont have constructor as we cannot create object of interface
// Interface
interface CarInterface{
    int cnt = 0; // public static final by default
    public void start();
    public void noise();
    // it is loosely coupled as we can add any method in interface and we dont need to change the implementing class 
    // here we are adding new method in interface and we need to implement it in the implementing class
    // airBags method is not mandatory to implement in the implementing class as it is default method
    default void airBags(){
        System.out.println("Car has airbags");
    }
    static void staticMethod(){
        System.out.println("This is a static method in interface");
    }
}
interface SunRoof{
    public void SunRoof();
}

// default method and static method in interface are not abstract methods 
// so we dont need to override them in the implementing class
// but we can override them if we want to change the behavior of the method 
// static method can be called using interface name 
class ManualCarInterface implements CarInterface, SunRoof {
    public void start(){
        CarInterface.staticMethod();
        // cnt++; // we cannot change the value of cnt as it is final by default in interface
        System.out.println("Manual car starts with a key "+(cnt+11));
    }
    public void noise(){
        System.out.println("Manual car makes a noise");
    }
    @Override
    public void airBags(){
        System.out.println("Manual car has 2 airbags");
    }
    @Override
    public void SunRoof(){
        System.out.println("Manual car has sunroof");
    }
}
/*  
 * class A {
    void show() { System.out.println("A"); }
}

class B extends A {
    void show() { System.out.println("B"); }
}

class C extends A {
    void show() { System.out.println("C"); }
}

// ❌ class D extends B, C { } // Ambiguity: which show() to use?
// ✅ Use interfaces to avoid ambiguity
 */

 // implementing multiple interfaces any give base class or child class can implement multiple interfaces but a abstract class can implement only one interface


class InterfaceJava{
    public static void main(String[] args) {
        System.out.println("Interface in Java");
        ManualCarInterface manualCar = new ManualCarInterface();
        manualCar.start();
        manualCar.noise();
        manualCar.airBags();
        CarInterface.staticMethod();
        manualCar.SunRoof();
    }
}