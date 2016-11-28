package bg.softuni.polymorphism.exercises.pr02VehiclesExtention.vehicles;

public class Truck extends Vehicle {

    private static final double DEFAULT_AC_CONSUMPTION = 1.6;

    public Truck(double fuelQuantity,
                 double fuelConsumptionPerKilometer,
                 double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
        this.setAcConsuption(DEFAULT_AC_CONSUMPTION);
    }

    @Override
    public void drive(double distanceInKilometers) {
        this.moveVehicle(this, distanceInKilometers);
    }

    @Override
    public void refuel(double fuel) {
        this.setFuelQuantity(this.getFuelQuantity() + fuel * 0.95);
    }
}
