// Composite Pattern
/*
 * Composite Pattern
 * 
 * Introduction
Structural design patterns are concerned with the composition of classes and objects. They focus on how to assemble classes and objects into larger structures while keeping these structures flexible and efficient. Composite Pattern is one of the most important structural design patterns. Let's understand in depth.

Composite Pattern
The Composite Pattern is a structural design pattern that allows you to compose objects into tree structures to represent part-whole hierarchies. It lets clients treat individual objects and compositions of objects uniformly.
Problem It Solves
The Composite Pattern solves the problem of treating individual objects and groups of objects in the same way. The main problem arises when:
You want to work with a hierarchy of objects.
You want the client code to be agnostic to whether it's dealing with a single object or a collection of them.
Understanding the Problem
Consider you are building the checkout service of an e-commerce application and you take the following approach as shown in the code below


Working of Refactored Code
CartItem interface defines the common methods for both products and bundles.
Product and ProductBundle classes implement the CartItem interface.
The cart now holds a list of CartItem, allowing us to treat both products and bundles uniformly.
The display and price calculation logic is simplified, as we no longer need to check types.

Understanding Leaf and Composite in the Composite Pattern
In the Composite Design Pattern, we categorize components into two main roles:
Leaf (Individual Object): A Leaf is a simple, atomic object in the structure. It does not contain any child components. In our example:
Product is a Leaf.
It represents individual purchasable items like books, phones, pens, etc.
Implements CartItem and provides its own getPrice() and display() logic.
Composite (Container of Components): A Composite is a complex object that can hold multiple CartItem objects, including both Leaf and other Composite objects. In our example:
ProductBundle is a Composite.
It can contain Products (leaves) and even other ProductBundles (nested composites).
Implements CartItem and delegates actions (getPrice() and display()) to its children.

How it Solves the Issues
Uniform Treatment via Shared Interface (CartItem): Now, both Product and ProductBundle implement CartItem, so the cart can contain any of them without special handling.
This eliminates the need for type checking (instanceof).
Enables Polymorphism: All operations like getPrice() and display() are defined in the CartItem interface, so they can be called uniformly on both products and bundles.
This simplifies logic and improves code extensibility.
Recursive Composition Made Easy: Bundles can now include other bundles or products seamlessly. This supports deeply nested combos or kits which is a common real-world scenario.
No Code Duplication: The cart-handling logic like computing total and displaying items is written once and works for any CartItem.
This promotes cleaner, DRY (Don't Repeat Yourself) code.
When to Use Composite Pattern
The Composite Pattern is particularly useful when:

You have a hierarchical structure: Use the composite pattern when your objects form a tree-like structure (e.g., folders inside folders, or products inside bundles).
You want to treat individual and groups in the same way: When operations on single items and collections of items should be uniform (e.g., calculating total price, displaying structure).
You want to avoid client-side logic to differentiate leaf and composite: Let polymorphism handle the differences between simple and composite objects, keeping client code clean and maintainable.
Advantages and Disadvantages

Pros:
Uniformity: Treats individual and composite objects in the same way.
Extensible: Easy to add new item types or structures.
Cleaner client code: Reduces complexity for the user of the structure.
Supports OCP (Open/Closed Principle): Add new components without modifying existing code.

Cons:
Violates SRP on scale: Components manage both hierarchy and business logic.
Overkill for flat and simple structures: Adds unnecessary complexity.
Can hide important distinctions: In regulated or sensitive systems, uniform treatment might blur critical differences between types.


 * 
 */

import java.util.ArrayList;
import java.util.List;

/* Without Composite Pattern 
class Product{
    private String name;
    private double price;

    public Product(String name, double price){
        this.price = price;
        this.name = name;
    }
    public double getPrice(){
        return price;
    }
    public void display(String indent){
        System.out.println(indent + "Product: " + name + ", Price: " + price);
    }
}

class ProductBundle{
    private String bundleName;
    private List<Product> products;

    public ProductBundle(String bundleName){
        this.bundleName = bundleName;
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product){
        products.add(product);
    }

    public double getPrice(){
        double total = 0;
        for(Product product : products){
            total += product.getPrice();
        }
        return total;
    }

    public void display(String indent){
        System.out.println(indent + "Bundle: " + bundleName + ", Total Price: " + getPrice());
        for(Product product : products){
            product.display(indent + "  ");
        }
    }
}
    

 * Problems with the Above Approach
 * 1. Type Checking: The client code needs to check the type of each item in the cart (whether it's a Product or a ProductBundle) to handle it appropriately. This leads to type-checking code scattered throughout the client logic.
 * 2. Code Duplication: The logic for displaying item details and calculating the total price
 * 
 * Working of Code
 * Product class represents a simple item with name and price.
 * ProductBundle class represents a group of products bundled together.
 * Both classes have methods to display and return their prices.
 * In main(), individual products and bundles are created and added to the cart.
 * The cart is a List<Object> that holds both products and bundles.
 * During checkout, the code checks each item's type using instanceof.
 * Based on the type, it casts the object and calls its respective methods.
 * Finally, it displays all items and calculates the total price.
 * Problem in above code
 * In the above example, the code lacks the structure to treat individual and group items uniformly, i.e., In the current implementation, individual products (Product) and product bundles (ProductBundle) are completely separate types with no shared interface or superclass. This means we cannot write code that treats both uniformly and the logic always has to check which type we're working with.
 * Other than these, there are some other problems as well:
 * instanceof is used repeatedly, breaking polymorphism.
 * Cart uses List<Object>, which is unsafe and violates abstraction.
 * ProductBundle cannot contain another ProductBundle (no recursive structure).
 * Display and price logic are duplicated instead of unified.

*/

// Composite Pattern Implementation
interface CartItem{
    double getPrice();
    void display(String indent);
}
class Product implements CartItem{
    private String name;
    private double price;

    public Product(String name, double price){
        this.price = price;
        this.name = name;
    }
    @Override
    public double getPrice(){
        return price;
    }
    @Override
    public void display(String indent){
        System.out.println(indent + "Product: " + name + ", Price: " + price);
    }
}
class ProductBundle implements CartItem{
    private String bundleName;
    private List<CartItem> items;

    public ProductBundle(String bundleName){
        this.bundleName = bundleName;
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item){
        items.add(item);
    }

    @Override
    public double getPrice(){
        double total = 0;
        for(CartItem item : items){
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void display(String indent){
        System.out.println(indent + "Bundle: " + bundleName + ", Total Price: " + getPrice());
        for(CartItem item : items){
            item.display(indent + "  ");
        }
    }
}
public class CompositePattern {
    public static void main(String[] args) {
        /* Without Composite Pattern
        // Individual Products
        Product laptop = new Product("Laptop", 1000);
        Product smartphone = new Product("Smartphone", 600);
        Product tablet = new Product("Tablet", 400);    
        // Product Bundle
        ProductBundle holidayBundle = new ProductBundle("Holiday Bundle");
        holidayBundle.addProduct(laptop);
        holidayBundle.addProduct(smartphone);
        holidayBundle.addProduct(tablet);

        // school kit bundle
        ProductBundle schoolKitBundle = new ProductBundle("School Kit Bundle");
        schoolKitBundle.addProduct(new Product("Notebook", 50));
        schoolKitBundle.addProduct(new Product("Pen Set", 20));
        schoolKitBundle.addProduct(new Product("Backpack", 80));

        // add to cart - problem begins
        List<Object> cart = new ArrayList<>();
        cart.add(laptop);   
        cart.add(holidayBundle);
        cart.add(schoolKitBundle);
        // Display Cart Details 
        System.out.println("Cart Details:");
        double grandTotal = 0;
        for(Object item : cart){
            if(item instanceof Product){
                Product product = (Product) item;
                product.display("  ");
                grandTotal += product.getPrice();
            } else if(item instanceof ProductBundle){
                ProductBundle bundle = (ProductBundle) item;
                bundle.display("  ");
                grandTotal += bundle.getPrice();
            }
        }
        System.out.println("Grand Total: " + grandTotal);
        
        */
        // With Composite Pattern
        // Individual Products
        CartItem laptop = new Product("Laptop", 1000);
        CartItem smartphone = new Product("Smartphone", 600);
        CartItem tablet = new Product("Tablet", 400);    
        // Product Bundle
        ProductBundle holidayBundle = new ProductBundle("Holiday Bundle");
        holidayBundle.addItem(laptop);
        holidayBundle.addItem(smartphone);
        holidayBundle.addItem(tablet);
        // school kit bundle
        ProductBundle schoolKitBundle = new ProductBundle("School Kit Bundle");
        schoolKitBundle.addItem(new Product("Notebook", 50));
        schoolKitBundle.addItem(new Product("Pen Set", 20));
        schoolKitBundle.addItem(new Product("Backpack", 80));
        // add to cart
        List<CartItem> cart = new ArrayList<>();
        cart.add(laptop);
        cart.add(holidayBundle);
        cart.add(schoolKitBundle);

        // Display Cart Details
        System.out.println("Cart Details:");
        double grandTotal = 0;
        for(CartItem item : cart){
            item.display("  ");
            grandTotal += item.getPrice();
        }
        System.out.println("Grand Total: " + grandTotal);
    }
}
