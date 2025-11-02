package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final long LOTTO_PRICE = 1000L;
    private static final String MATCH_COUNT_PRINT_FORMAT = "당첨 통계\n---\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private Lottos lottos;
    private Lotto tempWinnerLotto;
    private WinningLotto winningLotto;

    public void purchaseLotto(Long purchaseAmount){
        Long lottoCount = calculateLottoCount(purchaseAmount);

        List<Lotto> purchasedLotto = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = getLottoNumbers();
            purchasedLotto.add(new Lotto(numbers));
        }

        this.lottos = new Lottos(purchaseAmount, lottoCount, purchasedLotto);
    }

    List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    Long calculateLottoCount(Long purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    String getPurchaseCountMessage(){
        return lottos.purchseCountMessage();
    }

    String getLottoNumber(){
        return lottos.lottoNumberMessage();
    }
    public void saveWinnerNumbers(List<Integer> winnerNumbers) {
        this.tempWinnerLotto = new Lotto(winnerNumbers);
    }

    public void saveBonusNumber(Integer bonusNumber) {
        this.winningLotto = new WinningLotto(tempWinnerLotto, bonusNumber);
    }

    public String generateStatisticMessage() {
        Map<LottoStatistics, Long> statistics = lottos.calculateStatistics(winningLotto);
        String matchCountMessage = generateMatchCountMessage(statistics);
        String profitMessage = generateProfitMessage(statistics);

        return matchCountMessage + profitMessage;
    }

    private String generateMatchCountMessage(Map<LottoStatistics, Long> statistics) {
        StringBuilder sb = new StringBuilder(MATCH_COUNT_PRINT_FORMAT);

        for (LottoStatistics rank : LottoStatistics.getRanks()) {
            long count = statistics.get(rank);
            sb.append(String.format("%s - %d개\n", rank.getDescriptionMessage(), count));
        }
        return sb.toString();
    }

    private String generateProfitMessage(Map<LottoStatistics, Long> statistics) {
        long totalPrize = calculateTotalPrize(statistics);
        double profitRate = lottos.calculatePrizeRate(totalPrize);

        return String.format(PROFIT_RATE_FORMAT, profitRate);
    }

    private long calculateTotalPrize(Map<LottoStatistics, Long> statistics) {
        return statistics.entrySet().stream()
                .mapToLong(prize -> prize.getKey().getTotalPrize(prize.getValue()))
                .sum();
    }

    void purchaseLotto(Long purchaseAmount, List<Lotto> lottos) {
        Long lottoCount = (long) lottos.size();
        this.lottos = new Lottos(purchaseAmount, lottoCount, lottos);
    }
}
