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
}

public class P {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}
