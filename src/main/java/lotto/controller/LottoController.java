package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoStore;
import lotto.model.WinningLotto;
import lotto.parser.LottoParser;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.math.BigInteger;
import java.util.List;

public class LottoController {
    private final InputView inputView;
    private final LottoParser lottoParser;
    private final OutputView outputView;

    public LottoController(InputView inputView, LottoParser lottoParser, OutputView outputView) {
        this.inputView = inputView;
        this.lottoParser = lottoParser;
        this.outputView = outputView;
    }

    public void run() {
        BigInteger amount = lottoParser.parsePurchaseAmount(inputView.requestPurchaseAmount());

        LottoStore lottoStore = new LottoStore();
        List<Lotto> lottos = lottoStore.buy(amount);

        outputView.printPurchasedLottos(lottos);

        List<Integer> winningLottoNumbers = lottoParser.parseWinningLottoNumbers(inputView.requestWinningNumbers());
        Integer bonusNumber = lottoParser.parseBonusNumber(inputView.requestBonusNumber());
        WinningLotto winningLotto = new WinningLotto(winningLottoNumbers, bonusNumber);

        outputView.printLottoResult(amount, lottos, winningLotto);
    }
}
