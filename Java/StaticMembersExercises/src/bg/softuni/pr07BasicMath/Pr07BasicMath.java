package bg.softuni.pr07BasicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class MathUtil {

    static double Sum(double a, double b) {
        return a + b;
    }

    static double Subtract(double a, double b) {
        return a - b;
    }

    static double Multiply(double a, double b) {
        return a * b;
    }

    static double Divide(double a, double b) {
        return a / b;
    }

    static double GetPercentage(double number, double percentage) {
        return number * (percentage / 100);
    }
}

public class Pr07BasicMath {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command = reader.readLine();
        while(!Objects.equals(command, "End")) {
            String[] commandArgs = command.split(" ");
            String operation = commandArgs[0];
            double a = Double.parseDouble(commandArgs[1]);
            double b = Double.parseDouble(commandArgs[2]);
            switch (operation) {
                case "Sum":
                    System.out.printf("%.2f%n", MathUtil.Sum(a, b));
                    break;
                case "Subtract":
                    System.out.printf("%.2f%n", MathUtil.Subtract(a, b));
                    break;
                case "Multiply":
                    System.out.printf("%.2f%n", MathUtil.Multiply(a, b));
                    break;
                case "Divide":
                    System.out.printf("%.2f%n", MathUtil.Divide(a, b));
                    break;
                case "Percentage":
                    System.out.printf("%.2f%n", MathUtil.GetPercentage(a, b));
                    break;
                default:
                    break;
            }
            command = reader.readLine();
        }
    }
}
