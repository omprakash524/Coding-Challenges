import java.util.*;

interface Item{
    void accept(ItemVisitor visitor);
}

class PhysicalProduct implements Item{
    String name;
    double weight;
    public PhysicalProduct(String name, double weight){
        this.name = name;
        this.weight = weight;
    }
    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}

class DigitalProduct implements Item{
    String name;
    double filesize;
    public DigitalProduct(String name, double filesize){
        this.name = name;
        this.filesize = filesize;
    }
    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}

class GiftCard implements Item{
    String code;
    double amount;
    public GiftCard(String code, double amount){
        this.code = code;
        this.amount = amount;
    }
    public void accept(ItemVisitor visitor){
        visitor.visit(this);
    }
}
// class WareHouseVisitor implements Item{
//     String location;
//     double capacity;
//     public WareHouseVisitor(){
//         this.location = location;
//         this.capacity = capacity;
//     }
//     public void accept(ItemVisitor visitor){
//         visitor.visit(this);
//     }
// }

// visitor interface
interface ItemVisitor{
    void visit(PhysicalProduct product);
    void visit(DigitalProduct product);
    void visit(GiftCard giftCard);
    void visit(WareHouseVisitor wareHouseVisitor);
}
// concerete visito 1
class InvoiceVisitor implements ItemVisitor{
    public void visit(PhysicalProduct prod){
        System.out.println("Generating invoice for physical product: " + prod.name);
    }
    public void visit(DigitalProduct prod){
        System.out.println("Generating invoice for digital product: " + prod.name);
    }
    public void visit(GiftCard gft){
        System.out.println("Generating invoice for gift card: " + gft.code);
    }
    public void visit(WareHouseVisitor w){
        System.out.println("Generating invoice for warehouse visitor");
    }
}
class ShippingCostVisitor implements ItemVisitor{
    public void visit(PhysicalProduct p){
        System.out.println("Calculating shipping cost for physical product: " + p.name);
    }
    public void visit(DigitalProduct p){
        System.out.println("No shipping cost for digital product: " + p.name);
    }
    public void visit(GiftCard g){
        System.out.println("No shipping cost for gift card: " + g.code);
    }
    public void visit(WareHouseVisitor w) {
        System.out.println("Generating invoice for warehouse visitor");
    }
}
class WareHouseVisitor implements ItemVisitor{
    public void visit(PhysicalProduct p){
        System.out.println("Storing physical product in warehouse: " + p.name);
    }
    public void visit(DigitalProduct p){
        System.out.println("No warehouse needed for digital product: " + p.name);
    }
    public void visit(GiftCard g){
        System.out.println("No warehouse needed for gift card: " + g.code);
    }
    public void visit(WareHouseVisitor w) {
        System.out.println("Generating invoice for warehouse visitor");
    }
}
public class P {
    public static void main(String[] args) {
        List<Item> items = new ArrayList<>();
        items.add(new PhysicalProduct("Mobile", 1.2));
        items.add(new DigitalProduct("Ebook", 0.5));
        items.add(new GiftCard("GFT123", 100));
        
        ItemVisitor invoiceVisitor = new InvoiceVisitor();
        ItemVisitor shippingVisitor = new ShippingCostVisitor();
        ItemVisitor wareHouseVisitor = new WareHouseVisitor();

        for(Item item : items){
            item.accept(invoiceVisitor);
            item.accept(shippingVisitor);
            item.accept(wareHouseVisitor);
            System.out.println("-----");
        }

    }
}
