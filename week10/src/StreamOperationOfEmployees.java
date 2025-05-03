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
//1. Given a list of employees, you need to find all the employees whose age is greater than 30 and print the employee names.


//2. Given the list of employees, find the count of employees with age greater than 25?



//3. Given the list of employees, find the employee whose name is John.


//4.Given a list of employees, You need to find highest age of employee?

//5. Given a list of employees, you need sort employee list by age?


//6. Given the list of Employees, you need to join the all employee names with ","?


//7. Given the list of employees, you need to group them by name

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