class SingletonPattern {
    private static SingletonPattern instance;
    private SingletonPattern() {
        // private constructor to prevent instantiation
    }
    public static SingletonPattern getInstance() {
        if (instance == null) {
            instance = new SingletonPattern();
        }
        return instance;
    }
}
public class SingletonPatternDemo {
    public static void main(String[] args) {
        
    }
}
