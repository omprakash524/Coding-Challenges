/*
 * ISP: Interface Segregation Principle
 * 
 * Clients should not be forced to depend on interfaces they do not use."

🔍 Meaning:
An interface should have only the methods that are relevant to the implementing class.
Avoid creating fat interfaces that force classes to implement unnecessary methods.

❌ Violation Example
interface Worker {
    void work();
    void eat();
}

class Robot implements Worker {
    public void work() {
        System.out.println("Robot is working");
    }

    public void eat() {
        // ❌ Robot doesn't eat
        throw new UnsupportedOperationException("Robot can't eat");
    }
}
    ❌ Problem:
Robot is forced to implement eat() even though it doesn't need it.
Violates ISP.

 */

//  ✅ Correct ISP Design
// Split the interface into smaller, focused ones:

interface Workable{
    void work();
}
interface Drink{
    void drink();
}
interface Eatable{
    void eat();
}
class Human implements Workable, Eatable, Drink{
    public void work(){
        System.out.println("Human is working");
    }
    public void eat(){
        System.out.println("Human is eating");
    }
    public void drink(){
        System.out.println("Human is drinking");
    }
}
class Robot implements Workable{
    public void work(){
        System.out.println("Robot is working");
    }
}
public class ISP_Principle {
    public static void main(String[] args) {
        Workable humanWorker = new Human();
        Eatable humanEater = new Human();
        Drink humanDrinker = new Human();

        Workable robotWorker = new Robot();

        humanWorker.work();
        humanEater.eat();
        humanDrinker.drink();

        robotWorker.work();

    }
}
