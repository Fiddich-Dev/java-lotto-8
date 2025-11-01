package lotto.model;

import java.util.Arrays;
import java.util.Comparator;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(-1, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final long prize;

    LottoRank(int matchCount, boolean requiresBonus, long prize) {
        this.matchCount = matchCount;
        this.requiresBonus = requiresBonus;
        this.prize = prize;
    }

    public static LottoRank of(int matchCount, boolean bonusMatch) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && lottoRank.requiresBonus == bonusMatch) {
                return lottoRank;
            }
        }
        for (LottoRank lottoRank : values()) {
            if (lottoRank.matchCount == matchCount && !lottoRank.requiresBonus) {
                return lottoRank;
            }
        }
        return NONE;
    }

    public static LottoRank[] validRanks() {
        return validRanks(BY_PRIZE_DESC);
    }

    public static LottoRank[] validRanks(Comparator<LottoRank> comparator) {
        return Arrays.stream(values())
                .filter(rank -> rank != NONE)
                .sorted(comparator)
                .toArray(LottoRank[]::new);
    }

    public static final Comparator<LottoRank> BY_PRIZE_ASC =
            Comparator.comparingLong(LottoRank::getPrize);

    public static final Comparator<LottoRank> BY_PRIZE_DESC =
            Comparator.comparingLong(LottoRank::getPrize).reversed();

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public long getPrize() {
        return prize;
    }
}
