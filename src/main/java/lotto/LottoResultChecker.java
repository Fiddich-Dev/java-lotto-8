package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultChecker {

    private final List<Lotto> lottos;
    private final WinningLotto winningLotto;

    public LottoResultChecker(List<Lotto> lottos, WinningLotto winningLotto) {
        this.lottos = lottos;
        this.winningLotto = winningLotto;
    }

    public Map<LottoRank, Integer> check() {
        Map<LottoRank, Integer> result = new HashMap<>();
        for(LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }

        for(Lotto lotto : lottos) {
            result.put(calculateRank(lotto), result.get(calculateRank(lotto)) + 1);
        }
        return result;
    }

    private LottoRank calculateRank(Lotto lotto) {
        int matchCount = getMatchedNumbersCount(lotto);
        boolean bonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return LottoRank.of(matchCount, bonusMatch);
    }

    private int getMatchedNumbersCount(Lotto lotto) {
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

    private boolean isMatchBonusNumber(Lotto lotto) {
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
