import java.util.*;

/*
 * Prototype Pattern
 * The Prototype Pattern is a creational design pattern used to clone existing objects instead of constructing them from scratch. It enables efficient object creation, especially when the initialization process is complex or costly.
 * 
 * Deep Cloning VS Shallow Cloning
 * Shallow Cloning:
 * Creates a new object but copies references of nested objects.
 * Changes to nested objects in the clone affect the original.
 * Suitable for objects without nested mutable objects.
 * 
 * Deep Cloning:
 * Creates a new object and recursively copies all nested objects.
 * Changes to nested objects in the clone do not affect the original.
 * Suitable for objects with nested mutable objects.
 * 
 * 
 * Formal Definition:
 * "Prototype pattern creates duplicate objects while keeping performance in mind. It provides a mechanism to copy the original object to a new one without making the code dependent on their classes."
 * In simpler terms:
 * Imagine you already have a perfectly set-up object — like a well-written email template or a configured game character. Instead of building a new one every time (which can be repetitive and expensive), you just copy the existing one and make small adjustments. This is what the Prototype Pattern does. It allows you to create new objects by copying existing ones, saving time and resources.
 *
 * Real-life Analogy (Photocopy Machine)
 * Think of preparing ten offer letters. Instead of typing the same letter ten times, you write it once, photocopy it, and change just the name on each copy. This is how the Prototype Pattern works: start with a base object and produce modified copies with minimal changes.
 *
 * Understanding
 * Let's understand better through a common challenge in software systems.
 *
 * Consider an email notification system where each email instance requires extensive setup—loading templates, configurations, user settings, and formatting. Creating every email from scratch introduces redundancy and inefficiency.
 *
 * Now imagine having a pre-configured prototype email, and simply cloning it for each user while modifying a few fields (like the name or content). That would save time, reduce errors, and simplify the logic.
 *
 * Suitable Use Cases
 * Apply the Prototype Pattern in these situations:
 * Object creation is resource-intensive or complex.
 * You require many similar objects with slight variations.
 * You want to avoid writing repetitive initialization logic.
 * You need runtime object creation without tight class coupling.
 * 
 * 
 * 🤔 3. Why Would You Need Prototype Pattern Here?
 * Let’s imagine a real-world scenario:
 * Suppose:
 * You have a base email template with subject, header, footer, branding, etc.
 * You want to send slightly customized versions to different users.
 * Creating each email from scratch is redundant and error-prone.
 ** Prototype Pattern helps by:
 * Creating a base object once.
 * Cloning it for each user.
 * Modifying only the content or recipient.
 * This is useful when:
 *
 * You have many similar objects.
 * You want to avoid repeating setup logic.
 * You want to ensure consistency across clones.
 * 
 * This pattern is particularly useful in scenarios where object creation is costly or complex, and you want to create multiple similar objects efficiently.
 * ✅ 4. Where Prototype Would Be Better
 * Instead of:
 * WelcomeEmail email1 = new WelcomeEmail();
 * WelcomeEmail email2 = new WelcomeEmail();
 *
 * You can do:
 * WelcomeEmail baseEmail = new WelcomeEmail();
 * WelcomeEmail email1 = baseEmail.clone();
 * WelcomeEmail email2 = baseEmail.clone();
 *
 * This way, you avoid redundant setup and ensure consistency.
 *
 * Prototype Pattern is a powerful tool in scenarios like this.

 */

/*
// Bad Code: Incomplete Use of Design Principles
// it is violating the prototype pattern because we are not cloning the object, we are creating a new object every time.
// To implement prototype pattern we need to implement clone method in the class and use it to create new objects.
interface EmailTemplate{
    void setContent(String content);
    void send(String to);
}

class WelcomeEmail implements EmailTemplate{
    private String subject;
    private String content;
    public WelcomeEmail(){
        this.subject = "Welcome to TUF++";
        this.content = "Welcome to our service!";
    }
    @Override
    public void setContent(String content){
        this.content = content;
    }
    @Override
    public void send(String to){
        System.out.println("Sending Welcome Email to " + to + " with content: " + content);
    }
}


// Issues in the Bad design
// Tight Coupling to Concrete Class:
// The code uses the WelcomeEmail class directly.
// No abstraction for cloning—client code is tightly bound to object creation logic (new WelcomeEmail() everywhere).
// Repetitive Instantiation:
// For every variation, a new instance is created using the constructor—even though most data remains the same.
// This leads to unnecessary duplication of code and logic.
// Violates DRY Principle: Repeated calls to new WelcomeEmail() and then setContent() for slight modifications break the Don't Repeat Yourself principle.
// No Cloning or Copy Mechanism: There is no concept of cloning or reusing a pre-defined template and just modifying small parts.
*/

interface EmailTemplate extends Cloneable{
    EmailTemplate clone(); // Deep copy for complex objects recommended
    void setHeader(String header);
    void setSubject(String subject);
    void setContent(String content);
    void setFooter(String footer);
    void send(String to);
    String getContent();
}
class WelcomeEmail implements EmailTemplate{
    private String header;
    private String subject;
    private String content;
    private String footer;

    // Default constructor
    public WelcomeEmail(){
        this.header = "Welcome to TUF++";
        this.subject = "Welcome!";
        this.content = "Welcome to our service!";
        this.footer = "Best Regards, TUF++ Team";
    }


    // Shallow clone method (not recommended for complex objects)
    // @Override
    // public WelcomeEmail clone(){
    //     try {
    //         return (WelcomeEmail) super.clone(); // Shallow copy
    //     } catch (CloneNotSupportedException e) {
    //         throw new RuntimeException("Clone failed", e); // Can't happen
    //     }
    // }

    // Copy constructor for deep cloning
    private WelcomeEmail(WelcomeEmail email){
        this.header = email.header;
        this.subject = email.subject;
        this.content = email.content;
        this.footer = email.footer;
    }

    @Override
    public EmailTemplate clone(){
        return new WelcomeEmail(this); // Deep copy
    }

    @Override
    public void setHeader(String header){
        this.header = header;
    }

    @Override
    public void setSubject(String subject){
        this.subject = subject;
    }

    @Override
    public void setContent(String content){
        this.content = content;
    }

    @Override
    public String getContent(){
        return content;
    }

    @Override
    public void setFooter(String footer){
        this.footer = footer;
    }

    @Override
    public void send(String to){
        System.out.println("Sending Email to " + to);
        System.out.println("Header: " + header);
        System.out.println("Subject: " + subject);
        System.out.println("Content: " + content);
        System.out.println("Footer: " + footer);
    }
}

/*
 * 🔍 What is EmailTemplateRegistry?
 * EmailTemplateRegistry is a centralized registry or cache that stores prototype objects (like WelcomeEmail) and provides clones of them when needed.
 * 
 * ✅ Purpose:
 * Avoid repeated new object creation.
 * Avoid tight coupling to specific classes (WelcomeEmail, DiscountEmail, etc.).
 * Provide a flexible, scalable, and extensible way to manage email templates.
 * 
 * templates.put("welcome", new WelcomeEmail());
 * This creates the prototype once, and then clones it whenever needed.
 * 
 * 🧩 2. Decoupling
 * Client code doesn’t need to know the concrete class (WelcomeEmail). It just asks for a "welcome" template.
 * This reduces dependencies and makes the system more modular.
 * EmailTemplate email = EmailTemplateRegistry.getTemplate("welcome");
    * This returns a clone of the WelcomeEmail prototype without the client needing to know about WelcomeEmail directly.
    * This makes your system open for extension (OCP from SOLID) — you can add new templates without changing client code.
 * 🧱 3. Scalability
 * You can easily add more templates:  "discount", "forgotPassword", etc.
 * templates.put("discount", new DiscountEmail());
 * templates.put("forgotPassword", new ForgotPasswordEmail());
 * And use them like:
 * EmailTemplate discountEmail = EmailTemplateRegistry.getTemplate("discount");
 * 
 * The registry can grow without changing existing code.
 * 
 * 🛠️ 4. Flexibility
 * You can easily modify existing templates without affecting others.
 * For example, if you need to change the footer of the WelcomeEmail, you can do it in one place.

 */

class EmailTemplateRegistry{
    private static final Map<String, EmailTemplate> templates = new HashMap<>();
    static {
        templates.put("welcome", new WelcomeEmail()); // for the first time we will be creating the object, for first time it will cost, initializing the WelcomeEmail prototype
        // Add other templates as needed like "discount", "forgotPassword", etc.
    }
    public static EmailTemplate getTemplate(String type){
        EmailTemplate template = templates.get(type);
        if(template == null){
            throw new IllegalArgumentException("Unknown template type");
        }
        return template.clone(); // Return a clone of the prototype, clone avoids modifying the original
    }
}


public class PrototypePattern {
    public static void main(String[] args) {
        System.out.println("Prototype Pattern in Java");
        /*
        WelcomeEmail welcomeEmailTuf = new WelcomeEmail();
        welcomeEmailTuf.setContent("Hello User, Welcome to TUF! This is the original email.");
        welcomeEmailTuf.send("user1@example.com");

        WelcomeEmail welcomeEmailTufPlus = new WelcomeEmail();
        welcomeEmailTufPlus.setContent("Hello User, Welcome to TUF++! This is a cloned email.");
        welcomeEmailTufPlus.send("user2@example.com");
        */

        // Using Prototype Pattern
        EmailTemplate welcomeEmail1 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail1.setContent("Hello User, Welcome to TUF! This is the original email.");
        welcomeEmail1.send("user1@example.com");
        System.out.println("Original Email Content: " + welcomeEmail1.getContent());
        System.out.println("---");
        EmailTemplate welcomeEmail2 = EmailTemplateRegistry.getTemplate("welcome");
        welcomeEmail2.setContent("Hello User, Welcome to TUF++! This is a cloned email.");
        welcomeEmail2.send("user2@example.com");
        System.out.println("Cloned Email Content: " + welcomeEmail2.getContent());


        /*
         * 🧠 Why Not Just Use WelcomeEmail welcome = new WelcomeEmail(); welcome.clone();?
         * Yes, technically you can do this:
         * EmailTemplate welcomeEmail = new WelcomeEmail();
         * EmailTemplate welcomeEmailClone = welcomeEmail.clone();
         * However, this approach has drawbacks:
         * ❌ 1. Tight Coupling
         * You're directly tied to WelcomeEmail. If tomorrow you want to use DiscountEmail, you’ll have to change your code manually.
         * ❌ 2. No Central Management
         * There’s no centralized place to manage all available templates. You’ll have to instantiate each one manually.
         * ❌ 3. No Reuse of Initialized Prototypes
         * Each time you do new WelcomeEmail(), you're reinitializing the object. If initialization is expensive (e.g., loading branding, assets, etc.), it’s inefficient.
         * 
         */
    }
}
