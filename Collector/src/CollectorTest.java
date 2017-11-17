import java.util.*;
import java.util.stream.Collectors;

public class CollectorTest {


    public static void main(String[] args) {


        List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee("Employee1", 25, "Account"),
                new Employee("Employee2", 28, "HR"),
                new Employee("Employee3", 30, "Account"),
                new Employee("Employee4", 34, "HR"),
                new Employee("Employee5", 45, "Admin")));

        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(o -> o.getAge() > 30));

        collect.forEach((aBoolean, employees) -> System.out.println(aBoolean + "- " + employees));

        Map<Boolean, Long> booleanLongMap = employeeList.stream().collect(Collectors.partitioningBy((Employee e) -> e.getDepartment().equals("HR"), Collectors.counting()));
        booleanLongMap.forEach((aBoolean, employees) -> System.out.println(aBoolean + "- " + employees));

        Long aLong = employeeList.stream().collect(Collectors.counting());
        System.out.println("Size of collection :" + aLong);

        System.out.println("\nMin example");
        Optional<Employee> employee = employeeList.stream().min(Comparator.comparing(Employee::getAge));
        employee.ifPresent(System.out::println);

        System.out.println("\nMax example");
        employee = employeeList.stream().max(Comparator.comparing(Employee::getAge));
        employee.ifPresent(System.out::println);


        System.out.println("\nJoining using first variant");
        String joining1 = employeeList.stream().map(Employee::getName).collect(Collectors.joining());
        System.out.println(joining1);

        System.out.println("\nJoining using second variant");
        joining1 = employeeList.stream().map(Employee::getName).collect(Collectors.joining(",\n"));
        System.out.println(joining1);

        System.out.println("\nJoining using second variant");
        joining1 = employeeList.stream().map(Employee::getName).collect(Collectors.joining(",\n", "Start\n", "\nEnd"));
        System.out.println(joining1);


        employeeList.removeIf((Employee emp) -> emp.getAge() >= 35);
        System.out.println("Employees below the age of 35");
        employeeList.forEach(System.out::println);

        employeeList.replaceAll(employee1 -> {
            employee1.setName(employee1.getName().toUpperCase());
            return employee1;
        });
        System.out.println("Using replace all");
        employeeList.forEach(System.out::println);

        employeeList.sort(Comparator.comparingInt(Employee::getAge));
        System.out.println("Using sort method");
        employeeList.forEach(System.out::println);
    }
}
