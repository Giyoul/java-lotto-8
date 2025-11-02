package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class LottosTest {
    @Nested
    @DisplayName("calculateStatistics 테스트")
    class CalculateStatisticsTest {
        @Test
        void 통계_집계가_5개_일치한다() {
            // Given
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 40, 41, 42));
            List<Lotto> lottos = List.of(userLotto);
            Lottos lottoCollection = new Lottos(1000L, 1L, lottos);
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 40, 41, 22)), 7
            );

            // When
            Map<LottoStatistics, Long> statistics = lottoCollection.calculateStatistics(winningLotto);

            // Then
            assertEquals(0, statistics.get(LottoStatistics.THREE));
            assertEquals(0, statistics.get(LottoStatistics.FOUR));
            assertEquals(1, statistics.get(LottoStatistics.FIVE));
            assertEquals(0, statistics.get(LottoStatistics.FIVE_BONUS));
            assertEquals(0, statistics.get(LottoStatistics.SIX));
        }

        @Test
        void 통계_집계가_5개와_보너스가_일치한다() {
            // Given
            Lotto userLotto = new Lotto(List.of(1, 2, 3, 40, 41, 42));
            List<Lotto> lottos = List.of(userLotto);
            Lottos lottoCollection = new Lottos(1000L, 1L, lottos);
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 40, 41, 22)), 42
            );

            // When
            Map<LottoStatistics, Long> statistics = lottoCollection.calculateStatistics(winningLotto);

            // Then
            assertEquals(0, statistics.get(LottoStatistics.FIVE));
            assertEquals(1, statistics.get(LottoStatistics.FIVE_BONUS));
        }

        @Test
        void 여러_로또의_등수가_정확하게_집계된다() {
            // Given
            Lotto userLotto1 = new Lotto(List.of(1, 2, 3, 40, 41, 42));
            Lotto userLotto2 = new Lotto(List.of(1, 2, 3, 4, 41, 42));
            Lotto userLotto3 = new Lotto(List.of(1, 2, 3, 4, 5, 42));
            Lotto userLotto4 = new Lotto(List.of(1, 2, 3, 4, 5, 7));
            Lotto userLotto5 = new Lotto(List.of(1, 2, 3, 4, 5, 6));

            List<Lotto> lottos = List.of(userLotto1, userLotto2, userLotto3, userLotto4, userLotto5);
            Lottos lottoCollection = new Lottos(5000L, 5L, lottos);
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
            );

            // When
            Map<LottoStatistics, Long> statistics = lottoCollection.calculateStatistics(winningLotto);

            // Then
            assertEquals(1, statistics.get(LottoStatistics.THREE));
            assertEquals(1, statistics.get(LottoStatistics.FOUR));
            assertEquals(1, statistics.get(LottoStatistics.FIVE));
            assertEquals(1, statistics.get(LottoStatistics.FIVE_BONUS));
            assertEquals(1, statistics.get(LottoStatistics.SIX));
        }

        @Test
        void 같은_등수의_로또가_여러개일때_정확하게_집계된다() {
            // Given
            Lotto userLotto1 = new Lotto(List.of(1, 2, 3, 40, 41, 42));
            Lotto userLotto2 = new Lotto(List.of(1, 2, 3, 43, 41, 42));
            Lotto userLotto3 = new Lotto(List.of(1, 2, 3, 41, 45, 42));


            List<Lotto> lottos = List.of(userLotto1, userLotto2, userLotto3);
            Lottos lottoCollection = new Lottos(3000L, 3L, lottos);
            WinningLotto winningLotto = new WinningLotto(
                    new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7
            );

            // When
            Map<LottoStatistics, Long> statistics = lottoCollection.calculateStatistics(winningLotto);

            // Then
            assertEquals(3, statistics.get(LottoStatistics.THREE));
            assertEquals(0, statistics.get(LottoStatistics.FOUR));
            assertEquals(0, statistics.get(LottoStatistics.FIVE));
            assertEquals(0, statistics.get(LottoStatistics.FIVE_BONUS));
            assertEquals(0, statistics.get(LottoStatistics.SIX));
        }
    }
}
