class BurgerMeal{
    // required parameter
    private String bunType;
    private String pattyType;
    // optional parameter
    private final String side;
    private final boolean drink;
    private final String drinkType;

    private BurgerMeal(BurgerBuilder builder){
        this.bunType = builder.bunType;
        this.pattyType = builder.pattyType;
        this.side = builder.side;
        this.drink = builder.drink;
        this.drinkType = builder.drinkType;
    }
    public static class BurgerBuilder{
        // required parameter
        private final String bunType;
        private final String pattyType;
        // optional parameter
        private String side;
        private boolean drink;
        private String drinkType;
        public BurgerBuilder(String bunType, String pattyType){
            this.bunType = bunType;
            this.pattyType = pattyType;
        }
        public BurgerBuilder setSide(String side){
            this.side = side;
            return this;
        }
        public BurgerBuilder setDrink(boolean drink){
            this.drink = drink;
            return this;
        }
        public BurgerBuilder setDrinkType(String drinkT){
            this.drinkType = drinkT;
            return this;
        }
        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
        @Override
        public String toString(){
            return "Burger with " + bunType + " bun and " + pattyType + " patty" +
                    (side != null ? ", Side: " + side : "") +
                    (drink ? ", Drink: " + drinkType : "");
        }
    }
}
public class P1 {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Compiler c1 = Compiler.getInstance();
        Compiler c2 = Compiler.getInstance();
        System.out.println(c1.hashCode());
        System.out.println(c2.hashCode());
    }
}
