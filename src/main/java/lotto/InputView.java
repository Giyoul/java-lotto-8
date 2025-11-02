package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public Long readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        purchaseAmountValidation(purchaseAmount);
        return Long.parseLong(purchaseAmount);
    }

    public void purchaseAmountValidation(String purchaseAmount) {
        emptyInputCheck(purchaseAmount);
    }

    private void emptyInputCheck(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 빈 입력이면 안됩니다.");
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
