package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LottoService {
    private static final long LOTTO_PRICE = 1000L;
    private static final String MATCH_COUNT_PRINT_FORMAT = "\n당첨 통계\n---\n";
    private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";

    private Lottos lottos;
    private Lotto winnerLotto;
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

    public void saveWinnerNumbers(List<Integer> winnerNumbers) {
        this.winnerLotto = new Lotto(winnerNumbers);
    }

    public void saveBonusNumber(Integer bonusNumber) {
        this.winningLotto = new WinningLotto(winnerLotto, bonusNumber);
    }

    public String generateStatisticsMessage() {
        Map<LottoStatistics, Long> rankStatistics = lottos.calculateStatistics(winningLotto);
        String matchCountMessage = generateMatchCountMessage(rankStatistics);
        String profitMessage = generateProfitMessage(rankStatistics);

        return matchCountMessage + profitMessage;
    }

    List<Integer> getLottoNumbers(){
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    Long calculateLottoCount(Long purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    String getPurchaseCountMessage(){
        return lottos.purchaseCountMessage();
    }

    String getLottoNumber(){
        return lottos.lottoNumberMessage();
    }

    void purchaseLotto(Long purchaseAmount, List<Lotto> lottos) {
        Long lottoCount = (long) lottos.size();
        this.lottos = new Lottos(purchaseAmount, lottoCount, lottos);
    }

    private String generateMatchCountMessage(Map<LottoStatistics, Long> statistics) {
        StringBuilder message = new StringBuilder(MATCH_COUNT_PRINT_FORMAT);

        for (LottoStatistics rank : LottoStatistics.getRanks()) {
            long count = statistics.get(rank);
            message.append(String.format("%s - %d개\n", rank.getDescriptionMessage(), count));
        }
        return message.toString();
    }

    private String generateProfitMessage(Map<LottoStatistics, Long> statistics) {
        long totalPrize = calculateTotalPrize(statistics);
        double profitRate = lottos.calculatePrizeRate(totalPrize);

        return String.format(PROFIT_RATE_FORMAT, profitRate);
    }

    private long calculateTotalPrize(Map<LottoStatistics, Long> statistics) {
        return statistics.entrySet().stream()
                .mapToLong(entry -> entry.getKey().getTotalPrize(entry.getValue()))
                .sum();
    }
}
