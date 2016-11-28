package bg.softuni.polymorphism.exercises.pr03WildFarm.animals;


import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Food;

import java.text.DecimalFormat;
import java.text.MessageFormat;

public class Cat extends Felime {
    private static final String ANIMAL_TYPE = "Cat";

    private String breed;
    private Integer foodEaten;

    public Cat(String name, Double weight, String livingRegion, String breed) {
        super(name, weight, ANIMAL_TYPE, livingRegion);
        this.breed = breed;
        this.foodEaten = 0;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public Integer getFoodEaten() {
        return foodEaten;
    }

    public void setFoodEaten(Integer foodEaten) {
        this.foodEaten += foodEaten;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
       this.setFoodEaten(food.getQuantity());
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s, %d]",
                this.getType(),
                this.getName(),
                this.getBreed(),
                df.format(this.getWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
