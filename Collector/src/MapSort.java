import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapSort {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(15, "Mahesh");
        map.put(10, "Suresh");
        map.put(30, "Nilesh");


        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getKey))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));


        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));


        List<String> name = new ArrayList<>();
        map.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue))
                .peek(integerStringEntry -> name.add(integerStringEntry.getValue()))
                .forEach(e -> System.out.println(e.getKey() + " - " + e.getValue()));
        System.out.println(name);

        System.out.println("Collecting in map ");
        LinkedHashMap<Integer, String> hashMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (integer, integer2) -> integer, LinkedHashMap::new));

        hashMap.forEach(
                (integer, s) -> System.out.println(integer + " - " + s)
        );


    }
}