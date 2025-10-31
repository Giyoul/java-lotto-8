package lotto;

import java.util.List;

public class Lottos {
    private final Long purchaseAmount;
    private final Long purchaseCount;
    private final List<Lotto> lottos;

    public Lottos(Long purchaseAmount, Long purchaseCount, List<Lotto> purchasedLotto) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseCount;
        this.lottos = purchasedLotto;
    }
}
