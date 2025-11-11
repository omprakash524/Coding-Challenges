// Proxy Pattern
/*
 * Proxy Pattern involves using a surrogate or placeholder object to control access to another object.
 * This pattern is useful for various purposes such as lazy initialization, access control, logging, and caching.
 * Components of Proxy Pattern
 * Subject Interface: The common interface implemented by both the Real Subject and the Proxy.
 * Real Subject: The actual object that the proxy represents.
 * Proxy: The class that controls access to the Real Subject and implements the Subject Interface.
 * 
 * 
 * 
 * Introduction
Structural design patterns are concerned with the composition of classes and objects. They help manage relationships between objects to make systems more efficient, secure, and scalable. One such pattern is the Proxy Pattern, which acts as a placeholder or surrogate for another object to control access to it. Let’s explore this pattern in detail.

Proxy Pattern
The Proxy Pattern is a structural design pattern that provides a surrogate or placeholder for another object to control access to it.

A proxy acts as an intermediary that implements the same interface as the original object, allowing it to intercept and manage requests to the real object.
Real-Life Analogy
Think of a personal assistant:
A busy CEO may not respond to everyone directly.
Instead, their assistant takes calls, filters emails, manages the calendar, and only involves the CEO when necessary.
The assistant controls access to the CEO while still providing essential services to others.

Here, the assistant is the proxy that controls and optimizes access to the real resource (the CEO).
Problem It Solves
It solves the problem of uncontrolled or expensive access to an object. For example, consider a scenario where:
You have a heavy object like a video player that consumes a lot of resources on initialization.
You want to delay its creation until it's actually needed (lazy loading).
Or maybe the object resides on a remote server and you want to add a layer to manage the network communication.

The Proxy Pattern allows you to control access, defer initialization, add logging, caching, or security without modifying the original object.
Real-Life Coding Example
Imagine you're building a feature like a video streaming app (think YouTube or Netflix) where users can download videos. Now, consider this: multiple users might try to download the same video multiple times — or even the same user may repeat the request. In such scenarios, if we go ahead and download the video from the internet every single time, it leads to unnecessary network calls, longer wait times, and wasted bandwidth.

Let’s consider a scenario where we want to download a video multiple times, perhaps from different places in the code or by different users. A poor design would look like this:


When to Use Proxy Pattern?
The proxy pattern can be used when:

When object creation is expensive, and you want to delay or control its instantiation.
When you need to control access to sensitive operations or enforce permission checks.
When interacting with remote objects that are costly or slow to fetch.
When lazy loading is needed to optimize system performance and resource usage.
Types of Proxy
At a high level, proxies can be categorized into several types based on the specific purpose they serve:

Virtual Proxy
Purpose: Controls access to a resource that is expensive to create.
Use Case: Commonly used for lazy initialization — where the real object is created only when absolutely necessary.
Example: A video downloader app that only fetches and loads the video data when the user hits “Play”.
Protection Proxy
Purpose: Controls access to an object based on user permissions or roles.
Use Case: Useful in systems with multi-level access control, such as admin vs. regular users.
Example: In a document editor, only editors can modify content while viewers can only read.
Remote Proxy
Purpose: Controls access to an object located on a remote server or in a different address space.
Use Case: Enables local code to access remote services as if they were local.
Example: A Java RMI object or API wrapper that abstracts out network communication.
Smart Proxy
Purpose: Adds additional behavior when accessing the real object.
Use Case: Often used for logging, access counting, or reference counting.
Example: Automatically logging every time a file is accessed or updated.
Advantages
A few advantages of using the Proxy Pattern are:

Performance Optimization: By introducing features like caching or lazy initialization, proxies can significantly reduce resource consumption and improve application performance.
Access Control: Proxies act as a gatekeeper, controlling access to sensitive or expensive resources, and ensuring that only authorized users can access them.
Lazy Initialization: Proxies delay the creation of costly resources until they are actually needed, optimizing resource usage and startup times.
Added Functionality: Without modifying the original object, proxies can add additional behavior such as logging, security checks, or usage tracking.
Disadvantages
A few disadvantages of using the Proxy Pattern are:

Increased Complexity: Introducing a proxy layer adds more components to the system, which can make the overall design harder to understand and maintain.
Potential Delays: The proxy may introduce delays in accessing the actual object, especially when additional logic like permission checks or data fetching is involved.
Maintenance Overhead: With extra layers and duplicated interfaces, maintaining proxies alongside real objects can increase the development and debugging effort.




 */

// // without proxy pattern
// class RealVideoDownloader{
//     public String downloadVideo(String videoUrl){
//         // caching
//         // filtering
//         // access
//         System.out.println("downloading video from url: "+ videoUrl);
//         return "Video content from: "+videoUrl;
//     }
// }

// with proxy pattern

import java.util.HashMap;
import java.util.Map;

interface VideoDownloader{
    String downloadVideo(String videoUrl);
}

class RealVideoDownloader implements VideoDownloader{
    @Override
    public String downloadVideo(String videoUrl){
        System.out.println("downloading video from url: "+ videoUrl);
        return "Video content from: "+videoUrl;
    }
}

// proxy layer
class CachedVideoDownloader implements VideoDownloader{
    private RealVideoDownloader realVideoDownloader;
    private Map<String, String> cache;

    public CachedVideoDownloader(){
        this.realVideoDownloader = new RealVideoDownloader();
        this.cache = new HashMap<>();
    }

    @Override
    public String downloadVideo(String videoUrl){
        if(cache.containsKey(videoUrl)){
            System.out.println("Fetching video from cache for url: " + videoUrl);
            return cache.get(videoUrl);
        }
        System.out.println("Downloading video from url: " + videoUrl);
        String videoContent = realVideoDownloader.downloadVideo(videoUrl);
        cache.put(videoUrl, videoContent);
        return videoContent;
    }
}
public class ProxyPattern {
    public static void main(String[] args) {
        // RealVideoDownloader r1 = new RealVideoDownloader();
        // r1.downloadVideo("http://example.com/video");
        // RealVideoDownloader r2 = new RealVideoDownloader();
        // r2.downloadVideo("http://example.com/video");

        VideoDownloader cachedVideoDownloader = new CachedVideoDownloader();
        cachedVideoDownloader.downloadVideo("http://example.com/video");

        VideoDownloader cacheVideoDownloader2 = new CachedVideoDownloader();
        cacheVideoDownloader2.downloadVideo("http://example.com/video");
    }
}
