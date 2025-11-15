// Bridge Pattern
/*
 * The Bridge Pattern is a structural design pattern that decouples an abstraction from its implementation,
 * allowing the two to vary independently. This pattern is particularly useful when both the abstraction
 * and implementation need to be extended using inheritance.
 * 
 * 
 * Introduction
Structural design patterns are concerned with the composition of classes and objects. They focus on how to assemble classes and objects into larger structures while keeping these structures flexible and efficient. Bridge Pattern is one of the most important structural design patterns. Let's understand in depth.

Bridge Pattern
The Bridge Pattern is a structural design pattern that is used to decouple an abstraction from its implementation so that the two can vary independently.
Problem It Solves
When you have multiple dimensions of variability, such as different types of features (abstractions) and multiple implementations of those features, you might end up with a combinatorial explosion of subclasses if you try to use inheritance to handle all combinations. Thus bridge pattern:
Avoids tight coupling between abstraction and implementation.
Eliminates code duplication that would occur if every combination of abstraction and implementation had its own class.
Promotes composition over inheritance, allowing more flexible code evolution.
Real-Life Analogy
Think of a TV remote and a TV:
The remote is the abstraction (interface the user interacts with).
The TV is the implementation (actual functionality).

You can have different types of remotes (basic, advanced) and different brands of TVs (Samsung, Sony). Bridge Pattern allows any remote to work with any TV without creating a separate class for each combination.
Real-Life Coding Example
Imagine you're building a media player application that supports different types of devices (like Web, Mobile,
Smart TV) and different video quality options (like HD, Ultra HD). Without the Bridge Pattern, you might end up creating a separate class for each combination of device and quality, leading to a proliferation of classes.

 
*/


/*
 * without bridge pattern
 * Real-Life Coding Example
Assume we are building a video player that aims to model different video players (like Web, Mobile, Smart TV) each with different quality types (HD, Ultra HD, 4K).

Using Tight Coupling Causing Class Explosion
 * 
 * 
 * 
interface PlayQuality{
    void play(String title);
}
class WebHDPlayer implements PlayQuality{
    public void play(String title){
        System.out.println("Playing " + title + " in Web HD quality.");
    }
}
class MobileHDPlayer implements PlayQuality{
    public void play(String title){
        System.out.println("Playing " + title + " in Mobile HD quality.");
    }
}
class SMartTVUltraHDPlayer implements PlayQuality{
    public void play(String title){
        System.out.println("Playing " + title + " in Smart TV Ultra HD quality.");
    }
}
 * above approach has limitations as adding new devices or qualities requires creating new classes,
 * leading to class explosion.
 * Understanding the Issue
 * 
In the given design, platform types (like Web, Mobile, Smart TV) are tightly coupled with video quality types (like HD, Ultra HD, 4K). This results in a rigid system where every combination requires a separate class — for example, WebHDPlayer, MobileHDPlayer, SmartTVUltraHDPlayer, and so on.

As new platforms or quality types are introduced, the number of classes grows rapidly. Adding just one new platform or one new quality level leads to multiple new classes. If you have 5 platforms and 5 quality types, you end up with 25 distinct classes — most of which share very similar code.

Such tightly coupled designs are hard to test, extend, and manage over time. This is where the Bridge Pattern proves valuable — by decoupling the abstraction (platform) from its implementation (quality), it allows both to evolve independently, eliminating unnecessary class combinations.


// ==========================================================================
 * How Bridge Pattern Solves the Issue
Separation of Concerns: VideoPlayer (abstraction) focuses on the platform-specific behavior, while VideoQuality (implementor) handles quality-specific streaming logic.
Flexible Combinations: You can mix and match any platform with any quality at runtime without creating new classes.
Easier to Extend: Adding a new platform or a new quality only requires one new class, not multiple combinations:
Add SmartTVPlayer → works with all existing qualities.
Add FullHDQuality → works with all existing players.
Cleaner Code Structure: Each class has a single responsibility. This promotes maintainability, scalability, and adheres to the Open/Closed Principle.
When to use Bridge Pattern
Bridge Pattern is particularly useful when:

You have multiple dimensions of variation
You want to decouple abstraction from implementation
You anticipate frequent changes or additions
You want to follow SOLID principles
You want runtime flexibility
Advantages
A few advantages of using the Bridge Pattern are:

Decouples abstraction and implementation: Changes in one side (abstraction or implementation) do not affect the other.
Avoids class explosion: You don't need to create a separate class for every combination of abstraction and implementation.
Supports the Open/Closed Principle (OCP): You can extend functionalities without modifying existing code.
Ideal for cross-platform development: Useful when developing for multiple platforms that share similar features.
Improves maintainability and testing: Easier to manage and test each part independently.
Disadvantages
A few disadvantages of using the Bridge Pattern are:

Increased complexity: Might be overkill if your application is simple or has limited variations.
Can be confused with other patterns: Especially with patterns like Strategy or Adapter, due to structural similarities.
Coordination needed between teams: If abstraction and implementation are developed separately, good communication is essential.

 * 
 * 
 */



// Using Bridge Pattern to Decouple Abstraction and Implementation
interface VideoQuality{
    void play(String title);
}
class SDQuality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in SD quality.");
    }
}
class HDQuality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in HD quality.");
    }
}
class UltraHDQuality implements VideoQuality{
    @Override
    public void play(String title){
        System.out.println("Playing " + title + " in Ultra HD quality.");
    }
}
// if in future 8k will come then we can implement here   
/*
Abstraction → The “concept” of a video player (like Web, Mobile, Smart TV).
Implementation → The video quality logic (SD, HD, Ultra HD).

But the Bridge Pattern links them using composition, so you can mix and match:
A Web Player can use HDQuality or SDQuality.
A Smart TV can use UltraHDQuality or even 8KQuality in the future.
*/  
abstract class VideoPlayer{
    protected VideoQuality videoQuality;
    public VideoPlayer(VideoQuality vq){
        this.videoQuality = vq;
    }
    public abstract void playVideo(String title);
}

class WebHDPlayer extends VideoPlayer{
    public WebHDPlayer(VideoQuality vq){
        super(vq);
    }
    @Override
    public void playVideo(String title){
        System.out.print("Web Player: ");
        videoQuality.play(title);
    }
}
class MobileHDPlayer extends VideoPlayer{
    public MobileHDPlayer(VideoQuality vq){
        super(vq);
    }
    @Override
    public void playVideo(String title){
        System.out.print("Mobile Player: ");
        videoQuality.play(title);
    }
}
class SmartTVUltraHDPlayer extends VideoPlayer{
    public SmartTVUltraHDPlayer(VideoQuality vq){
        super(vq);
    }
    @Override
    public void playVideo(String title){
        System.out.print("Smart TV Player: ");
        videoQuality.play(title);
    }
}
public class BridgePattern {
    public static void main(String[] args) {
        VideoPlayer videoPlayer1 = new WebHDPlayer(new HDQuality());
        videoPlayer1.playVideo("Nature Documentary");

        VideoPlayer videoPlayer2 = new MobileHDPlayer(new SDQuality());
        videoPlayer2.playVideo("Action Movie");

        VideoPlayer videoPlayer3 = new SmartTVUltraHDPlayer(new UltraHDQuality());
        videoPlayer3.playVideo("Sci-Fi Series");
    }
}
