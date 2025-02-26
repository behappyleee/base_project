package game;

import java.util.Set;

public class LottoGame {

    public static void main(String[] args) {
        // https://nakhonest.tistory.com/entry/Java-enum-%ED%99%9C%EC%9A%A9%EA%B8%B0enum%EC%97%90%EC%84%9C%EC%9D%98-%EB%8B%A4%ED%98%95%EC%84%B1
        // 로또 번호의 숫자 범위는 1 ~ 45 까지임
        // 1개의 로또를 발행할 때 는 중복되지 않는 6개의 숫자를 뽑음
        // 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑음
        // 당첨은 1등 부터 5등까지 있음, 당첨 기준과 금액
        // 1등 : 6개 번호 일치 -> 2,000,000,000 원
        // 2등 : 5개 번호 + 보너스 번호 일치 -> 30,000,000 원
        // 3등 : 5개 번호 일치 / 1,500,000 원
        // 4등 : 4개 번호 일치 / 50,000 원
        // 5등 : 3개 번호 일치 / 5,000 원

    }

    // TODO - Lotto 당첨 번호 6자리 !만들어주기 !
    private static Set<Integer> lottoNumber() {
        return null;
    }

    // TODO - Random Special 번호 만들기 !
    private static int specialNumber() {
        return 3;
    }

    private static final int[] lottoNumbers = {
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
            21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
            41, 42, 43, 44, 45
    };


}

