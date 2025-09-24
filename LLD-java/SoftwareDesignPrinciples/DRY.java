// LLD - Low Level Design
// Demonstrating DRY Principle
/*
 * DRY: Don't Repeat Yourself
 * The DRY principle emphasizes the importance of reducing code duplication.
 * When you find yourself writing the same code multiple times, it's a sign that you should refactor it into a single, reusable component.
 * This makes your codebase cleaner, easier to maintain, and less error-prone.
 * 
 * ❌ Violation Example
 * Let's say we have a class that calculates the area of different shapes:
 * class AreaCalculator {
    public double calculateCircleArea(double radius) {
        return Math.PI * radius * radius;
    }

    public double calculateSquareArea(double side) {
        return side * side;
    }

    public double calculateRectangleArea(double length, double width) {
        return length * width;
    }
}


    // ❌ Violation
public class Invoice {
    public double calculateTax(double amount) {
        return amount * 0.18;
    }

    public double calculateTotal(double amount) {
        return amount + (amount * 0.18); // repeated tax logic
    }
}

// ✅ DRY Applied
public class TaxCalculator {
    public double calculateTax(double amount) {
        return amount * 0.18;
    }
}

public class Invoice {
    private TaxCalculator taxCalculator = new TaxCalculator();

    public double calculateTotal(double amount) {
        return amount + taxCalculator.calculateTax(amount);
    }
}

    * 
    * If we need to add more shapes, we might end up duplicating the area calculation logic.
    * This violates the DRY principle.
    * 
    * ✅ Correct DRY Design
    * We can refactor the code to use an interface and separate classes for each shape:
    */
// Shape interface
interface Shape {
    double area();
}
// Circle class
class Circle implements Shape {
    private double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * radius * radius;
    }
}
// Square class
class Square implements Shape {
    private double side;

    Square(double side) {
        this.side = side;
    }

    public double area() {
        return side * side;
    }
}

public class DRY {
    public static void main(String[] args) {
        Shape circle = new Circle(5);
        Shape square = new Square(4);

        System.out.println("Circle Area: " + circle.area());
        System.out.println("Square Area: " + square.area());
    }
}
