package chapter_1.refactor_1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {

    // SRP - 단일 책임 원칙
    // 1. 한 클래스는 한 기능만 책임짐
    // 2. 클래스가 변경되어야 하는 이유는 오직 하나여야 함
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    // 개별로 분리 필요 모듈
    // 1. 입력 읽기
    // 2. 주어진 형식의 입력 파싱
    // 3. 결과 처리
    // 4. 결과 요약 리포트
    private BankTransaction parseFromCSV(final String line) {
        final String[] columns = line.split(",");
        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];
        
        return new BankTransaction(date, amount, description);
    }

    public List<BankTransaction> parseLinesFromCSV(final List<String> lines) {
        final List<BankTransaction> transactions = new ArrayList<>();
        for (final String line : lines) {
            transactions.add(parseFromCSV(line));
        }
        return transactions;
    }
}

