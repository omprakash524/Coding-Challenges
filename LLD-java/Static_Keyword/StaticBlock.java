class StaticBlockExample {
    static {
        // static block
        System.out.println("Static block is executed before main method");
    }
    static{
        System.out.println("Static block 2");
    }
}
class Demo{
    static int doSomething(){
        System.out.println("Static method in static block class");
        return 10;
    }
    int sum(int a, int b){
        return a + b;
    }
}
public class StaticBlock {
    public static void main(String[] args) {
        System.out.println("Static Block in Java");
        Demo demo = new Demo();
        System.out.println("Sum: " + demo.sum(5, 10));
        Demo.doSomething();
        int x = 5;
        System.out.println(x++ + ++x);
        // static block is executed before main method
        // static block is executed only once when the class is loaded
        // static block is used to initialize static variables
        // static block can access only static members of the class
        // static block cannot access non-static members of the class
        // static block can be used to load configuration settings
        // static block can be used to load database drivers
        // static block can be used to perform one-time initialization tasks
        // static block can be used to create singleton classes
        // static block can be used to create utility classes
        // static block can be used to create factory classes
    }
}
