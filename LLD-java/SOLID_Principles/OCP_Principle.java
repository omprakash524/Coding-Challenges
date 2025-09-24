/*
 * OCP: Open Closed Principle
 * Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification.
 * This means that we should be able to add new functionality without changing the existing code.
 * This can be achieved using interfaces, abstract classes, and polymorphism.

 public class DiscountCalculator {
    public double getDiscount(String customerType) {
        if (customerType.equals("Regular")) {
            return 0.1;
        } else if (customerType.equals("Premium")) {
            return 0.2;
        } else {
            return 0.0;
        }
    }
}
❌ Problems:
Every time a new customer type is added, you must modify this class.
Violates OCP.
 */
// Base interface
interface DiscountStrategy {
    double getDiscount();
}

// Regular customer
class RegularDiscount implements DiscountStrategy {
    public double getDiscount() {
        return 0.1;
    }
}

// Premium customer
class PremiumDiscount implements DiscountStrategy {
    public double getDiscount() {
        return 0.2;
    }
}


abstract class Shape{
    abstract void draw();
}
class Circle extends Shape{
    @Override
    void draw(){
        System.out.println("Drawing a circle");
    }
}
class Rectangle extends Shape{
    @Override
    void draw(){
        System.out.println("Drawing a rectangle");
    }
}
public class OCP_Principle {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();

        circle.draw();
        rectangle.draw();

        // Discount calculation using OCP
        DiscountStrategy regular = new RegularDiscount();
        DiscountStrategy premium = new PremiumDiscount();

        System.out.println("Regular customer discount: " + regular.getDiscount());
        System.out.println("Premium customer discount: " + premium.getDiscount());


    }
}
