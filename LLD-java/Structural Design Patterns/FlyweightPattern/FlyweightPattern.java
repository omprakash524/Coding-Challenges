import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Flyweight Pattern
/*Introduction
Structural design patterns are concerned with the composition of classes and objects. They help make large systems more efficient, scalable, and maintainable. The Flyweight Pattern is one such structural pattern that focuses on optimizing memory usage and performance by sharing objects. Let's understand it in detail.

Flyweight Pattern
The Flyweight Pattern is a structural design pattern used to minimize memory usage by sharing as much data as possible with similar objects.

It separates the intrinsic (shared) state from the extrinsic (unique) state, so that shared parts of objects are stored only once and reused wherever needed.
Real-Life Analogy
Think of trees in a video game. In an open-world video game, you might see thousands of trees:
All oak trees have the same texture, shape, and behavior (shared/intrinsic).
But their location, size, or health status may differ (extrinsic).

Rather than loading the same tree model thousands of times, the game engine uses a single shared tree model and passes different parameters when rendering.
Problem It Solves
It solves the problem of high memory usage when a large number of similar objects are created. For example, imagine a system rendering:
Thousands of tree objects in a forest
Each with the same shape and texture but a different location

Instead of creating thousands of identical objects, the Flyweight Pattern lets you share the common parts (shape, texture) and store the unique parts (location) externally, dramatically reducing memory consumption.
Core Concepts
Intrinsic State: The immutable, shared data stored inside the flyweight. It is independent of context.
Extrinsic State: The context-specific data passed from the client and not stored in the flyweight.
Real-Life Coding Example
Imagine you're building a feature like Google Maps where you need to visually represent trees across the globe. Now, even though millions of trees are shown, most of them belong to only a few common types like “Oak”, “Pine”, or “Birch”. However, if we were to create a separate object for each individual tree — storing the same data repeatedly for tree type, color, and texture — it would lead to massive memory consumption.

Let’s consider a scenario where we want to create 1 million trees, all with the same name, color, and texture. A poor design would look like this:


How Flyweight Pattern Solves the Issue
Let’s break it down:
TreeType Class: This acts as the flyweight object. It stores data common to all trees of a given type—like name, color, and texture. Instead of duplicating this data, we create only one instance per unique combination.
Tree Class: This now only stores:
Intrinsic data: x, y (unique to each tree)
Reference to shared data: A TreeType instance
TreeFactory Class: This is the central factory that ensures TreeType instances are reused:
Memory Efficiency: Even with 1 million trees, if they all share the same TreeType ("Oak", "Green", "Rough"), only one TreeType object is created and shared across all trees, reducing memory usage dramatically.
When to Use Flyweight Pattern?
The flyweight pattern can be used when:

When you need to create a large number of similar objects.
When memory and performance optimization is crucial.
When the object's intrinsic properties could be shared independently of its extrinsic properties.
Advantages
A few advantages of using the Flyweight Pattern are:

Greatly reduces memory usage when there are a lot of similar objects.
Improves performance in resource-constrained environments.
Enables faster object creation.
Disadvantages
A few disadvantages of using the Flyweight Pattern are:

Adds complexity (especially around factory and object management).
Harder to debug due to shared state.
Can lead to tight coupling between flyweight and client code if not designed carefully.
Real-World Applications of Flyweight Pattern
The Flyweight pattern is widely used in large-scale applications where rendering or managing many similar objects efficiently is essential. Here are some real-world examples:

Google Maps
When displaying millions of trees or similar visual landmarks, Google Maps avoids creating separate objects for each tree. Instead, it shares the same data (like tree type, color, texture) across all trees and only varies extrinsic properties like position — a classic use of the Flyweight pattern.
Uber App
Uber renders many nearby cars on the map, but most of them are visually identical (same icon, color, etc.). Instead of creating a new object for each car from scratch, Uber reuses a common flyweight object and just changes the coordinates — reducing memory and improving performance.
Web Browsers (Chrome, Firefox, etc.)
When rendering complex webpages with thousands of similar DOM elements (like repeated icons, buttons, text styles), modern browsers internally use the Flyweight pattern to optimize memory. For instance:
A webpage might have hundreds of <div> or <button> elements styled identically.
Instead of allocating separate memory for each element’s styling and behavior, browsers reuse the same shared style object (like CSS rules or rendering data) across all similar components.
This allows browsers to load and display large webpages faster and with less RAM usage.



Quick additional example (different domain)

Suppose you’re building a text editor:
For each character on screen you could have a Glyph object storing font, size, style, color. But in a large document many characters share exactly the same font + size + style.
So: Intrinsic = character code + font + size + style. Extrinsic = position of the glyph (x, y) in document.
Flyweight factory returns one Glyph per unique font+style+character combination, and then you draw many by passing position.
This very example is cited in Wikipedia.

 */


//  Beloware advanced, interview-ready Flyweight Pattern Q&A — exactly the kind you can directly use in FAANG/Meta interviews.
// All explanations are crisp, structured, and impressive for interviews.
// ________________________________________
// ✅ 20 Interview Questions + Strong Answers (Flyweight Pattern)
// ________________________________________
// 1. What is the Flyweight Pattern?
// A structural pattern that minimizes memory usage by sharing common intrinsic state across multiple objects while keeping extrinsic state external and passed on demand.
// ________________________________________
// 2. What problem does Flyweight solve?
// When an application must create millions of similar objects, Flyweight reduces memory by storing shared state once instead of repeating it multiple times.
// ________________________________________
// 3. What are intrinsic and extrinsic states?
// •	Intrinsic: Shared, immutable data stored inside the flyweight (e.g., texture, sprite, font).
// •	Extrinsic: Context-specific data supplied by the client (e.g., position, size).
// ________________________________________
// 4. When should you use Flyweight?
// •	When the system creates huge numbers of objects.
// •	When objects contain substantial shared data.
// •	When memory optimisation is critical.
// ________________________________________
// 5. When should you NOT use Flyweight?
// •	When most object attributes are unique, not shareable.
// •	When shared state is mutable, risking inconsistent sharing.
// •	When object count is small, offering no memory advantage.
// ________________________________________
// 6. What is the role of the Flyweight Factory?
// It ensures:
// •	A flyweight object is created once per unique intrinsic state.
// •	New requests reuse existing objects.
// •	It maintains an internal cache/mapping of flyweights.
// ________________________________________
// 7. Is Flyweight similar to Singleton?
// No.
// •	Singleton → one instance globally.
// •	Flyweight → one instance per key (per shared state combination).
// ________________________________________
// 8. How does Flyweight improve performance?
// •	Reduces heap memory allocations.
// •	Shrinks object count.
// •	Lowers GC pressure.
// •	Makes rendering faster (common in UI/graphics).
// ________________________________________
// 9. Give a real-world example.
// Example: Google Maps trees/icons
// Millions of identical tree icons share the same image, color, style. Only (x, y) coordinates differ — extrinsic.
// ________________________________________
// 10. How does Flyweight differ from Prototype?
// •	Prototype → clones objects.
// •	Flyweight → shares objects.
// ________________________________________
// 11. How do you make shared state thread-safe?
// •	Make intrinsic state immutable.
// •	Use concurrent collections in the factory.
// •	Avoid storing mutable fields in flyweights.
// ________________________________________
// 12. How does Flyweight work in a game engine?
// Game engines render thousands of entities (bullets, trees, particles).
// They share:
// •	3D model
// •	Texture
// •	Color
// •	Behaviour
// Each entity passes only extrinsic values like position or velocity.
// ________________________________________
// 13. What drawback does Flyweight introduce?
// More complex design because extrinsic state must be manually provided every time.
// ________________________________________
// 14. Name some systems that internally use Flyweight.
// •	Java’s String Pool
// •	Java Integer.valueOf() caching
// •	Browsers reusing DOM style objects
// •	Font rendering engines
// •	GUI icon caching
// ________________________________________
// 15. Is Flyweight the same as caching?
// Flyweight is a design pattern using caching of intrinsic objects.
// Caching ≠ Flyweight, but Flyweight uses caching as part of its structure.
// ________________________________________
// 16. What happens if client mistakenly modifies intrinsic data?
// All objects sharing that flyweight become inconsistent.
// Solution: Make intrinsic state immutable.
// ________________________________________
// 17. How do you identify good Flyweight candidates?
// Ask:
// •	Are there millions of similar objects?
// •	Do many objects share the same data?
// •	Can we split object state into shared vs unique?
// If yes → perfect candidate.
// ________________________________________
// 18. What is the memory savings formula?
// Memory saved =
// (original_object_size – extrinsic-only_size) × number_of_shared_objects
// ________________________________________
// 19. Can Flyweight be used with Composite Pattern?
// Yes.
// Composite + Flyweight is common in large UIs and graphics systems for efficient tree rendering.
// ________________________________________
// 20. Write a one-line answer for “Why do we need Flyweight?”
// “To drastically reduce memory usage by sharing object state across many fine-grained objects.”
// ________________________________________



// 🔵 Scenario

// 1 — Final Polished Meta/Google Answer

// If the interviewer asks:

// “How would you optimize Google Maps tree rendering using Flyweight?”

// Here is the polished answer you can use:

// *“I separate tree data into intrinsic and extrinsic.
// Intrinsic properties like tree name, color, and texture are identical for thousands of trees, so I keep them inside a shared TreeType flyweight.
// The only thing unique is the tree’s coordinates, which I pass from the outside as extrinsic state.

// This lets millions of trees share a handful of TreeType objects, which drastically reduces memory and speeds up rendering.”*

// This answer shows:
// ✓ You understand intrinsic/extrinsic
// ✓ You understand memory optimisation
// ✓ You know the reasoning behind the pattern
// ✓ You can explain scalability
/*
// ================== without flyweight pattern =====================

class Tree{
    private int x;
    private int y;
    private String name;
    private String color;
    private String texture;

    public Tree(int x, int y, String name, String color, String texture){
        this.x = x;
        this.y = y;
        this.name = name;
        this.color = color;
        this.texture = texture;
    }
    public void displayTree(){
        System.out.println("Tree: " + name + ", Color: " + color + ", Texture: " + texture + ", Position: (" + x + ", " + y + ")");
    }
}

class Forest{
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture){
        Tree tree = new Tree(x, y, name, color, texture);
        trees.add(tree);
    }

    public void displayForest(){
        for(Tree tree : trees){
            tree.displayTree();
        }
    }
}

// Understanding the Issues
// Although the above codes works absolutely fine but there are a few problems associated with it:
// Redundant memory usage: Same tree data duplicated a million times.
// Inefficient: Slower rendering, higher GC overhead.

// The previous implementation created a new Tree object for each of the 1 million trees, even when most of them had identical properties like name, color, and texture. This led to unnecessary duplication of memory for the shared attributes.

// To solve this, we use the Flyweight Design Pattern — a structural pattern focused on minimizing memory usage by sharing as much data as possible between similar objects.

*/


// ============= with flyweight pattern ==================

class TreeType {
    private String name;
    private String color;
    private String texture;
    // Intrinsic state = the part of the object state that is shared among many objects. It’s independent of object context and ideally immutable 
    public TreeType(String name, String color, String texture) {
        this.name = name;
        this.color = color;
        this.texture = texture;
    }

    public void display(int x, int y) {
        System.out.println("Tree: " + name + ", Color: " + color + ", Texture: " + texture + ", Position: (" + x + ", " + y + ")");
    }
}
class Tree {
    // Extrinsic state = the part that varies from one object instance to another, or is context-specific. This is provided by the client when the object is used. 
    private int x;
    private int y;
    private TreeType type;

    public Tree(int x, int y, TreeType type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public void displayTree() {
        type.display(x, y);
    }
}

class TreeFactory {
    private static final Map<String, TreeType> treeTypeMap = new HashMap<>();

    public static TreeType getTreeType(String name, String color, String texture) {
        String key = name + "-" + color + "-" + texture;
        if (!treeTypeMap.containsKey(key)) {
            treeTypeMap.put(key, new TreeType(name, color, texture));
        }
        return treeTypeMap.get(key);
    }
}

class Forest {
    private List<Tree> trees = new ArrayList<>();

    public void plantTree(int x, int y, String name, String color, String texture) {
        // TreeType type = new TreeType(name, color, texture); // here we are creating new object every time, here is the problem, we write factory pattern to solve this
        // instead we will use flyweight pattern to reuse the same object, memory optimization, memoization
        
        Tree tree = new Tree(x, y, TreeFactory.getTreeType(name, color, texture));
        trees.add(tree);
    }

    public void displayForest() {
        for (Tree tree : trees) {
            tree.displayTree();
        }
    }
}
public class FlyweightPattern {
    public static void main(String[] args) {
        Forest forest = new Forest();
        forest.plantTree(10, 20, "Oak", "Green", "Rough");
        forest.plantTree(15, 25, "Pine", "Dark Green", "Smooth");
        forest.plantTree(30, 40, "Birch", "Light Green", "Peeling");
        forest.displayForest();
        // plant 1 million trees
        for(int i=0; i<1000000; i++){
            forest.plantTree(i, i+1, "Oak", "Green", "Rough");
        }
        forest.displayForest();
    }
}
