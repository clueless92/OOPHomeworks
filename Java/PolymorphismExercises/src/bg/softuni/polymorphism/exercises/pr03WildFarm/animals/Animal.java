package bg.softuni.polymorphism.exercises.pr03WildFarm.animals;

import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Food;

public abstract class Animal {
    private String name;
    private String type;
    private Double weight;

    public Animal(String name, Double weight, String animalType) {
        this.name = name;
        this.weight = weight;
        this.type = animalType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}
