package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 다른_로또와_비교해서_일치하는_번호_개수를_정확하게_반환한다() {
        // Given
        Lotto lotto1 = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto lotto2 = new Lotto(List.of(1, 2, 3, 10, 11, 12));

        // When
        int result = lotto1.countMatchNumbers(lotto2);

        // Then
        assertEquals(result, 3, "다른 로또 번호와 비교해서 일치하는 번호 개수를 정확하게 반환한다.");
    }

    @Test
    void 로또_번호가_1부터_45_사이의_숫자가_아닌_경우_예외가_발생한다() {
        // Given
        List<Integer> list = List.of(1, 2, 3, 4, 5, 46);

        // When & Then
        assertThrows(IllegalArgumentException.class,
                () -> new Lotto(list)
        );
    }
}
