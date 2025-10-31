package lotto.parser;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class LottoParser {

    public BigInteger parsePurchaseAmount(String input) {
        try {
            BigInteger amount = new BigInteger(input.trim());
            validate(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력해야 합니다.");
        }
    }

    private void validate(BigInteger value) {
        if (value.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("[ERROR] 0 이하의 값은 허용되지 않습니다: " + value);
        }
    }

    public List<Integer> parseWinningLottoNumbers(String input) {
        // Integer 범위 바깥의 수가 들어올때
        try {
            List<Integer> numbers = Arrays.stream(input.trim().split(","))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .peek(this::validateLottoNumber)
                    .toList();

            if (numbers.size() != new HashSet<>(numbers).size()) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복될 수 없습니다.");
            }

            return numbers;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    private void validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다. 입력값: " + number);
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
