import java.util.*;

// Relationships: Association, Aggregation and Composition
// Association: A uses B [ one to one, one to many, many to one, many to many ]
// Aggregation: A has a B (B can exist without A) 
// Composition: A has a B (B cannot exist without A)


// one to one association
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


// one to many association
class Student1 {
    private String name;
    private String rollNumber;
    Student1(String name, String rollNumber) {
        this.name = name;
        this.rollNumber = rollNumber;
    }
    public String getName() {
        return name;
    }
    public String getRollNumber() {
        return rollNumber;
    }
}
class College{
    private String name;
    private List<Student1> students; // aggregation
    College(String name, List<Student1> students){
        this.name = name;
        this.students = students;
    }
    public void addStudent(Student1 student){
        students.add(student);
    }
    public void printAllStudents(){
        System.out.println("College name: " + name);
        for(Student1 student : students){
            System.out.println("Student name: " + student.getName() + ", Roll number: " + student.getRollNumber());
        }
    }
}

// Many to many association can be implemented using a third class that holds the references of both classes
class Student2 {
    private String name;
    private List<Course> courses;
    Student2(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
}
class Course {
    private String courseName;
    private List<Student2> students;
    Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }
    public String getCourseName() {
        return courseName;
    }
    public void addStudent(Student2 student) {
        students.add(student);
    }
    public List<Student2> getStudents() {
        return students;
    }
    public void displayAllStudent(){
        for(Student2 student : students) {
            System.out.println("Student name: " + student.getName());
        }
    }
}

public class AssociationAggregationComposition {
    public static void main(String[] args) {
        // System.out.println("Association, Aggregation and Composition in Java");
        // Passport passport = new Passport("A1234567");
        // Student student = new Student("John Doe", passport);
        // student.display();

        // Student1 s1 = new Student1("Alice", "R001");
        // Student1 s2 = new Student1("Bob", "R002");
        // List<Student1> studentList = new ArrayList<>();
        // studentList.add(s1);
        // studentList.add(s2);
        // College college = new College("XYZ College", studentList);
        // college.printAllStudents();


        Course math = new Course("Mathematics");
        Course physics = new Course("Physics");
        Student2 studentA = new Student2("Alice");
        Student2 studentB = new Student2("Bob");
        // studentA.addCourse(math);
        // studentA.addCourse(physics);
        // studentB.addCourse(physics);
        math.addStudent(studentA);
        physics.addStudent(studentA);
        physics.addStudent(studentB);
    }
}
