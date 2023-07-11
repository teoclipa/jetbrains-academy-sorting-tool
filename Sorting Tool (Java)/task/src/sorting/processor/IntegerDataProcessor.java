package sorting.processor;

import sorting.util.SortingType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IntegerDataProcessor extends DataProcessor<Integer> {
    public IntegerDataProcessor(SortingType sortingType) {
        super(sortingType);
    }

    @Override
    public void process(String data) {
        String[] parts = data.split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String part : parts) {
            try {
                numbers.add(Integer.parseInt(part));
            } catch (NumberFormatException ex) {
                System.out.println("\"" + part + "\" is not a long. It will be skipped.");
                // If input is not integer, ignore it.
            }
        }
        Collections.sort(numbers);
        printOutput(numbers, "numbers");
    }
}
