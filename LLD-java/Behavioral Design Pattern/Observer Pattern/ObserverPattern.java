// Observer Design Pattern
/*
Introduction
Behavioral design patterns focus on how objects interact and communicate with each other,
helping to define the flow of control in a system. These patterns simplify complex
communication logic between objects while promoting loose coupling.

Imagine a notification system where multiple users get alerts when a new blog post is
published. The publisher shouldn't have to worry about who all are subscribed or how they
get notified. This kind of automatic, event-driven update mechanism is exactly what
behavioral patterns help us achieve.

One such pattern is the Observer Pattern. Let’s explore the Observer Pattern in depth in the
upcoming sections.

Observer Pattern
The Observer Pattern is a behavioral design pattern that defines a one-to-many dependency
between objects so that when one object (the subject) changes its state, all its dependents
(called observers) are notified and updated automatically.

Formal Definition
The Observer Pattern is a behavioral design pattern where an object, known as the subject,
maintains a list of dependents (observers) and notifies them of any state changes, usually by
calling one of their methods.

This means if multiple objects are watching another object for updates, they don’t need to
keep checking repeatedly. Instead, they get notified as soon as something changes — making
the system more efficient and loosely coupled.

Real-Life Analogy
Think of subscribing to a YouTube channel. Once you hit the Subscribe button and turn on
notifications, you don’t have to keep visiting the channel to check for new videos. As soon as
a new video is uploaded, you get notified instantly.

In this case:
The channel is the subject.
The subscribers are the observers.
The notification is the automatic update mechanism triggered by the subject.

Similarly, in software, when an object (subject) undergoes a change, all registered observers
get notified, just like YouTube alerts its subscribers.



How This Solves the Problem:

Problem in Old Approach	                          How Observer Pattern Solves It
-----------------------------------------------------------------------------------------------
Channel is tightly coupled with notification logic    Each subscriber handles its own
                                                      notification via update()
Not extensible for new notification types             Add new subscriber classes without
                                                      modifying existing code
No reusability of logic                               Notification logic is encapsulated in
                                                      reusable subscriber classes
SRP Violation (upload + notify in one class)          Upload logic stays in YouTubeChannel;
                                                      notification logic is external
Difficult to manage large number of subscribers       subscribe() and unsubscribe() methods
                                                      handle this cleanly



Use Cases and Limitations

Recommended Scenarios for Applying the Observer Pattern

State Change Propagation:
When a change in one object must be immediately reflected across multiple dependent objects,
the Observer Pattern provides a clean way to propagate this change without direct coupling.

Decoupling Between Core Components:
In systems where the subject (publisher) should remain agnostic of how many observers exist or
what actions they perform, the Observer Pattern promotes separation of concerns. This makes
the system easier to extend and maintain.

Dynamic Subscriptions at Runtime:
Situations that involve modules being added or removed dynamically (e.g., plugins, UI listeners,
notification modules) benefit from the Observer Pattern, as it allows flexible attachment and
detachment of observers without affecting the subject.


Situations Where the Observer Pattern May Fall Short

Excessive Observer Load:
In high-scale systems with millions of observers (e.g., when a celebrity with 10M followers goes
live), a direct notification loop becomes inefficient. Such cases are better handled using event
queues, pub-sub architectures, or broadcast systems optimized for massive concurrency.

Strict Control Over Notification Timing:
In environments where the timing of notifications must be tightly managed—such as financial
systems or real-time analytics, deterministic control is critical. The Observer Pattern lacks
fine-grained scheduling control. Systems like message brokers (e.g., Kafka, RabbitMQ) are more
suitable in such scenarios, providing features like buffering, retries, and ordering.

In short, Observer Pattern works really well with a small number of observers, but to scale, it
becomes essential to move toward an event-driven architecture.



Pros and Cons

Pros
- Promotes Loose Coupling:
  Observers and subjects are decoupled. They interact only through a common interface,
  which improves flexibility and modularity.

- Open for Extension:
  New types of observers can be added without modifying the subject class, adhering to the
  Open/Closed Principle.

- Supports Dynamic Subscription:
  Observers can be attached or detached at runtime, enabling highly configurable and
  adaptable systems.

- Encourages Reusability:
  Different observer implementations can be reused across subjects or contexts without
  duplication of logic.


Cons
- Unpredictable Update Sequences:
  If the order of observer notifications matters, it may be hard to manage as the pattern does
  not guarantee update order.

- Performance Bottlenecks at Scale:
  Notifying a large number of observers synchronously can degrade performance in high-scale
  systems.

- Risk of Memory Leaks:
  Failure to unsubscribe unused observers may result in lingering references and memory issues.

- Difficult Debugging:
  Since interactions happen indirectly through interfaces, tracing the source of bugs or
  unwanted updates can be challenging.

- Tight Timing Coupling:
  All observers are notified immediately. Delayed or controlled delivery of events is not
  supported natively.

Real-World Examples
UI Event Handling:
In GUI frameworks, buttons, sliders, and input fields use observers (listeners) to respond to user actions like clicks or typing.
News or Blog Subscriptions:
Readers subscribe to news feeds or blog updates. When new content is published, all subscribers are notified instantly.
Stock Market Tickers:
Trading platforms subscribe to stock price changes. Whenever prices update, relevant modules (charts, alerts, watchlists) are notified in real-time.
File System Watchers:
IDEs or OS-level watchers use observers to track file changes. Once a file is modified, all registered tools or services (like compilers or sync tools) are triggered.
Social Media Notifications:
Platforms like YouTube or Instagram notify followers when someone they follow posts new content.


✅ 2. Interview Answer Format (Short, Crisp, Impressive)
⭐ What is the Observer Pattern?

It is a behavioral design pattern used to create a one-to-many dependency between objects so when the subject changes state, all observers get notified automatically.

⭐ When do you use it?

When multiple modules depend on one source of truth

When dynamic event-driven communication is required

When loose coupling is essential

⭐ Real-life example?

YouTube: When a channel uploads a video, all subscribers receive notifications.

⭐ Advantages

Loose coupling between subject and observers

Highly extensible (new observers can be added easily)

Supports dynamic subscription

Great for event-driven systems

⭐ Drawbacks

Notification order cannot be controlled

Not suitable for millions of observers

Can cause memory leaks if observers aren’t removed

Harder to debug due to indirect interaction

⭐ FAANG-Level Question

Q: How is Observer Pattern different from Pub-Sub?
A:

Observer: observers know the subject, tightly linked

Pub-Sub: uses event brokers (Kafka, RabbitMQ), loosely linked

Pub-Sub is more scalable for distributed systems

⭐ Another FAANG Question

Q: How would you handle millions of observers?
A:

Use event brokers, queues, or streaming systems

Avoid direct observer notification loops




================================================================
✅ 3. Hinglish Explanation (Simple + Relatable)

Observer Pattern ka simple matlab hai —
jab ek object me change ho, toh baaki saare connected objects ko automatic update mil jaaye.

Bilkul YouTube jaisa:

Channel = Subject

Subscribers = Observers

New video upload = Notification to everyone

Old method me channel khud notifications bhejta tha —
isliye code tightly coupled ho gaya tha.

Observer Pattern use karte hi:

Channel sirf "notify" bulaata hai

EmailSubscriber, AppSubscriber apna-apna kaam karte hain

Naya type of subscriber add karna easy ho jaata hai

Code clean, maintainable aur extendable ho jaata hai

Real life me use hota hai:

Button click listeners

Stock price update

Instagram notifications

File watchers (VS Code ka auto-refresh)



==========================================================================
Here are strong, interview-ready Q&A specifically for the Observer Design Pattern.
Short, crisp, impressive — perfect to add in your notes, PPT, or spoken answer.
________________________________________
✅ Top Interview Questions & Answers — Observer Pattern
1️⃣ What is the Observer Pattern?
Answer:
It is a behavioral pattern that creates a one-to-many dependency between objects. When the subject changes state, all registered observers get notified automatically.
________________________________________
2️⃣ Why do we use the Observer Pattern?
Answer:
To achieve loose coupling between objects and build event-driven systems where updates must propagate automatically without manual calls.
________________________________________
3️⃣ What problem does the Observer Pattern solve?
Answer:
•	Removes tight coupling between publisher and subscribers
•	Allows dynamic subscription
•	Avoids mixing update logic in the subject
•	Makes the system extensible and maintainable
________________________________________
4️⃣ Give a real-world example of the Observer Pattern.
Answer:
YouTube notifications. A channel uploads a video (subject), and all subscribers (observers) receive alerts instantly.
________________________________________
5️⃣ What are the main components of the Observer Pattern?
Answer:
•	Subject – maintains observers, notifies them
•	Observer interface – defines update method
•	Concrete Observers – respond to notifications
•	Concrete Subject – stores data & triggers updates
________________________________________
6️⃣ How is Observer different from Pub-Sub?
Answer:
•	Observer: Observers know the subject; direct communication; works inside a single application.
•	Pub-Sub: Publisher and subscriber never know each other; uses message brokers; suitable for distributed, scalable systems.
________________________________________
7️⃣ What are the advantages of the Observer Pattern?
Answer:
1.	Loose coupling
2.	Easy to add new observers
3.	Supports dynamic subscription
4.	Promotes reusability
5.	Clean separation of concerns
________________________________________
8️⃣ What are the disadvantages?
Answer:
•	Notification order not guaranteed
•	Hard to debug indirect interactions
•	Risk of memory leaks if observers aren’t removed
•	Not suitable for millions of observers
________________________________________
9️⃣ When should you NOT use the Observer Pattern?
Answer:
•	When system scale is huge (millions of listeners)
•	When you need guaranteed message ordering
•	When notification timing must be controlled
Better alternative: Event Queue, Kafka, RabbitMQ, etc.
________________________________________
🔟 How does Observer Pattern support the Open/Closed Principle?
Answer:
You can add new observer classes without modifying the subject, meaning the system is open for extension but closed for modification.
________________________________________
1️⃣1️⃣ What happens if one observer fails during notification?
Answer:
In basic implementations, it may break the entire notify cycle.
Solution: wrap notifications with try–catch or use async event dispatchers.
________________________________________
1️⃣2️⃣ Why is Observer considered a behavioral pattern?
Answer:
Because it defines how objects behave and communicate based on state changes.
________________________________________
1️⃣3️⃣ Explain a scenario where Observer Pattern is used in Java libraries.
Answer:
•	Swing/AWT event listeners
•	PropertyChangeListener
•	Java Util Observable (Deprecated in newer versions)
________________________________________
1️⃣4️⃣ Can Observer Pattern cause memory leaks? How?
Answer:
Yes. If observers are not unsubscribed properly, the subject will keep holding them in memory, preventing garbage collection.
________________________________________
1️⃣5️⃣ How can you improve performance of Observer Pattern?
Answer:
•	Use asynchronous notification
•	Use concurrent data structures
•	Use event batching
•	Switch to message queues for large-scale systems
________________________________________



 * 
 */



/*
// Example of YouTube channel notifying subscribers about new video upload
// without observer design pattern

Understanding the Problem
Let’s say we’re building a simple YouTube-like Notification System. Whenever a creator uploads a new video, all their subscribers should get notified.

Below is a naive implementation of this logic:


What’s Wrong with This Approach?
While the code works, there are several design-level concerns:
Tightly Coupled Code:
The YouTubeChannel class is directly responsible for how users are notified. If tomorrow we want to send an SMS or push notification, we’ll have to edit this class.
No Reusability:
The notification logic (email, app, etc.) is hardcoded. You can't reuse or extend this behavior in other places without copying code.
Scalability Issues:
Imagine having hundreds of users and multiple notification types. You’d end up cluttering this class with all the notification logic.
Violation of Single Responsibility Principle (SRP): The class is doing two things: handling video uploads and managing user notifications. Ideally, each class should have one responsibility.



class YouTubeChannel{
    public void uploadNewVideo(String videoTitle){
        System.out.println("Uploading: "+ videoTitle);

        // notify all subscribers manually
        System.out.println("Notifying all subscribers about new video: "+ videoTitle);
        System.out.println("Email sent to subscriber1");
        System.out.println("Email sent to subscriber2");
        }
        }
        
        
Let us now understand how we can solve this problem using the Observer Pattern.
        
*/

// using observer design pattern
// Observer Interface

import java.util.ArrayList;
import java.util.List;

interface Subscriber {
    void update(String videoTitle);
}

/// concrete observer
class EmailSubscriber implements Subscriber {
    private String email;

    public EmailSubscriber(String email) {
        this.email = email;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Email sent to " + email + " about new video: " + videoTitle);
    }
}

class MobileAppSubscriber implements Subscriber {
    private String username;

    public MobileAppSubscriber(String username) {
        this.username = username;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println("Push notification sent to " + username + " about new video: " + videoTitle);
    }
}

// subject Interface
interface YouTubeChannelSubject {
    void subscribe(Subscriber subscriber);
    void unsubscribe(Subscriber subscriber);
    void notifySubscribers(String videoTitle);
}

// Concrete Subject
class YouTubeChannel implements YouTubeChannelSubject {
    private List<Subscriber> subscribers = new ArrayList<>();;
    private String channelName;

    public YouTubeChannel(String channelName) {
        this.channelName = channelName;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public void notifySubscribers(String videoTitle) {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

    public void uploadNewVideo(String videoTitle) {
        System.out.println("Uploading: " + videoTitle + " to channel: " + channelName);
        notifySubscribers(videoTitle);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        System.out.println("Observer Pattern Example");
        YouTubeChannel omChannelSubject = new YouTubeChannel("OM Programming");
        omChannelSubject.subscribe(new EmailSubscriber("subscriber1@example.com"));
        omChannelSubject.subscribe(new MobileAppSubscriber("subscriber2"));
        omChannelSubject.subscribe(new EmailSubscriber("subscriber3@example.com"));

        omChannelSubject.uploadNewVideo("Observer Design Pattern in Java");

    }
}
