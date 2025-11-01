package lotto;

import lotto.controller.LottoController;
import lotto.parser.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        Parser parser = new Parser();
        LottoController lottoController = new LottoController(inputView, parser, outputView);

        lottoController.run();
    }
}
