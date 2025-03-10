package strategy;

import strategy.compression.Compressor;
import strategy.compression.RunLengthEncoding;
import strategy.compression.SimpleReplacementCompression;
import strategy.payment.CreditCardPayment;
import strategy.payment.PaypalPayment;
import strategy.payment.ShoppingCart;

public class StrategyPattern {
    // 전략 패턴
    // 특정 작업을 하는 방식들 전략 들을 여럿 두고 이들을 필요에 따라 갈아끼우는 전략임
    // 전략들을 만들어 놓고 이를 필요에 따라 가져다가 씀

    // 특정 기능을 수행하기 위한 여러 가지 알고리즘을 별도 캡슐을 관리
    // 코드 실행 중 얼마든지 교체 가능하도록 설정

    // 전략은 실탄, 페인트 탄, 고무탄 같은 여러가지 총알들
    // context (ShoppingCart) 는 총 같은 개념임
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        // 전략을 먼저 설정 !
        cart.setPaymentStrategy(
            new CreditCardPayment()
        );
        cart.pay(3000);

        // 전략을 수정 다른 총알을 끼워 넣어 봄 !
        cart.setPaymentStrategy(
            new PaypalPayment()
        );

        cart.pay(3000);

        String data = "aabccbd";
        Compressor compressor = new Compressor();
        compressor.setCompressionStrategy(new RunLengthEncoding());
        System.out.println("RLE Compression : " + compressor.compress(data));

        compressor.setCompressionStrategy(new SimpleReplacementCompression());
        System.out.println("Simple Replacement : " + compressor.compress(data));
    }
}

