import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class GroupByTest {

    public static void main(String[] args) {


        List<Employee> employeeList = Arrays.asList(new Employee("Employee1", 25, "Account"),
                new Employee("Employee2", 28, "HR"),
                new Employee("Employee3", 30, "Account"),
                new Employee("Employee4", 34, "HR"),
                new Employee("Employee5", 45, "Admin"));

        System.out.println("\nUsing groupingBy First Varient");
        Map<String, List<Employee>> stringListMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        stringListMap.forEach((s, employees) -> System.out.println(s + " - " + employees));

        System.out.println("\nUsing groupingBy Second Varient");
        Map<String, Set<Employee>> stringSetMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.toSet()));
        stringSetMap.forEach((s, employees) -> System.out.println(s + " - " + employees));

        System.out.println("\nUsing groupingBy Third Varient");
        TreeMap<String, Set<Employee>> treeMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, TreeMap::new, Collectors.toSet()));
        treeMap.forEach((s, employees) -> System.out.println(s + " - " + employees));

        System.out.println("\nUsing groupBy & averagingDouble");
        Map<String, Double> doubleMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getAge)));
        doubleMap.forEach((s, aDouble) -> System.out.println(s + " - " + aDouble));


        System.out.println("\nUsing groupBy & summingLong");
        Map<String, LongSummaryStatistics> statisticsMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summarizingLong(Employee::getAge)));
        statisticsMap.forEach((s, longSummaryStatistics) -> System.out.println(s + " - " + longSummaryStatistics));

        System.out.println("\nUsing groupBy & mapping");
        Map<String, List<String>> listMap = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println(listMap);

        System.out.println("\n---New Example--");

        List<String> items =
                Arrays.asList("apple", "apple", "banana",
                        "apple", "orange", "banana", "papaya");

        Map<String, Long> collect = items.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(collect);

        System.out.println("Add sorting");
        collect.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));

    }
}
