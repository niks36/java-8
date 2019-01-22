import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class ReduceTest {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>(Arrays.asList("John", "Mike"));
        List<String> list2 = new ArrayList<>(Arrays.asList("Donald", "Duck"));

        // Reduce First variant - One Parameter - Binary Operator. Returns Optional Value
        Optional<List<String>> reduce = Stream.of(list1, list2)
                .reduce((list, list21) -> {
                            list.addAll(list21);
                            return list;
                        }
                );
        System.out.println(reduce.get());

        // Output - [John, Mike, Donald, Duck]

        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        // Reduce Second variant - Two Parameter - Returns Value
        // 1. If value is not available then what to use
        // 2. Binary Operator
        List<String> reduceUsingSecondVarient = Stream.of(list1, list2)
                .reduce(Collections.singletonList("ABC"), (list, list21) -> {
                            list.addAll(list21);
                            return list;
                        }
                );
        System.out.println(reduceUsingSecondVarient);
        // Output - [ABC]

    }
}
