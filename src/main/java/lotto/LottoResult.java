package lotto;

import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private LottoResult() {
    }

    public static Map<LottoRank, Integer> of(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> result = new HashMap<>();
        for(LottoRank lottoRank : LottoRank.values()) {
            result.put(lottoRank, 0);
        }

        for(Lotto lotto : lottos) {
            result.put(calculateRank(lotto, winningLotto), result.get(calculateRank(lotto, winningLotto)) + 1);
        }
        return result;
    }

    public static BigInteger calculateTotalPrize(List<Lotto> lottos, WinningLotto winningLotto) {
        BigInteger totalPrize = BigInteger.ZERO;
        Map<LottoRank, Integer> result = of(lottos, winningLotto);
        for(LottoRank lottoRank : LottoRank.validRanks()) {
            totalPrize = totalPrize.add(
                    BigInteger.valueOf(lottoRank.getPrize())
                            .multiply(BigInteger.valueOf(result.get(lottoRank))));
        }
        return totalPrize;
    }

    private static LottoRank calculateRank(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = getMatchedNumbersCount(lotto, winningLotto);
        boolean isBonusMatch = lotto.getNumbers().contains(winningLotto.getBonusNumber());
        return LottoRank.of(matchCount, isBonusMatch);
    }

    private static int getMatchedNumbersCount(Lotto lotto, WinningLotto winningLotto) {
        List<Integer> winningLottoNumbers = winningLotto.getNumbers();
        return (int) lotto.getNumbers().stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }
}
