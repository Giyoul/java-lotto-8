package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validateBoundary(bonusNumber);
        validateDuplicate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateDuplicate(Integer bonusNumber) {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalStateException("[ERROR] 보너스 번호는 로또 번호와 중복되는 숫자가 있으면 안됩니다.");
        }
    }

    private void validateBoundary(Integer bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int countMatchNumbers(Lotto userLotto) {
        return this.lotto.countMatchNumbers(userLotto);
    }

    public boolean hasBonusNumber(Lotto userLotto) {
        return userLotto.contains(bonusNumber);
    }
}
