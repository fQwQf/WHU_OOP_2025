# week10 作业

Java Stream API 编程作业

## 任务描述
请完成以下7个Java Stream API操作题目。使用提供的Employee类和StreamOperationOfEmployees类中的getListOfEmployees方法生成测试数据。需在main方法中编写Stream代码，​不要修改其他代码。

## 题目列表
1. 过滤与映射
给定员工列表，找出所有年龄大于30岁的员工，并打印他们的姓名。
示例输出：Jerry
2. 计数操作
统计年龄大于25岁的员工数量。
示例输出：3
3. 查找操作
找到名为“John”的员工并打印其信息。
示例输出：Employee [name=John, age=27]
4. 最大值操作
找出所有员工中的最大年龄。
示例输出：32
5. 排序操作
将员工列表按年龄升序排序，并打印排序后的结果。
示例输出：
```
Employee [name=Amit, age=22]  
Employee [name=Tom, age=24]  
...（其他员工）
```
6. 字符串归约
将所有员工的姓名用逗号连接成一个字符串。
示例输出：Tom,John,Jerry,Amit,Amit
7. 分组操作
将员工按姓名分组，并按格式打印结果：
```
John:  
[Employee [name=John, age=27]]  
Amit:  
[Employee [name=Amit, age=22], Employee [name=Amit, age=24]]  
...（其他分组）
```

提供的代码框架

1. Employee.java
```
package assignment;

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
}
```

2. StreamOperationOfEmployees.java
```
package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
```