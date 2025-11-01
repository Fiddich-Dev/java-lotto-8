package lotto.view;

import lotto.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OutputView {
    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    private static final String PURCHASE_NUMBERS_MESSAGE_FORMAT = "[%s]%n";
    private static final String RESULT_MESSAGE = "당첨 통계\n---";
    private static final String MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치%s (%,d원) - %d개%n";
    private static final String MATCH_BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String NOT_MATCH_BONUS_MESSAGE = "";

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(PURCHASE_MESSAGE_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            printSingleLotto(lotto);
        }
        System.out.println();
    }

    private void printSingleLotto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers()
                .stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf(PURCHASE_NUMBERS_MESSAGE_FORMAT, lottoNumbers);
    }

    public void printLottoResult(BigInteger amount, List<Lotto> lottos, WinningLotto winningLotto) {
        System.out.println(RESULT_MESSAGE);

        Map<LottoRank, Integer> lottoResult = LottoResult.of(lottos, winningLotto);

        long totalPrize = 0;

        for (LottoRank lottoRank : LottoRank.validRanks(LottoRank.BY_PRIZE_ASC)) {
            if (lottoRank.isRequiresBonus()) {
                System.out.printf(MATCH_RESULT_MESSAGE_FORMAT, lottoRank.getMatchCount(), MATCH_BONUS_MESSAGE, lottoRank.getPrize(), lottoResult.get(lottoRank));
                totalPrize += (long) lottoResult.get(lottoRank) * lottoRank.getPrize();
                continue;
            }
            System.out.printf(MATCH_RESULT_MESSAGE_FORMAT, lottoRank.getMatchCount(), NOT_MATCH_BONUS_MESSAGE, lottoRank.getPrize(), lottoResult.get(lottoRank));
            totalPrize += (long) lottoResult.get(lottoRank) * lottoRank.getPrize();
        }
        System.out.println("총 수익률은 입니다." + totalPrize);
    }
}
