package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    public static final String PURCHASE_COUNT_PRINT_FORMAT = "개를 구매했습니다.";
    private static final int PERCENT = 100;
    private static final double ROUNDING_FACTOR = 100.0;

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


    public Map<LottoStatistics, Long> calculateStatistics(WinningLotto winningLotto) {
        Map<LottoStatistics, Long> rankCounts = initializeRankCounts();

        for (Lotto userLotto : lotto) {
            int matchCount = winningLotto.countMatchNumbers(userLotto);
            boolean hasBonus = winningLotto.hasBonusNumber(userLotto);

            LottoStatistics rank = LottoStatistics.valueOf(matchCount, hasBonus);
            rankCounts.put(rank, rankCounts.get(rank) + 1);
        }

        return rankCounts;
    }

    public double calculatePrizeRate(long totalPrize) {
        double profitRate = (double) totalPrize / purchaseAmount;
        double percentage = profitRate * PERCENT;
        return Math.round(percentage * ROUNDING_FACTOR) / ROUNDING_FACTOR;
    }

    private Map<LottoStatistics, Long> initializeRankCounts() {
        Map<LottoStatistics, Long> rankCounts = new EnumMap<>(LottoStatistics.class);
        for (LottoStatistics rank : LottoStatistics.values()) {
            rankCounts.put(rank, 0L);
        }
        return rankCounts;
    }
}
