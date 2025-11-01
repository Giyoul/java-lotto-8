package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoService {
    private static final long LOTTO_PRICE = 1000L;

    private Lottos lottos;
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
        this.winningLotto = new WinningLotto(winnerNumbers);
    }
}
