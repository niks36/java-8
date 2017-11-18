import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ComparatorTest {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>(Arrays.asList(new Employee("John", 25, "Account"),
                new Employee("Niket", 28, "HR"),
                new Employee("Priyank", 30, "Account"),
                new Employee("Priyank", 32, "HR"),
                new Employee("Parth", 32, "HR"),
                new Employee("Nikunj", 45, "Admin")));

        employeeList.sort(Comparator.comparing(Employee::getAge));
        employeeList.forEach(System.out::println);


        System.out.println("\nReverse order of name");
        employeeList.sort(Comparator.comparing(Employee::getName, Comparator.reverseOrder()));
        employeeList.forEach(System.out::println);


        System.out.println("\nthenComparing");
        employeeList.sort(Comparator.comparing(Employee::getName).thenComparing(Comparator.comparing(Employee::getAge, Comparator.reverseOrder())));
        employeeList.forEach(System.out::println);


        System.out.println("\nusing nullLast");
        employeeList.add(new Employee(null, 32, "HR"));
        employeeList.sort(Comparator.comparing(Employee::getName, Comparator.nullsLast(String::compareTo)));
        employeeList.forEach(System.out::println);

        System.out.println("\nusing nullFirst ");
        employeeList.sort(Comparator.comparing(Employee::getName, Comparator.nullsFirst(String::compareTo)));
        employeeList.forEach(System.out::println);

    }
}
