package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

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


    public Map<LottoStatistics, Integer> calculateStatistics(WinningLotto winningLotto) {
        Map<LottoStatistics, Integer> rankCounts = new EnumMap<>(LottoStatistics.class);

        for (LottoStatistics rank : LottoStatistics.values()) {
            rankCounts.put(rank, 0);
        }

        for (Lotto userLotto : lotto) {
            int matchCount = winningLotto.countMatchNumbers(userLotto);
            boolean hasBonus = winningLotto.hasBonusNumber(userLotto);

            LottoStatistics rank = LottoStatistics.valueOf(matchCount, hasBonus);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        return rankCounts;
    }
}
