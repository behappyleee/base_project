package chapter_1.refactor_2;

import chapter_1.refactor_1.BankTransaction;

import java.util.List;

public class BankStatementCSVParser implements BankStatementParser {

    @Override
    public BankTransaction parseFrom(String line) {
        return null;
    }

    @Override
    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        return List.of();
    }
}

