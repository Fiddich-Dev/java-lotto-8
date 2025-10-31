package lotto.parser;

public class LottoParser {
    private static final int UNIT = 1000;

    public int parsePurchaseAmount(String input) {
        try {
            int amount = Integer.parseInt(input.trim());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력해야 합니다.");
        }
    }

    private void validatePurchaseAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        if (amount % UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
