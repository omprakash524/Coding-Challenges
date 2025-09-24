// LLD - Low Level Design
// Demonstrating YAGNI Principle
// YAGNI: You Aren't Gonna Need It
// Don’t implement something until it’s actually needed. Avoid speculative features.
// The YAGNI principle advises developers to avoid adding functionality until it is necessary.
// This helps prevent over-engineering and keeps the codebase simpler and more maintainable.
// By focusing on the current requirements and avoiding speculative features, you can reduce complexity and improve development efficiency.
// It encourages developers to implement only what is needed at the moment, rather than anticipating future needs.
// This leads to cleaner, more focused code that is easier to understand and maintain over time.
/*
 * ❌ Violation Example
 * Let's say we are building a simple user management system and we decide to add a feature for user roles,
 * even though the current requirements only involve basic user creation and authentication.
 * This additional complexity can lead to unnecessary complications in the codebase.
 * 
 * class User {
    private String username;
    private String password;
    // Unused role feature
    private String role; // ❌ YAGNI violation

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
}
    // ❌ Problem: Unused role feature adds unnecessary complexity
// Violates YAGNI.
 * ✅ Correct YAGNI Design
 * We should only implement features that are currently required.
 * class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Getters and setters
}
    // ✅ YAGNI followed: No unnecessary features added
   public class YAGNI {
    public static void main(String[] args) {
        System.out.println("You Aren't Gonna Need It Principle in Java");
    }
}
 *
/*
 * ✅ Correct YAGNI Design
 * We should only implement features that are currently required.
 */

// ❌ YAGNI Violation
class UserNotFollowingYAGNI {
    private String name;
    private String email;
    private String phoneNumber;
    private String address; // not needed now
    private String socialMediaHandle; // not needed now
}

// ✅ YAGNI Applied
class UserFollowingYAGNI {
    private String name;
    private String email;
    // Only implement what is needed now
    public UserFollowingYAGNI(String name, String email) {
        this.name = name;
        this.email = email;
    }
}

public class YAGNI {
    public static void main(String[] args) {
        System.out.println("You Aren't Gonna Need It Principle in Java");
        // Example usage of User class
        UserFollowingYAGNI user = new UserFollowingYAGNI("John Doe", "john@example.com");
        System.out.println("User created: " + user);

    }
}
