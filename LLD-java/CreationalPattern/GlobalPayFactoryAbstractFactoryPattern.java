// abstract factory interface
interface PaymentGatewayMethod{
    void makePayment(double amount);
}
interface InvoiceMethod{
    void makeInvoice();
}
interface RefundMethod{
    void processRefund(double amount);
}

// concrete payment gateways for India
class BhimPayment implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing INR payment via BHIM: " + amount);
    }
}
class PhonePePayment implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing INR payment via PhonePe: " + amount);
    }
}
class GSTInvoiceMethod implements InvoiceMethod{
    public void makeInvoice(){
        System.out.println("Generating GST Invoice for India.");
    }
}
class IndiaRefundMethod implements RefundMethod{
    public void processRefund(double amount){
        System.out.println("Processing INR refund via India Refund Method: " + amount);
    }
}
// concrete payment gateways for China
class AliChatPaymentMethod implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing CNY payment via AliChat: " + amount);
    }
}
class WeChatPaymentMethod implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing CNY payment via WeChat: " + amount);
    }
}
class CNInvoiceMethod implements InvoiceMethod{
    public void makeInvoice(){
        System.out.println("Generating CN Invoice for China.");
    }
}
class ChinaRefundMethod implements RefundMethod{
    public void processRefund(double amount){
        System.out.println("Processing CNY refund via China Refund Method: " + amount);
    }
}
// concrete payment gateways for South Korea
class KakaoPayPaymentMethod implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing KRW payment via KakaoPay: " + amount);
    }
}
class NaverPayPaymentMethod implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing KRW payment via NaverPay: " + amount);
    }
}
class KRInvoiceMethod implements InvoiceMethod{
    public void makeInvoice(){
        System.out.println("Generating KR Invoice for South Korea.");
    }
}
class KoreaRefundMethod implements RefundMethod{
    public void processRefund(double amount){
        System.out.println("Processing KRW refund via Korea Refund Method: " + amount);
    }
}
// concrete payment gateways for Africa
class MpesaPaymentMethod implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing KES payment via Mpesa: " + amount);
    }
}
class FlutterwavePaymentMethod implements PaymentGatewayMethod{
    public void makePayment(double amount){
        System.out.println("Processing USD payment via Flutterwave: " + amount);
    }
}
class AFRInvoiceMethod implements InvoiceMethod{
    public void makeInvoice(){
        System.out.println("Generating AFR Invoice for Africa.");
    }
}
class AfricaRefundMethod implements RefundMethod{
    public void processRefund(double amount){
        System.out.println("Processing USD refund via Africa Refund Method: " + amount);
    }
}
// abstract factory interface
interface RegionalFactory{
    PaymentGatewayMethod getPaymentGatewayMethod(String type);
    InvoiceMethod getInvoiceMethod();
    RefundMethod getRefundMethod();
}

// concrete factories
class IndiaFactory implements RegionalFactory{
    public PaymentGatewayMethod getPaymentGatewayMethod(String type){
        if(type.equalsIgnoreCase("bhim")){
            return new BhimPayment();
        } else if(type.equalsIgnoreCase("phonepe")){
            return new PhonePePayment();
        }
        throw new IllegalArgumentException("Unknown payment gateway type");
    }
    public InvoiceMethod getInvoiceMethod(){
        return new GSTInvoiceMethod();
    }
    public RefundMethod getRefundMethod(){
        return new IndiaRefundMethod();
    }
}
class ChinaFactory implements RegionalFactory{
    public PaymentGatewayMethod getPaymentGatewayMethod(String type){
        if(type.equalsIgnoreCase("alichat")){
            return new AliChatPaymentMethod();
        } else if(type.equalsIgnoreCase("wechat")){
            return new WeChatPaymentMethod();
        }
        throw new IllegalArgumentException("Unknown payment gateway type");
    }
    public InvoiceMethod getInvoiceMethod(){
        return new CNInvoiceMethod();
    }
    public RefundMethod getRefundMethod(){
        return new ChinaRefundMethod();
    }
}
class KoreaFactory implements RegionalFactory{
    public PaymentGatewayMethod getPaymentGatewayMethod(String type){
        if(type.equalsIgnoreCase("kakaopay")){
            return new KakaoPayPaymentMethod();
        } else if(type.equalsIgnoreCase("naverpay")){
            return new NaverPayPaymentMethod();
        }
        throw new IllegalArgumentException("Unknown payment gateway type");
    }
    public InvoiceMethod getInvoiceMethod(){
        return new KRInvoiceMethod();
    }
    public RefundMethod getRefundMethod(){
        return new KoreaRefundMethod();
    }
}
class AfricaFactory implements RegionalFactory{
    public PaymentGatewayMethod getPaymentGatewayMethod(String type){
        if(type.equalsIgnoreCase("mpesa")){
            return new MpesaPaymentMethod();
        } else if(type.equalsIgnoreCase("flutterwave")){
            return new FlutterwavePaymentMethod();
        }
        throw new IllegalArgumentException("Unknown payment gateway type");
    }
    public InvoiceMethod getInvoiceMethod(){
        return new AFRInvoiceMethod();
    }
    public RefundMethod getRefundMethod(){
        return new AfricaRefundMethod();
    }
}
// checkout service
class CheckoutServiceMethod{
    private RegionalFactory factory;
    private String gatewayType;
    public CheckoutServiceMethod(RegionalFactory factory, String gatewayType){
        this.factory = factory;
        this.gatewayType = gatewayType; 
    }
    public void completeOrderMethod(double amount){
        PaymentGatewayMethod gateway = factory.getPaymentGatewayMethod(gatewayType);
        gateway.makePayment(amount);
        InvoiceMethod invoice = factory.getInvoiceMethod();
        invoice.makeInvoice();
        RefundMethod refund = factory.getRefundMethod();
        refund.processRefund(amount);
    }
}

public class GlobalPayFactoryAbstractFactoryPattern {
    public static void main(String[] args) {
        System.out.println("Abstract Factory Pattern Problem Statement in Java");
        // Using BHIM in India
        CheckoutServiceMethod inCheckout = new CheckoutServiceMethod(new IndiaFactory(), "bhim");
        inCheckout.completeOrderMethod(1000);
        System.out.println("---");
        // Using WeChat in China
        CheckoutServiceMethod cnCheckout = new CheckoutServiceMethod(new ChinaFactory(), "wechat");
        cnCheckout.completeOrderMethod(2000);
        System.out.println("---");
        // Using KakaoPay in South Korea
        CheckoutServiceMethod krCheckout = new CheckoutServiceMethod(new KoreaFactory(), "kakaopay");
        krCheckout.completeOrderMethod(3000);
        System.out.println("---");
        // Using Mpesa in Africa
        CheckoutServiceMethod afCheckout = new CheckoutServiceMethod(new AfricaFactory(), "mpesa");
        afCheckout.completeOrderMethod(4000);
    }
}
