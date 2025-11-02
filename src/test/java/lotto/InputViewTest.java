package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Nested
    @DisplayName("구입 금액 입력 테스트")
    class purchaseAmountValidationTest {

        @Nested
        @DisplayName("빈 입력 테스트")
        class emptyInputTest {
            @Test
            void 입력받은_금액은_빈_입력일_경우_IllegalArgumentException을_던집니다() {
                // Given
                String input = "";

                // When & Then
                assertThrows(IllegalArgumentException.class, () -> {
                    inputView.emptyInputCheck(input);
                });
            }

            @Test
            void 입력받은_금액은_빈_입력일_경우_에러메시지를_출력합니다() {
                // Given
                String input = "";

                // When
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> inputView.emptyInputCheck(input)
                );

                // Then
                assertThat(exception.getMessage()).isEqualTo("[ERROR] 구입 금액은 빈 입력이면 안됩니다.");
            }
        }

        @Nested
        @DisplayName("입력이 숫자가 맞는지 테스트")
        class numberInputTest {
            @Test
            void 입력받은_금액이_숫자가_아닐_경우_NumberFormatException을_던집니다() {
                // Given
                String input = "a";

                // When & Then
                assertThrows(NumberFormatException.class, () -> {
                    inputView.numberFormatCheck(input);
                });
            }

            @Test
            void 입력받은_금액이_숫자가_아닐_경우_에러메시지를_출력합니다() {
                // Given
                String input = "a";

                // When
                IllegalArgumentException exception = assertThrows(
                        NumberFormatException.class,
                        () -> inputView.numberFormatCheck(input)
                );

                // Then
                assertThat(exception.getMessage()).isEqualTo("[ERROR] 구입 금액은 숫자여야 합니다.");
            }
        }

        @Nested
        @DisplayName("숫자가 1000원 이상인지 테스트")
        class negativeNumberCheckTest {
            @Test
            void 입력받은_금액이_음수일_경우_IllegalArgumentException을_던집니다() {
                // Given
                Long input = -10L;

                // When & Then
                assertThrows(IllegalArgumentException.class, () -> {
                    inputView.numberBoundaryCheck(input);
                });
            }

            @Test
            void 입력받은_금액이_1000원_미만일_경우_IllegalArgumentException을_던집니다() {
                // Given
                Long input = 500L;

                // When & Then
                assertThrows(IllegalArgumentException.class, () -> {
                    inputView.numberBoundaryCheck(input);
                });
            }

            @Test
            void 입력받은_금액이_음수일_경우_에러메시지를_출력합니다() {
                // Given
                Long input = -10L;

                // When
                IllegalArgumentException exception = assertThrows(
                        IllegalArgumentException.class,
                        () -> inputView.numberBoundaryCheck(input)
                );

                // Then
                assertThat(exception.getMessage()).isEqualTo("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
            }
        }
    }
}
