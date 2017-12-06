import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamConcat {

    public static void main(String[] args) {
        Stream<String> s1 = Stream.of("A", "B", "C", "D");
        Stream<String> s2 = Stream.of("E", "F", "C", "D");

        Stream<String> distinct = Stream.concat(s1, s2).distinct();
        distinct.forEach(System.out::print);

        System.out.println("");
        List<Book> lst = new ArrayList<>();
        lst.add(new Book("Core Java", 500));
        lst.add(new Book("Effective Java", 400));
        lst.add(new Book("Advance Java", 400));
        lst.add(new Book("Core Java", 200));

        lst.stream().distinct().forEach(System.out::println);

        System.out.println("Distinct by price");
        lst.stream().filter(distinctByKey(Book::getPrice)).forEach(System.out::println);

    }

    static <T> Predicate<T> distinctByKey(Function<T, ?> keyExtract) {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtract.apply(t), Boolean.TRUE) == null;
    }

}
