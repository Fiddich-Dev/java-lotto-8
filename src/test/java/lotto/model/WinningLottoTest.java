package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class WinningLottoTest {
    @Test
    @DisplayName("당첨 로또 번호 개수가 6개가 넘으면 예외 발생")
    void overWinningLottoNumbersCount() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6, 7), 8))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 번호 개수가 6개보다 적으면 예외 발생")
    void underWinningLottoNumbersCount() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외 발생")
    void duplicateBonusNumber() {
        assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 6))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("당첨 로또 번호가 범위를 벗어나면 예외 발생")
    void winningLottoNumbersTest() {
        Assertions.assertThatThrownBy(() -> new WinningLotto(List.of(1, 2, 3, 4, 5, 47), 7))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("방어적 복사 테스트")
    void defensiveCopyTest() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        int count = numbers.size();
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        // when
        numbers.add(7);

        // then
        Assertions.assertThat(winningLotto.getNumbers().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("불변객체 테스트")
    void immutableTest() {
        // given
        List<Integer> numbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 10;
        WinningLotto winningLotto = new WinningLotto(numbers, bonusNumber);

        // when, then
        Assertions.assertThatThrownBy(() ->
                        winningLotto.getNumbers().add(7)
                )
                .isInstanceOf(UnsupportedOperationException.class);
    }
}