package lotto.parser;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private static final String ERROR_NOT_NUMERIC_AMOUNT = "[ERROR] 금액은 숫자만 입력해야 합니다.";
    private static final String ERROR_NON_NUMERIC_LIST = "[ERROR] 당첨 번호는 숫자여야 합니다.";
    private static final String ERROR_NON_NUMERIC_VALUE = "[ERROR] 보너스 번호는 숫자여야 합니다.";
    private static final String DELIMITER = ",";

    public BigInteger parseBigInteger(String input) {
        try {
            return new BigInteger(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NOT_NUMERIC_AMOUNT);
        }
    }

    public List<Integer> parseIntegerList(String input) {
        try {
            return Arrays.stream(input.trim().split(DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_LIST);
        }
    }

    public Integer parseInteger(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_VALUE);
        }
    }
}
