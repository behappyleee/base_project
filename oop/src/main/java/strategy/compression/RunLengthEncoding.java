package strategy.compression;

public class RunLengthEncoding implements CompressionStrategy {
    @Override
    public String compress(String input) {
        StringBuilder compressed = new StringBuilder();
        int count = 1;
        for (int i = 1; i<= input.length(); i++) {
            if (i < input.length() && input.charAt(i) == input.charAt(i-1)) {
                count++;
            }  else {
                compressed.append(input.charAt(i-1));
                compressed.append(count);
                count = 1;
            }
        }

        return compressed.toString();
    }
}
