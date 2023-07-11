package sorting.processor;

import sorting.datatype.Word;
import sorting.util.SortingType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WordDataProcessor extends DataProcessor<Word> {
    public WordDataProcessor(SortingType sortingType) {
        super(sortingType);
    }

    @Override
    public void process(String data) {
        List<Word> words = Arrays.stream(data.split("\\s+")).map(Word::new).sorted().collect(Collectors.toList());
        printOutput(words, "words");
    }
}
