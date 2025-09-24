// This is not fully Abstract Factory Pattern implementation, just a problem statement to show the violation of Open/Closed Principle.
// Let's say we have a CheckoutService that processes payments and generates invoices based on the user's region.
// For simplicity, we'll consider two regions: India and US.    


interface PaymentGateway{
    void processPayment(double amount);
}
class RazorpayGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing INR payment via Razorpay: " + amount);
    }
}
class PayUGateway implements PaymentGateway{
    public void processPayment(double amount){
        System.out.println("Processing INR payment via PayU: " + amount);
    }
}
interface Invoice{
    void generateInvoice();
}
class GSTInvoice implements Invoice{
    public void generateInvoice(){
        System.out.println("Generating GST Invoice for India.");
    }
}

class IndianFactory{
    public static PaymentGateway getPaymentGateway(String type){
        if(type.equalsIgnoreCase("razorpay")){
            return new RazorpayGateway();
        } else if(type.equalsIgnoreCase("payu")){
            return new PayUGateway();
        }
        throw new IllegalArgumentException("Unknown payment gateway type");
    }
    public static Invoice getInvoice(){
        return new GSTInvoice();
    }
}
class CheckoutService{
    private String gatewayType;
    public CheckoutService(String gatewayType){
        this.gatewayType = gatewayType; 
    }
    public void checkOut(double amount){
        PaymentGateway gateway = IndianFactory.getPaymentGateway(gatewayType);
        // if(gatewayType.equalsIgnoreCase("razorpay")){
        //     gateway = new RazorpayGateway();
        // } else {
        //     gateway = new PayUGateway();
        // }
        gateway.processPayment(amount);
        Invoice invoice = IndianFactory.getInvoice();
        invoice.generateInvoice();
    }
    // here we are violating the Open/Closed Principle because if we want to add more payment gateways or invoice types, we need to modify the CheckoutService class.
    // This can be resolved by using Abstract Factory Pattern.
// This is fine as long as we have only one region (India) and limited payment gateways and invoice types.
// But if we want to support multiple regions (like US, EU) with different payment gateways and invoice types, this design will become cumbersome.
// For example, if we want to add support for US region with PayPal and Stripe as payment gateways and USInvoice as invoice type, we would need to modify the CheckoutService class again.
// To adhere to the Open/Closed Principle, we can use Abstract Factory Pattern to create families of related objects without specifying their concrete classes.
// This way, we can add new regions, payment gateways, and invoice types without modifying the existing code.
// Let's see how we can implement Abstract Factory Pattern for this scenario.
// ========== US Implementations ==========
}

public class AbstractPatternProblem {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Pattern Example");
        
    }
}
