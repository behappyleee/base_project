import chapter_1.refactor_1.BankTransaction;
import chapter_1.refactor_2.BankStatementCSVParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;


public class BankStatementCSVParserTest {

    private final BankStatementCSVParser parser = new BankStatementCSVParser();

    @Test
    public void shouldParseOneCorrectLine() throws Exception {
        final String line = "30-01-2017,-50,Tesco";
        final BankTransaction result = parser.parseFrom(line);
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");

        final double tolerance = 0.0d;
    }
}
