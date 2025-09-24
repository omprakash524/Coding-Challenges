// Single Responsibility Principle
// A class should have only one reason to change, meaning it should only have one job or responsibility.
/*
 * In system design, SRP helps you modularize your architecture so that each part of the system has a clear, focused responsibility. This improves:
 * Maintainability: Easier to update or fix.
 * Scalability: Easier to scale specific parts.
 * Testability: Easier to write unit tests.
 * Reusability: Components can be reused in other contexts.
class OrderManager {
    void createOrder() {...}
    void sendEmail() {...} // ❌ Violates SRP
}
class EmailService {
    void sendEmail() {...} // ✅ Adheres to SRP

-----------------------------------------------------------------
public class OrderManager {
    public void createOrder(String item) {
        System.out.println("Order created for: " + item);
    }

    public void sendEmail(String email) {
        System.out.println("Email sent to: " + email);
    }

    public void saveToDatabase(String data) {
        System.out.println("Saved to DB: " + data);
    }
}

❌ Problems:
Multiple responsibilities: Order creation, email sending, and database operations.
Hard to maintain: Any change in email logic or DB logic affects this class.
Violates SRP.

 */

 // Handles order-related logic
class OrderService {

    public void createOrder(String item) {
        System.out.println("Order created for: " + item);
    }
}

// Handles email notifications
class EmailService {

    public void sendEmail(String email) {
        System.out.println("Email sent to: " + email);
    }
}
// Handles payment processing
class PaymentService{
    public void processPayment(String paymentMethod){
        System.out.println("Payment processed using: " + paymentMethod);
    }
}

// Handles database operations
class DatabaseService {

    public void saveToDatabase(String data) {
        System.out.println("Saved to DB: " + data);
    }
}
/*
✅ Benefits:
Each class has one responsibility.
Easier to test, maintain, and extend.
Follows clean architecture principles.
 */

public class SRP_Principle {
    public static void main(String[] args) {
        OrderService orderService = new OrderService();
        orderService.createOrder("Book");

        EmailService emailService = new EmailService();
        emailService.sendEmail("user@example.com");

        DatabaseService databaseService = new DatabaseService();
        databaseService.saveToDatabase("Order data");

        PaymentService paymentService = new PaymentService();
        paymentService.processPayment("Credit Card");
        
    }
}
