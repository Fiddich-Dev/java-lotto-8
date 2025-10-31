package lotto.parser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public List<Integer> parseWinningLottoNumbers(String input) {
        try {
            return Arrays.stream(input.trim().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    public Integer parseBonusNumber(String input) {
        try {
            return Integer.parseInt(input.trim());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
