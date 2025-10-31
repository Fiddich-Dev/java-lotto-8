package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.util.List;

public class LottoResultChecker {

    private final Lotto lotto;
    private final WinningLotto winningLotto;

    public LottoResultChecker(Lotto lotto, WinningLotto winningLotto) {
        this.lotto = lotto;
        this.winningLotto = winningLotto;
    }

    public LottoRank calculateRank() {
        int matchCount = getMatchedNumbersCount();
        boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return LottoRank.of(matchCount, bonusMatch);
    }

    private int getMatchedNumbersCount() {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        List<Integer> lottoNumbers = lotto.getNumbers();

        int count = 0;
        for(Integer lottoNumber : lottoNumbers) {
            for(Integer winningLottoNumber : winningLottoNumbers) {
                if(lottoNumber.equals(winningLottoNumber)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    private boolean isMatchBonusNumber() {
        Integer bonusNumber = winningLotto.getBonusNumber();
        List<Integer> lottoNumbers = lotto.getNumbers();

        for(Integer lottoNumber : lottoNumbers) {
            if(lottoNumber.equals(bonusNumber)) {
                return true;
            }
        }
        return false;
    }


}
