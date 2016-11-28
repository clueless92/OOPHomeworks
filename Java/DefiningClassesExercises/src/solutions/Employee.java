import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Scanner;
import java.util.TreeMap;

public class Employee {

    private String name;
    private double salary;
    private String position;
    private String department;
    private String email;
    private int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department, String email) {
        this(name, salary, position, department, email, -1);
    }

    public Employee(String name, double salary, String position, String department, int age) {
        this(name, salary, position, department, "n/a", age);
    }

    public Employee(String name, double salary, String position, String department) {
        this(name, salary, position, department, "n/a", -1);
    }

    public static void main(String[] args) {
        final Scanner sc = new Scanner(System.in);
        final int n = Integer.parseInt(sc.nextLine());
        final List<Employee> employees = new ArrayList<>();
        final TreeMap<String, List<Double>> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            final String[] data = sc.nextLine().split(" ");
            Employee emp = null;

            if (data.length == 4) {
                emp = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3]);
            } else if (data.length == 5) {

                try {
                    final Integer age = Integer.parseInt(data[4]);
                    emp = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], age);
                } catch (final NumberFormatException e) {
                    final String email = data[4];
                    emp = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], email);
                }

            } else if (data.length == 6) {
                int x = -1;
                x = Integer.parseInt(data[5]);

                emp = new Employee(data[0], Double.parseDouble(data[1]), data[2], data[3], data[4],
                        x);

            }

            employees.add(emp);

            if (!map.containsKey(emp.department)) {
                map.put(emp.department, new ArrayList<>());
            }

            map.get(emp.department).add(emp.salary);
        }

        final Comparator<? super Entry<String, List<Double>>> comparator = (b, a) -> Double.compare(
                b.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble(),
                a.getValue().stream().mapToDouble(Double::doubleValue).average().getAsDouble());

        Optional<Entry<String, List<Double>>> opt = map.entrySet().stream().max(comparator);

        String department = "";
        if (opt.isPresent()) {
            department = map.entrySet().stream().max(comparator).get().getKey();
        }

        final String dep = department;
        System.out.println("Highest Average Salary: " + department);

        employees.stream()
                .filter(e -> e.department.equals(dep))
                .sorted((a,b) -> Double.compare(b.salary, a.salary))
                .forEach(s -> {
                    System.out.printf("%s %.2f %s %d",s.name, s.salary, s.email, s.age);
                    System.out.println();
                });

    }

}
