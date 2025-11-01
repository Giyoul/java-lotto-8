package lotto;

import java.util.List;

public class Lottos {
    public static final String PURCHASE_COUNT_PRINT_FORMAT = "개를 구매했습니다.";

    private final Long purchaseAmount;
    private final Long purchaseCount;
    private final List<Lotto> lotto;

    public Lottos(Long purchaseAmount, Long purchaseCount, List<Lotto> purchasedLotto) {
        this.purchaseAmount = purchaseAmount;
        this.purchaseCount = purchaseCount;
        this.lotto = purchasedLotto;
    }

    public String purchseCountMessage(){
        return "\n" + purchaseCount + PURCHASE_COUNT_PRINT_FORMAT;
    }

    public String lottoNumberMessage() {
        return String.join("", lotto.stream()
                .map(Lotto::buildLottoNumberMessage)
                .toList());
    }
}
