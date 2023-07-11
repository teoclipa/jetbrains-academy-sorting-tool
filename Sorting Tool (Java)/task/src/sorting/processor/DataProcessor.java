package sorting.processor;

import sorting.datatype.Line;
import sorting.util.SortingType;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class DataProcessor<T extends Comparable<T>> {
    protected final SortingType sortingType;

    public DataProcessor(SortingType sortingType) {
        this.sortingType = sortingType;
    }

    public abstract void process(String data);

    protected void printOutput(List<T> data, String elementsName) {
        System.out.println("Total " + elementsName + ": " + data.size() + ".");

        if (sortingType == SortingType.NATURAL) {
            if (data.get(0) instanceof Line) {
                System.out.println("Sorted data: ");
                for (T item : data) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Sorted data: " + data.stream().map(Object::toString).collect(Collectors.joining(" ")));
            }
        } else if (sortingType == SortingType.BY_COUNT) {
            Map<T, Long> countMap = data.stream().collect(Collectors.groupingBy(e -> e, Collectors.counting()));
            countMap.entrySet().stream().sorted(Map.Entry.<T, Long>comparingByValue().thenComparing(Map.Entry.comparingByKey((k1, k2) -> {
                // If data type is integer, compare keys as integers
                if (data.get(0) instanceof Integer) {
                    return Integer.compare((Integer) k1, (Integer) k2);
                }
                // Else, compare keys as strings
                else {
                    return k1.toString().compareTo(k2.toString());
                }
            }))).forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " time(s), " + (entry.getValue() * 100 / data.size()) + "%"));
        }
    }

}
