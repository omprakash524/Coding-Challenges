// Abstract Factory Pattern
/*
 * The Abstract Factory Pattern is a creational design pattern that provides an interface for creating families of related or dependent objects without specifying their concrete classes. It is used when the system needs to be independent of how its objects are created, composed, and represented.
 * This pattern is particularly useful when the system needs to be configured with one of multiple families of products. It allows for the creation of objects that are related by a common theme or purpose, ensuring that the client code remains decoupled from the specific implementations of these objects.
 * The Abstract Factory Pattern typically involves the following components:
 * 1. Abstract Factory: An interface that declares methods for creating abstract products.
 * 2. Concrete Factory: A class that implements the Abstract Factory interface and produces concrete products.
 * 3. Abstract Product: An interface that defines the characteristics of the products to be created.
 * 4. Concrete Product: A class that implements the Abstract Product interface and defines the specific product.
 * 5. Client: The client code that uses the Abstract Factory to create products without being aware of their concrete implementations.
 * Example Use Case: GUI Toolkit
 * Consider a GUI toolkit that needs to support multiple operating systems (e.g., Windows, macOS, Linux). Each operating system has its own set of UI components (buttons, text fields, etc.). The Abstract Factory Pattern can be used to create a family of related UI components for each operating system without the client code needing to know the specifics of each implementation.
 * Benefits:
 * - Promotes consistency among products of the same family.
 * - Enhances flexibility and scalability by allowing easy addition of new product families.
 * - Decouples client code from concrete implementations, making it easier to maintain and modify.
 * Drawbacks:
 * - Can lead to a proliferation of classes, making the codebase more complex.
 * - May introduce additional layers of abstraction, which can complicate the design.
 */

/*
 * 🏭 What Is Abstract Factory Pattern?
 * Imagine you're building a Checkout System for an e-commerce platform like TUF Plus. You need to support different payment gateways and invoice formats depending on the country (India, US, etc.).
 * Instead of hardcoding:
 * Bad Design: Hardcoded Object Creation in CheckoutService
 * This version of the CheckoutService tightly couples business logic with object creation. It works for a simple scenario but quickly becomes problematic as the application scales or needs to support multiple payment gateways and invoice formats.
 */
// Interface representing any payment gateway
/* 
interface PaymentGateway {
    void processPayment(double amount);
}

// Concrete implementation: Razorpay
class RazorpayGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

// Concrete implementation: PayU
class PayUGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

// Interface representing invoice generation
interface Invoice {
    void generateInvoice();
}

// Concrete invoice implementation for India
class GSTInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating GST Invoice for India.");
    }
}

// CheckoutService that directly handles object creation (bad practice)
class CheckoutService {
    private String gatewayType;

    // Constructor accepts a string to determine which gateway to use
    public CheckoutService(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    // Checkout process hardcodes logic for gateway and invoice creation
    public void checkOut(double amount) {
        PaymentGateway paymentGateway;

        // Hardcoded decision logic
        if (gatewayType.equals("razorpay")) {
            paymentGateway = new RazorpayGateway();
        } else {
            paymentGateway = new PayUGateway();
        }

        // Process payment using selected gateway
        paymentGateway.processPayment(amount);

        // Always uses GSTInvoice, even though more types may exist later
        Invoice invoice = new GSTInvoice();
        invoice.generateInvoice();
    }
}
*/
/*
 * Issues with this ⬆️⬆️ design
 * Tight Coupling: The CheckoutService directly creates instances of RazorpayGateway, PayUGateway, and GSTInvoice, making it dependent on specific implementations.
 * Violation of the Open/Closed Principle: Any addition of new payment gateways or invoice types will require modifying the CheckoutService class.
 * Lack of Extensibility: Hardcoding limits the ability to support other countries or multiple combinations of payment methods and invoice formats.
 */

// ---------------------------------------------------------------
/*
 * ✅ Refactored Design Using Abstract Factory Pattern
 * Improved Design: Abstract Factory Pattern for CheckoutService
 * This version follows the Abstract Factory Pattern to cleanly separate the creation of PaymentGateway and Invoice objects from the business logic of CheckoutService.
 */
// Abstract Factory interface
// ========== Interfaces ==========
interface PaymentGateway {
    void processPayment(double amount);
}

interface Invoice {
    void generateInvoice();
}

// ========== India Implementations ==========
class RazorpayGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}

class PayUGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}

class GSTInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating GST Invoice for India.");
    }
}

// ========== US Implementations ==========
class PayPalGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via PayPal: " + amount);
    }
}

class StripeGateway implements PaymentGateway {
    public void processPayment(double amount) {
        System.out.println("Processing USD payment via Stripe: " + amount);
    }
}

class USInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating Invoice as per US norms.");
    }
}

// ========== Japan Implementations ==========
class RakutenPay implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing JPY payment via RakutenPay: " + amount);
    }
}

class LinePay implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing JPY payment via LinePay: " + amount);
    }
}

class JPInvoice implements Invoice {
    public void generateInvoice() {
        System.out.println("Generating Invoice as per Japan norms.");
    }
}

// ========== Abstract Factory ==========
interface RegionFactory {
    PaymentGateway createPaymentGateway(String gatewayType);
    Invoice createInvoice();
}

// ========== Concrete Factories ==========
class IndiaFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("razorpay")) {
            return new RazorpayGateway();
        } else if (gatewayType.equalsIgnoreCase("payu")) {
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for India: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new GSTInvoice();
    }
}

class USFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("paypal")) {
            return new PayPalGateway();
        } else if (gatewayType.equalsIgnoreCase("stripe")) {
            return new StripeGateway();
        }
        throw new IllegalArgumentException("Unsupported gateway for US: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new USInvoice();
    }
}

class JapanFactory implements RegionFactory {
    public PaymentGateway createPaymentGateway(String gatewayType) {
        if (gatewayType.equalsIgnoreCase("rakutenpay")) {
            return new RakutenPay();
        } else if (gatewayType.equalsIgnoreCase("linepay")) {
            return new LinePay();
        }
        throw new IllegalArgumentException("Unsupported gateway for Japan: " + gatewayType);
    }

    public Invoice createInvoice() {
        return new JPInvoice();
    }
}


// ========== Checkout Service ==========
class CheckoutService {
    private PaymentGateway paymentGateway;
    private Invoice invoice;
    private String gatewayType;

    public CheckoutService(RegionFactory factory, String gatewayType) {
        this.gatewayType = gatewayType;
        this.paymentGateway = factory.createPaymentGateway(gatewayType);
        this.invoice = factory.createInvoice();
    }

    public void completeOrder(double amount) {
        paymentGateway.processPayment(amount);
        invoice.generateInvoice();
    }
}
// ---------------------------------------------------------------
class AbstractFactoryPattern {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Pattern in Java");
        // Example: Using Razorpay
        // Using Razorpay in India
        CheckoutService indiaCheckout = new CheckoutService(new IndiaFactory(), "razorpay");
        indiaCheckout.completeOrder(1999.0);

        System.out.println("---");

        // Using PayPal in US
        CheckoutService usCheckout = new CheckoutService(new USFactory(), "paypal");
        usCheckout.completeOrder(49.99);

        System.out.println("---");
        // Using RakutenPay in Japan
        CheckoutService jpCheckout = new CheckoutService(new JapanFactory(), "rakutenpay");
        jpCheckout.completeOrder(10000.0);
    }
}
