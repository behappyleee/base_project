package refactor_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    private static final String RESOURCE = "src/chapter_1/";

    public static void main(String[] args) throws IOException {
        final chapter_1.refactor_1.BankStatementCSVParser bankStatementCSVParser = new chapter_1.refactor_1.BankStatementCSVParser();
        final String fileName = "transactions.csv";
        final Path path = Paths.get(RESOURCE + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<chapter_1.refactor_1.BankTransaction> bankTransactions = bankStatementCSVParser.parseLinesFromCSV(lines);

        System.out.println("The total for all transaction is " + calculateTotalAmount(bankTransactions));
        System.out.println("Transaction in January " + selectInMonth(bankTransactions, Month.JANUARY));

    }

    public static double calculateTotalAmount(final List<chapter_1.refactor_1.BankTransaction> bankTransactions) {
        double total = 0d;
        for (final chapter_1.refactor_1.BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.amount();
        }
        return total;
    }

    public static List<chapter_1.refactor_1.BankTransaction> selectInMonth(final List<chapter_1.refactor_1.BankTransaction> bankTransactions, final Month month) {
        final List<chapter_1.refactor_1.BankTransaction> bankTransactionInMonth = new ArrayList<>();
        for (final chapter_1.refactor_1.BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.localDate().getMonth() == month) {
               bankTransactionInMonth.add(bankTransaction);
            }
        }

        return bankTransactionInMonth;
    }
}
