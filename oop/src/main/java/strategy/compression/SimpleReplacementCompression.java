package strategy.compression;

public class SimpleReplacementCompression implements CompressionStrategy {
    @Override
    public String compress(String input) {
        return input.replace("a", "1")
                .replace("e", "2")
                .replace("i", "3")
                .replace("o", "4")
                .replace("u", "5");
    }
}
