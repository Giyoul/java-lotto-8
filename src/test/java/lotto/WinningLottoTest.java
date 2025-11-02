package lotto;

import static org.junit.jupiter.api.Assertions.assertThrows;
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

    @Test
    void 보너스_번호가_1부터_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
        // Given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Integer input = 46;

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> new WinningLotto(lotto, input)
        );
    }
}
