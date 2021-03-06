import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        List<Employee> employeeList = Arrays.asList(new Employee("Employee1", 1, 10000.0),
                new Employee("Employee2", 2, 20000.0),
                new Employee("Employee3", 3, 30000.0),
                new Employee("Employee4", 4, 12000.0),
                new Employee("Employee5", 5, 50000.0));

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

        System.out.println("infinite method");
        List<Integer> integers = Stream.iterate(1, n -> 2 * n + 1).limit(10).collect(Collectors.toList());
        integers.forEach(System.out::println);

        System.out.println("generate method");
        List<Double> collect = Stream.generate(Math::random).limit(10).collect(Collectors.toList());
        collect.forEach(System.out::println);

        System.out.println("reduce method using first varient");
        Double totalSalary = employeeList.stream().map(Employee::getSalary).reduce(0.00, (a, b) -> a + b);
        System.out.println("Total Salary:" + totalSalary);

        System.out.println("reduce method using second varient");
        Optional<Employee> reduce = employeeList.stream().reduce((a, b) -> a.getSalary() > b.getSalary()
                ? a : b);
        reduce.ifPresent(employee -> System.out.println("Maximum salary:" + employee));

    }


}

class Employee {
    private String name;
    private Integer id;
    private Double salary;


    public Employee(String name, Integer id, Double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
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

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", salary=" + salary +
                '}';
    }
}
