package lotto.parser;

public class LottoParser {
    private static final int UNIT = 1000;

    public int parsePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input.trim());
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력해야 합니다.");
        }
    }
}
