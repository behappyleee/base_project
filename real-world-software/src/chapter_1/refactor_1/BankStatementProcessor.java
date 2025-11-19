package chapter_1.refactor_1;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {
    private final List<chapter_1.refactor_1.BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            total += bankTransaction.amount();
        }
        return total;
    }

    public List<BankTransaction> selectInMonth(final Month month) {
        final List<BankTransaction> bankTransactionInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.localDate().getMonth() == month) {
                bankTransactionInMonth.add(bankTransaction);
            }
        }

        return bankTransactionInMonth;
    }

    public double calculateTotalInMonth(final Month month) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.localDate().getMonth() == month) {
                total += bankTransaction.amount();
            }
        }
        return total;
    }

    public double calculateTotalForCategory(final String category) {
        double total = 0d;
        for (final BankTransaction bankTransaction : bankTransactions) {
            if (bankTransaction.description().equals(category)) {
                total += bankTransaction.amount();
            }
        }
        return total;
    }
}

