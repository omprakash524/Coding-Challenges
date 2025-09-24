/*
* LSP: Liskov Substitution Principle
 * Objects of a superclass should be replaceable with objects of its subclasses without affecting the correctness of the program.
 * If class B is a subclass of class A, then we should be able to use B wherever A is expected — without breaking the behavior.
 * ❌ Violation Example
 * Let’s say we have a base class Bird:
 * class Bird {
    public void fly() {
        System.out.println("Bird is flying");
    }
}
* Now we create a subclass:
class Ostrich extends Bird {
    @Override
    public void fly() {
        throw new UnsupportedOperationException("Ostrich can't fly");
    }
}

❌ Problem:
Ostrich is a bird, but it violates LSP because it can't fly.
If you substitute Bird with Ostrich, your program may crash.
 * 
 * 
 * 
 * ✅ Correct LSP Design
Use interfaces or abstract classes to separate behaviors:
 */

interface Bird{
    void eat();
}
interface FlyingBird extends Bird{
    void fly();
}
class Sparrow implements FlyingBird{
    public void eat(){
        System.out.println("Sparrow is eating");
    }
    public void fly(){
        System.out.println("Sparrow is flying");
    }
}
class Ostrich implements Bird{
    public void eat(){
        System.out.println("Ostrich is eating");
    }
}
/*
 * ✅ Benefits:
You can substitute Bird with Sparrow or Ostrich safely.
No unexpected behavior or exceptions.

✅ Why This Follows LSP
You can substitute Bird with Sparrow or Ostrich without breaking the program.
You don’t force Ostrich to fly, which would violate its natural behavior.
You use interfaces to separate capabilities (eating vs flying).
 */


public class LSP_Principle {
    public static void main(String[] args) {
        // Using Bird interface
        Bird bird1 = new Sparrow();  // ✅ LSP: Sparrow is a Bird
        Bird bird2 = new Ostrich();  // ✅ LSP: Ostrich is a Bird
        bird1.eat();  // Works fine
        bird2.eat();  // Works fine
        // Using FlyingBird interface
        FlyingBird flyingBird = new Sparrow();  // ✅ LSP: Sparrow is a FlyingBird
        flyingBird.fly();  // Works fine

        // ❌ Ostrich is not a FlyingBird, so we don't use it here
        // FlyingBird ostrichFly = new Ostrich(); // Compile-time error

    }
}
