package lotto.controller;

import lotto.model.dto.PurchaseResult;
import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.WinningLotto;
import lotto.parser.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final Parser parser;
    private final OutputView outputView;

    public LottoController(InputView inputView, Parser parser, OutputView outputView) {
        this.inputView = inputView;
        this.parser = parser;
        this.outputView = outputView;
    }

    public void run() {
        PurchaseResult purchaseResult = purchaseLottos();
        checkWinningResult(purchaseResult.amount(), purchaseResult.lottos());
    }

    private PurchaseResult purchaseLottos() {
        while (true) {
            try {
                BigInteger amount = parser.parseBigInteger(inputView.requestPurchaseAmount());
                List<Lotto> lottos = LottoStore.buy(amount);
                outputView.printPurchasedLottos(lottos);
                return new PurchaseResult(amount, lottos);
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("금액 입력 재시도 " + e.getMessage());
            }
        }
    }

    private void checkWinningResult(BigInteger amount, List<Lotto> lottos) {
        while (true) {
            try {
                List<Integer> winningLottoNumbers = parser.parseIntegerList(inputView.requestWinningNumbers());
                Integer bonusNumber = parser.parseInteger(inputView.requestBonusNumber());
                WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

                outputView.printLottoResult(amount, lottos, winningLotto);
                return;
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("당첨번호 입력 재시도 " + e.getMessage());
            }
        }
    }
}
