package bg.softuni.polymorphism.exercises.pr02VehiclesExtention.vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {

    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;
    private double tankCapacity;
    private double acConsuption;

    public Vehicle(double fuelQuantity,
                   double fuelConsumptionPerKilometer,
                   double tankCapacity) {
        this.tankCapacity = tankCapacity;
        this.setFuelQuantity(fuelQuantity);
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity <= 0) {
            throw new IllegalArgumentException("Fuel must be a positive number");
        }

        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionPerKilometer() {
        return this.fuelConsumptionPerKilometer;
    }

    public double getTankCapacity() {
        return this.tankCapacity;
    }

    public double getAcConsumption() {
        return this.acConsuption;
    }

    public void setAcConsuption(double acConsuption) {
        this.acConsuption = acConsuption;
    }

    public abstract void drive(double distanceInKilometers);

    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel);
    }

    protected void moveVehicle(Vehicle vehicle, double distance) {
        double requiredFuel = distance * (this.getFuelConsumptionPerKilometer()
                + this.getAcConsumption());
        if (requiredFuel <= this.getFuelQuantity()) {
            DecimalFormat df = new DecimalFormat("0.######");
            System.out.printf("%s travelled %s km%n",
                    vehicle.getClass().getSimpleName(),
                    df.format(distance));
            this.setFuelQuantity(this.getFuelQuantity() - requiredFuel);
        } else {
            System.out.println(vehicle.getClass().getSimpleName() +
                    " needs refueling");
        }
    }
}
