// Factory Pattern - A creational design pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created.
// -------------------------------------------------------
/**
 * THEORY NOTES:
 *
 * 1. Factory Method Pattern - Defines an interface for creating an object, but lets subclasses decide which class to instantiate. - Promotes loose coupling by eliminating the need to bind application-specific classes into the code.
 *
 * 2. Abstract Factory Pattern - Provides an interface for creating families of related or dependent objects without specifying their concrete classes. - Useful when the system needs to be independent of how its products are created, composed, and represented.
 *
 * 3. Simple Factory (Not a standard GoF pattern) - A simple factory is a class with a method that creates and returns instances of different classes based on input parameters. - It encapsulates the object creation logic in one place.
 *
 * 4. When to Use - Use Factory Method when a class cannot anticipate the class of objects it must create. - Use Abstract Factory when the system needs to be independent of how its products are created, composed, and represented. - Use Simple Factory for straightforward scenarios where you want to centralize object creation logic.
 *
 * 5. Benefits - Promotes loose coupling by reducing the dependency on concrete classes. - Enhances code maintainability and scalability by allowing easy addition of new product types without modifying existing code.
 *
 * 6. Drawbacks - Can introduce complexity due to additional classes and interfaces. - May lead to a proliferation of small classes that can be hard to manage.
 */

interface Logistics{
    void send();
}
// concrete class - implements the Logistics interface
class RoadLogistics implements Logistics{
    @Override
    public void send(){
        System.out.println("Sending by Road");
    }
}
class SeaLogistics implements Logistics{
    @Override
    public void send(){
        System.out.println("Sending by Sea");
    }
}
class AirLogistics implements Logistics{
    @Override
    public void send(){
        System.out.println("Sending by Air");
    }
}

class LogisticsFactory{
    public static Logistics createLogistics(String type){
        if(type.equalsIgnoreCase("Road")){
            return new RoadLogistics();
        } else if(type.equalsIgnoreCase("Sea")){
            return new SeaLogistics();
        } else if(type.equalsIgnoreCase("Air")){
            return new AirLogistics();
        }
        throw new IllegalArgumentException("Unknown logistics type");
    }
}
class LogisticsService{
    public void send(String mode){
        Logistics logistics = LogisticsFactory.createLogistics(mode);
        logistics.send();
    }
}

// another example
// step 1: Payment interface
interface Payment{
    void pay(int amount);
}

// step 2: Concrete classes Implementing the Payment interface
class CreditCardPayment implements Payment{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class PayPalPayment implements Payment{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using PayPal");
    }
}

class CreditCardPayment1 implements Payment{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using Credit Card");
    }
}

class UPIpayment implements Payment{
    @Override
    public void pay(int amount){
        System.out.println("Paid " + amount + " using UPI");
    }
}

// step 3: Factory class to generate object of concrete class based on given information
class PaymentFactory{
    public static Payment createPayment(String type){
        if(type.equalsIgnoreCase("CreditCard")){
            return new CreditCardPayment();
        } else if(type.equalsIgnoreCase("PayPal")){
            return new PayPalPayment();
        } else if(type.equalsIgnoreCase("UPI")){
            return new UPIpayment();
        } else if(type.equalsIgnoreCase("CreditCard1")){
            return new CreditCardPayment1();
        }
        throw new IllegalArgumentException("Unknown payment type");
    }
}
// step 4: Use the Factory to get the object of concrete class by passing an information such as type to the factory
class PaymentService{
    public void processPayment(String type, int amount){
        Payment payment = PaymentFactory.createPayment(type);
        payment.pay(amount);
    }
}

public class FactoryPattern {
    public static void main(String[] args) {
        System.out.println("Factory Pattern");
        LogisticsService service = new LogisticsService();
        service.send("Road");
        service.send("Sea");
        service.send("Air");

        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("CreditCard1", 100);
    }
}
