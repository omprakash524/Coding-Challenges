// Aggregation.java
// Aggregation: A has a B (B can exist without A)
class Passport{
    private String passportNumber;
    Passport(String passportNumber){
        this.passportNumber = passportNumber;
    }
    public String getPassportNumber(){
        return passportNumber;
    }
}

class Student{
    private String name;
    // A class can have reference of another class as an attribute but doesnt own it
    // weak relationship
    private Passport passport; //  as an attribute

    Student(String name, Passport passport){
        this.name = name;
        this.passport = passport;
    }
    public void display(){
        System.out.println("Student name: " + name);
        System.out.println("Passport number: " + passport.getPassportNumber());
    }
}

// composition example
class StudentComp{
    private String name;
    // A class can have reference of another class as an attribute and owns it
    // strong relationship
    private Passport passport; //  as an attribute

    StudentComp(String name, String passportNumber){
        this.name = name;
        this.passport = new Passport(passportNumber); // StudentComp owns Passport
    }
    public void display(){
        System.out.println("Student name: " + name);
        System.out.println("Passport number: " + passport.getPassportNumber());
    }
}
public class Aggregation {
    public static void main(String[] args) {
        System.out.println("Aggregation in Java");
        // Passport passport = new Passport("A1234567");
        // Student student = new Student("John Doe", passport);
        // student.display();
        // passport can exist without student
        // System.out.println("Passport number from main: " + passport.getPassportNumber());
        System.out.println("Composition in Java");
        StudentComp studentComp = new StudentComp("Jane Doe", "B7654321");  
        studentComp.display();
        // passport cannot exist without studentComp    
    }
}
