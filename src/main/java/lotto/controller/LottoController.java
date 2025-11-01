package lotto.controller;

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
        BigInteger amount = parser.parseBigInteger(inputView.requestPurchaseAmount());

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buy(amount);

        outputView.printPurchasedLottos(lottos);

        List<Integer> winningLottoNumbers = parser.parseIntegerList(inputView.requestWinningNumbers());
        Integer bonusNumber = parser.parseInteger(inputView.requestBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        outputView.printLottoResult(amount, lottos, winningLotto);
    }
}
