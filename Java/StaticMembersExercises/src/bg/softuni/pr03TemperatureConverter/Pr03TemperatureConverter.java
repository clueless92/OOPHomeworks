package bg.softuni.pr03TemperatureConverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TemperatureConverter {

    public static double toFahrenheit(double temperatureInCelsius) {
        return ((9.0 / 5.0) * temperatureInCelsius) + 32;
    }

    public static double toCelsius(double temperatureInFahrenheit) {
        return (5.0 / 9.0) * (temperatureInFahrenheit - 32);
    }
}

public class Pr03TemperatureConverter {

    static final String CELSIUS = "Celsius";
    static final String FAHRENHEIT = "Fahrenheit";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        while (!command.equals("End")) {
            String[] commandArgs = command.split(" ");
            double temperature = Double.parseDouble(commandArgs[0]);
            String unit = commandArgs[1];
            double convertedTemperature = 0;
            if (unit.equals(CELSIUS)) {
                convertedTemperature = TemperatureConverter.toFahrenheit(temperature);
                System.out.printf("%.2f %s%n", convertedTemperature, FAHRENHEIT);
            } else if (unit.equals(FAHRENHEIT)) {
                convertedTemperature = TemperatureConverter.toCelsius(temperature);
                System.out.printf("%.2f %s%n", convertedTemperature, CELSIUS);
            }

            command = reader.readLine();
        }
    }
}
