import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorTest {


    public static void main(String[] args) {


        List<Employee> employeeList = Arrays.asList(new Employee("Employee1", 25, "Account"),
                new Employee("Employee2", 28, "HR"),
                new Employee("Employee3", 30, "Account"),
                new Employee("Employee4", 34, "HR"),
                new Employee("Employee5", 45, "Admin"));

        Map<Boolean, List<Employee>> collect = employeeList.stream().collect(Collectors.partitioningBy(o -> o.getAge() > 30));

        collect.forEach((aBoolean, employees) -> System.out.println(aBoolean + "- " + employees));


    }
}
