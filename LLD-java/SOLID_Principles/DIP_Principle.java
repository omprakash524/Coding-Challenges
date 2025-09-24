// DIP: Dependency Inversion Principle
// High-level modules should not depend on low-level modules. Both should depend on abstractions.
// Abstractions should not depend on details. Details should depend on abstractions.
// This principle is about decoupling software modules. It suggests that the high-level modules
// (which contain complex logic) should not depend on low-level modules (which provide utility features).
// Instead, both should depend on abstractions (e.g., interfaces).
/*
 * High-level modules should not depend on low-level modules. Both should depend on abstractions."
"Abstractions should not depend on details. Details should depend on abstractions.


❌ Violation Example

class MySQLDatabase {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}

class Application {
    private MySQLDatabase db = new MySQLDatabase(); // ❌ tightly coupled

    public void start() {
        db.connect();
    }
}
    ❌ Problem:
Application is tightly coupled to MySQLDatabase.
Hard to switch to another database (e.g., PostgreSQL).
Violates DIP.


✅ Correct DIP Design
Use an interface to abstract the database:

 */

// Abstraction
interface Database {
    void connect();
}

// Low-level module
class MySQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to MySQL");
    }
}
// low-level module
class MongoDBDatabase implements Database{
    public void connect(){
        System.out.println("Connected to MongoDB");
    }
}

// Another low-level module
class PostgreSQLDatabase implements Database {
    public void connect() {
        System.out.println("Connected to PostgreSQL");
    }
}

// High-level module
class Application {
    private Database db;
    // Inject dependency via constructor
    public Application(Database db) {
        this.db = db;
    }
    public void start() {
        db.connect();
    }
}


// import java.io.*;

// ----------- another example of DIP ------------------
interface PaymentProcessor{
    void processPayment();
}

class CreditCardProcessor implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing credit card payment");
    }
}

class UPIPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing UPI payment");
    }
}

class CashOnDelivery implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing cash on delivery payment");
    }
}
class BitcoinPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing Bitcoin payment");
    }
}
class PayPalPaymentProcessor implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing PayPal payment");
    }
}
class BankTransferProcessor implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing Bank Transfer payment");
    }
}
class ApplePayProcessor implements PaymentProcessor{
    @Override
    public void processPayment(){
        System.out.println("Processing Apple Pay payment");
    }
}


// This class depends on the abstraction (PaymentProcessor) rather than concrete implementations
// This allows us to add new payment methods without modifying the PaymentService class
// thus adhering to the Dependency Inversion Principle
class PaymentService{
    private PaymentProcessor paymentProcessor;
    public PaymentService(PaymentProcessor paymentProcessor){
        this.paymentProcessor = paymentProcessor;
    }
    public void makePayment(){
        paymentProcessor.processPayment();
    }
}
public class DIP_Principle {
    public static void main(String[] args) {
        
        Database mysql = new MySQLDatabase();
        Database postgres = new PostgreSQLDatabase();
        Database mongo = new MongoDBDatabase();

        Application app1 = new Application(mysql);
        Application app2 = new Application(postgres);
        Application app3 = new Application(mongo);

        app1.start();  // Output: Connected to MySQL
        app2.start();  // Output: Connected to PostgreSQL
        app3.start();  // Output: Connected to MongoDB

        // -----  another example -----------
        PaymentProcessor creditCard = new CreditCardProcessor();
        PaymentService paymentService = new PaymentService(creditCard);

        paymentService.makePayment();

        PaymentService upiPaymentService = new PaymentService(new UPIPaymentProcessor());
        upiPaymentService.makePayment();

        PaymentProcessor cod = new CashOnDelivery();
        PaymentService codPaymentService = new PaymentService(cod);
        codPaymentService.makePayment();

        PaymentProcessor bitcoin = new BitcoinPaymentProcessor();
        PaymentService bitcoinPaymentService = new PaymentService(bitcoin);
        bitcoinPaymentService.makePayment();

        PaymentProcessor paypal = new PayPalPaymentProcessor();
        PaymentService paypalPaymentService = new PaymentService(paypal);
        paypalPaymentService.makePayment();

        PaymentProcessor bankTransfer = new BankTransferProcessor();
        PaymentService bankTransferPaymentService = new PaymentService(bankTransfer);
        bankTransferPaymentService.makePayment();

        PaymentProcessor applePay = new ApplePayProcessor();
        PaymentService applePayPaymentService = new PaymentService(applePay);
        applePayPaymentService.makePayment();
    }
}
