// Decorator Pattern
/*
 * Decorator Pattern
The Decorator Pattern is a structural design pattern that allows behavior to be added to individual objects, dynamically at runtime, without affecting the behavior of other objects from the same class.
    * It is typically used to extend the functionalities of classes in a flexible and reusable way.
    * Key Components
        * Component Interface: This defines the interface for objects that can have responsibilities added to them dynamically.
        * Concrete Component: This is the original object to which additional responsibilities can be attached.
        * Decorator: This is an abstract class that implements the component interface and contains a reference to a component object. It delegates all operations to the component.
        * Concrete Decorators: These are classes that extend the decorator and add specific functionalities to the component.

    * The pattern involves a set of decorator classes that are used to wrap concrete components.
    * Real-Life Analogy
Think of a coffee shop:
You order a simple coffee.
Then, you can add milk, add sugar, add whipped cream, etc.
You don't need a whole new drink class for every combination.

Each addition wraps the original and adds something more.

Problem It Solves
It solves the problem of class explosion that occurs when you try to use inheritance to add combinations of behavior. For Example, imagine you have:
A Pizza
A CheesePizza
A CheeseAndOlivePizza
A CheeseAndOliveStuffedPizza

Every combination would need a new subclass as shown in the code below.

Key Takeaways

Abstract Classes and Constructors:
Abstract classes can have constructors, and these constructors are executed when a subclass is instantiated. This is important for initializing common properties or behavior shared across all subclasses.
Decorator as Layers:
Each decorator acts like a layer, similar to wrapping a gift box. Every decorator adds behavior on top of the previous one, allowing for flexible and dynamic composition of functionality.
Call Stack Analogy:
The Decorator Pattern functions like a call stack, where behavior is accumulated step by step as each decorator wraps the component. This stacked behavior is then unwrapped during method calls, preserving the order and layering.
Loose Coupling Between Classes: The use of interfaces and composition in the Decorator Pattern ensures loose coupling between components. This makes the system more flexible, testable, and easier to extend without affecting existing code.

When Should You Use the Decorator Pattern?
The Decorator Pattern is particularly useful in scenarios where flexibility, modularity, and extensibility are key. Consider using it when:

You need to add responsibilities to objects dynamically:
Instead of hardcoding behaviors into a class, decorators allow you to attach additional functionality at runtime, offering great flexibility.
You want to avoid an explosion of subclasses:
For every possible combination of features, creating separate subclasses leads to unmanageable and bloated class hierarchies. Decorators eliminate this by composing behaviors.
You want to follow the Open/Closed Principle (OCP):
The pattern supports the OCP by allowing classes to be open for extension but closed for modification. You enhance behavior without altering existing code.
You want reusable and composable behaviors:
Decorators can be reused across different components and can be composed in various combinations to achieve desired functionality.
You need layered, step-by-step enhancements:
Decorators can be applied one after another, layering features gradually in a controlled and traceable way—much like wrapping layers around an object.


Advantages
A few advantages of using the Decorator Pattern are:

Adheres to the Open/Closed Principle (OCP): Enhancements can be made without modifying existing code, supporting scalability and maintainability.
Runtime Flexibility to Compose Features: Behaviors can be added or removed dynamically, allowing for highly customizable solutions.
Avoids Subclass Explosion: Instead of creating multiple subclasses for every feature combination, decorators provide a cleaner, more modular approach.
Promotes Single Responsibility for Each Add-on: Each decorator focuses on a specific functionality, leading to better code organization and readability.


Advantages
A few advantages of using the Decorator Pattern are:

Adheres to the Open/Closed Principle (OCP): Enhancements can be made without modifying existing code, supporting scalability and maintainability.
Runtime Flexibility to Compose Features: Behaviors can be added or removed dynamically, allowing for highly customizable solutions.
Avoids Subclass Explosion: Instead of creating multiple subclasses for every feature combination, decorators provide a cleaner, more modular approach.
Promotes Single Responsibility for Each Add-on: Each decorator focuses on a specific functionality, leading to better code organization and readability.


Real-World Use Cases
The Decorator Pattern is widely used in real-life software products to enable dynamic behavior composition without bloating the class hierarchy. Below are practical examples where it plays a critical role:

1. Food Delivery Applications (e.g., Swiggy, Zomato)
Context: Customers can customize food items with add-ons like extra cheese, sauces, toppings, or side dishes.

Role of Decorator Pattern:
Each add-on modifies the base food item's description and price dynamically.
Instead of creating subclasses for every combination (e.g., PizzaWithCheeseAndOlives), decorators like CheeseDecorator, OliveDecorator, etc., can be stacked over a base Pizza.
This allows the system to stay open for extension (new add-ons) but closed for modification.

2. Google Docs or Word Processors
Context: Users can apply text formatting like bold, italic, or underline independently or in combination.

Role of Decorator Pattern:
Each text style is implemented as a decorator that wraps the plain text object.
Allows flexible layering of styles, e.g., UnderlineDecorator(BoldDecorator(ItalicDecorator(Text))).
Avoids subclassing for all combinations like BoldItalicUnderlineText, keeping the design clean and extensible.



 */


// class PlainPizza{}
// class CheesePizza extends PlainPizza{}
// class PepperoniPizza extends PlainPizza{}
// class CheeseStuffedCrust extends PlainPizza{}
// class ExtraCheeseTopping extends PlainPizza{}

interface Pizza {
    String getDescription();
    double getCost();
}

// concrete component
class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}

// Decorator Abstract Class
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza; // HAS-A relationship

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// Concrete Decorators
class CheeseTopping extends PizzaDecorator {
    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Cheese Topping";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 100.0;
    }
}
class ExtraCheeseTopping extends PizzaDecorator{
    public ExtraCheeseTopping(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Extra Cheese Topping";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 200.0;
    }
}

class Olives extends PizzaDecorator{
    public Olives(Pizza pizza){
        super(pizza);
    }
    @Override
    public String getDescription(){
        return pizza.getDescription() + ", Olives Topping";
    }
    @Override
    public double getCost(){
        return pizza.getCost() + 350.0;
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new Margherita();
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());

        pizza = new CheeseTopping(pizza);
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());

        pizza = new ExtraCheeseTopping(new Margherita());
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());

        pizza = new Olives(new CheeseTopping(new Margherita()));
        System.out.println(pizza.getDescription() + " costs " + pizza.getCost());
    }
}
