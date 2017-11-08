import test.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Function<Employee,String> stringFunction = e -> e.getName().toUpperCase();
        List<Employee> employeeList=
                Arrays.asList(new Employee("Tom Jones", 45),
                        new Employee("Harry Major", 25),
                        new Employee("Ethan Hardy", 65),
                        new Employee("Nancy Smith", 15),
                        new Employee("Deborah Sprightly", 29));

        System.out.println("\nGetting First name using apply method. Which Transforms object A -> B");
        applyTest(employeeList,stringFunction);

        System.out.println("\nGetting Length of name using andThen method. Which Transforms object A -> B (using apply) & Then B -> C(using andThen()");
        andThenTest(employeeList,stringFunction);

        System.out.println("\nGetting name using compose method. Which Transforms object A -> B (using compose) & Then B -> C(using apply()");
        composeTest(employeeList,e -> e.getName().toLowerCase());

    }

    private static void applyTest(List<Employee> employeeList, Function<Employee,String> function){
        employeeList.forEach(employee -> System.out.println(function.apply(employee)));
    }

    private static void andThenTest(List<Employee> employeeList, Function<Employee,String> function){
        Function<String,Integer> lengthFunction = String::length;
        Function<Employee, Integer> employeeIntegerFunction = function.andThen(lengthFunction);
        employeeList.forEach(employee -> System.out.println(employeeIntegerFunction.apply(employee)));
    }

    private static void composeTest(List<Employee> employeeList, Function<Employee,String> function){
        Function<Integer,Employee> lengthFunction = employeeList::get;
        Function<Integer, String> compose = function.compose(lengthFunction);
        Stream.of(0,1,2,3,4).forEach(integer -> System.out.println(compose.apply(integer)));
    }
}
