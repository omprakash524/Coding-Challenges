// Facade Pattern
// Facade Pattern provides a simplified interface to a complex subsystem.
/*
 * The Facade Pattern is a structural design pattern that provides a simplified, unified interface to a complex subsystem or group of classes.
 * It acts as a single entry point for clients to interact with the system, hiding the underlying complexity and making the system easier to use.
 * 
 * 🧠 Concept in Simple Terms
Imagine you're at a restaurant. You don’t go to the kitchen, talk to the chef, or manage the billing system. You just talk to the waiter.
The waiter is your facade — he simplifies your interaction with the complex subsystems (kitchen, billing, inventory, etc.).


When to use Facade Pattern?
You should use use Facade pattern when:

Subsystems are complex: This means there are too many classes and too many dependencies within the system you are trying to simplify.
You want to provide a simpler API for the outer world: The Facade acts as a simplified entry point, hiding the complexity from clients.
You want to reduce coupling between subsystems and client code: By interacting with the facade, the client code becomes less dependent on the individual components of the subsystem.
You want to layer your architecture cleanly: The Facade helps in organizing the system into distinct layers, making it more modular and understandable.

Advantages
A few advantages of using the Facade Pattern are:

Lightweight coupling: It reduces the dependencies between the client and the subsystem.
Flexibility: It allows the subsystem to evolve without impacting the client code.
Simplifies client design: Clients interact with a single, simplified interface instead of multiple complex objects.
Promotes layered architecture: It helps organize the system into distinct layers, improving maintainability and scalability.
Better testability: Individual subsystem components can be tested independently, and the facade itself can be tested for its orchestration logic.


Disadvantages
A few disadvantages of using the Facade Pattern are:

Fragile coupling: If the facade itself changes frequently, it can still lead to ripple effects on client code.
Hidden complexity: While it simplifies the client's view, the underlying complexity of the subsystem still exists, just hidden. This can make debugging or understanding the full flow more challenging for developers working on the subsystem.
Runtime errors: Errors originating from the complex subsystem might be harder to diagnose when only interacting through the facade.
Difficult to trace: Debugging can be more challenging as the facade adds another layer of indirection.
Violation of SRP (Single Responsibility Principle): A facade might take on too many responsibilities if it orchestrates a very large and diverse set of operations, potentially becoming a "god object."




🏠 Real-World Analogy
Think of a smart home:

You have subsystems: Lights, Thermostat, Security, Music System
Instead of controlling each one separately, you press “Good Night” on your app:

Lights turn off
Thermostat adjusts
Security system activates
Music stops



That “Good Night” button is the Facade.



 */

// Subsystem Classes
class Light{
    public void turnOn(){
        System.out.println("Lights are ON");
    }

    public void turnOff(){
        System.out.println("Lights are OFF");
    }
}

class Thermostat{
    public void setTemperature(int temperature){
        System.out.println("Thermostat set to " + temperature + " degrees.");
    }
}

class SecuritySystem{
    public void activate(){
        System.out.println("Security system activated.");
    }

    public void deactivate(){
        System.out.println("Security system deactivated.");
    }
}

class MusicSystem{
    public void stop(){
        System.out.println("Music stopped.");
    }

    public void play(){
        System.out.println("Music playing.");
    }
}

// Facade Class
class SmartHomeFacade{
    private Light light;
    private Thermostat thermostat;
    private SecuritySystem securitySystem;
    private MusicSystem musicSystem;

    public SmartHomeFacade(){
        this.light = new Light();
        this.thermostat = new Thermostat();
        this.securitySystem = new SecuritySystem();
        this.musicSystem = new MusicSystem();
    }

    public void goodNight(){
        light.turnOff();
        thermostat.setTemperature(18);
        securitySystem.activate();
        musicSystem.stop();
        System.out.println("Good Night routine completed.");
    }

    public void goodMorning(){
        light.turnOn();
        thermostat.setTemperature(22);
        securitySystem.deactivate();
        musicSystem.play();
        System.out.println("Good Morning routine completed.");
    }
}


// ====== Another example of Facade Pattern =====
/*

// without Facade
/*
 * While this code works, it's tightly coupled. The Main class (or client code) is manually calling each subsystem service in the correct order and with the correct parameters.

 * This leads to:
 * High complexity for the client
 * Duplicate code if you have to do this in multiple places
 * Violation of the Single Responsibility Principle (the Main class knows too much)

class PaymentServiceWithoutFacade{
    public void processPayment(String account, double amount){
        System.out.println("Processing payment of " + amount + " for account " + account);
    }
}

class NotificationService{
    public void sendNotification(String message){
        System.out.println("Sending notification: " + message);
    }
}

class SeatReservationService{
    public void reserveSeat(String movieId, String seatNumber){
        System.out.println("Reserving seat: " + seatNumber + " for movie: " + movieId);
    }
}

class LoyaltyService{
    public void addPoints(String account, int points){
        System.out.println("Adding " + points + " loyalty points to account " + account);
    }
}

class TicketService{
    public void generateTicket(String movieId, String seatNumber){
        System.out.println("Generating ticket for movie: " + movieId + ", seat: " + seatNumber);
    }
}

*/

// Using Facade Pattern
// Service class responsible for handling payments
class PaymentService {

    public void makePayment(String accountId, double amount) {
        System.out.println("Payment of ₹" + amount + " successful for account " + accountId);
    }
}

// Service class responsible for reserving seats
class SeatReservationService {

    public void reserveSeat(String movieId, String seatNumber) {
        System.out.println("Seat " + seatNumber + " reserved for movie " + movieId);
    }
}

// Service class responsible for sending notifications
class NotificationService {

    public void sendBookingConfirmation(String userEmail) {
        System.out.println("Booking confirmation sent to " + userEmail);
    }
}

// Service class for managing loyalty/reward points
class LoyaltyPointsService {

    public void addPoints(String accountId, int points) {
        System.out.println(points + " loyalty points added to account " + accountId);
    }
}

// Service class for generating movie tickets
class TicketService {

    public void generateTicket(String movieId, String seatNumber) {
        System.out.println("Ticket generated for movie " + movieId + ", Seat: " + seatNumber);
    }
}

// ========== The MovieBookingFacade class  ==============
class MovieBookingFacade {

    private PaymentService paymentService;
    private SeatReservationService seatReservationService;
    private NotificationService notificationService;
    private LoyaltyPointsService loyaltyPointsService;
    private TicketService ticketService;

    // Constructor to initialize all the subsystem services.
    public MovieBookingFacade() {
        this.paymentService = new PaymentService();
        this.seatReservationService = new SeatReservationService();
        this.notificationService = new NotificationService();
        this.loyaltyPointsService = new LoyaltyPointsService();
        this.ticketService = new TicketService();
    }

    // Method providing a simplified interface for booking a movie ticket
    public void bookMovieTicket(String accountId, String movieId, String seatNumber, String userEmail, double amount) {
        paymentService.makePayment(accountId, amount);
        seatReservationService.reserveSeat(movieId, seatNumber);
        ticketService.generateTicket(movieId, seatNumber);
        loyaltyPointsService.addPoints(accountId, 50);
        notificationService.sendBookingConfirmation(userEmail);

        // Indicate successful completion of the entire booking process.
        System.out.println("Movie ticket booking completed successfully!");
    }
}

public class FacadePattern {
    public static void main(String[] args) {
        SmartHomeFacade smartHome = new SmartHomeFacade();
        smartHome.goodNight();
        System.out.println("-----");
        smartHome.goodMorning();

        // Without Facade
        // System.out.println("-----");
        // PaymentServiceWithoutFacade paymentService = new PaymentServiceWithoutFacade();
        // NotificationService notificationService = new NotificationService();
        // SeatReservationService seatReservationService = new SeatReservationService();
        // LoyaltyService loyaltyService = new LoyaltyService();
        // TicketService ticketService = new TicketService();

        // Simulating a movie ticket booking
        String account = "user@example.com";
        double amount = 12.99;
        String movieId = "movie123";
        String seatNumber = "A1";
        int loyaltyPoints = 100;

        // paymentService.processPayment(account, amount);
        // notificationService.sendNotification("Payment successful for movie: " + movieId);
        // seatReservationService.reserveSeat(movieId, seatNumber);
        // loyaltyService.addPoints(account, loyaltyPoints);
        // ticketService.generateTicket(movieId, seatNumber);

        System.out.println("-----");
        // With Facade
        MovieBookingFacade movieBookingFacade = new MovieBookingFacade();
        movieBookingFacade.bookMovieTicket(account, movieId, seatNumber, "user@example.com", amount);


    }
}
