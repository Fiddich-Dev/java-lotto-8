package lotto.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;


class LottoRankTest {

    @Test
    @DisplayName("낙첨을 제외한 순위만 반환한다")
    void selectValidRanks() {
        // given
        List<LottoRank> lottoRanks = LottoRank.validRanks();

        // when, then
        Assertions.assertThat(lottoRanks).doesNotContain(LottoRank.NONE);
    }

    @Test
    @DisplayName("낙첨을 제외한 순위를 오름차순으로 반환한다")
    void selectValidRanksASC() {
        // given
        List<LottoRank> lottoRanks = LottoRank.validRanks(LottoRank.BY_PRIZE_ASC);

        // when, then
        Assertions.assertThat(lottoRanks)
                .isSortedAccordingTo(LottoRank.BY_PRIZE_ASC);
    }

    @Test
    @DisplayName("(기본값) 낙첨을 제외한 순위를 내림차순으로 반환한다")
    void selectValidRanksDESC() {
        // given
        List<LottoRank> lottoRanks = LottoRank.validRanks();

        // when, then
        Assertions.assertThat(lottoRanks)
                .isSortedAccordingTo(LottoRank.BY_PRIZE_DESC);
    }

    @ParameterizedTest
    @CsvSource({
            "6,true,FIRST",
            "5,true,SECOND",
            "5,false,THIRD",
            "4,true,FOURTH",
            "3,false,FIFTH",
            "2,true,NONE",
            "0,true,NONE"
    })
    @DisplayName("맞춘 번호개수에 따른 당첨 결과 테스트")
    void of_returns_correct_rank(int matchCount, boolean bonus, LottoRank expected) {
        Assertions.assertThat(LottoRank.of(matchCount, bonus))
                .isEqualTo(expected);
    }
}