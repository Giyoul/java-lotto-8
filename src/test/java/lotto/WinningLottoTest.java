package lotto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
    @Test
    void 보너스_번호가_포함되어_있는지_정확하게_확인한다(){
        // Given
        WinningLotto winningLotto = new WinningLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);
        Lotto userLotto = new Lotto(List.of(7, 8, 9, 10, 11, 12));

        // When
        boolean result = winningLotto.hasBonusNumber(userLotto);

        // Then
        assertTrue(result, "보너스 번호가 포함되어 있는지 정확하게 확인한다");
    }
}
