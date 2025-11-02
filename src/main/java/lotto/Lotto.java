package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateBoundary(numbers);
        this.numbers = numbers;
    }

    private void validateBoundary(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public String buildLottoNumberMessage(){
        return "[" + String.join(", ",
                numbers.stream()
                        .map(String::valueOf)
                        .toList()
        ) + "]\n";
    }

    public int countMatchNumbers(Lotto otherLotto) {
        return (int) this.numbers.stream()
                .filter(otherLotto::contains)
                .count();
    }

    public boolean contains(Integer number) {
        return this.numbers.contains(number);
    }
}
