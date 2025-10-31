package lotto.model;

public enum LottoRank {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(-1, false, 0);

    private final int matchCount;
    private final boolean requiresBonus;
    private final int prize;

    LottoRank(int matchCount, boolean requiresBonus, int prize) {
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

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isRequiresBonus() {
        return requiresBonus;
    }

    public int getPrize() {
        return prize;
    }
}
