import java.util.ArrayList;
import java.util.List;
// Iterator Pattern 
/*

 * Introduction
Behavioral design patterns focus on how objects interact and communicate with each other, helping to define the flow of control in a system. These patterns simplify complex communication logic between objects while promoting loose coupling.

Imagine a TV remote that lets you switch through channels one by one, without needing to know how the channels are stored internally. This kind of controlled access is exactly what behavioral patterns help us achieve.

One such pattern is the Iterator Pattern. Let's understand the Iterator Pattern in depth in the upcoming sections.

Iterator Pattern
The Iterator Pattern is a behavioral design pattern that provides a way to access the elements of a collection sequentially without exposing the underlying representation.

Formal Definition
The Iterator Pattern is a behavioral design pattern that entrusts the traversal behavior of a collection to a separate design object. It traverses the elements without exposing the underlying operations.

This means whether your collection is an array, a list, a tree, or something custom, you can use an iterator to traverse it in a consistent manner, one element at a time, without worrying about how the data is stored or managed internally.
Real-Life Analogy
Think of a vending machine. You don’t need to know how the snacks are arranged inside or where exactly your favorite drink is stored. You just press the "Next" button to scroll through options one by one. The vending machine controls the order and pace of traversal.

Similarly, an iterator acts like that "Next" button, giving you one item at a time, hiding the complexity of what’s going on behind the scenes.
Understanding the Problem
Let’s say we’re building a YouTube Playlist system. We want to store a list of videos and print their titles one by one. Let's look at the initial code setup:


What are the Issues?
While the code works, there are several design-level concerns:
Exposes internal structure:
The internal list or array is directly returned via getVideos() or similar methods.
This breaks encapsulation, as clients can access or even modify the internal collection outside the owning class.
Tight coupling with underlying structure:
The external code is tightly bound to the specific type of collection used (like vector, list, etc.).
Any change in the internal structure may require changes in client code.
No control over traversal
Traversal logic is managed outside the class.
You can't enforce custom traversal behaviors (e.g., reverse, skip elements, filter) without modifying external code.
Difficult to support multiple independent traversals:
If two parts of your program want to iterate over the same playlist independently, there's no built-in way to do that cleanly.
You have to manage indexing and traversal state manually.

Let us now understand how we can solve this problem using the Iterator Pattern.



How This Solves the Problem
With the iterator pattern in place, we’ve clearly separated the concern of how elements are traversed from the actual data structure that stores them. Here's how this improves our design:

Problem	                                        How Iterator Pattern Solves It
Direct access to internal data structure    	The collection no longer exposes its internal data (like a list or array) directly for traversal. Instead, an iterator is used to access elements one-by-one, encapsulating the structure.
No standard way to iterate	                    All traversal is now handled through a consistent interface (hasNext() / next()), regardless of how the data is stored internally. This ensures uniformity in how iteration happens.
Traversal logic spread across client code	    The logic for maintaining iteration state (e.g., index or position) is encapsulated within the iterator class itself, keeping the client code clean and focused only on usage.
Difficult to customize traversal	            Custom iterator classes can easily be extended to provide different traversal strategies (e.g., reverse, filtering, skipping), without changing the underlying collection.
Tight coupling to collection type	            Client code no longer depends on the exact type of data structure (like array, list, vector). It interacts only with the iterator, reducing dependencies and improving flexibility.

---------------------
One Major Issue Still Remains...
Even though we’ve abstracted the traversal logic into an iterator class, the client is still responsible for creating and using the iterator, which is not ideal. The goal of true encapsulation would be to hide even the creation of the iterator, something we’ll address now with a more refined approach in the next section.
======================================================================================================
Key Improvements
The YouTubePlaylist class no longer exposes its internal implementation of Videos.
The client does not manage or know about the internal structure.
The Playlist interface allows us to make other types of playlists (e.g., MusicPlaylist) that can also be iterable.
Fully aligns with the Iterator Design Pattern principles.
Ideal Scenarios for Using the Iterator Pattern
The Iterator Pattern isn’t meant for every situation, but it becomes incredibly useful in specific cases. Here are the key situations where this pattern shines:

You want to traverse a collection without exposing its internal structure:
Instead of revealing whether it's an ArrayList, Vector, or a custom tree, the pattern lets clients access elements one-by-one, safely and uniformly.
You need multiple ways to traverse a collection:
For example, forward traversal, reverse traversal, or skipping every second element. Each of these can be handled by a different iterator implementation without changing the collection itself.
You want a unified way to traverse different types of collections:
Whether it’s a list of videos, a set of songs, or a stack of documents, clients should be able to iterate over them using a common interface.
You want to decouple iteration logic from collection logic:
By separating how elements are stored from how they’re accessed, you reduce complexity and improve maintainability. Changes in iteration logic won’t affect how the collection is structured, and vice versa.
Real World Examples
The Iterator Pattern is deeply embedded in software systems where data needs to be traversed without exposing its internal structure. Here are two crisp, real-world examples:

1. Java Collection Framework
In Java, every collection class, like ArrayList, HashSet, TreeSet, implements the Iterable interface, which returns an Iterator via the iterator() method:
List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Banana");

Iterator<String> iterator = fruits.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}






Pros and Cons

Pros of Iterator Pattern
Hides internal structure:
You can traverse a collection without knowing how it's built internally.
Unified way to traverse:
You use the same methods (hasNext, next) regardless of the collection type.
Supports multiple traversal strategies:
You can easily create different iterators (e.g., forward, reverse, filtered).
Follows SRP and OCP principles:
Iteration logic is separated (Single Responsibility), and new iterators can be added without modifying existing code (Open/Closed).

Cons of Iterator Pattern
Adds extra classes/interfaces:
Requires more boilerplate code to set up custom iterators.
Can be overkill for simple data structures:
For small lists, a direct for loop might be more straightforward.
External iteration is manual:
Client has to manage the loop using hasNext() and next() unless abstracted further.




====================================================================================================





 * The Iterator Pattern provides a way to access the elements of an aggregate object (like a collection) sequentially without exposing its underlying representation.
 * It allows clients to traverse a collection without needing to know the details of how the collection is
 * 
 * Thik hai Om, bahut simple Hinglish me samjha deta hoon — bilkul easy language me — aur neeche reliable sources ke links bhi de raha hoon.
________________________________________
⭐ Behavioral Design Patterns – Simple Hinglish Explanation
Behavioral patterns ka matlab hota hai:
➡️ Objects aapas me kaise communicate karte hain aur kaise kaam baant-te hain.
Easy words me:
Jab code ke different parts ko ek-dusre se baat karni ho, ya kaun kya kare ye decide karna ho — tab behavioral patterns use hote hain.
Examples: Strategy, Observer, Command, Iterator, State, Template Method etc.
________________________________________
⭐ Iterator Pattern – Bilkul Simple Hinglish Me
Iterator Pattern ka matlab:
➡️ Collection ke elements ko ek-ek karke access karna, bina collection ka internal structure jaane.
Matlab:
•	Tumhare paas list, array, ya koi bucket hai
•	Tum directly us bucket ko open nahi karte
•	Tum ek iterator lete ho
•	Iterator tumhe bolta hai:
o	“Agle element ko dedo?”
o	“Aur element bache hain kya?”
Ye pattern useful hota hai jab:
•	Tumko pata nahi hota ke data array me hai, list me hai ya tree me
•	Tum sirf loop karna chahte ho ek-ek item pe
________________________________________
⭐ VERY SIMPLE REAL LIFE EXAMPLE
Example: Library me 100 books hain.
Library tumhe poora shelf nahi uthake degi.
Library bolti hai — “Yeh lo iterator. Ek-ek book nikaalte jao.”
Tum use karte ho:
hasNext() → aur kitni books bachi hain?
next() → next book dedo
Bas. Tumhe nahi pata ki books ek array hai, linked list hai, tree hai… kuch bhi ho sakta hai.
Iterator tumhare liye kaam easy kar deta hai.
________________________________________
⭐ CODE Example (Hinglish Explanation)
List<String> names = List.of("Om", "Rahul", "Priya");

Iterator<String> it = names.iterator();

while (it.hasNext()) {
    System.out.println(it.next());
}
Yaha:
•	it.hasNext() → check karta hai elements bache hain?
•	it.next() → next element de deta hai
Tumne kahin nahi likha ki list ka structure kya hai.
Array hai? LinkedList hai? Tumko farak nahi padta.
________________________________________
⭐ Kyun Use Karte Hain? (Very Simple)
✔ Internal structure hidden rehta hai
✔ Traversal (looping) easy ho jaata hai
✔ Different type ke traversal bana sakte ho (forward, backward, filter)
________________________________________
⭐ Reliable Sources (Design Patterns)
Yeh sab reputable computer science references hain:
1.	Refactoring Guru – Iterator Pattern
https://refactoring.guru/design-patterns/iterator
2.	GeeksForGeeks – Iterator Design Pattern
https://www.geeksforgeeks.org/iterator-design-pattern/
3.	Java Official Docs – Iterator Interface
https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
________________________________________



The Iterator Pattern is a behavioral design pattern that provides a way to access elements of a collection (like a list, array, or tree) sequentially without exposing its internal structure.

✅ Why do we need it?

Collections can have different internal representations (array, linked list, tree).
We want a uniform way to traverse them without knowing how they are implemented.
It promotes Single Responsibility Principle: traversal logic is separated from collection logic.


Key Components


Iterator Interface
Defines methods like:

hasNext() → checks if more elements exist.
next() → returns the next element.



Concrete Iterator
Implements the iterator interface for a specific collection.


Aggregate (Collection) Interface
Defines a method to create an iterator.


Concrete Aggregate
Implements the collection and returns an iterator.

Benefits

Decouples traversal from collection structure.
Supports multiple traversal strategies (forward, backward).
Easy to add new iterators without changing collection code.
======================================================================

________________________________________
✅ Real-World Analogy for Iterator Pattern
Imagine Netflix:
•	You have a playlist of movies (collection).
•	Netflix doesn’t show you the internal database structure (SQL tables, JSON, etc.).
•	Instead, it gives you a Next button and a Previous button to move through movies one by one.
•	You don’t care how movies are stored internally; you just use the iterator (Next/Previous) to access them sequentially.
This is exactly what the Iterator Pattern does:
It hides the complexity of the collection and provides a simple way to traverse elements.
________________________________________
✅ FAANG-Level Interview Questions on Iterator Pattern
Q1: Why do we need the Iterator Pattern when Java already has for-each loops?
Answer:
•	for-each works only on collections that implement Iterable.
•	Iterator Pattern is language-agnostic and can be applied to custom data structures (e.g., trees, graphs).
•	It allows multiple traversal strategies (forward, backward, filtered) without exposing internal representation.
________________________________________
Q2: How would you implement an iterator for a Binary Tree?
Answer:
•	Use DFS or BFS traversal logic inside the iterator.
•	Maintain a stack (DFS) or queue (BFS) internally.
•	hasNext() checks if stack/queue is empty.
•	next() pops the next node and pushes its children.
________________________________________
Q3: What are the advantages and disadvantages of the Iterator Pattern?
Answer:
✅ Advantages:
•	Decouples traversal from collection structure.
•	Supports multiple traversal strategies.
•	Promotes Single Responsibility Principle.
❌ Disadvantages:
•	Adds extra classes (Iterator, ConcreteIterator).
•	Can increase complexity for simple collections.
________________________________________
Q4: How would you design an iterator for a Graph in Java?
Answer:
•	Maintain a visited set and a stack/queue.
•	next() returns the next node based on DFS/BFS.
•	hasNext() checks if there are unvisited nodes.
________________________________________
Q5: Can you make an iterator thread-safe?
Answer:
•	Use Concurrent Collections or synchronized blocks.
•	Or implement fail-fast iterators (like Java’s ConcurrentModificationException).
________________________________________



===================================================================
Here’s a focused list of FAANG-level interview questions specifically related to the Iterator Pattern:
________________________________________
✅ Basic Understanding
1.	What is the Iterator Pattern and why is it useful?
2.	How does the Iterator Pattern promote the Single Responsibility Principle?
3.	What are the main components of the Iterator Pattern?
4.	Explain the difference between external and internal iteration.

________________________________________
✅ Coding Questions
5.	Implement an iterator for a custom linked list in Java.
6.	Design an iterator for a Binary Tree (DFS or BFS).
7.	Create an iterator for a Graph supporting DFS traversal.
8.	Implement a bidirectional iterator for a doubly linked list.
9.	Write a filtering iterator that only returns even numbers from a collection.
________________________________________
✅ Advanced / FAANG-Level Variations
10.	How would you design an iterator for a huge dataset that cannot fit in memory?
o	Hint: Use lazy loading or pagination.
11.	Implement a thread-safe iterator for a concurrent collection.
12.	Design an iterator that supports multiple traversal strategies (DFS, BFS) for a graph.
13.	How would you implement a fail-fast iterator like Java’s ConcurrentModificationException?
14.	Create an iterator for a composite object structure (e.g., file system directories).
________________________________________
✅ System Design Angle
15.	If you were designing a social media feed system, how would you use the Iterator Pattern?
o	Hint: For paginated scrolling and abstracting data source.
________________________________________
🔥 These questions are commonly asked in Meta, Amazon, and Google interviews when discussing design patterns and data structures.
________________________________________



 */
class Video{
    String title;
    public Video(String title){
        this.title = title;
    }
    public String getTitle(){
        return title;
    }
}

// class YouTubePlayList{
//     private List<Video> videos;
//     public YouTubePlayList(){
//         this.videos = new ArrayList<>();
//     }
//     public void addVideo(Video video){
//         videos.add(video);
//     }
//     public List<Video> getVideo(){
//         return videos;
//     }
// }

// using Iterator Pattern
interface PlayListIterator{
    boolean hasNext();
    Video next();
}
// ========= Concrete Iterator Implementation ==========
class YouTubePlayListIterator implements PlayListIterator{
    private List<Video> videos;
    private int currentIndex;

    public YouTubePlayListIterator(List<Video> videos){
        this.videos = videos;
        this.currentIndex = 0;
    }
    @Override
    public boolean hasNext(){
        return currentIndex < videos.size();
    }
    @Override
    public Video next(){
        if(!hasNext()){
            return null;
        }
        return videos.get(currentIndex++);
    }
}

// Iterable interface can also be created for YouTubePlayList to return iterator
// so client should not write iterator or loop or decide how to iterate
interface IterablePlayList{
    PlayListIterator createIterator();
}
// iterable class 
class YouTubePlayListIterable implements IterablePlayList{
    private List<Video> videos = new ArrayList<>();

    public void addVideo(Video video){
        this.videos.add(video);
    }
    @Override
    public PlayListIterator createIterator(){
        return new YouTubePlayListIterator(videos); // this internally uses iterator whatever traversal logic it want
    }
}


public class IteratorPattern1 {
    public static void main(String[] args) {
        System.out.println(" Iterator Pattern");

        YouTubePlayListIterable playList = new YouTubePlayListIterable();
        playList.addVideo(new Video("Video 1"));
        playList.addVideo(new Video("LLD Tutorial"));
        playList.addVideo(new Video("System Design Basics"));
        // for(Video video : playList.getVideo()){
        //     System.out.println("Video Title: " + video.getTitle());
        // }

        PlayListIterator iterator = playList.createIterator();
        while(iterator.hasNext()){
            Video video = iterator.next();
            System.out.println("Video Title: " + video.getTitle());
        }
    }
}
