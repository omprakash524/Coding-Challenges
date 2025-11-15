class UserUpdateDB {
    private String userName;
    private String product;
    private double id;
    UserUpdateDB(String userName, String product, double id){
        this.userName = userName;
        this.product = product;
        this.id = id;
    }
    void displayDetails(){
        System.out.println("User Name: " + userName);
        System.out.println("Product: " + product);
        System.out.println("ID: " + id);
    }
}
public class PrepUb {
    public static void main(String[] args) {
        UserUpdateDB user = new UserUpdateDB("John", "Laptop", 1);
        user.displayDetails();
    }
}
