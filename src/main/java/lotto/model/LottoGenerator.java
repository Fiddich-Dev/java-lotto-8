package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.List;

public class LottoGenerator {
    public static final int LOTTO_NUMBER_COUNT = 6;
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;

    public static Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return new Lotto(numbers);
    }
}
