package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public int countMatchNumbers(Lotto userLotto) {
        return this.lotto.countMatchNumbers(userLotto);
    }

    public boolean hasBonusNumber(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }
}
