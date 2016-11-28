package bg.softuni.polymorphism.exercises.pr03WildFarm.animals;

public abstract class Mammal extends Animal {

    private String livingRegion;

    public Mammal(String name, Double weight, String animaltype, String livingRegion) {
        super(name, weight, animaltype);
        this.livingRegion = livingRegion;
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    public void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }
}
