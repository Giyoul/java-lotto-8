package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
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
}
