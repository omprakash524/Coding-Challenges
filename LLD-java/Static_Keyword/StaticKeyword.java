// A static variable belongs to the class, not to any specific object.
// All instances (objects) of the class share the same static variable.

// with static 
// Every time a new BankAccount object is created, counter is incremented.
// Since counter is shared across all objects, it correctly tracks the total number of accounts.

// without static
/* Now, counter becomes an instance variable.
Each object has its own copy of counter, initialized to 0.
So acc1.getCounter() and acc2.getCounter() will both return 1, because each object increments its own counter.
 */
class BankAccount{
    static int counter = 0; // static variable to keep track of number of accounts
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    BankAccount(String accountHolderName, double initialBalance){
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        counter++;
        this.accountNumber = "ACC" + String.format("%04d", counter); // generating account number
    }
    public int getCounter(){
        return counter;
    }
}

public class StaticKeyword {
    public static void main(String[] args) {
        System.out.println("Static Keyword in Java");
        // static is keyword in Java
        // static variable is shared among all the objects of the class
        // static method can be called without creating object of the class
        // static block is used to initialize static variables
        // static nested class is a nested class that is static
        // static import is used to import static members of a class
        // can a static method access non-static members of the class? No
        // Advantages of static members: memory efficient, easy to access
        // Disadvantages of static members: not thread safe, cannot be overridden
        BankAccount acc1 = new BankAccount("Prakash", 1000);
        BankAccount acc2 = new BankAccount("Rao", 2000);
        System.out.println("Number of accounts created: " + acc1.getCounter());
    }
}
