package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String PURCHASE_MESSAGE_FORMAT = "%d개를 구매했습니다.%n";
    private static final String PURCHASE_NUMBERS_MESSAGE_FORMAT = "[%s]%n";
    private static final String RESULT_FORMAT = "%d개 일치 (%s원) - %d개%n";
    private static final String RESULT_FORMAT2 = "%d개 일치, 보너스 볼 일치 (%s원) - %d개%n";

    public void printLottos(List<Lotto> lottos) {
        System.out.printf(PURCHASE_MESSAGE_FORMAT, lottos.size());
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getLottoNumbers().stream().map(String::valueOf).collect(Collectors.joining(", "));
        System.out.printf(PURCHASE_MESSAGE_FORMAT, lottoNumbers);
    }

    public void printResult(int seedMoney, List<Lotto> lottos) {
        System.out.println("당첨 통계");
        System.out.println("---");
        long totalPrize = 0;
        System.out.printf(RESULT_FORMAT, 3, "5,000", 1);
        System.out.printf(RESULT_FORMAT, 4, "50,000", 1);
        System.out.printf(RESULT_FORMAT, 5, "1,500,000", 1);
        System.out.printf(RESULT_FORMAT2, 5, "30,000,000", 1);
        System.out.printf(RESULT_FORMAT, 6, "2,000,000,000", 1);
        System.out.println("총 수익률은 입니다.");
    }



    public void temp(int matchCount, boolean bonusMatched) {

    }
}
