package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class LottoResultTest {
    WinningLotto winningLotto = new WinningLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    Lotto first = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    Lotto second = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    Lotto third = new Lotto(List.of(1, 2, 3, 4, 5, 8));
    Lotto fourth = new Lotto(List.of(1, 2, 3, 4, 8, 9));
    Lotto fifth = new Lotto(List.of(1, 2, 3, 9, 10, 11));
    Lotto none = new Lotto(List.of(1, 2, 10, 20, 30, 40));

    @Test
    @DisplayName("1등 로또 1개일 때 총 상금 계산")
    void firstPrizeTest() {
        // given
        List<Lotto> lottos = List.of(first);

        // when
        Map<LottoRank, Integer> result = LottoResult.of(lottos, winningLotto);

        // then
        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(LottoResult.calculateTotalPrize(lottos, winningLotto))
                .isEqualTo(BigInteger.valueOf(LottoRank.FIRST.getPrize()));
    }

    @Test
    @DisplayName("2등 로또 1개일 때 총 상금 계산")
    void secondPrizeTest() {
        // given
        List<Lotto> lottos = List.of(second);

        // when
        Map<LottoRank, Integer> result = LottoResult.of(lottos, winningLotto);

        // then
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(1);
        assertThat(LottoResult.calculateTotalPrize(lottos, winningLotto))
                .isEqualTo(BigInteger.valueOf(LottoRank.SECOND.getPrize()));
    }

    @Test
    @DisplayName("3등 로또 1개일 때 총 상금 계산")
    void thirdPrizeTest() {
        // given
        List<Lotto> lottos = List.of(third);

        // when
        Map<LottoRank, Integer> result = LottoResult.of(lottos, winningLotto);

        // then
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(1);
        assertThat(LottoResult.calculateTotalPrize(lottos, winningLotto))
                .isEqualTo(BigInteger.valueOf(LottoRank.THIRD.getPrize()));
    }

    @Test
    @DisplayName("4등 로또 1개일 때 총 상금 계산")
    void fourthPrizeTest() {
        // given
        List<Lotto> lottos = List.of(fourth);

        // when
        Map<LottoRank, Integer> result = LottoResult.of(lottos, winningLotto);

        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(LottoResult.calculateTotalPrize(lottos, winningLotto))
                .isEqualTo(BigInteger.valueOf(LottoRank.FOURTH.getPrize()));
    }

    @Test
    @DisplayName("5등 로또 1개일 때 총 상금 계산")
    void fifthPrizeTest() {
        // given
        List<Lotto> lottos = List.of(fifth);

        // when
        Map<LottoRank, Integer> result = LottoResult.of(lottos, winningLotto);

        // then
        assertThat(result.get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(LottoResult.calculateTotalPrize(lottos, winningLotto))
                .isEqualTo(BigInteger.valueOf(LottoRank.FIFTH.getPrize()));
    }

    @Test
    @DisplayName("여러 장의 로또 결과 총 상금 계산")
    void multipleLottosResultTest() {
        // given
        List<Lotto> lottos = List.of(
                first, // 1등
                second, second, // 2등
                third, third, // 3등
                fourth, // 4등
                fifth, fifth, // 5등
                none, none, none, none // 낙첨
        );
        BigInteger expectedTotal = BigInteger.valueOf(
                2_000_000_000L + 30_000_000L*2 + 1_500_000L*2 + 50_000L + 5_000L*2
        );

        // when
        Map<LottoRank, Integer> result = LottoResult.of(lottos, winningLotto);

        // then
        assertThat(result.get(LottoRank.FIRST)).isEqualTo(1);
        assertThat(result.get(LottoRank.SECOND)).isEqualTo(2);
        assertThat(result.get(LottoRank.THIRD)).isEqualTo(2);
        assertThat(result.get(LottoRank.FOURTH)).isEqualTo(1);
        assertThat(result.get(LottoRank.FIFTH)).isEqualTo(2);
        assertThat(result.get(LottoRank.NONE)).isEqualTo(4);
        assertThat(LottoResult.calculateTotalPrize(lottos, winningLotto))
                .isEqualTo(expectedTotal);
    }
}