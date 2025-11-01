package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    private final InputView inputView = new InputView();

    @Nested
    @DisplayName("당첨_번호_정상_입력_테스트")
    class getWinnerNumbersTest {
        private List<Integer> numbers;

        @BeforeEach
        void setUp() {
            // Given
            String winnerNumber = "1,2,3,4,5,6";

            // When
            numbers = inputView.parseWinnerNumber(winnerNumber);
        }

        @Test
        void 당첨_입력은_6개여야_합니다() {
            // Then
            assertThat(numbers.size()).isEqualTo(6);
        }

        @Test
        void 당첨_입력_번호는_중복되면_안됩니다() {
            // Then
            Set<Integer> uniqueNumbers = new HashSet<>(numbers);
            assertEquals(6, uniqueNumbers.size(), "로또 숫자는 중복되면 안된다");
        }

        @Test
        void 로또_숫자는_1부터_45_사이에_있습니다() {
            // Then
            assertThat(numbers.stream().allMatch(num -> num >= 1 && num <= 45)).isEqualTo(true);
        }
    }
}
