package bg.softuni.polymorphism.exercises.pr01Vehicles.vehicles;

public abstract class Vehicle {
    private double fuelQuantity;
    private double fuelConsumptionPerKilometer;

    protected Vehicle(double fuelQuantity, double fuelConsumptionPerKilometer) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    protected void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getFuelConsumptionPerKilometer() {
        return this.fuelConsumptionPerKilometer;
    }

    private void setFuelConsumptionPerKilometer(double fuelConsumptionPerKilometer){
        this.fuelConsumptionPerKilometer = fuelConsumptionPerKilometer;
    }

    public abstract void Drive(double distanceInKilometers);
    public abstract void Refuel(double fuel);
}
