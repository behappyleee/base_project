import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class EnumPatternJava {

    public static void main(String[] args) {

        // Data 들을 조회
        EnumTest et1 = EnumTest.Y;
        EnumTest et2 = EnumTest.N;

        // 각 Code 마다 맞는 값을 조회
        CodeCalculator c1 = CodeCalculator.CODEA;
        CodeCalculator c2 = CodeCalculator.CODEB;

        System.out.println(c1.getCalculate(5));
        System.out.println(c2.getCalculate(21));

        // PaymentType 을 Enum 을 통하여 ENUM 이 관리하므로 ENUM 에게 확인하면 됨
        // ENUM 을 통하여 이제 관리 주체인 Enum 에게 Payment Type 을 확인 하면 됨

        // 아직까지 문제가 하나 남아있음 받는 결제 수단이 아직 문자열 String 임
        // 이를 위하여 받는 결제 수단도 ENUM 으로 처리를 하여야 함
        // PaymentTypeTest pt = PaymentTypeTest.getPaymentTypeByPaymentCode("MONEY");
        // System.out.println("[PT DATA ] : " + pt);

        // PaymentType 을 Enum 으로 변경 하면서 안전하게 값 관리가 가능해짐
        PaymentTypeTest pt1 = PaymentTypeTest.getPaymentTypeByPaymentCode(PaymentCode.MONEY);
        System.out.println("[PT1 DATA CHECK ] : " + pt1);

        // Enum 의 가장 큰 장점은 문맥 Context 를 담는 것
        // Enum 을 통하여 확실한 부분과 불 확실한 부분 분리가 가능해짐
        // 

        TestClassGeneric<String, Integer> aa = new TestClassGeneric<String, Integer>();


    }

    // Payment Type 을 리턴해주는 함수 Test
    // 결제 수단의 범위를 지정할 수 없어서 문자열이면 전부 Parameter 로 넘어감
    // 마찬가지로 결과를 받는 쪽에서도 문자열을 받기에 결제종류로 지정 된 값만 받을 수 있도록 검증코드가 필요
    // 입력값과 결제 값이 예측이 불가능 이래서 이를 Enum 으로 변경
    public String getPayType(String payType) {
        if("MONEY".equals(payType) || "CARD".equals(payType)) {
            return "PAY";
        } else {
            return "ELSE";
        }
    }

    // ENUM 을 통하여 이제 관리 주체인 Enum 에게 Payment Type 을 확인 하면 됨



}

enum PaymentCode {
    BCCARD,
    MONEY,
    DOLLAR,
    WOORI,
    KOOKMIN,
}


// 각 타입은 본인이 수행하여야 할 기능과 책임만 가질 수 있게 하려면 기존 방식으로는 해결하기가 어려움.
// 그래서 이를 Enum 으로 전환
enum PaymentTypeTest {

//    받는 값도 안전하게 받기 위하여 PaymentCode 도 ENUM 으로 처리
//    CARD("카드", Arrays.asList("BCCARD")),
//    CASH("현금", Arrays.asList("MONEY", "DOLLAR")),
//    CREDIT_CARD("신용카드", Arrays.asList("WOORI", "KOOKMIN"));

    CARD("카드", Arrays.asList(PaymentCode.BCCARD)),
    CASH("현금", Arrays.asList(PaymentCode.MONEY, PaymentCode.DOLLAR)),
    CREDIT_CARD("신용카드", Arrays.asList(PaymentCode.WOORI, PaymentCode.KOOKMIN));

    private String payTypeName;
    // private List<String> paymentList;
    private List<PaymentCode> paymentCodeList;

    private PaymentTypeTest(String payTypeName, List<PaymentCode> paymentCodeList) {
        this.payTypeName = payTypeName;
        this.paymentCodeList = paymentCodeList;
    }

    public String getPaymentType() {
        return payTypeName;
    }

    public List<PaymentCode> getPaymentList() {
        return paymentCodeList;
    }

    public static PaymentTypeTest getPaymentTypeByPaymentCode(PaymentCode paymentCode) {
        return Arrays.stream(PaymentTypeTest.values())
                .filter(payType -> payType.hasCode(paymentCode))    // TEST 로 MONEY 를 입력
                .findAny()
                .orElse(null);
    }

    public boolean hasCode(PaymentCode payCode) {
        return paymentCodeList.stream()
                .anyMatch(pay -> pay.equals(payCode));
    }

}

enum CodeCalculator {
    // Code 에 따라 값을 강제 계산
    CODEA(10, value1 -> value1 + 10),
    CODEB(20, value2 -> value2 + 20),
    CODEC(30, value3 -> value3 + 30);

    private int calNum;
    // 함수도 선언이 가능
    private Function<Long, Long> expression;

    private CodeCalculator(int calNum, Function<Long, Long> expression) {
        this.calNum = calNum;
        this.expression = expression;
    }

    public int getCalNum() {
        return calNum;
    }

    public long getCalculate(long value) {
        return expression.apply(value);
    }

}


enum EnumTest {
    Y(1, true),
    N(0, false);

    private int booleanCode;
    private boolean matchBoolean;

    private EnumTest(int booleanCode, boolean matchBoolean) {
        this.booleanCode = booleanCode;
        this.matchBoolean = matchBoolean;
    }

    public int getBooleanCode() {
        return booleanCode;
    }

    public boolean getMatchBoolean() {
        return matchBoolean;
    }

}

// Java 7 Version 이하에서는 추상 메서드 하나 선언 후 나머지 상수들에서 메서드를 Overrider 하여 구현
enum UnderJavaSevenVersion {
    CODE_A {
        @Override
        public int getCal(int value) {
            return 12;
        }
    },
    CODE_B {
        @Override
        public int getCal(int value) {
            return 13;
        }
    };
    abstract public int getCal(int value);
}

@Target(ElementType.METHOD)
@Documented
@interface TestAnnotiation {

}

class TestClassGeneric<T,R> {
    
}