package bg.softuni.polymorphism.exercises.pr03WildFarm.animals;


import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Food;
import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Vegetable;

import java.text.DecimalFormat;

public class Mouse extends Mammal {
    private Integer cheeseEaten;
    private static final String ANIMAL_TYPE = "Mouse";

    public Mouse(String name, Double weight, String livingRegion) {
        super(name, weight, ANIMAL_TYPE, livingRegion);
        this.cheeseEaten = 0;
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food instanceof Vegetable) {
            this.cheeseEaten += food.getQuantity();
            System.out.println("A cheese was just eaten!");
        } else {
            System.out.println("Mouses are not eating that type of food!");
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
                this.cheeseEaten);
    }
}
