package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoStore {
    private final static BigInteger PRICE = BigInteger.valueOf(1000);

    public List<Lotto> buy(BigInteger amount) {
        validatePurchaseAmount(amount);
        BigInteger count = amount.divide(PRICE);

        List<Lotto> lottos = new ArrayList<>();

        BigInteger i = BigInteger.ZERO;
        while (i.compareTo(count) < 0) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
            i = i.add(BigInteger.ONE);
        }
        return lottos;
    }

    private void validatePurchaseAmount(BigInteger amount) {
        if (amount.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 0보다 커야 합니다.");
        }
        if (!amount.remainder(PRICE).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("[ERROR] 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }
}
