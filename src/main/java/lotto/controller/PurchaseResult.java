package lotto.controller;

import lotto.model.Lotto;

import java.math.BigInteger;
import java.util.List;

public record PurchaseResult(BigInteger amount, List<Lotto> lottos) {
    public PurchaseResult {
        lottos = List.copyOf(lottos);
    }
}
