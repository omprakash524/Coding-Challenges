import java.util.*;

class BurgerMeal2{
    // mandatory components
    private final String bunType;
    private final String pattyType;
    // optional components
    private final boolean cheese;
    private final boolean lettuce;
    private final String sideItem;
    private final String drink;

    private BurgerMeal2(BurgerBuilder builder){
        this.bunType = builder.bunType;
        this.pattyType = builder.pattyType;
        this.cheese = builder.cheese;
        this.lettuce = builder.lettuce;
        this.sideItem = builder.sideItem;
        this.drink = builder.drink;
    }

    public static class BurgerBuilder{
        // required parameters
        private final String bunType;
        private final String pattyType;
        // optional parameters - initialized to default values
        private boolean cheese;
        private boolean lettuce;
        private String sideItem;
        private String drink;

        public BurgerBuilder(String bunType, String pattyType){
            this.bunType = bunType;
            this.pattyType = pattyType;
        }
        public BurgerBuilder addCheese(boolean value){
            this.cheese = value;
            return this;
        }
        public BurgerBuilder addLettuce(boolean value){
            this.lettuce = value;
            return this;
        }
        public BurgerBuilder addSideItem(String sideItem){
            this.sideItem = sideItem;
            return this;
        }
        public BurgerBuilder addDrink(String drink){
            this.drink = drink;
            return this;
        }
        public BurgerMeal2 build(){
            return new BurgerMeal2(this);
        }
    }
    @Override
    public String toString(){
        return "BurgerMeal [bunType=" + bunType + ", pattyType=" + pattyType + ", cheese=" + cheese + ", lettuce="
                + lettuce + ", sideItem=" + sideItem + ", drink=" + drink + "]";
    }
}

public class BuilderPatternPractice {
    public static void main(String[] args) {
        BurgerMeal2 meal = new BurgerMeal2.BurgerBuilder("Sesame", "Veggie")
                .addCheese(true)
                .addLettuce(true)
                .addSideItem("Fries")
                .addDrink("Coke")
                .build();
        BurgerMeal2 meal2 = new BurgerMeal2.BurgerBuilder("Gluten-Free", "Chicken").addCheese(false).addLettuce(true).addSideItem("Salad").addDrink("Water").build();
        System.out.println("Meals : "+meal);
        System.out.println("Meals : "+meal2);
    }
}