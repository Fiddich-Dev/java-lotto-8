package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoStoreTest {

    @Test
    @DisplayName("금액이 1000원 단위일 때 정상적으로 로또를 구매할 수 있다")
    void buy_validAmount_createsCorrectNumberOfLottos() {
        // given
        BigInteger amount = BigInteger.valueOf(5000);

        // when
        List<Lotto> lottos = LottoStore.buy(amount);

        // then
        assertThat(lottos).hasSize(5);
        assertThat(lottos).allSatisfy(lotto ->
                assertThat(lotto.getNumbers()).hasSize(6)
        );
    }

    @Test
    @DisplayName("금액이 0원 이하이면 예외 발생")
    void buy_zeroOrNegativeAmount_throwsException() {
        // given
        BigInteger zeroAmount = BigInteger.ZERO;
        BigInteger negativeAmount = BigInteger.valueOf(-1000);

        // when, then
        assertThatThrownBy(() -> LottoStore.buy(zeroAmount))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> LottoStore.buy(negativeAmount))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("금액이 1000원 단위가 아니면 예외 발생")
    void buy_notMultipleOfPrice_throwsException() {
        // given
        BigInteger amount = BigInteger.valueOf(2500);

        // when, then
        assertThatThrownBy(() -> LottoStore.buy(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}