
// Singleton Pattern - Ensure a class has only one instance and provide a global point of access to it.
// Use Case: Logging, Configuration Management, Database Connection Pooling, etc.
// Example: A class that tracks the number of code runs and submissions in a coding platform.
// Note: This is a basic example and does not include thread-safety mechanisms.
// For a thread-safe singleton, consider using synchronized methods or the Bill Pugh Singleton Design.
// Singleton class
// Here, we are not implementing singleton pattern correctly to demonstrate the concept.
// In a proper singleton pattern, we would make the constructor private and provide a static method to get the instance.
// This example is just to illustrate the counting functionality.
// We can see that creating multiple instances of JudgeAnalytics will lead to separate counts, which is not the intended behavior of a singleton.
// In a true singleton, there would be only one instance shared across the application.
// For simplicity, we are not implementing that here.
// In a real-world scenario, you would implement the singleton pattern correctly to ensure only one instance exists.

// class JudgeAnalytics{
//     private int run = 0;
//     private int submit = 0;

//     public void countRun(){
//         run++;
//     }
//     public void countSubmit(){
//         submit++;
//     }
//     public int getRun(){
//         return run;
//     }
//     public int getSubmit(){
//         return submit;
//     }
// }

// Correct Singleton Implementation
// Eager loading , it is thread safe because the instance is created at the time of class loading.
class JudgeAnalytics{
    private static final JudgeAnalytics instance = new JudgeAnalytics();
    private JudgeAnalytics(){
        // private constructor to prevent instantiation
    }
    public static JudgeAnalytics getInstance(){
        return instance;
    }
}
class Compiler{
    private static final Compiler compiler = new Compiler();
    private Compiler(){
        // private constructor to prevent instantiation
    }
    public static Compiler getInstance(){
        return compiler;
    }
}

// Lazy Loading - Not thread safe
class JudgeAnalyticsLazyLoading{
    private static JudgeAnalyticsLazyLoading instance;
    private JudgeAnalyticsLazyLoading(){
        // private constructor to prevent instantiation
    }
    public static JudgeAnalyticsLazyLoading getInstance(){
        if(instance == null){
            instance = new JudgeAnalyticsLazyLoading();
        }
        return instance;
    }
}
class lazyLoading{
    private static lazyLoading compiler;
    private lazyLoading(){
        // private constructor to prevent instantiation
    }
    public static lazyLoading getInstance(){
        if(compiler == null){
            compiler = new lazyLoading();
        }
        return compiler;
    }
}

// Thread Safety: A Critical Concern in Singleton Pattern
// To achieve this Different Ways to Achieve Thread Safety
// 1. Synchronized Method
// 2. Double-Checked Locking
// 3. Bill Pugh Singleton (Best Practice for Lazy Loading)

// 1. Synchronized Method
/*
 * This is the simplest way to ensure thread safety. By synchronizing the method that creates the instance, 
 * we can prevent multiple threads from creating separate instances at the same time. However, 
 * this approach can lead to performance issues due to the overhead of synchronization.
 */
class ThreadSafeSingleton{
    private static ThreadSafeSingleton instance;
    private ThreadSafeSingleton(){
        // private constructor to prevent instantiation
    }
    public static synchronized ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }
}



// 2. Double-Checked Locking
/* This is a more efficient way to achieve thread safety. The idea is to check if the instance is null before acquiring the lock. If it is, then we synchronize the block and check again. This reduces the overhead of synchronization after the instance has been created.
 * This approach reduces the overhead of synchronization by first checking if the instance is null without locking. 
 * If it is null, it synchronizes and checks again before creating the instance. 
 * This way, synchronization is only used when the instance is being created for the first time.
 * 
 * lets say at first when multiple thread try to created instance at the same time
 * both thread will check instance is null or not and it is null for both thread then both thread will enter in the synchronized block
 * now only one thread will get the lock and other thread will wait for the lock to be released
 * now the thread which got the lock will check again if instance is null or not and it is null then it will create the instance
 * now the lock will be released and the other thread will get the lock and it will check again if instance is null or not
 * now instance is not null so it will return the instance.
 * This way we are ensuring that only one instance is created and we are reducing the overhead of synchronization.
 * 
 * Note: The instance variable is declared as volatile to prevent issues with instruction reordering.
 * volatile keyword ensures that multiple threads handle the instance variable correctly when it is being initialized to the Singleton instance.
 * Volatile keyword ensures changes made by one thread are visible to others. Without Volatile, one thread might create the Singleton instance, 
 * but other threads may not see the updated value due to caching. Volatile ensures that the instance is always read from the main memory, so all threads see the most up-to-date version.
 * This is crucial for the correct functioning of the Double-Checked Locking pattern.
 */
class DoubleCheckedLockingSingleton{
    private static volatile DoubleCheckedLockingSingleton instance;
    private DoubleCheckedLockingSingleton(){
        // private constructor to prevent instantiation
    }
    public static DoubleCheckedLockingSingleton getInstance(){
        if(instance == null){
            synchronized (DoubleCheckedLockingSingleton.class) {
                if(instance == null){
                    instance = new DoubleCheckedLockingSingleton();
                }
            }
        }
        return instance;
    }
}


// 3. Bill Pugh Singleton (Best Practice for Lazy Loading)
/*
 * This approach uses a static inner helper class to hold the singleton instance. 
 * The instance is created only when the inner class is loaded, which happens when getInstance() is called for the first time. 
 * This method is thread-safe without requiring synchronized blocks and is efficient.
 * The JVM guarantees that the instance will be created before any thread accesses the static getInstance() method.
 * This is because the class initialization phase is guaranteed by the Java Language Specification to be serial,
 * i.e., non-concurrent, and to complete before any thread accesses a static variable of that class.
 * This ensures that the instance is created in a thread-safe manner without the need for explicit synchronization.
 * This approach is also lazy-loaded, meaning the instance is not created until it is needed.
 * This can be beneficial in terms of resource management, especially if the singleton instance is resource-intensive to create.
 * Overall, the Bill Pugh Singleton Design is a widely recommended approach for implementing singletons in Java due to its simplicity, efficiency, and thread safety.
 * It is considered a best practice for lazy loading and is often preferred in modern Java applications.
 * This approach also provides a clear and concise way to implement the Singleton pattern without the complexities of other methods.
 * It is a clean and effective solution that leverages Java's class loading mechanism to ensure thread safety and lazy initialization.
 * Overall, the Bill Pugh Singleton Design is a robust and efficient way to implement the Singleton pattern in Java.
 * It is widely used and recommended in the Java community for its simplicity and effectiveness. 
 * It ensures thread safety, lazy loading, and high performance without synchronization overhead.
 * - Pros -
 * Best of both worlds: Lazy + Thread-safe.
 * No need for synchronized or volatile.
 * Clean and efficient.
*/
class BillPughSingleton{
    private BillPughSingleton(){
        // private constructor to prevent instantiation
    }
    private static class SingletonHelper{
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }
    public static BillPughSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }
}

// Enum Singleton (Best Practice for Serialization and Reflection Safety)
/*
 * This approach uses an enum to implement the singleton pattern. 
 * Enums in Java are inherently serializable and provide a guarantee against multiple instantiation, even in the face of complex serialization or reflection attacks.
 * This is because the Java language ensures that any enum value is instantiated only once in a Java program.
 * This approach is also thread-safe and provides a simple and effective way to implement the singleton pattern.
 * The enum singleton is considered the best practice for implementing singletons in Java due to its simplicity, thread safety, and protection against serialization and reflection issues.
 * It is a clean and concise solution that leverages the built-in features of enums in Java to ensure that only one instance of the singleton is created.
 * Overall, the enum singleton is a robust and efficient way to implement the singleton pattern in Java.
 * It is widely used and recommended in the Java community for its simplicity and effectiveness. 
 * It ensures thread safety, serialization safety, and protection against reflection attacks without any additional code or complexity.
 * Why use Enum for Singleton?
 * Thread-safety by default: JVM handles instance creation internally.
 * Serialization safe: Unlike normal classes, Enums provide automatic serialization.
 * Reflection safe: Cannot create a new instance via reflection.
 * Cloning safe: Enum cannot be cloned.
 * Simplicity: Only a few lines of code.
 * - Pros -
 * Simple and concise.
 * Thread-safe by default.
 * Serialization-safe.
 * Reflection-safe.
*/
enum EnumSingleton{
    INSTANCE;
    public void someMethod(){
        System.out.println("Method in Enum Singleton");
    }
}


// Breaking & Securing a Singleton
// Reflection attack:
// Serialization attack:
// Cloning attack:



public class SingletonPattern {
    public static void main(String[] args) {
        System.out.println("Singleton Pattern in Java");
        // Using the singleton instance
        JudgeAnalytics analytics1 = JudgeAnalytics.getInstance();
        JudgeAnalytics analytics2 = JudgeAnalytics.getInstance();
        System.out.println("Are both instances the same? : " + (analytics1 == analytics2)); // should print true
        Compiler compiler1 = Compiler.getInstance();
        Compiler compiler2 = Compiler.getInstance();
        System.out.println("Compiler 1 : " + compiler1);
        System.out.println("Compiler 2: " + compiler2);

        // Using the lazy loading singleton instance
        JudgeAnalyticsLazyLoading lazy1 = JudgeAnalyticsLazyLoading.getInstance();
        JudgeAnalyticsLazyLoading lazy2 = JudgeAnalyticsLazyLoading.getInstance();
        System.out.println("Are both instances the same? : " + (lazy1 == lazy2)); // should print true

        System.out.println("Thread Safe Singleton");
        ThreadSafeSingleton ts1 = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton ts2 = ThreadSafeSingleton.getInstance();
        System.out.println("Are both Thread Safe (synchronized) instances the same? : " + (ts1 == ts2)); // should print true

        System.out.println("Double Checked Locking Singleton");
        DoubleCheckedLockingSingleton dc1 = DoubleCheckedLockingSingleton.getInstance();
        DoubleCheckedLockingSingleton dc2 = DoubleCheckedLockingSingleton.getInstance();
        System.out.println("Are both Double Checked Locking instances the same? : " + (dc1 == dc2)); // should print true

        System.out.println("Bill Pugh Singleton");
        BillPughSingleton bp1 = BillPughSingleton.getInstance();
        BillPughSingleton bp2 = BillPughSingleton.getInstance();
        System.out.println("Are both Bill Pugh instances the same? : " + (bp1 == bp2)); // should print true  

        System.out.println("Enum Singleton");
        EnumSingleton enum1 = EnumSingleton.INSTANCE;
        EnumSingleton enum2 = EnumSingleton.INSTANCE;
        System.out.println("Are both Enum instances the same? : " + (enum1 == enum2)); // should print true
        enum1.someMethod();

        // JudgeAnalytics analytics1 = new JudgeAnalytics();
        // analytics1.countRun();
        // analytics1.countSubmit();
        // System.out.println("Run count: " + analytics1.getRun());
        // System.out.println("Submit count: " + analytics1.getSubmit());

        // JudgeAnalytics analytics2 = new JudgeAnalytics();
        // analytics2.countRun();
        // analytics2.countSubmit();
        // System.out.println("Run count from analytics2: " + analytics2.getRun());
        // System.out.println("Submit count from analytics2: " + analytics2.getSubmit());
    }
}
