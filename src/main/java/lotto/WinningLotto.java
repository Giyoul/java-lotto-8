package lotto;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(List<Integer> lottoNumbers) {
        this.lotto = new Lotto(lottoNumbers);
        bonusNumber = null;
    }

    public WinningLotto(List<Integer> lottoNumbers, Integer bonusNumber) {
        this.lotto = new Lotto(lottoNumbers);
        this.bonusNumber = bonusNumber;
    }
}
