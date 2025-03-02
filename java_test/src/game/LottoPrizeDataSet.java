package game;

import java.util.Set;

// TODO - 로또 상금에 맞는 Enum 구현해주기 !
enum LottoPrizeDataSet{
    FIRST(2000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_500),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    LottoPrizeDataSet(int prizeMoney) {}

    static LottoPrizeDataSet getPrize(LottoGame.PickLottoNumber pickLottoNumber, LottoGame.LottoWinningNumber winningNumber) {
        Set<Integer> pickNumbers = pickLottoNumber.lottoPickNumbers();
        int pickBonusNumber = pickLottoNumber.bonusNumber();
        Set<Integer> winningNumbers = winningNumber.winningNumbers();
        int winningBonusNumber = winningNumber.bonusNumber();

        pickNumbers.retainAll(winningNumbers);

        if (pickNumbers.isEmpty()) {
            return FIRST;
        }
        if (pickNumbers.size() == 1 && pickBonusNumber == winningBonusNumber) {
            return SECOND;
        }
        if (pickNumbers.size() == 1) {
            return THIRD;
        }
        if (pickNumbers.size() == 2) {
            return FOURTH;
        }
        if (pickNumbers.size() == 3) {
            return FIFTH;
        }
        return NONE;
    }
}

// 로또 번호의 숫자 범위는 1 ~ 45 까지임
// 1개의 로또를 발행할 때 는 중복되지 않는 6개의 숫자를 뽑음
// 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑음
// 당첨은 1등 부터 5등까지 있음, 당첨 기준과 금액
// 1등 : 6개 번호 일치 -> 2,000,000,000 원
// 2등 : 5개 번호 + 보너스 번호 일치 -> 30,000,000 원
// 3등 : 5개 번호 일치 / 1,500,000 원
// 4등 : 4개 번호 일치 / 50,000 원
// 5등 : 3개 번호 일치 / 5,000 원