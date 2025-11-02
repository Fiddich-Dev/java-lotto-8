package lotto.view;

import lotto.model.LottoResult;
import lotto.model.Lotto;
import lotto.model.LottoRank;
import lotto.model.WinningLotto;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
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
    private static final String PROFIT_RATE_MESSAGE_FORMAT = "총 수익률은 %s%%입니다.%n";
    private static final int PRECISION = 1;

    public void printPurchasedLottos(List<Lotto> lottos) {
        System.out.printf(PURCHASE_MESSAGE_FORMAT, lottos.size());
        lottos.forEach(this::printSingleLotto);
        System.out.println();
    }

    private void printSingleLotto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.printf(PURCHASE_NUMBERS_MESSAGE_FORMAT, lottoNumbers);
    }

    public void printLottoResult(BigInteger amount, List<Lotto> lottos, WinningLotto winningLotto) {
        System.out.println(RESULT_MESSAGE);
        printWinningCounts(lottos, winningLotto);
        printProfitRate(amount, lottos, winningLotto);
    }

    private void printWinningCounts(List<Lotto> lottos, WinningLotto winningLotto) {
        Map<LottoRank, Integer> lottoResult = LottoResult.of(lottos, winningLotto);

        for (LottoRank lottoRank : LottoRank.validRanks(LottoRank.BY_PRIZE_ASC)) {
            String bonusMessage = NOT_MATCH_BONUS_MESSAGE;
            if (lottoRank.isRequiresBonus()) {
                bonusMessage = MATCH_BONUS_MESSAGE;
            }
            System.out.printf(MATCH_RESULT_MESSAGE_FORMAT,
                    lottoRank.getMatchCount(),
                    bonusMessage,
                    lottoRank.getPrize(),
                    lottoResult.get(lottoRank));
        }
    }

    private void printProfitRate(BigInteger amount, List<Lotto> lottos, WinningLotto winningLotto) {
        BigInteger totalPrize = LottoResult.calculateTotalPrize(lottos, winningLotto);

        BigDecimal totalPrizeDecimal = new BigDecimal(totalPrize);
        BigDecimal amountDecimal = new BigDecimal(amount);

        BigDecimal profitRate = totalPrizeDecimal
                .multiply(BigDecimal.valueOf(100))
                .divide(amountDecimal, PRECISION + 1, RoundingMode.HALF_UP); // 소수점 둘째자리까지 반올림

        String numberFormat = "%." + PRECISION + "f";
        String formattedRate = String.format(numberFormat, profitRate.doubleValue());

        System.out.printf(PROFIT_RATE_MESSAGE_FORMAT, formattedRate);
    }
}
