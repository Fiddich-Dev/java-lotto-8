package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성기는 숫자를" + LottoGenerator.LOTTO_NUMBER_COUNT + "개 반환한다")
    void lottoNumbersCountTest() {
        // given, when
        Lotto lotto = LottoGenerator.generate();
        List<Integer> numbers = lotto.getNumbers();

        // then
        Assertions.assertThat(numbers).hasSize(LottoGenerator.LOTTO_NUMBER_COUNT);
    }

    @Test
    @DisplayName("로또 생성기에서 나올 수 있는 수의 범위는 " + LottoGenerator.MIN_NUMBER + ", " + LottoGenerator.MAX_NUMBER + " 사이다")
    void lottoNumbersRangeTest() {
        // given, when
        Lotto lotto = LottoGenerator.generate();
        List<Integer> numbers = lotto.getNumbers();

        // then
        int min = numbers.stream().mapToInt(Integer::intValue).min().orElseThrow();
        int max = numbers.stream().mapToInt(Integer::intValue).max().orElseThrow();

        // then
        Assertions.assertThat(min).isGreaterThanOrEqualTo(LottoGenerator.MIN_NUMBER);
        Assertions.assertThat(max).isLessThanOrEqualTo(LottoGenerator.MAX_NUMBER);
    }
}