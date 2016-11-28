package bg.softuni.pr01Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Student {
    public static int counter = 0;
    public String name;

    public Student(String name) {
        this.name = name;
        counter++;
    }
}

public class Pr01Students {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        while(!name.equals("End")) {
            Student student = new Student(name);
            name = reader.readLine();
        }

        System.out.println(Student.counter);
    }
}
