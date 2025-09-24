// File: LLD-java/SOLID_Principles/OCP_P_RealWordExample.java
// OCP: Open for extension, closed for modification
// We should be able to add new functionality without changing the existing code
// Let’s build one real-world example that uses both Interface + Inheritance together to achieve the Open/Closed Principle (OCP).
// Real-World Example: Ride Fare Calculation (like Uber/Ola)


// define a contract that all fare calculators must follow.
interface FareCalculator{
    double calculateFare(double distance);
}

// 2: Create an Abstract Base Class (Inheritance)
// We provide some common functionality for all rides (like base fare).
abstract class BaseFareCalculator implements FareCalculator{
    protected double baseFare;

    public BaseFareCalculator(double baseFare){
        this.baseFare = baseFare;
    }

    // subclasses must implement this method, will override the method from interface
    public abstract double calculateFare(double distance);
}
// Step 3: Extend the Base Class for Specific Ride Types
class BikeRideFare extends BaseFareCalculator{
    
    public BikeRideFare(){
        super(20.0); // base fare
    }

    @Override
    public double calculateFare(double distance){
        return baseFare + (15.0 * distance); // 15 is the per km rate
    }
}



public class OCP_P_RealWordExample {
    public static void main(String[] args) {
        System.out.println("OCP Principle Real World Example");
    }
}
