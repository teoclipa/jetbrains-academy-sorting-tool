package sorting.datatype;

public record Line(String line) implements Comparable<Line> {

    @Override
    public int compareTo(Line other) {
        return Integer.compare(this.line.length(), other.line.length());
    }
    @Override
    public String toString() {
        return line;
    }
}
