// parent class or super class
class School{
    private String name;

    public School() {
        name = "DPS";
    }
    void printSchoolName(){
        System.out.println("School Name: " + name);
    }
}

// child class or sub class
class Student extends School {
    private String name;
    Student(String name) {
        this.name = name;
    }
    void printStudentName(){
        System.out.println("Student Name: " + name);
    }
}

// multiple inheritance is not supported in java
// multi-level inheritance
class Parent extends Student {
    private String name;
    Parent(String name, String studentName){
        super(studentName); // calling parent class constructor
        this.name = name;
    }
    void printParentName(){
        System.out.println("Parent Name: " + name);
    }
}

// creating inheritance in real world example
class Product{
    private String name;
    private String category;
    private double price;
    Product(String name, String category, double price){
        this.name = name;
        this.category = category;
        this.price = price;
    }
    void displayDetails(){
        System.out.println("Product Name: " + name);
        System.out.println("Category: " + category);
        System.out.println("Price: " + price);
    }
}


class Electronics extends Product {
    private int warranty; 
    private String brand;
    Electronics(String name, String category, double price, int warranty, String brand){
        super(name, "Electronics", price); // calling parent class constructor   
        this.warranty = warranty;
        this.brand = brand;
    }
    void displayDetails(){
        super.displayDetails(); // calling parent class method
        System.out.println("Brand: " + brand);
        System.out.println("Warranty: " + warranty + " months");
    }
}


class Tshirt extends Product {
    private String size;
    private String color;
    Tshirt(String name, String category, double price, String size, String color){
        super(name, "Clothing", price); // calling parent class constructor   
        this.size = size;
        this.color = color;
    }
    void displayDetails(){
        super.displayDetails(); // calling parent class method
        System.out.println("Size: " + size);
        System.out.println("Color: " + color);
    }
}

public class Inheritance {
    public static void main(String[] args) {
        System.out.println("Inheritance");
        // School school = new School();
        // school.printSchoolName();
        // Student student = new Student("John");
        // student.printStudentName();
        // Student student = new Student("John");
        // student.printSchoolName();
        // student.printStudentName();
        
        // Parent parent = new Parent("Dad", "Om");
        // parent.printParentName();
        // parent.printSchoolName();
        // parent.printStudentName();

        Electronics laptop = new Electronics("Laptop", "Electronics", 50000, 24, "Dell");
        laptop.displayDetails();
        System.out.println();
        System.out.println("--------------");
    }
}
