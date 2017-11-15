import java.util.*;
import java.util.stream.Collectors;

public class GroupByTest {

    public static void main(String[] args) {


        List<Employee> employeeList = Arrays.asList(new Employee("Employee1", 25, "Account"),
                new Employee("Employee2", 28, "HR"),
                new Employee("Employee3", 30, "Account"),
                new Employee("Employee4", 34, "HR"),
                new Employee("Employee5", 45, "Admin"));

        System.out.println("\nUsing groupingBy First Varient");
        Map<String, List<Employee>> stringListMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        stringListMap.forEach((s, employees) -> System.out.println(s + " - " + employees));

        System.out.println("\nUsing groupingBy Second Varient");
        Map<String, Set<Employee>> stringSetMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
        stringSetMap.forEach((s, employees) -> System.out.println(s + " - " + employees));

        System.out.println("\nUsing groupingBy Third Varient");
        TreeMap<String, Set<Employee>> treeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.toSet()));
        treeMap.forEach((s, employees) -> System.out.println(s + " - " + employees));

    }
}
