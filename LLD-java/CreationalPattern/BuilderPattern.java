import java.util.*;
// Example of Builder Pattern in Java
/*
 * Builder Pattern is a creational design pattern that allows for the step-by-step construction of complex objects. It separates the construction of a complex object from its representation, allowing the same construction process to create different representations.
 * Key Components:
 * 1. Product: The complex object that is being built.
 * 2. Builder: The interface that defines the methods for creating the parts of the product.
 * 3. ConcreteBuilder: The class that implements the Builder interface and constructs the product.
 * 4. Director: The class that manages the construction process and uses the Builder to create the product.
 * 5. Client: The code that uses the Director and Builder to create the product.
 * Benefits:
 * - Provides control over the construction process.
 * - Allows for the creation of different representations of the product.
 * - Improves code readability and maintainability.
 * Drawbacks:
 * - Can introduce additional complexity with multiple classes.
 * - May lead to a proliferation of builder classes for different products.
 * When to Use:
 * - When the construction process of an object is complex and involves multiple steps.
 * - When you want to create different representations of a complex object.
 * - When you want to isolate the construction logic from the representation logic.
 * Examples:
 * - Building complex objects like HTML documents, SQL queries, or configuration objects.
 * - Creating objects with many optional parameters.
 * - Constructing immutable objects with many attributes.
 * - Implementing fluent interfaces for object creation.
 * - Constructing objects in a step-by-step manner.
 * 
 * Builder Pattern
The Builder Pattern is a creational design pattern that separates the construction of a complex object from its representation. This allows you to create different types and representations of an object using the same construction process.

Formal Definition:
"Builder pattern builds a complex object step by step. It separates the construction of a complex object from its representation, so that the same construction process can create different representations."

In simpler terms:
Imagine you're ordering a custom burger. You choose the bun, patty, toppings, sauces, and whether you want it grilled or toasted. The chef follows your instructions step by step to build your custom burger. This is what the Builder Pattern does — it lets you construct complex objects by specifying their parts one at a time, giving you flexibility and control over the object creation process.

Real-life Analogy (Custom Pizza Order)
Think of ordering a pizza online. You select the crust type, size, toppings, cheese, and sauce — all step by step. The pizza shop then builds your pizza according to your selections. Different customers can use the same process to get entirely different pizzas. This is the essence of the Builder Pattern: a structured, step-wise approach to creating customized complex objects.
Understanding the Problem
Imagine you're building a BurgerMeal in your application. A burger must have some mandatory components like: Bun and Patty. And it can also include option components like: Sides, Toppings, and Cheese.

 */

// Now let’s try to implement this using a traditional constructor approach:
// class BurgerMeal{
//     private String bun; // mandatory
//     private String patty; // mandatory
//     // optional components
//     private String sides;
//     private List<String> toppings;
//     private String cheese;

//     // constructor to handle all parameters
//     public BurgerMeal(String bun, String patty, String sides, List<String> toppings, String cheese) {
//         this.bun = bun;
//         this.patty = patty;
//         this.sides = sides;
//         this.toppings = toppings;
//         this.cheese = cheese;
//     }
// }

/*
 * The above approach has several drawbacks:
 * 1. Readability: The constructor has many parameters, making it hard to read and understand.
 * 2. Flexibility: If you want to create a BurgerMeal with only the mandatory components, you still have to pass null for the optional ones.
 * 3. Maintainability: If you want to add more optional components in the future, you would need to modify the constructor, which can lead to breaking existing code.
 * 4. Immutability: The object is mutable, which can lead to unintended side effects if the object is modified after creation.
 * 5. Scalability: As the number of optional components increases, the constructor can become unwieldy and difficult to manage.
 * 6. Error-Prone: It's easy to accidentally swap parameters when calling the constructor, leading to bugs.
 * 7. Lack of Clarity: The purpose of each parameter may not be clear, especially if they are of the same type (e.g., multiple String parameters).
 * 8. No Default Values: You have to explicitly pass values for all parameters, even if they are optional and could have sensible defaults.
 * 9. Difficulty in Object Creation: Creating a BurgerMeal with different combinations of optional components can lead to a combinatorial explosion of constructor overloads.
 * 10. Testing Challenges: Writing unit tests for the constructor can be cumbersome due to the large number of parameters.
 * To address these issues, we can use the Builder Pattern to create a more flexible and readable way to construct BurgerMeal objects.
 * 
 * Issues in Code
This constructor approach works, but it creates multiple problems:
Hard to Read and Maintain:
The user has to remember the order of parameters and their types. It becomes difficult to read when more optional parameters are added.
Unnecessary null values:
Even if the user doesn’t want toppings or sides, they still have to pass null explicitly. This clutters the object creation code.
Risk of NullPointerException:
If we forget to null-check before accessing optional values inside the class, it may lead to runtime exceptions.
Too Many Constructor Overloads:
To handle various combinations (e.g., with cheese, without sides, only toppings, etc.), you’d need to create multiple overloaded constructors — which is not scalable.
Tight Coupling Between Parameters and Construction:
There is no flexibility to set values step by step. The entire object must be built in one go, which doesn't match the natural way of ordering or customizing a burger.
 */

class BurgerMeal{
    // required parameters
    private final String bunType;
    private final String patty;

    // optional parameters
    private final String side;
    private final boolean hasCheese;
    private final List<String> toppings;
    private final String drink;

    // private constructor to enforce object creation through the builder
    private BurgerMeal(BurgerBuilder builder){
        this.bunType = builder.bunType;
        this.patty = builder.patty;
        this.side = builder.side;
        this.hasCheese = builder.hasCheese;
        this.toppings = builder.toppings;
        this.drink = builder.drink;
    }
    // same as BurgerMeal class above but with private constructor
    public static class BurgerBuilder{
        // required parameters
        private final String bunType;
        private final String patty;

        // optional parameters - initialized to default values
        private String side;
        private boolean hasCheese;
        private List<String> toppings;
        private String drink;

        // constructor with required parameters
        public BurgerBuilder(String bunType, String patty){
            this.bunType = bunType;
            this.patty = patty;
        }
        // this - means here we are returning the current object reference of BurgerBuilder class
        // so that we can chain the methods one after another
        public BurgerBuilder setSide(String side){
            this.side = side;
            return this;
        }
        public BurgerBuilder addTopping(List<String> toppings){
            this.toppings = toppings;
            return this;
        }
        public BurgerBuilder setCheese(boolean hasCheese){
            this.hasCheese = hasCheese;
            return this;
        }
        public BurgerBuilder setDrink(String drink){
            this.drink = drink;
            return this;
        }
        public BurgerMeal build(){
            return new BurgerMeal(this); // here this is reference to BurgerBuilder reference object
        }
    }
    @Override
    public String toString() {
        return "BurgerMeal{" +
                "bunType='" + bunType + '\'' +
                ", patty='" + patty + '\'' +
                ", side='" + side + '\'' +
                ", hasCheese=" + hasCheese +
                ", toppings=" + toppings +
                ", drink='" + drink + '\'' +
                '}';
    }
}

// Telescoping Constructor Anti-Pattern
/*
 * The telescoping constructor pattern is a design pattern where a class has multiple constructors with increasing numbers of parameters. This pattern is often used to provide flexibility in object creation, allowing users to create objects with different combinations of parameters. However, it can lead to code that is difficult to read and maintain, especially when there are many optional parameters.
 * Example:
 * <p>
 * NutritionFacts cereal = new NutritionFacts.Builder(100, 1)
 *         .calories(300)
 *         .fat(10)
 *         .sodium(150)
 *         .carbohydrate(50)
 *         .build();
 * </p>
 * In this example, the NutritionFacts class has a builder with required parameters (servingSize and servings) and optional parameters (calories, fat, sodium, carbohydrate). The builder pattern allows for a more readable and maintainable way to create objects with many optional parameters compared to telescoping constructors.
 * Drawbacks of Telescoping Constructors:
 * 1. Readability: As the number of parameters increases, the constructors become harder to read and understand.
 * 2. Maintainability: Adding or removing parameters requires modifying multiple constructors, which can lead to errors and inconsistencies.
 * 3. Usability: Users of the class may find it difficult to remember the order and meaning of parameters, leading to potential mistakes when creating objects.
 * 4. Immutability: Objects created with telescoping constructors are often mutable, which can lead to unintended side effects if the object is modified after creation.    
 * 5. Scalability: As the number of optional parameters increases, the number of constructor overloads can grow exponentially, making it impractical to manage. 
 * 6. Testing Challenges: Writing unit tests for the constructors can be cumbersome due to the large number of parameters and combinations.
 * 7. Lack of Clarity: The purpose of each parameter may not be clear, especially if they are of the same type (e.g., multiple int parameters).
 * 8. No Default Values: You have to explicitly pass values for all parameters, even if they are optional and could have sensible defaults.
 * 9. Difficulty in Object Creation: Creating objects with different combinations of optional parameters can lead to a combinatorial explosion of constructor overloads.
 * 10. Error-Prone: It's easy to accidentally swap parameters when calling the constructor, leading to bugs.
 * To address these issues, the Builder Pattern is often preferred for creating objects with many optional parameters, as it provides a more flexible and readable way to construct complex objects.
 * This is called Telescoping Constructor Anti-Pattern.

But this creates a cascade of constructors that become:
Hard to read and write
Error-prone due to confusing parameter order
Difficult to maintain when more fields are added
Inflexible, as users must use parameters in a specific order

It occurs most commonly in Java, which lacks support for optional or default parameters (unlike C++ or Python). Because of this limitation, developers are forced to create multiple constructor overloads to handle different combinations of parameters.

Clearly, this approach doesn't scale well. And this is exactly the kind of problem that the Builder Pattern is designed to solve. It gives the user full control over which parts to build while keeping the construction code clean, readable, and safe.
 */
class NutritionFacts {
    private final int servingSize;  // (mL)            required
    private final int servings;     // (per container) required
    private final int calories;     //                 optional
    private final int fat;          // (g)             optional
    private final int sodium;       // (mg)            optional
    private final int carbohydrate; // (g)             optional

    public NutritionFacts(int servingSize, int servings) {
        this(servingSize, servings, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories) {
        this(servingSize, servings, calories, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat) {
        this(servingSize, servings, calories, fat, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium) {
        this(servingSize, servings, calories, fat, sodium, 0);
    }

    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
        this.servingSize = servingSize;
        this.servings = servings;
        this.calories = calories;
        this.fat = fat;
        this.sodium = sodium;
        this.carbohydrate = carbohydrate;
    }
}

/*
 * When to Use and When to Avoid the Builder Pattern

When to Use?
You should consider using the Builder Pattern in the following scenarios:
An object has multiple fields, especially when many of them are optional. Managing such objects using constructors becomes messy and error-prone.
Immutability is preferred - Builder lets you construct an object step by step and then make it immutable once built.
You want readable, maintainable object creation, especially when dealing with domain models or configuration objects. The fluent interface style improves clarity and flexibility.

When to Avoid?
The Builder Pattern can be overkill in simpler use cases. Avoid it when:
Your class has only 1-2 fields: Using a constructor or setter methods is simpler and more concise.
You don’t need object customization or immutability: If the object is small, mutable, or built only in one place, a builder adds unnecessary complexity.
Pros and Cons of Builder Pattern
Understanding both the advantages and limitations of the Builder Pattern helps in deciding when to use it effectively.

Pros
Avoids constructor telescoping: You no longer need to write multiple overloaded constructors for different configurations.
Ensures immutability: The final object can be made immutable once built, which improves safety and thread-safety.
Clean, readable object creation: The fluent API makes object construction expressive and easy to follow.
Great for complex configurations: If your object has many optional parameters or conditional setup, the builder pattern keeps it organized.

Cons
Slightly tough to set up: Initial setup requires writing a separate builder class, which adds to boilerplate.
Overkill for small classes: If a class only has one or two fields, using a builder adds unnecessary complexity.
Separate builder class needed: You need to maintain a second class or static inner class just to construct the main object, increasing maintenance.
 */

public class BuilderPattern {
    public static void main(String[] args) {
        System.out.println("Builder Pattern");
        // Using the traditional constructor approach
        // BurgerMeal meal1 = new BurgerMeal("Whole Wheat", "Beef", "Fries", Arrays.asList("Lettuce", "Tomato"), "Cheddar");
        // BurgerMeal meal2 = new BurgerMeal("Gluten-Free", "Chicken", null, null, null);

        // Using the Builder Pattern
        List<String> toppings = Arrays.asList("lettuce", "onion", "jalapeno");
        BurgerMeal meal1 = new BurgerMeal.BurgerBuilder("Whole Wheat", "Veggie").setSide("Fries").addTopping(toppings).setCheese(true).setDrink("Coke").build();
        // here build() method will return the BurgerMeal object, if we forget to call build() method it will return BurgerBuilder object
        System.out.println(meal1);
        BurgerMeal meal2 = new BurgerMeal.BurgerBuilder("Gluten-Free", "Chicken").build(); // only mandatory parameters
        System.out.println(meal2);

        BurgerMeal meal3 = new BurgerMeal.BurgerBuilder("Sesame", "Veggie").setCheese(false).setSide("Salad").setDrink("Lemonade").build();
        System.out.println(meal3);
    }
}
