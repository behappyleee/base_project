package chapter_1.refactor_2;

import chapter_1.refactor_1.BankStatementProcessor;
import chapter_1.refactor_1.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCE = "src/chapter_1/";

    // 특정 구현제에 종속되지 않도록 한다.
//    private static final chapter_1.refactor_1.BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
    public void analyze(final String fileName, final chapter_1.refactor_2.BankStatementParser bankStatementParser) throws IOException {
        final Path path = Paths.get(RESOURCE  + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);
    }

    private static void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("The total for all transations is " + bankStatementProcessor.calculateTotalAmount());
        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
        System.out.println("The total for transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
        System.out.println("The total for salary transactions is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }
}
