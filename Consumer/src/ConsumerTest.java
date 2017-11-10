import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Consumer<Integer> consumer = i -> System.out.println(i+ " x10 is = "+(i*10));
        System.out.println("Consumer accept()");
        consumeTest(list,consumer);
        System.out.println("\nConsumer andThen()");
        consumeAndTest(list,consumer);
    }

    private static void consumeTest(List<Integer> list, Consumer<Integer> consumer){
        list.forEach(consumer);
    }

    private static void consumeAndTest(List<Integer> list, Consumer<Integer> consumer){
        list.forEach(consumer.andThen(integer -> System.out.println("do something...")));
    }


}
