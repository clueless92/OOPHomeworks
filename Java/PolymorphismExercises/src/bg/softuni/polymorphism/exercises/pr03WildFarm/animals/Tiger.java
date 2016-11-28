package bg.softuni.polymorphism.exercises.pr03WildFarm.animals;


import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Food;
import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Meat;

import java.text.DecimalFormat;

public class Tiger extends Felime {
    private static final String ANIMAL_TYPE = "Tiger";

    private Integer foodEaten;

    public Tiger(String name, Double weight, String livingRegion) {
        super(name, weight, ANIMAL_TYPE, livingRegion);

        this.foodEaten = 0;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Meat) {
            this.setFoodEaten(food.getQuantity());
        } else {
            System.out.println("Tigers are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %d]",
                this.getType(),
                this.getName(),
                df.format(this.getWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
