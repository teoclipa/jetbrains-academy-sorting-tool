package sorting.processor;

import sorting.datatype.Line;
import sorting.util.SortingType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LineDataProcessor extends DataProcessor<Line> {
    public LineDataProcessor(SortingType sortingType) {
        super(sortingType);
    }

    @Override
    public void process(String data) {
        List<Line> lines = Arrays.stream(data.split("\n")).map(Line::new).sorted().collect(Collectors.toList());
        printOutput(lines, "lines");
    }
}