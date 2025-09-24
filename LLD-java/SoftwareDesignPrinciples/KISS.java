// KISS - Keep It Simple Stupid
// The KISS principle states that most systems work best if they are kept simple rather than made complex.
// Therefore, simplicity should be a key goal in design, and unnecessary complexity should be avoided.
// The KISS principle is about avoiding over-engineering and keeping the design straightforward and easy to understand.
// It encourages developers to focus on the essential features and functionality, rather than adding unnecessary bells and
// whistles that complicate the system.
// By adhering to the KISS principle, you can create software that is easier to maintain, understand, and extend over time.
// This leads to more efficient development processes and better overall software quality.
// In practice, this means breaking down complex problems into smaller, manageable parts, using clear and concise code, and avoiding unnecessary abstractions or convoluted logic.
// The KISS principle is often summarized by the phrase "Keep It Simple, Stupid," which serves as a reminder to prioritize simplicity in design and implementation.
// Design systems as simply as possible. Avoid unnecessary complexity.
/*
 * // 
❌ Over-engineered
public class MathUtils {
    public double calculate(double a, double b, String operation) {
        if (operation.equals("add")) {
            return a + b;
        } else if (operation.equals("subtract")) {
            return a - b;
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }
}

// ✅ KISS Applied
public class SimpleCalculator {
    public double add(double a, double b) {
        return a + b;
    }

    public double subtract(double a, double b) {
        return a - b;
    }
}

 */
// ❌ Over-engineered
class MathUtils {
    public double calculate(double a, double b, String operation) {
        if (operation.equals("add")) {
            return a + b;
        } else if (operation.equals("subtract")) {
            return a - b;
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }
}

// ✅ KISS Applied
class SimpleCalculator {
    public double add(double a, double b) {
        return a + b;
    }
    public double subtract(double a, double b) {
        return a - b;
    }
}

public class KISS {
    public static void main(String[] args) {
        System.out.println("Keep It Simple Stupid Principle in Java");
        SimpleCalculator calculator = new SimpleCalculator();
        System.out.println("Addition: " + calculator.add(5, 3));    
        System.out.println("Subtraction: " + calculator.subtract(5, 3));
        MathUtils mathUtils = new MathUtils();
        System.out.println("Using Over-engineered MathUtils:");
        System.out.println("Addition: " + mathUtils.calculate(5, 3, "add"));
        System.out.println("Subtraction: " + mathUtils.calculate(5, 3, "subtract"));
    }
}
