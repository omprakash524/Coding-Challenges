/* Notification Interface */
/* 
interface Notification{
    void sendNotification(String message);
}

class EmailNotification implements Notification{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending Email Notification: " + message);
    }
}

class SMSNotification implements Notification{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending SMS Notification: " + message);
    }
}

class CourierNotification implements Notification{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending Courier Notification: " + message);
    }
}

class WhatsAppNotification implements Notification{
    @Override
    public void sendNotification(String message){
        System.out.println("Sending WhatsApp Notification: " + message);
    }
}

class NotificationService{
    private Notification notification;
    NotificationService(Notification notification){
        this.notification = notification;
    }
    public void notifyUser(String message){
        notification.sendNotification(message);
    }
}
*/
//
abstract class Notification{
    abstract void sendNotification(String m);
}

class EmailNotification extends Notification{
    @Override
    void sendNotification(String m){
        System.out.println("Sending Email Notification: " + m);
    }
}
class WhatsAppNotification extends Notification{
    @Override
    void sendNotification(String m){
        System.out.println("Sending WhatsApp Notification: " + m);
    }
}

class NotificationService{
    Notification n;
    NotificationService(Notification n){
        this.n = n;
    }
    public void notifyUser(String m){
        n.sendNotification(m);
    }
}
interface Bird{
    void eat();
}
interface FlyBird extends Bird{
    void fly();
}
class Sparrow implements FlyBird{
    public void eat(){
        System.out.println("Sparrow is eating");
    }
    public void fly(){
        System.out.println("Sparrow is flying");
    }
}
class Ostrich implements Bird{
    public void eat(){
        System.out.println("Ostrich is eating");
    }
}
public class P {
    public static void main(String[] args) {
        System.out.println("Hello World");

        /*
        Notification email = new EmailNotification();
        email.sendNotification("Your order has been placed!");

        Notification sms = new SMSNotification();
        sms.sendNotification("Your OTP is 123456");

        Notification n;
        n = new CourierNotification();
        n.sendNotification("Your package is out for delivery");
        n = new WhatsAppNotification();
        n.sendNotification("Your meeting is at 10 AM tomorrow");

        NotificationService notificationService = new NotificationService(new EmailNotification());
        notificationService.notifyUser("Welcome to our service!");
        NotificationService nsSMS = new NotificationService((new SMSNotification()));
        nsSMS.notifyUser("Your verification code is 654321");
        NotificationService nsWhatsApp = new NotificationService(new WhatsAppNotification());
        nsWhatsApp.notifyUser("Don't forget our meeting at 3 PM");

        */

        NotificationService ns = new NotificationService(new EmailNotification());
        ns.notifyUser("Your order has been shipped!");
        NotificationService ns2 = new NotificationService(new WhatsAppNotification());
        ns2.notifyUser("Your package will arrive tomorrow!");
    }
}
