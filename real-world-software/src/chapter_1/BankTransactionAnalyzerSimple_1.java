package chapter_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BankTransactionAnalyzerSimple_1 {

    // 간단한 csv 파일을 파싱하는 클래스
    private static final String RESOURCES = "src/chapter_1/";

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(RESOURCES + "transactions.csv");
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line : lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[0]);
            total += amount;
        }

        System.out.println("The total for all transaction is " + total);
    }
}

