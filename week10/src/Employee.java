import java.util.List;

public class Employee implements Comparable<Employee> {
    private String name;
    private int age;
    private List<String> listOfCities;

    public Employee(String name, int age, List<String> listOfCities) {
        this.name = name;
        this.age = age;
        this.listOfCities = listOfCities;
    }

    // Getters and setterspublic String getName() { return name; }
    public int getAge() { return age; }
    public List<String> getListOfCities() { return listOfCities; }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.getName());
    }

    public String getName() {
        return this.name;
    }
}