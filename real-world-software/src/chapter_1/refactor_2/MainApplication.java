package chapter_1.refactor_2;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        // BankStatementAnalyzer 클래스가 더 이상 특정 구현에 종속되지 않도록 개선이 되었으므로 요구 사항이 바뀌더라도
        // 쉽게 대응이 가능 하다. (구현체만 변경해 주면 된다.)
        // 보통 코드를 구현할 때는 결합도를 낮춰야 한다고 한다. 이는 코드의 다양한 컴포넌트가 내부와 세부 구현에 의존하지 않도록 해야한다.
        // 반대로 높은 결합도는 무조건 피한다
        final chapter_1.refactor_2.BankStatementAnalyzer bankStatementAnalyzer = new chapter_1.refactor_2.BankStatementAnalyzer();
        final chapter_1.refactor_2.BankStatementParser bankStatementParser = new BankStatementCSVParser();

        bankStatementAnalyzer.analyze("transactions.csv", bankStatementParser);
    }
}
