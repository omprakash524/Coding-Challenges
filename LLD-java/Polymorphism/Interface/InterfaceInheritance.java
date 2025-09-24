interface Vehicle{
    public void start();
    public void stop();
    default void fuel(){
        System.out.println("Vehicle needs fuel");
    }
}
// To provide multiple inheritance.
// interface can inherit another interface using extends keyword
// a interface can inherit multiple interfaces
interface Car extends Vehicle{
    public void drive();
    public void park();
    // You can call InterfaceName.super.method() only inside a class that implements the interface, not inside another interface.
    // Vehicle.super.fuel(); // calling default method of parent interface
    default void fuel(){
        System.out.println("Car needs petrol or diesel");
        Vehicle.super.fuel(); // calling default method of parent interface
    }
}

class ManualCar implements Car{
    public void start(){
        System.out.println("Manual car starts with a key");
    }
    public void stop(){
        System.out.println("Manual car stops with brakes");
    }
    public void drive(){
        System.out.println("Manual car is driving");
    }
    public void park(){
        System.out.println("Manual car is parked");
    }
}

public class InterfaceInheritance {
    public static void main(String[] args) {
        ManualCar manualCar = new ManualCar();
        manualCar.start();
        manualCar.stop();
        manualCar.drive();
        manualCar.park();
        manualCar.fuel(); // calling default method from interface
    }
}
