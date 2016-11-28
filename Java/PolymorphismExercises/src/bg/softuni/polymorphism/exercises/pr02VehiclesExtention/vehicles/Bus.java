package bg.softuni.polymorphism.exercises.pr02VehiclesExtention.vehicles;

public class Bus extends Vehicle {

    private static final double DEFAULT_AC_CONSUMPTION = 1.4;

    public Bus(double fuelQuantity, double fuelConsumptionPerKilometer, double tankCapacity) {
        super(fuelQuantity, fuelConsumptionPerKilometer, tankCapacity);
        this.setAcConsuption(DEFAULT_AC_CONSUMPTION);
    }

    @Override
    public double getFuelQuantity() {
        return super.getFuelQuantity();
    }

    @Override
    protected void setFuelQuantity(double fuelQuantity) {
        if (fuelQuantity + this.getFuelQuantity() > this.getTankCapacity()) {
            throw new IllegalArgumentException("Cannot fit fuel in tank");
        }

        super.setFuelQuantity(fuelQuantity);
    }

    @Override
    public void drive(double distanceInKilometers) {
        this.moveVehicle(this, distanceInKilometers);
    }

    public void driveEmpty(double distanceInKilometers) {
        this.setAcConsuption(0d);
        this.moveVehicle(this, distanceInKilometers);
        this.setAcConsuption(DEFAULT_AC_CONSUMPTION);
    }
}
