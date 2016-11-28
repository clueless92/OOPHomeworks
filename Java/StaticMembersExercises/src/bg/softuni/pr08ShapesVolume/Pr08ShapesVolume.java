package bg.softuni.pr08ShapesVolume;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class TrianglePrism {

    double baseSide;
    double height;
    double length;

    TrianglePrism(double baseSide, double height, double length) {
        this.baseSide = baseSide;
        this.height = height;
        this.length = length;
    }
}

class Cube {

    double length;

    Cube(double length) {
        this.length = length;
    }
}

class Cylinder {

    double height;
    double radius;

    Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
    }
}

class VolumeCalculator {

    static double CalculateTrianglePrismVolume(TrianglePrism prism) {
        return 0.5 * prism.height * prism.baseSide * prism.length;
    }

    static double CalculateCubeVolume(Cube cube) {
        return cube.length * cube.length * cube.length;
    }

    static double CalculateCylinderVolume(Cylinder cylinder) {
        return Math.PI * cylinder.radius * cylinder.radius * cylinder.height;
    }
}

public class Pr08ShapesVolume {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        String command = reader.readLine();
        while (!Objects.equals(command, "End")) {
            String[] commandArgs = command.split(" ");
            String figure = commandArgs[0];
            if (Objects.equals(figure, "Cube")) {
                Cube cube = new Cube(Double.parseDouble(commandArgs[1]));
                System.out.printf("%.3f%n", VolumeCalculator.CalculateCubeVolume(cube));
            } else if (Objects.equals(figure, "TrianglePrism")) {
                double baseSide = Double.parseDouble(commandArgs[1]);
                double height = Double.parseDouble(commandArgs[2]);
                double length = Double.parseDouble(commandArgs[3]);
                TrianglePrism prism = new TrianglePrism(baseSide, height, length);
                System.out.printf("%.3f%n", VolumeCalculator.CalculateTrianglePrismVolume(prism));
            } else if (Objects.equals(figure, "Cylinder")) {
                double radius = Double.parseDouble(commandArgs[1]);
                double height = Double.parseDouble(commandArgs[2]);
                Cylinder cylinder = new Cylinder(height, radius);
                System.out.printf("%.3f%n", VolumeCalculator.CalculateCylinderVolume(cylinder));
            }
            command = reader.readLine();
        }
    }
}
