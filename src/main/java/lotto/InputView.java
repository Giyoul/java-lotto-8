package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public Long readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return purchaseAmountValidation(purchaseAmount);
    }

    public Long purchaseAmountValidation(String purchaseAmount) {
        emptyInputCheck(purchaseAmount);
        return numberFormatCheck(purchaseAmount);
    }

    void emptyInputCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 빈 입력이면 안됩니다.");
        }
    }

    Long numberFormatCheck(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    public List<Integer> readWinnerNumbers() {
        String winnerNumber = Console.readLine();
        return parseWinnerNumber(winnerNumber);
    }

    List<Integer> parseWinnerNumber(String winnerNumber) {
        return Arrays.stream(winnerNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    public Integer readBonusNumber() {
        String bonusNumber = Console.readLine();
        return Integer.parseInt(bonusNumber);
    }
}
