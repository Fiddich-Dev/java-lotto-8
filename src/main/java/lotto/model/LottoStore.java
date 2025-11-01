package lotto.model;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    private static final String ERROR_AMOUNT_NOT_POSITIVE = "[ERROR] 금액은 0보다 커야 합니다.";
    private static final String ERROR_AMOUNT_NOT_MULTIPLE_OF_PRICE = "[ERROR] 금액은 1,000원 단위로 입력해야 합니다.";

    private final static BigInteger PRICE = BigInteger.valueOf(1000);

    public List<Lotto> buy(BigInteger amount) {
        validatePurchaseAmount(amount);
        BigInteger count = amount.divide(PRICE);

        List<Lotto> lottos = new ArrayList<>();

        BigInteger i = BigInteger.ZERO;
        while (i.compareTo(count) < 0) {
            lottos.add(LottoGenerator.generate());
            i = i.add(BigInteger.ONE);
        }
        return lottos;
    }

    private void validatePurchaseAmount(BigInteger amount) {
        if (amount.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException(ERROR_AMOUNT_NOT_POSITIVE);
        }
        if (!amount.remainder(PRICE).equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException(ERROR_AMOUNT_NOT_MULTIPLE_OF_PRICE);
        }
    }
}
