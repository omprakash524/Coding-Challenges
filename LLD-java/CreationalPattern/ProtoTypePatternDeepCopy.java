import java.util.*;

interface EmailTemplate extends Cloneable{
    EmailTemplate clone();
    void setContent(String content);
    void setHeader(String header);
}
class WelcomeEmail implements EmailTemplate{
    private String header;
    private String content;
    public WelcomeEmail(String header, String content){
        this.header = header;
        this.content = content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public EmailTemplate clone(){
        return new WelcomeEmail(this.header, this.content);
    }
    public String toString(){
        return "WelcomeEmail [header=" + header + ", content=" + content + "]";
    }
}
class PasswordResetEmail implements EmailTemplate{
    private String header;
    private String content;
    public PasswordResetEmail(String header, String content){
        this.header = header;
        this.content = content;

    }
    public void setContent(String content){
        this.content = content;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public EmailTemplate clone(){
        return new PasswordResetEmail(this.header, this.content);
    }
    public String toString(){
        return "PasswordResetEmail [header=" + header + ", content=" + content + "]";
    }
}
class ThankYouEmail implements EmailTemplate{
    private String header;
    private String content;
    public ThankYouEmail(String header, String content){
        this.header = header;
        this.content = content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public EmailTemplate clone(){
        return new ThankYouEmail(this.header, this.content);
    }
    public String toString(){
        return "ThankYouEmail [header=" + header + ", content=" + content + "]";
    }
}
class ExpiryEmail implements EmailTemplate{
    private String header;
    private String content;
    public ExpiryEmail(String header, String content){
        this.header = header;
        this.content = content;
    }
    public void setContent(String content){
        this.content = content;
    }
    public void setHeader(String header){
        this.header = header;
    }
    public EmailTemplate clone(){
        return new ExpiryEmail(this.header, this.content);
    }
    public String toString(){
        return "ExpiryEmail [header=" + header + ", content=" + content + "]";
    }
}

class EmailTemplateCache{
    private static final Map<String, EmailTemplate> emailTemplateMap = new HashMap<>();
    static{
        emailTemplateMap.put("welcome", new WelcomeEmail("Welcome to Our Service", "Thank you for joining us!"));
        emailTemplateMap.put("passwordReset", new PasswordResetEmail("Password Reset Request", "Click the link to reset your password."));
        emailTemplateMap.put("thankYou", new ThankYouEmail("Thank You!", "We appreciate your business."));
        emailTemplateMap.put("expiry", new ExpiryEmail("Subscription Expiry Notice", "Your subscription is about to expire."));
    }
    public static EmailTemplate getEmailTemplate(String type){
        EmailTemplate template = emailTemplateMap.get(type);
        return template != null ? template.clone() : null;
    }
}


public class ProtoTypePatternDeepCopy {
    public static void main(String[] args) {
        System.out.println("Prototype Pattern Practice in Java");
        EmailTemplate welcomeEmail = EmailTemplateCache.getEmailTemplate("welcome");
        System.out.println(welcomeEmail);
        EmailTemplate passwordResetEmail = EmailTemplateCache.getEmailTemplate("passwordReset");
        System.out.println(passwordResetEmail);
        EmailTemplate thankYouEmail = EmailTemplateCache.getEmailTemplate("thankYou");
        System.out.println(thankYouEmail);
        EmailTemplate expiryEmail = EmailTemplateCache.getEmailTemplate("expiry");
        System.out.println(expiryEmail);
    }
}
