import java.util.*;

public class Java8Map {

    public static void main(String[] args) {

        Map<Integer, List<Employee>> employeeDOJMap = new HashMap<>();

        List<Employee> list2014 = new ArrayList<>(Arrays.asList(
                new Employee("Deborah Sprightly", 29, "HR")));
        employeeDOJMap.put(2014, list2014);
        List<Employee> list2015 = Arrays.asList(
                new Employee("Tom Jones", 45, "ACCOUNT"),
                new Employee("Harry Major", 25, "ADMIN"));
        employeeDOJMap.put(2015, list2015);
        List<Employee> list2016 = Arrays.asList(
                new Employee("Ethan Hardy", 65, "ACCOUNT"),
                new Employee("Nancy Smith", 22, "HR"));
        employeeDOJMap.put(2016, list2016);


        System.out.println("Using For each ");
        employeeDOJMap.forEach((integer, employees) -> System.out.println("Year: " + integer + " Employee: " + employees));

        System.out.println("\nUsing replace All");
        employeeDOJMap.replaceAll((integer, employees) -> {
            employees.replaceAll(employee -> {
                employee.setName(employee.getName().toUpperCase());
                return employee;
            });
            return employees;
        });
        employeeDOJMap.forEach((integer, employees) -> System.out.println("Year: " + integer + " Employee: " + employees));


        System.out.println("\nUsing computeIfAbsent");
        employeeDOJMap.computeIfAbsent(2017, integer -> new ArrayList<>()).add(new Employee("ABC", 32, "HR"));
        employeeDOJMap.computeIfAbsent(2014, integer -> new ArrayList<>()).add(new Employee("ABC", 32, "HR"));
        employeeDOJMap.forEach((integer, employees) -> System.out.println("Year: " + integer + " Employee: " + employees));


        System.out.println("\nUsing computeIfPresent");
        employeeDOJMap.computeIfPresent(2017, (integer, employees) ->
                employees.removeIf(employee -> employee.getAge() == 32) && employees.size() == 0 ? null : employees
        );
        employeeDOJMap.computeIfPresent(2014, (integer, employees) ->
                employees.removeIf(employee -> employee.getAge() == 32) && employees.size() == 0 ? null : employees
        );
        employeeDOJMap.forEach((integer, employees) -> System.out.println("Year: " + integer + " Employee: " + employees));

        System.out.println("\nUsing getOrDefault method");
        List<Employee> aDefault = employeeDOJMap.getOrDefault(2019, new ArrayList<>());
        System.out.println(aDefault);
        aDefault = employeeDOJMap.getOrDefault(2014, new ArrayList<>());
        System.out.println(aDefault);
    }

}
