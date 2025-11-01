package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ERROR_EMPTY_INPUT = "[ERROR] 입력값은 비어있을 수 없습니다.";
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public String requestPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        String input = Console.readLine();
        validate(input);
        System.out.println();
        return input;
    }

    public String requestWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        String input = Console.readLine();
        validate(input);
        System.out.println();
        return input;
    }

    public String requestBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        String input = Console.readLine();
        validate(input);
        System.out.println();
        return input;
    }

    private void validate(String input) {
        if(input == null || input.isBlank()) {
            throw new IllegalArgumentException(ERROR_EMPTY_INPUT);
        }
    }
}
