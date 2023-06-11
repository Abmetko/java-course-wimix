package training.sorting;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CollectionSorting {

    public static void main(String[] args) {
        int[] array = {1, 9, 7, 3, 0, 5, 4, 7, 8};
        List<Integer> list = IntStream.of(array).boxed()
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        list.forEach(System.out::println);
    }
}