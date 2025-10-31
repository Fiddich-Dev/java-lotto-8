package lotto.view;

import lotto.model.Lotto;
import lotto.model.LottoRank;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    private static final String PURCHASE_NUMBERS_MESSAGE_FORMAT = "[%s]%n";
    private static final String MATCH_RESULT_MESSAGE_FORMAT = "%d개 일치%s (%,d원) - %d개%n";
    private static final String MATCH_BONUS_MESSAGE = ", 보너스 볼 일치";
    private static final String NOT_MATCH_BONUS_MESSAGE = "";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(PURCHASE_MESSAGE_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.printf(PURCHASE_MESSAGE_FORMAT, lottoNumbers);
    }

    public void printLottoResult(int seedMoney, List<Lotto> lottos) {
        System.out.println("당첨 통계");
        System.out.println("---");

        long totalPrize = 0;

        for(LottoRank lottoRank : LottoRank.values()) {
            if(lottoRank.isRequiresBonus()) {
                System.out.printf(MATCH_RESULT_MESSAGE_FORMAT, lottoRank.getMatchCount(), MATCH_BONUS_MESSAGE, lottoRank.getPrize(), -1);
                continue;
            }
            System.out.printf(MATCH_RESULT_MESSAGE_FORMAT, lottoRank.getMatchCount(), NOT_MATCH_BONUS_MESSAGE, lottoRank.getPrize(), -1);
        }
        System.out.println("총 수익률은 입니다.");
    }
}
