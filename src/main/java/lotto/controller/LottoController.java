package lotto.controller;

import lotto.parser.LottoParser;
import lotto.view.InputView;
import lotto.view.OutputView;

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
        int amount = lottoParser.parsePurchaseAmount(inputView.requestPurchaseAmount());

    }
}
