package lotto.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class ParserTest {
    private final Parser parser = new Parser();

    @Test
    @DisplayName("정상 금액 입력은 BigInteger로 변환된다")
    void parseBigInteger_validInput() {
        BigInteger result = parser.parseBigInteger("10000");
        assertThat(result).isEqualTo(BigInteger.valueOf(10000));
    }

    @Test
    @DisplayName("비어있는 입력은 예외 발생")
    void parseBigInteger_emptyInput() {
        assertThatThrownBy(() -> parser.parseBigInteger(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 금액 입력 시 예외 발생 (BigInteger)")
    void parseBigInteger_nonNumeric() {
        assertThatThrownBy(() -> parser.parseBigInteger("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자 문자열은 정수 리스트로 변환된다")
    void parseIntegerList_validInput() {
        List<Integer> result = parser.parseIntegerList("1, 2, 3, 4, 5, 6");
        assertThat(result).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    @DisplayName("리스트에 숫자가 아닌 값이 포함되면 예외 발생")
    void parseIntegerList_containsNonNumeric() {
        assertThatThrownBy(() -> parser.parseIntegerList("1, 2, a, 4"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비어있는 입력은 예외 발생 (IntegerList)")
    void parseIntegerList_emptyInput() {
        assertThatThrownBy(() -> parser.parseIntegerList(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("정상 숫자 입력은 Integer로 변환된다")
    void parseInteger_validInput() {
        Integer result = parser.parseInteger("7");
        assertThat(result).isEqualTo(7);
    }

    @Test
    @DisplayName("숫자가 아닌 보너스 번호 입력 시 예외 발생")
    void parseInteger_nonNumeric() {
        assertThatThrownBy(() -> parser.parseInteger("bonus"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("비어있는 입력은 예외 발생 (Integer)")
    void parseInteger_emptyInput() {
        assertThatThrownBy(() -> parser.parseInteger(" "))
                .isInstanceOf(IllegalArgumentException.class);
    }
}