import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("Employee1", 1),
                new Employee("Employee2", 2),
                new Employee("Employee3", 3),
                new Employee("Employee4", 4),
                new Employee("Employee5", 5));

        List<Employee> employees = employeeList.stream().filter(employee -> employee.getId() > 3).collect(Collectors.toList());
        employees.forEach(System.out::println);

        System.out.println("Using limit function");
        employees = employeeList.stream().limit(2).collect(Collectors.toList());
        employees.forEach(System.out::println);

        System.out.println("Using skip function");
        employees = employeeList.stream().skip(2).collect(Collectors.toList());
        employees.forEach(System.out::println);

        System.out.println("Using map function");
        List<String> nameList = employeeList.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        nameList.forEach(System.out::println);

        System.out.println("allMatch method");
        boolean result = employeeList.stream().allMatch(employee -> employee.getId() < 6);
        System.out.println("result: " + result);

        System.out.println("anyMatch method");
        result = employeeList.stream().anyMatch(employee -> employee.getId() < 4);
        System.out.println("result: " + result);

        System.out.println("noneMatch method");
        result = employeeList.stream().noneMatch(employee -> employee.getId() < 4);
        System.out.println("result: " + result);


    }


}

class Employee {
    private String name;
    private Integer id;

    public Employee(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
