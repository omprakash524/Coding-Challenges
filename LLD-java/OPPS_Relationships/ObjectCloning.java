// ObjectCloning.java
// Object Cloning: Creating a copy of an existing object (exact copy)
// why use it: to avoid expensive object creation, to preserve the state of an object, to implement prototype design pattern
// shallow copy: copies the values of the object, if the object contains references to other objects, it copies the references
// deep copy: copies the values of the object and the values of the objects referenced by the object
// in java, we can achieve shallow copy using clone() method of Object class and deep copy using serialization or copy constructor
// to use clone() method, the class must implement Cloneable interface and override clone() method

// shallow cloning example
class PassportClone{
    String passportNumber;
    PassportClone(String passportNumber){
        this.passportNumber = passportNumber;
    }
}

class Student implements Cloneable{
    String name;
    PassportClone passport; // reference to another object
    Student(String name, PassportClone passport){
        this.name = name;
        this.passport = passport;
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone(); // shallow copy
        // deep copy
        PassportClone clonedPassport = new PassportClone(this.passport.passportNumber);
        return new Student(this.name, clonedPassport);
    }
}
public class ObjectCloning {
    public static void main(String[] args) {
        System.out.println("Object Cloning in Java");
        PassportClone passport = new PassportClone("A1234567");
        Student student = new Student("John Doe", passport);
        // shallow copy
        Student studentClone = new Student(student.name, student.passport);
        System.out.println("Original Student Name: " + student.name);
        System.out.println("Original Passport Number: " + student.passport.passportNumber);
        System.out.println("Cloned Student Name: " + studentClone.name);
        System.out.println("Cloned Passport Number: " + studentClone.passport.passportNumber);
        // modifying the clone's passport number
        studentClone.passport.passportNumber = "B7654321";
        Student clonedStudent = (Student) studentClone.clone();
        System.out.println("Original Student Name: " + student.name);
        System.out.println("Original Passport Number: " + student.passport.passportNumber);
        System.out.println("Cloned Student Name: " + studentClone.name);
        System.out.println("Cloned Passport Number: " + studentClone.passport.passportNumber);
        System.out.println("Deep Cloned Student Name: " + clonedStudent.name);
        System.out.println("Deep Cloned Passport Number: " + clonedStudent.passport.passportNumber);
    }
}
