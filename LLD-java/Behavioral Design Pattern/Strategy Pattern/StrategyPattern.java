// Strategy Pattern
/*
 * The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime.
 * It defines a family of algorithms, encapsulates each one, and makes them interchangeable.
 * This pattern allows the algorithm to vary independently from clients that use it.
 * 
 * 
 * 
 * Introduction
Behavioral design patterns focus on how objects interact and communicate with each other, helping to define the flow of control in a system. These patterns make systems more flexible by allowing behavior to be selected or changed at runtime without altering the core logic.

Imagine a navigation app that can switch between driving, walking, or cycling routes. The algorithm used to calculate the path depends on the selected mode of travel. Instead of hardcoding all possible strategies inside one class, wouldn’t it be better if each strategy was defined separately and chosen dynamically?

That’s exactly what the Strategy Pattern enables. It allows a class to choose its behavior at runtime by encapsulating related algorithms into interchangeable objects. Let's explore the Strategy Pattern in detail in the upcoming sections.

Strategy Pattern
The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one into a separate class, and makes them interchangeable at runtime depending on the context.

Formal Definition
The Strategy Pattern is a behavioral design pattern that enables selecting an algorithm's behavior at runtime by defining a set of strategies (algorithms), each encapsulated in its own class, and making them interchangeable via a common interface.

It is primarily focused on changing the behavior of an object dynamically, without modifying its class. This promotes better organization of related algorithms and enhances code flexibility and scalability.
Real-Life Analogy
Consider how Uber matches a rider with a driver. The underlying algorithm may change depending on the context, like matching with the nearest driver, giving priority to surge zones, or choosing from an airport queue.
In this case:
The ride-matching service is the context.
The different matching algorithms (nearest, surge-priority, airport-queue) are the strategies.
The strategy interface allows the system to switch between these algorithms seamlessly, depending on real-time conditions.

Similarly, in software, the Strategy Pattern allows a class to use different algorithms or behaviors at runtime, without altering its code structure, just like Uber switches matching strategies based on need.
Understanding the Problem
Let’s say we are building a ride-matching service for a ride-hailing platform. The matching behavior changes depending on conditions such as proximity, surge areas, or airport queues.


How This Solves the Earlier Problems
Problem in Old Approach	                How Strategy Pattern Solves It
Violation of Open/Closed Principle	    New strategies can be added without modifying existing service code, just create a new class implementing MatchingStrategy.
Code Becomes Messy	                    Eliminates complex if-else logic by delegating behavior to separate classes.
Difficult to Test or Reuse	            Each strategy is independently testable and reusable across services or contexts.
No Separation of Concerns	            RideMatchingService is only concerned with coordination, actual logic lies in strategy classes.


Suitable Scenarios for Strategy Pattern
The Strategy Pattern is an ideal choice in the following scenarios:

Multiple Interchangeable Algorithms:
When a system supports different algorithms or behaviors that can be swapped in and out based on context or configuration.
Compliance with Open/Closed Principle (OCP):
When new strategies need to be introduced without modifying the existing business logic, keeping the core code closed for modification and open for extension.
Elimination of Conditionals:
When large blocks of if-else or switch statements are used to select behavior, Strategy Pattern helps to cleanly separate these into dedicated classes.
Behavior-Specific Unit Testing
When there's a need to test behaviors independently and isolate them from the context, Strategy Pattern offers clear test boundaries.
Runtime Behavior Selection
When the behavior of a class needs to be selected dynamically during execution based on user input, configuration, or environment.
Pros and Cons

Pros
Supports the Open/Closed Principle (OCP):
New strategies can be added without modifying existing code, keeping the system extensible.
Easy to Add New Behaviors:
Each behavior is encapsulated in its own class, making it simple to plug in new logic.
Enables Runtime Behavior Changes:
Behavior can be changed dynamically at runtime by swapping strategy objects.
Encourages Composition Over Inheritance:
Promotes flexible design by favoring object composition rather than rigid class hierarchies.

Cons
May Lead to Too Many Small Classes:
Each strategy is implemented in a separate class, which can increase code volume.
Requires Awareness of All Strategies:
The client needs to know which strategies exist and when to use each one.
Slight Overhead Due to Interfaces:
Involves extra structure around interfaces, which may be unnecessary for simple logic.
Slightly More Complex Than if-else:
For very simple cases, the Strategy Pattern may introduce more complexity than needed.


✅ Key Idea
Instead of hardcoding an algorithm inside a class, you delegate the behavior to a separate strategy object. This makes your code flexible and easier to maintain.

Structure


Strategy Interface
Defines a common interface for all supported algorithms.


Concrete Strategies
Implement different variations of the algorithm.


Context
Maintains a reference to a strategy object and delegates the work to it.


Here’s a FAANG-focused Strategy Pattern interview revision sheet with questions and detailed answers:
________________________________________
✅ 1. Explain the Strategy Pattern. Why is it useful?
Answer:\ The Strategy Pattern is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. It allows the algorithm to vary independently from clients that use it.\ Why useful?
•	Promotes Open/Closed Principle (easy to add new strategies without modifying existing code).
•	Removes large if-else blocks.
•	Enables runtime flexibility.
________________________________________
✅ 2. How is Strategy Pattern different from State Pattern?
Answer:
•	Strategy Pattern: Focuses on choosing an algorithm dynamically. The state does not change internally; the client decides which strategy to use.
•	State Pattern: Focuses on changing behavior based on internal state transitions. The object manages its own state.
________________________________________
✅ 3. Give a real-world example of Strategy Pattern.
Answer:
•	Payment systems: Credit Card, UPI, PayPal.
•	Sorting algorithms: QuickSort, MergeSort, HeapSort.
•	Compression tools: ZIP, RAR, GZIP.
________________________________________
✅ 4. How does Strategy Pattern adhere to SOLID principles?
Answer:
•	Single Responsibility: Each strategy class handles one algorithm.
•	Open/Closed: Add new strategies without modifying existing code.
•	Dependency Inversion: Context depends on an abstraction (interface), not concrete classes.
________________________________________
✅ 5. What are the disadvantages of Strategy Pattern?
Answer:
•	Increased number of classes.
•	Client must know which strategy to use.
•	Can lead to complexity if too many strategies exist.
________________________________________
✅ 6. How would you implement dynamic behavior switching at runtime?
Answer:\ By allowing the Context class to accept a new strategy object via a setter method:
context.setStrategy(new UpiPayment());
________________________________________
✅ 7. Can Strategy Pattern be combined with Factory Pattern?
Answer:\ Yes. Use Factory Pattern to create the appropriate strategy object based on input, then inject it into the context. This avoids exposing strategy creation logic to the client.
________________________________________
✅ 8. Design a sorting utility using Strategy Pattern.
Answer:
•	Strategy Interface: SortStrategy { void sort(List<Integer> list); }
•	Concrete Strategies: QuickSort, MergeSort, HeapSort.
•	Context: Sorter class that uses a SortStrategy.
________________________________________
✅ 9. When would you use Strategy Pattern over Template Method Pattern?
Answer:
•	Strategy: When you want to swap entire algorithms dynamically.
•	Template Method: When you want to fix the structure but allow subclasses to override specific steps.
________________________________________
✅ 10. How do you avoid creating too many classes in Strategy Pattern?
Answer:
•	Use lambda expressions or functional interfaces in languages like Java 8+.
•	Example:
PaymentStrategy upiPayment = amount -> System.out.println("Paid " + amount + " via UPI");
________________________________________
🔥 Pro Tip for FAANG Interviews:\ Always connect your answer to scalability and maintainability. For example:
“I’d use Strategy Pattern in a payment system because it allows adding new payment methods without modifying existing code, which is critical for scalability in large systems.”
________________________________________



 */


/* Example: Ride Matching Service
 * In a ride-sharing application, different strategies can be used to match riders with drivers.
 * Strategies could include matching based on proximity, driver ratings, or cost.
 * The Strategy Pattern allows the application to switch between these matching strategies dynamically.
 *
 * 
 * Problems with This Approach:
Issue	Explanation
Violation of Open/Closed Principle	Adding a new strategy (e.g., VIP rider matching) would require modifying the RideMatchingService class. This tightly couples strategy logic with the core class.
Code Becomes Messy	As more conditions are added, the number of if-else branches grows, making the code harder to maintain and read.
Difficult to Test or Reuse	Individual matching strategies are not reusable or testable in isolation. All logic is embedded inside a single method.
No Separation of Concerns	The class handles both coordination (service logic) and implementation (strategy logic), which reduces flexibility.


// Without Strategy Pattern
class RideMatchService{
    public void matchRider(String riderLocation, String matchingType){
        if(matchingType.equals("NEAREST")){
            // Find nearest driver
        }else if(matchingType.equals("RATING")){
            // Find highest rated driver
        }else if(matchingType.equals("COST")){
            // Find lowest cost driver
        }
    }
}

*/

// With Strategy Pattern
interface MatchingStrategy {
    void match(String riderLocation);
}

class NearestDriverStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        // Logic to find nearest driver
        System.out.println("Matching rider at " + riderLocation + " with nearest driver.");
    }
}

class AirportQueueStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        // Logic to find driver in airport queue
        System.out.println("Matching rider at " + riderLocation + " with driver from airport queue.");
    }
}

class SurgePriorityStrategy implements MatchingStrategy {
    @Override
    public void match(String riderLocation) {
        // Logic to find driver based on surge pricing
        System.out.println("Matching rider at " + riderLocation + " with driver based on surge pricing.");
    }
}

class RideMatchingService {
    private MatchingStrategy matchingStrategy;

    public RideMatchingService(MatchingStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public void setMatchingStrategy(MatchingStrategy matchingStrategy) {
        this.matchingStrategy = matchingStrategy;
    }

    public void matchRider(String riderLocation) {
        matchingStrategy.match(riderLocation);
    }
}






public class StrategyPattern {
    public static void main(String[] args) {
        System.out.println("Strategy Pattern Example");
        RideMatchingService rideMatchingService = new RideMatchingService(new NearestDriverStrategy());
        rideMatchingService.matchRider("Downtown");
        rideMatchingService.setMatchingStrategy(new AirportQueueStrategy());
        rideMatchingService.matchRider("Airport");
        rideMatchingService.setMatchingStrategy(new SurgePriorityStrategy());
        rideMatchingService.matchRider("Surge Area");
    }
}
