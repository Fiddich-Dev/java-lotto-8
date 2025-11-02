package lotto.model;

import lotto.controller.dto.PurchaseResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    @DisplayName("로또 번호가 6개보다 적을때")
    void lottoNumbersCountTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호가 범위를 벗어날때")
    void lottoNumbersTest() {
        Assertions.assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 47)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방어적 복사 테스트")
    void defensiveCopyTest() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int count = numbers.size();
        Lotto lotto = new Lotto(numbers);

        // when
        numbers.add(7);

        // then
        Assertions.assertThat(lotto.getNumbers().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("불변객체 테스트")
    void immutableTest() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto = new Lotto(numbers);

        // when, then
        Assertions.assertThatThrownBy(() ->
                        lotto.getNumbers().add(7)
                )
                .isInstanceOf(UnsupportedOperationException.class);
    }
}
