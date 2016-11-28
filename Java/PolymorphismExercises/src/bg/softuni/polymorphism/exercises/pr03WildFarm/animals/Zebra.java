package bg.softuni.polymorphism.exercises.pr03WildFarm.animals;


import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Food;
import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Vegetable;

import java.text.DecimalFormat;

public class Zebra extends Mammal {
    private static final String ANIMAL_TYPE = "Zebra";

    private Integer foodEaten;

    public Zebra(String name, Double weight, String livingRegion) {
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
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.setFoodEaten(food.getQuantity());
        } else {
            System.out.println("Zebras are not eating that type of food!");
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
