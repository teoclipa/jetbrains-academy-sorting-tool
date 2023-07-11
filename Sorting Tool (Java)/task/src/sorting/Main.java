package sorting;

import sorting.processor.DataProcessor;
import sorting.processor.IntegerDataProcessor;
import sorting.processor.LineDataProcessor;
import sorting.processor.WordDataProcessor;
import sorting.util.DataType;
import sorting.util.SortingType;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        DataType dataType = DataType.WORD;
        SortingType sortingType = SortingType.NATURAL;
        String inputFileName = null;
        String outputFileName = null;

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-sortingType" -> {
                    if (i + 1 < args.length) {
                        switch (args[++i]) {
                            case "natural" -> sortingType = SortingType.NATURAL;
                            case "byCount" -> sortingType = SortingType.BY_COUNT;
                            default -> System.out.println("No sorting type defined!");
                        }
                    } else {
                        System.out.println("No sorting type defined!");
                    }
                }
                case "-dataType" -> {
                    if (i + 1 < args.length) {
                        switch (args[++i]) {
                            case "long" -> dataType = DataType.INTEGER;
                            case "line" -> dataType = DataType.LINE;
                            case "word" -> dataType = DataType.WORD;
                            default -> System.out.println("No data type defined!");
                        }
                    } else {
                        System.out.println("No data type defined!");
                    }
                }
                case "-inputFile" -> {
                    if (i + 1 < args.length) {
                        inputFileName = args[++i];
                    }
                }
                case "-outputFile" -> {
                    if (i + 1 < args.length) {
                        outputFileName = args[++i];
                    }
                }
                default -> System.out.println("\"" + args[i] + "\" is not a valid parameter. It will be skipped.");
            }
        }

        DataProcessor<?> dataProcessor = switch (dataType) {
            case INTEGER -> new IntegerDataProcessor(sortingType);
            case LINE -> new LineDataProcessor(sortingType);
            case WORD -> new WordDataProcessor(sortingType);
        };

        StringBuilder data = new StringBuilder();

        try (BufferedReader reader = inputFileName != null ? new BufferedReader(new FileReader(inputFileName)) : new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        PrintStream originalOut = System.out;
        try {
            if (outputFileName != null) {
                FileOutputStream fos = new FileOutputStream(outputFileName);
                System.setOut(new PrintStream(fos));
            }
            dataProcessor.process(data.toString());
        } catch (FileNotFoundException e) {
            System.setOut(originalOut);
            System.out.println("Error writing to file: " + e.getMessage());
        } finally {
            System.setOut(originalOut);
        }
    }
}
