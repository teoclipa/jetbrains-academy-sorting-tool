package sorting.datatype;

public record Word(String word) implements Comparable<Word> {

    @Override
    public int compareTo(Word other) {
        return this.word.compareTo(other.word);
    }
    @Override
    public String toString() {
        return word;
    }
}
