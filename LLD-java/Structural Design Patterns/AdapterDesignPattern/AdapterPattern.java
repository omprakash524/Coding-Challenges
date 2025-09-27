import java.util.*;
/*
 * Adapter Pattern
 * Introduction
 * Structural design patterns are concerned with the composition of classes and objects. They focus on how to assemble classes and objects into larger structures while keeping these structures flexible and efficient. Adapter Pattern is one of the most important structural design patterns. Let's understand in depth.
 * Adapter Pattern
 * The Adapter Pattern allows incompatible interfaces to work together by acting as a translator or wrapper around an existing class. It converts the interface of a class into another interface that a client expects.
 * It acts as a bridge between the Target interface (expected by the client) and the Adaptee (an existing class with a different interface). This structural wrapping enables integration and compatibility across diverse systems.
 * Real-Life Analogy
 * Imagine traveling from India to Europe. Your mobile charger doesn't fit into European sockets. Instead of buying a new charger, you use a plug adapter. The adapter allows your charger (with its Indian plug) to fit the European socket, enabling charging without modifying either the socket or the charger.
 * Problem It Solves
 * Interface incompatibility between classes.
 * Reusability of existing classes without modifying their source code.
 * Enables systems to communicate that otherwise couldn't due to differing method signatures.
 * Similarly, the Adapter Pattern allows objects with incompatible interfaces to collaborate by introducing an adapter.
 * Components of Adapter Pattern
 * Target Interface: The interface expected by the client.
 * Adaptee: The existing class with a different interface.
 * Adapter: The class that implements the Target Interface and translates calls to the Adaptee.
 * 
 * 
 * Now the problem here is that if we want to integrate another payment gateway, we need to create a new class that implements the PaymentGateway interface.
 * But what if the new payment gateway has a different interface?
 * For example, let's say we want to integrate Stripe payment gateway or RazorPay which has a different method signature.
 * Adaptee: 
 * An existing class with an incompatible interface
 * class RazorPayGateway{
 *     public void makePayment(String orderId, double amount){
 *         System.out.println("Paying " + amount + " for order " + orderId + " using RazorPay Gateway");
 *     }
 * }
 * 
 * Here the makePayment method is different from the pay method in the PaymentGateway interface.
 * We cannot directly use the Stripe payment gateway in our CheckoutService class because it does not implement the PaymentGateway interface.
 * We need to create an adapter class that implements the PaymentGateway interface and internally uses the Stripe
 * We can use the Adapter Pattern to solve this problem.
 */

// Using Incompatible Interface (Without Adapter)
// Target Interface: 
// Standard interface expected by the CheckoutService
// Concrete implementation of PaymentGateway for PayU
interface PaymentGateway{
    void pay(String orderId, double amount);
}

class PayUGateway implements PaymentGateway{
    @Override
    public void pay(String orderId, double amount){
        System.out.println("Paying " + amount + " for order " + orderId + " using PayU Gateway");
    }
}

// Adaptee: 
// An existing class with an incompatible interface
class RazorPayAPI{
    public void makePayment(String orderId, double amount){
        System.out.println("Paying " + amount + " for order " + orderId + " using RazorPay Gateway");
    }
}

// Adapter Class:
// Allows RazorpayAPI to be used where PaymentGateway is expected

class RazorPayAdapter implements PaymentGateway{
    private RazorPayAPI razorpayAPI;
    public RazorPayAdapter(){
        this.razorpayAPI = new RazorPayAPI();
    }
    @Override
    public void pay(String orderId, double amount){
        // Translate the pay method to makePayment method
        razorpayAPI.makePayment(orderId, amount);
    }
}
class RazorpayAPI2{
    public void processPayment(String orderId, double amount){
        System.out.println("Paying " + amount + " for order " + orderId + " using RazorPay2 Gateway");
    }
}
class RazorPayAdapter2 implements PaymentGateway{
    private RazorpayAPI2 razorpayAPI2;
    public RazorPayAdapter2(){
        this.razorpayAPI2 = new RazorpayAPI2();
    }
    @Override
    public void pay(String orderId, double amount){
        razorpayAPI2.processPayment(orderId, amount);
    }
}
/*
 * When to Use Adapter Pattern
 * The Adapter Pattern is ideal in scenarios where you're trying to integrate components that were not originally designed to work together. It proves especially useful when:
 * You need to use an existing class, but its interface does not match the one your system expects.
 * You want to reuse legacy code without modifying its internal structure.
 * You're integrating third-party APIs or external services into your application.
 * In such cases, the Adapter Pattern serves as a bridge, allowing seamless compatibility without altering existing codebases.
 */




// Client Class:
// Uses PaymentGateway interface to process payments
class CheckoutService{
    private PaymentGateway paymentGateway;
    // Constructor injection for dependency inversion
    public CheckoutService(PaymentGateway paymentGateway){
        this.paymentGateway = paymentGateway;
    }
    // Business logic to perform checkout
    public void checkout(String orderId, double amount){
        paymentGateway.pay(orderId, amount);
    }
}
public class AdapterPattern {
    public static void main(String[] args) {
        System.out.println("Adapter Pattern Practice in Java");
        // PaymentGateway paymentGateway = new PayUGateway();
        PaymentGateway paymentGateway = new RazorPayAdapter();
        CheckoutService checkoutService = new CheckoutService(paymentGateway);
        checkoutService.checkout("12345", 250.75);
    }
}
