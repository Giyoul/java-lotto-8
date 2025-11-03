package lotto;

import java.util.HashSet;
import java.util.List;

/**
 * Represents a lotto ticket with 6 numbers.
 */
public class Lotto {
    private static final Integer LOTTO_NUMBER_COUNT = 6;
    private static final Integer MIN_LOTTO_NUMBER = 1;
    private static final Integer MAX_LOTTO_NUMBER = 45;
    private static final String NUMBER_SEPARATOR = ", ";
    private static final String LOTTO_FORMAT_START = "[";
    private static final String LOTTO_FORMAT_END = "]\n";

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateBoundary(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public String buildLottoNumberMessage(){
        return LOTTO_FORMAT_START + String.join(NUMBER_SEPARATOR,
                numbers.stream()
                        .map(String::valueOf)
                        .toList()
        ) + LOTTO_FORMAT_END;
    }

    public int countMatchNumbers(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateBoundary(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }
}
