interface CartItem{
    double getPrice();
    void displayItem(String indent);
}
class Product implements CartItem{
    private String name;
    private double price;

    public Product(String n, double p){
        this.name = n;
        this.price = p;
    }
    @Override
    public double getPrice(){
        return price;
    }
    @Override
    public void displayItem(String indent){
        System.out.println(indent + "Product: " + name + ", Price: " + price);
    }
}
class Product1{
    private Stirng name;
    private double price;

    public Product1(String n, double p){
        this.name = n;
        this.price = p;
    }
}
public class P {
    
}
