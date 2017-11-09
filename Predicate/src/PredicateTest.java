import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateTest {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Predicate<Integer> predicate = i -> i > 5;
        System.out.println("Predicate Simple Example");
        predicateTest(list,predicate);
        System.out.println("\nPredicate And Example");
        predicateAndTest(list,predicate);
        System.out.println("\nPredicate Or Example");
        predicateOrTest(list,predicate);
        System.out.println("\nPredicate Negate Example");
        predicateNegateTest(list,predicate);
    }

    private static void predicateTest(List<Integer> list,Predicate<Integer> predicate){

        List<Integer> collect = list.stream().filter(predicate).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void predicateAndTest(List<Integer> list,Predicate<Integer> predicate){
        Predicate<Integer> and = predicate.and(i -> i > 8);
        List<Integer> collect = list.stream().filter(and).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void predicateOrTest(List<Integer> list,Predicate<Integer> predicate){
        Predicate<Integer> or = predicate.or(i -> i > 3);
        List<Integer> collect = list.stream().filter(or).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }

    private static void predicateNegateTest(List<Integer> list,Predicate<Integer> predicate){
        Predicate<Integer> negate = predicate.negate();
        List<Integer> collect = list.stream().filter(negate).collect(Collectors.toList());
        collect.forEach(System.out::println);
    }
}
