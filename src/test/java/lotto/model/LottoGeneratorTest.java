package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;


class LottoGeneratorTest {

    @Test
    @DisplayName("로또 생성기는 숫자를 오름차순으로 만들어 반환한다")
    void lottoNumbersSortedTest() {
        // given
        Lotto lotto = LottoGenerator.generate();

        // when
        List<Integer> numbers = lotto.getNumbers();

        // then
        Assertions.assertThat(numbers).isSorted();
    }
}