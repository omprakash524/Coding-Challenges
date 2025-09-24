
import java.io.*;
import java.lang.reflect.Constructor;

// -------------------------------------------------------
// Breaking & Securing a Singleton Pattern
// -------------------------------------------------------
/**
 * THEORY NOTES:
 *
 * 1. Reflection Attack - Reflection lets you access private constructors. -
 * Breaks Singleton by creating multiple instances. - Fix: Throw exception
 * inside constructor OR use Enum Singleton.
 *
 * 2. Serialization Attack - Serialization -> saves object to byte stream. -
 * Deserialization -> creates NEW object. - Fix: Implement readResolve() to
 * return the same instance.
 *
 * 3. Cloning Attack - If Singleton implements Cloneable, clone() creates a new
 * instance. - Fix: Override clone() to throw exception.
 *
 * 4. Multithreading Issue - Multiple threads can create multiple objects. -
 * Fix: Double-checked locking or Bill Pugh Singleton.
 */
// ---------------- Reflection Example -----------------
class ReflectionSingleton {

    private static final ReflectionSingleton instance = new ReflectionSingleton();

    private ReflectionSingleton() {
        // Normally private constructor prevents instantiation
    }

    public static ReflectionSingleton getInstance() {
        return instance;
    }
}

class SafeReflectionSingleton {

    private static final SafeReflectionSingleton instance = new SafeReflectionSingleton();

    private SafeReflectionSingleton() {
        if (instance != null) {
            throw new RuntimeException("Use getInstance() method to create Singleton");
        }
    }

    public static SafeReflectionSingleton getInstance() {
        return instance;
    }
}

// ---------------- Serialization Example -----------------
class SerializationSingleton implements Serializable {
    private static final SerializationSingleton instance = new SerializationSingleton();
    private SerializationSingleton() {
    }
    public static SerializationSingleton getInstance() {
        return instance;
    }
}

class SafeSerializationSingleton implements Serializable {
    private static final SafeSerializationSingleton instance = new SafeSerializationSingleton();
    private SafeSerializationSingleton() {
    }
    public static SafeSerializationSingleton getInstance() {
        return instance;
    }
    // Fix: ensures same object is returned during deserialization
    protected Object readResolve() {
        return instance;
    }
}

// ---------------- Cloning Example -----------------
class CloningSingleton implements Cloneable {

    private static final CloningSingleton instance = new CloningSingleton();

    private CloningSingleton() {
    }

    public static CloningSingleton getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // creates new instance -> breaks Singleton
    }
}

class SafeCloningSingleton implements Cloneable {

    private static final SafeCloningSingleton instance = new SafeCloningSingleton();

    private SafeCloningSingleton() {
    }

    public static SafeCloningSingleton getInstance() {
        return instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning not allowed for Singleton");
    }
}

// ---------------- MAIN DEMO -----------------
public class BreakSecureSingleton {

    public static void main(String[] args) throws Exception {

        // -------- Reflection Attack --------
        System.out.println("🔴 Breaking Singleton using Reflection");
        ReflectionSingleton r1 = ReflectionSingleton.getInstance();

        Constructor<ReflectionSingleton> constructor
                = ReflectionSingleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        ReflectionSingleton r2 = constructor.newInstance();

        System.out.println("r1 hashcode: " + r1.hashCode());
        System.out.println("r2 hashcode: " + r2.hashCode()); // different objects

        System.out.println("🟢 Securing Singleton against Reflection");
        SafeReflectionSingleton sr1 = SafeReflectionSingleton.getInstance();
        try {
            Constructor<SafeReflectionSingleton> safeCons
                    = SafeReflectionSingleton.class.getDeclaredConstructor();
            safeCons.setAccessible(true);
            SafeReflectionSingleton sr2 = safeCons.newInstance(); // throws exception
        } catch (Exception e) {
            System.out.println("Reflection attack prevented: " + e.getMessage());
        }

        // -------- Serialization Attack --------
        System.out.println("\n🔴 Breaking Singleton using Serialization");
        SerializationSingleton s1 = SerializationSingleton.getInstance();

        // Serialize
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("singleton.ser"));
        out.writeObject(s1);
        out.close();

        // Deserialize
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("singleton.ser"));
        SerializationSingleton s2 = (SerializationSingleton) in.readObject();
        in.close();

        System.out.println("s1 hashcode: " + s1.hashCode());
        System.out.println("s2 hashcode: " + s2.hashCode()); // different objects

        System.out.println("🟢 Securing Singleton against Serialization");
        SafeSerializationSingleton ss1 = SafeSerializationSingleton.getInstance();
        ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("safe_singleton.ser"));
        out2.writeObject(ss1);
        out2.close();

        ObjectInputStream in2 = new ObjectInputStream(new FileInputStream("safe_singleton.ser"));
        SafeSerializationSingleton ss2 = (SafeSerializationSingleton) in2.readObject();
        in2.close();

        System.out.println("ss1 hashcode: " + ss1.hashCode());
        System.out.println("ss2 hashcode: " + ss2.hashCode()); // same object

        // -------- Cloning Attack --------
        System.out.println("\n🔴 Breaking Singleton using Cloning");
        CloningSingleton c1 = CloningSingleton.getInstance();
        CloningSingleton c2 = (CloningSingleton) c1.clone();

        System.out.println("c1 hashcode: " + c1.hashCode());
        System.out.println("c2 hashcode: " + c2.hashCode()); // different objects

        System.out.println("🟢 Securing Singleton against Cloning");
        SafeCloningSingleton sc1 = SafeCloningSingleton.getInstance();
        try {
            SafeCloningSingleton sc2 = (SafeCloningSingleton) sc1.clone(); // throws exception
        } catch (Exception e) {
            System.out.println("Cloning attack prevented: " + e.getMessage());
        }
    }
}
