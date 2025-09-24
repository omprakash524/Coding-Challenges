class CartItem{
    // required parameters
    private final String itemId;
    private final int quantity;
    private final double price;

    // optional parameters
    private final String size;
    private final String color;
    private final String deliveryOption;
    private final boolean giftWrap;
    private final String saveForLater;
    private final String discountTag;

    // private constructor to enforce object creation through the builder
    private CartItem(CartItemBuilder builder){
        this.itemId = builder.itemId;
        this.quantity = builder.quantity;
        this.price = builder.price;
        this.size = builder.size;
        this.color = builder.color;
        this.deliveryOption = builder.deliveryOption;
        this.giftWrap = builder.giftWrap;
        this.saveForLater = builder.saveForLater;
        this.discountTag = builder.discountTag;
    }

    // Builder class
    public static class CartItemBuilder{
        // required parameters
        private final String itemId;
        private final int quantity;
        private final double price;

        // optional parameters - initialized to default values
        private String size;
        private String color;
        private String deliveryOption;
        private boolean giftWrap;
        private String saveForLater;
        private String discountTag;

        // Constructor with required parameters
        public CartItemBuilder(String itemId, int quantity, double price){
            this.itemId = itemId;
            this.quantity = quantity;
            this.price = price;
        }
        // Setter methods for optional parameters (returning builder for chaining, fluent style)
        public CartItemBuilder setSize(String size){
            this.size = size;
            return this;
        }
        public CartItemBuilder setColor(String color){
            this.color = color;
            return this;
        }
        public CartItemBuilder setDeliveryOption(String deliveryOption){
            this.deliveryOption = deliveryOption;
            return this;
        }
        public CartItemBuilder setGiftWrap(boolean giftWrap){
            this.giftWrap = giftWrap;
            return this;
        }
        public CartItemBuilder setSaveForLater(String saveForLater){
            this.saveForLater = saveForLater;
            return this;
        }
        public CartItemBuilder setDiscountTag(String discountTag){
            this.discountTag = discountTag;
            return this;
        }
        // build method to create the final object
        public CartItem build(){
            return new CartItem(this);
        }
    }
    @Override
    public String toString(){
        return "CartItem [ itemId = " + itemId + ", quantity = " + quantity + ", price = " + price + ", size = " + size
                + ", color = " + color + ", deliveryOption = " + deliveryOption + ", giftWrap = " + giftWrap
                + ", saveForLater = " + saveForLater + ", discountTag = " + discountTag + " ]";
    }
}
public class AmazonCartItemConfigurationBuilderPattern {
        public static void main(String[] args){
            System.out.println("Amazon Cart using Builder Pattern");
            // Creating CartItem objects using the Builder pattern
            CartItem item1 = new CartItem.CartItemBuilder("item123", 2, 19.99)
                    .setSize("M")
                    .setColor("Red")
                    .setDeliveryOption("Express")
                    .setGiftWrap(true)
                    .build();

            CartItem item2 = new CartItem.CartItemBuilder("item456", 1, 49.99)
                    .setColor("Blue")
                    .setSaveForLater("Yes")
                    .build();

            CartItem item3 = new CartItem.CartItemBuilder("item789", 3, 9.99)
                    .setSize("L")
                    .setDiscountTag("SUMMER21")
                    .build();

            System.out.println(item1);
            System.out.println(item2);
            System.out.println(item3);

            // Example 1: A customized T-shirt
        CartItem tshirt = new CartItem.CartItemBuilder("TSHIRT123", 2, 799.99)
                .setSize("L")
                .setColor("Black")
                .setGiftWrap(true)
                .setDeliveryOption("One-Day Delivery")
                .setDiscountTag("Summer Sale 20% OFF")
                .build();

        // Example 2: A book saved for later
        CartItem book = new CartItem.CartItemBuilder("BOOK456", 1, 399.00).setSaveForLater("Yes").build();

        // Example 3: Laptop with no optional fields
        CartItem laptop = new CartItem.CartItemBuilder("LAPTOP789", 1, 75000.00).build();
        
        System.out.println(tshirt);
        System.out.println(book);
        System.out.println(laptop);
        }
}
