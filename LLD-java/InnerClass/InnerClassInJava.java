// Any java class defined inside another class is called inner class
// Inner class is used to logically group classes that are only used in one place
// Types of inner class
// 1. Non-static inner class (Instance inner class)
// 2. Static inner class (Static nested class)
// 3. Local inner class (Defined inside a method)
// 4. Anonymous inner class (Defined without a class name)

class OuterClass {
    static int outerField = 10; // accessed without creating object of outer class
    String name = "Outer"; // accessed by creating object of outer class

    // non static variable cannot be accessed in static inner class
    // but static variable can be accessed in static inner class
    static class InnerClass{
        public void execute(){
            System.out.println("Inner class method accessing outer class static field: " + outerField);
            System.out.println("Accessing outer class static field: " + outerField);
            // System.out.println("Accessing outer class instance field: " + name); // cannot access non-static field
        }
    }
    public void execute(){
        System.out.println("Outer class method");
        System.out.println("Accessing outer class instance field: " + name);
        InnerClass inner = new InnerClass(); // creating object of inner class
        inner.execute(); // calling method of inner class
    }
}

public class InnerClassInJava {
    public static void main(String[] args) {
        System.out.println("Inner Class in Java");
        OuterClass.InnerClass inner = new OuterClass.InnerClass();
        inner.execute();
        OuterClass outer = new OuterClass();
        outer.execute();
    }
}
