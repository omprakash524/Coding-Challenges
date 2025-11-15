class manager {
    int id;
    String name;
    float salary;

    public manager(int id, String name, float salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public void display() {
        System.out.println(id + " " + name + " " + salary);
    }
}
public class OopJava {
    class employee {
        int id;
        String name;
        float salary;

        public employee(int id, String name1, float salary) {
            this.id = id;
            // this.name = name;
            name = name1;
            this.salary = salary;
        }
        public void display() {
            System.out.println(id + " " + name + " " + salary);
        }
    }
    public static void main(String[] args) {
        System.out.println("hi");
        OopJava obj = new OopJava();
        employee e1 = obj.new employee(1, "John", 50000);
        e1.display();
        manager m1 = new manager(2, "Jane", 80000);
        m1.display();
    }
}
