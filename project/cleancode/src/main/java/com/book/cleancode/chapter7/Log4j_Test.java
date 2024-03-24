package com.book.cleancode.chapter7;

import java.util.logging.Logger;

public class Log4j_Test {

    public static void main(String[] args) {

        // 소프트웨어 설계가 우수하다면 변경하는데 많은 투자와 재작업이 필요하지 않다.
        // 엄청난 시간과 노력과 재 작업을 요구하지 않는다. 통제하지 못하는 코드를 사용할 떄 는 너무 많은 투자를 하거나 향후 변경 비용이 지나치게
        // 커지지 않도록 각별히 주의하여야 한다.
        // 외부 패키지를 호출하는 코드를 가능한 줄여 경계를 관리하자.
        Logger logger = Logger.getLogger("MyLogger");
        logger.info("Hello !");

    }

}
