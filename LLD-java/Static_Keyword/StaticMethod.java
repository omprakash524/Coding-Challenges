class Utility {
    // static method can be called without creating object of the class
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int add(int a, int b) {
        return a + b;
    }
}
public class StaticMethod {
    public static void main(String[] args) {
        System.out.println("Static Method in Java");
        // static method can be called without creating object of the class
        // static method can access only static members of the class
        // static method cannot access non-static members of the class
        // static method can be overloaded
        // static method cannot be overridden
        // static method can be inherited
        // static method can be used to create utility methods
        // static method can be used to create factory methods
        // static method can be used to create singleton classes
        // static method can be used to create main method
        Utility.printMessage("Hello, World!");
        int sum = Utility.add(5, 10);
        System.out.println("Sum: " + sum);
    }
}
