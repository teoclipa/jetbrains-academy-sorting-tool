# jetbrains-academy-sorting-tool

This Java-based command-line program provides various sorting functionalities, including sorting numbers and lines from a file or standard input. The sorting method and data type can be specified using command-line arguments. The program is flexible and allows for input and output redirection through files, handling errors, and displaying meaningful messages to the user.

## Key Components:

### Command-line Arguments Handling
The program processes the command-line arguments and sets the appropriate flags for sorting type, data type, input file, and output file. Invalid command-line arguments are handled, with an error message printed to the console for each unknown argument.

### Data Processing
Depending on the specified data type (`long`, `line`, or `word`), the appropriate data processor (`IntegerDataProcessor`, `LineDataProcessor`, or `WordDataProcessor`) is chosen. Each of these classes extends an abstract `DataProcessor` class and implements the `process` method differently according to the data type.

### Sorting
Sorting is performed either naturally or by count, depending on the provided command-line argument. The count sort is done using a frequency map that holds each distinct value from the input and its corresponding count.

### Input/Output Redirection
If the `-inputFile` argument is specified, the program reads data from the given file. If `-outputFile` is specified, the program writes the results to the given file. Errors encountered during file reading/writing are handled and displayed to the user.

### Error Handling
The code handles potential errors such as invalid data type, missing sorting type, or incorrect input format. In such cases, meaningful error messages are displayed to the console.

This program is a comprehensive tool that combines different aspects of data processing (sorting, input/output redirection, error handling) and provides a useful command-line utility for sorting tasks.
