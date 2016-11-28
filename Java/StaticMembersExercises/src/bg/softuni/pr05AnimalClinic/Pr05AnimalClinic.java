package bg.softuni.pr05AnimalClinic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Animal {

    public String name;
    public String breed;

    public Animal(String name, String breed) {
        this.name = name;
        this.breed = breed;
    }

    @Override
    public String toString() {
        return this.name + " " + this.breed;
    }
}

class AnimalClinic {

    public static int patientId;
    public static int healedAnimalsCount;
    public static int rehabilitatedAnimalsCount;
    public List<Animal> healedAnimals;
    public List<Animal> rehabilitatedAnimals;

    static {
        patientId = 0;
        healedAnimalsCount = 0;
        healedAnimalsCount = 0;
    }

    public AnimalClinic() {
        this.healedAnimals = new ArrayList<>();
        this.rehabilitatedAnimals = new ArrayList<>();
    }

    public void HealAnimal(Animal animal) {
        this.healedAnimals.add(animal);
        healedAnimalsCount++;
        patientId++;
    }

    public void RehabilitateAnimal(Animal animal) {
        this.rehabilitatedAnimals.add(animal);
        rehabilitatedAnimalsCount++;
        patientId++;
    }
}

public class Pr05AnimalClinic {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        AnimalClinic animalClinic = new AnimalClinic();
        String command = reader.readLine();
        while (!Objects.equals(command, "End")) {
            String[] commandArgs = command.split(" ");
            String name = commandArgs[0];
            String breed = commandArgs[1];
            String action = commandArgs[2];
            Animal animal = new Animal(name, breed);
            if (Objects.equals(action, "heal")) {
                animalClinic.HealAnimal(animal);
                System.out.printf("Patient %d: [%s (%s)] has been healed!%n",
                        AnimalClinic.patientId, animal.name, animal.breed);
            } else if (Objects.equals(action, "rehabilitate")) {
                animalClinic.RehabilitateAnimal(animal);
                System.out.printf("Patient %d: [%s (%s)] has been rehabilitated!%n",
                        AnimalClinic.patientId, animal.name, animal.breed);
            }
            command = reader.readLine();
        }
        System.out.printf("Total healed animals: %d%n", AnimalClinic.healedAnimalsCount);
        System.out.printf("Total rehabilitated animals: %d%n", AnimalClinic.rehabilitatedAnimalsCount);
        String listCommand = reader.readLine();
        if (Objects.equals(listCommand, "heal")) {
            for (Animal animal : animalClinic.healedAnimals) {
                System.out.println(animal);
            }
        } else if (Objects.equals(listCommand, "rehabilitate")) {
            for (Animal animal : animalClinic.rehabilitatedAnimals) {
                System.out.println(animal);
            }
        }
    }
}
