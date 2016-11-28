package bg.softuni.polymorphism.exercises.pr01Vehicles.vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {

    public Car(double fuelQuantity, double fuelConsumptionPerKilometer) {
        super(fuelQuantity, fuelConsumptionPerKilometer);
    }

    @Override
    public void Drive(double distanceInKilometers) {
        double requiredFuel = distanceInKilometers *
                (this.getFuelConsumptionPerKilometer() + 0.9);
        if (requiredFuel <= this.getFuelQuantity()) {
            DecimalFormat df = new DecimalFormat("0.######");
            System.out.printf("Car travelled %s km%n", df.format(distanceInKilometers));
            this.setFuelQuantity(this.getFuelQuantity() - requiredFuel);
        } else {
            System.out.println("Car needs refueling");
        }
    }

    @Override
    public void Refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }
}
