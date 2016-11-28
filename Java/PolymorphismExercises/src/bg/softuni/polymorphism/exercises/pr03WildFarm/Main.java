package bg.softuni.polymorphism.exercises.pr03WildFarm;

import bg.softuni.polymorphism.exercises.pr03WildFarm.animals.*;
import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Food;
import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Meat;
import bg.softuni.polymorphism.exercises.pr03WildFarm.food.Vegetable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String animalInfo = reader.readLine();
        while (!animalInfo.equals("End")) {
            String[] tokens = animalInfo.split(" ");
            Animal animal = getAnimalInstance(tokens);
            String foodInfo = reader.readLine();
            String[] foodTokens = foodInfo.split(" ");
            Food food = getFood(foodTokens);
            animal.makeSound();
            animal.eat(food);
            System.out.println(animal);
            animalInfo = reader.readLine();
        }
    }

    public static Animal getAnimalInstance(String[] animalTokens) {
        String animalInstanceType = animalTokens[0];

        if (animalInstanceType.equals("Mouse")) {
            return new Mouse(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
        } else if (animalInstanceType.equals("Cat")) {
            return new Cat(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3], animalTokens[4]);
        } else if (animalInstanceType.equals("Tiger")) {
            return new Tiger(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
        }

        return new Zebra(animalTokens[1], Double.parseDouble(animalTokens[2]), animalTokens[3]);
    }

    public static Food getFood(String[] foodTokens) {
        if (foodTokens[0].equals("Meat")) {
            return new Meat(Integer.parseInt(foodTokens[1]));
        }

        return new Vegetable(Integer.parseInt(foodTokens[1]));
    }
}
