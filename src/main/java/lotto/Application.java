package lotto;

import lotto.controller.LottoController;
import lotto.parser.LottoParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoParser lottoParser = new LottoParser();
        LottoController lottoController = new LottoController(inputView, lottoParser, outputView);

        lottoController.run();
    }
}
