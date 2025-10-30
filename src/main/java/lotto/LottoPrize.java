package lotto;

import java.util.Map;

public class LottoPrize {

    private static final Map<Integer, Integer> PRIZE_MAP = Map.of(
            1, 2_000_000_000,
            2, 30_000_000,
            3, 1_500_000,
            4, 50_000,
            5, 5_000
    );



    public static int getPrize(int matchCount, boolean bonusMatched) {
        int rank = getRank(matchCount, bonusMatched);
        return PRIZE_MAP.getOrDefault(rank, 0);
    }

    public static int getPrize(int rank) {
        return PRIZE_MAP.getOrDefault(rank, 0);
    }

    public static int getRank(int matchCount, boolean bonusMatched) {
        if (matchCount == 6) {
            return 1;
        }
        if (matchCount == 5 && bonusMatched) {
            return 2;
        }
        if (matchCount == 5) {
            return 3;
        }
        if (matchCount == 4) {
            return 4;
        }
        if (matchCount == 3) {
            return 5;
        }
        return 0;
    }

}
