import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Special {

    public static void main(String[] args) {

        System.out.println("mapToObj example");
        String password = "password123";
        password.chars().mapToObj(i -> (char) i).forEach(System.out::println);


        System.out.println("boxed() example");
        int[] number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntStream stream = Arrays.stream(number);
        List<Integer> collect = stream.boxed().collect(Collectors.toList());
        collect.forEach(integer -> System.out.println(integer instanceof Integer));

        System.out.println("anyMatch example");
        System.out.println(IntStream.of(number).anyMatch(x -> x == 4));

    }
}
