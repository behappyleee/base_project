package chapter_1.refactor_1;

import java.time.LocalDate;

public record BankTransaction(LocalDate localDate, double amount, String description) {

    @Override
    public String toString() {
        return "BankTransaction {localDate = " + localDate + ", amount = " + amount + ", description = " + description + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BankTransaction that = (BankTransaction) o;
        return Double.compare(that.amount, amount) == 0 && localDate.equals(that.localDate) && description.equals(that.description);
    }

}
