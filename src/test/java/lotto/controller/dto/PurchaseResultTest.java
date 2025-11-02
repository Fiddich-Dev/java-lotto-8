package lotto.controller.dto;

import lotto.model.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

class PurchaseResultTest {
    private List<Lotto> lottos;
    private BigInteger amount;
    private BigInteger price;
    private int count;

    @BeforeEach
    void setUp() {
        amount = BigInteger.valueOf(10000);
        price = BigInteger.valueOf(1000);
        count = amount.divide(price).intValue();
        lottos = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));
        }
    }

    @Test
    @DisplayName("방어적 복사 테스트")
    void defensiveCopyTest() {
        // given
        // (setUp은 자동 실행됨)

        // when
        PurchaseResult purchaseResult = new PurchaseResult(BigInteger.valueOf(9000), lottos);
        lottos.add(new Lotto(List.of(1, 2, 3, 4, 5, 6)));

        // then
        Assertions.assertThat(purchaseResult.lottos().size()).isEqualTo(count);
    }

    @Test
    @DisplayName("불변객체 테스트")
    void immutableTest() {
        // given
        // (setUp은 자동 실행됨)

        // when
        PurchaseResult purchaseResult = new PurchaseResult(BigInteger.valueOf(9000), lottos);

        // then
        Assertions.assertThatThrownBy(() ->
                        purchaseResult.lottos().add(new Lotto(List.of(1, 2, 3, 4, 5, 6)))
                )
                .isInstanceOf(UnsupportedOperationException.class);
    }
}