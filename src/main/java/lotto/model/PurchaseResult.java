package lotto.model;

import java.math.BigInteger;
import java.util.List;

public class PurchaseResult {

    private final BigInteger amount;
    private final List<Lotto> lottos;

    public PurchaseResult(BigInteger amount, List<Lotto> lottos) {
        this.amount = amount;
        this.lottos = lottos;
    }

    public BigInteger amount() {
        return amount;
    }

    public List<Lotto> lottos() {
        return lottos;
    }
}
