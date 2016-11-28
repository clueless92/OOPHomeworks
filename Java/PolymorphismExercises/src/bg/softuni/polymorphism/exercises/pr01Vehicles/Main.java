package bg.softuni.polymorphism.exercises.pr01Vehicles;

import bg.softuni.polymorphism.exercises.pr01Vehicles.vehicles.Car;
import bg.softuni.polymorphism.exercises.pr01Vehicles.vehicles.Truck;
import bg.softuni.polymorphism.exercises.pr01Vehicles.vehicles.Vehicle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] carInput = reader.readLine().split(" ");
        double carFuelQuantity = Double.parseDouble(carInput[1]);
        double carFuelConsumption = Double.parseDouble(carInput[2]);
        Car car = new Car(carFuelQuantity, carFuelConsumption);

        String[] truckInput = reader.readLine().split(" ");
        double truckFuelQuantity = Double.parseDouble(truckInput[1]);
        double truckFuelConsumption = Double.parseDouble(truckInput[2]);
        Truck truck = new Truck(truckFuelQuantity, truckFuelConsumption);

        int tests = Integer.parseInt(reader.readLine());
        for (int t = 0; t < tests; t++) {
            String[] command = reader.readLine().split(" ");
            String action = command[0];
            String vehicle = command[1];
            switch (vehicle) {
                case "Car":
                    ExecuteCommand(car, action, command[2]);
                    break;
                case "Truck":
                    ExecuteCommand(truck, action, command[2]);
                    break;
                default:
                    break;
            }
        }

        System.out.printf("Car: %.2f%n", car.getFuelQuantity());
        System.out.printf("Truck: %.2f%n", truck.getFuelQuantity());
    }

    private static void ExecuteCommand(
            Vehicle vehicle, String action, String parameter) {
        switch (action) {
            case "drive":
                double distance = Double.parseDouble(parameter);
                vehicle.Drive(distance);
                break;
            case "refuel":
                double liters = Double.parseDouble(parameter);
                vehicle.Refuel(liters);
                break;
            default:
                break;
        }
    }
}