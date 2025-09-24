// Method overloading
class Calculator{
    int add(int a, int b){
        return a + b;
    }
    double add(double a, double b){
        return a + b;
    }
    int add(int a, int b, int c){
        return a + b + c;
    }
}

// Method overriding
class Parent{
    void display(){
        System.out.println("Parent class method");
    }
}
class Child extends Parent{
    @Override
    void display(){
        System.out.println("Child class method");
    }
}

// for static method you dont need to create a object of the class
// but if you create object then it will give warning
// overriding is not possible for static method
public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // compile time polymorphism
        System.out.println("Sum of two integers: " + calculator.add(5, 10));
        System.out.println("Sum of two doubles: " + calculator.add(5.5, 10.5));
        System.out.println("Sum of three integers: " + calculator.add(5, 10, 15));
        // run time polymorphism
        Parent parent = new Child();
        parent.display();
    }
}
