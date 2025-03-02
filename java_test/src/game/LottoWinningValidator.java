package game;

import java.util.Set;

public class LottoWinningValidator {

    Set<Integer> pickLottoNumbers;
    int bonusNumber;

    Set<Integer> winningNumbers;
    int winningBonusNumber;

    public LottoWinningValidator(LottoGame.PickLottoNumber pickLottoNumber, LottoGame.LottoWinningNumber winningNumber) {
        this.pickLottoNumbers = pickLottoNumber.lottoPickNumbers();
        this.bonusNumber = pickLottoNumber.bonusNumber();
        this.winningNumbers = winningNumber.winningNumbers();
        this.winningBonusNumber = winningNumber.bonusNumber();
    }
}

