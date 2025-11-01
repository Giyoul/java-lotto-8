package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public Long readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return Long.parseLong(purchaseAmount);
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
}
