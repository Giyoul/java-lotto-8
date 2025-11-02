package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Nested
    class getLottoNumbersTest{
        private List<Integer> lottoNumbers;

        @BeforeEach
        void setUp() {
            // Given & When
            lottoNumbers = lottoService.getLottoNumbers();
        }

        @Test
        void 로또는_6개의_숫자를_가진다(){
            // Then
            assertEquals(6, lottoNumbers.size(), "로또는 6개의 숫자여야 한다");
        }

        @Test
        void 로또는_중복된_숫자를_갖지_않는다() {
            // Then
            Set<Integer> uniqueNumbers = new HashSet<>(lottoNumbers);
            assertEquals(6, uniqueNumbers.size(), "로또 숫자는 중복되면 안된다");
        }

        @Test
        void 로또_숫자는_1부터_45_사이에_있다() {
            // Then
            assertTrue(lottoNumbers.stream().allMatch(n -> n >= 1 && n <= 45), "로또 숫자는 1부터 45 사이여야 한다");
        }
    }

    @Test
    @DisplayName("정상 금액 구매 시 로또 개수를 정확히 계산한다.")
    void calculate_LottoCount_ExactDivision(){
        // Given
        Long purchaseAmount = 5000L;

        // When
        Long purchaseCount = lottoService.calculateLottoCount(purchaseAmount);

        // Then
        assertThat(purchaseCount).isEqualTo(5);
    }

    @Nested
    class generateMatchCountMessageTest {
        @Test
        void 모든_등수_포함한_메시지를_생성한다() {
            // Given
            Lotto lotto3 = new Lotto(List.of(1, 2, 3, 40, 41, 42));
            Lotto lotto4 = new Lotto(List.of(1, 2, 3, 4, 41, 42));
            Lotto lotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 42));
            Lotto lotto5Bonus = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Lotto lotto6 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            List<Lotto> lottos = List.of(lotto3, lotto4, lotto5, lotto5Bonus, lotto6);

            lottoService.purchaseLotto(5000L);
            lottoService.saveWinnerNumbers(List.of(1, 2, 3, 4, 5, 6 ));
            lottoService.saveBonusNumber(7);

            // When
            String result = lottoService.generateStatisticMessage();

            // Then
            assertThat(result).contains("3개 일치 (5,000원) - 1개");
            assertThat(result).contains("4개 일치 (50,000원) - 1개");
            assertThat(result).contains("5개 일치 (1,500,000원) - 1개");
            assertThat(result).contains("5개 일치, 보너스 볼 일치 (30,000,000원) - 1개");
            assertThat(result).contains("6개 일치 (2,000,000,000원) - 1개");
        }

        @Test
        void 메시지_헤더와_구분선이_포항된다() {
            // Given
            lottoService.purchaseLotto(1000L);
            lottoService.saveWinnerNumbers(List.of(1, 2, 3, 4, 5, 6 ));
            lottoService.saveBonusNumber(7);

            // When
            String result = lottoService.generateStatisticMessage();

            // Then
            assertThat(result).contains("당첨 통계");
            assertThat(result).contains("---");
        }
    }
}
