package bg.softuni.pr02UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Student {
    public static final HashSet<String> uniqueNames = new HashSet<>();
    public String name;

    public Student(String name) {
        this.name = name;
        uniqueNames.add(this.name);
    }
}

public class Pr02UniqueStudentNames {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        while(!name.equals("End")) {
            Student student = new Student(name);
            name = reader.readLine();
        }

        System.out.println(Student.uniqueNames.size());
    }
}
