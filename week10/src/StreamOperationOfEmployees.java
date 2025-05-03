import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;

public class StreamOperationOfEmployees {
    public static void main(String[] args) {
        List<Employee> employeesList = getListOfEmployees();

        // 在此处编写你的Stream代码（替换以下注释）// 任务1-7的代码需依次编写在此处
        System.out.println("--- Task 1: Filter Age > 30, Print Names ---");
        employeesList.stream()
                .filter(employee -> employee.getAge() > 30)
                .map(Employee::getName)
                .forEach(System.out::println);
        System.out.println("--------------------------------------------------");


        System.out.println("\n--- Task 2: Count Age > 25 ---");
        long countAgeGreaterThan25 = employeesList.stream()
                .filter(employee -> employee.getAge() > 25)
                .count();
        System.out.println(countAgeGreaterThan25);
        System.out.println("----------------------------------");


        System.out.println("\n--- Task 3: Find John ---");
        Optional<Employee> johnOptional = employeesList.stream()
                .filter(employee -> "John".equals(employee.getName()))
                .findFirst();
        johnOptional.ifPresent(System.out::println);
        System.out.println("--------------------------------------");


        System.out.println("\n--- Task 4: Max Age ---");
        OptionalInt maxAge = employeesList.stream()
                .mapToInt(Employee::getAge)
                .max();
        maxAge.ifPresent(System.out::println);
        System.out.println("-------------------------");


        System.out.println("\n--- Task 5: Sort By Age ---");
        employeesList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(System.out::println);
        System.out.println("-----------------------------------------");


        System.out.println("\n--- Task 6: Join Names with Comma ---");
        String joinedNames = employeesList.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(joinedNames);
        System.out.println("----------------------------------------------");


        System.out.println("\n--- Task 7: Grouping By Name ---");
        Map<String, List<Employee>> employeesGroupedByName = employeesList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        employeesGroupedByName.forEach((name, group) -> {
            System.out.println(name + ":");
            System.out.println(group);
        });
        System.out.println("----------------------------------");
    }

    public static List<Employee> getListOfEmployees() {
        List<Employee> listOfEmployees = new ArrayList<>();
        listOfEmployees.add(new Employee("Tom", 24, Arrays.asList("NewYork", "Washington")));
        listOfEmployees.add(new Employee("John", 27, Arrays.asList("Paris", "London")));
        listOfEmployees.add(new Employee("Jerry", 32, Arrays.asList("LosAngles", "Seattle")));
        listOfEmployees.add(new Employee("Amit", 22, Arrays.asList("Beijing", "Shanghai")));
        listOfEmployees.add(new Employee("Amit", 24, Arrays.asList("Shanghai", "Wuhan")));
        return listOfEmployees;
    }
}