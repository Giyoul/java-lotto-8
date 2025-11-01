package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public Long readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return Long.parseLong(purchaseAmount);
    }

    public List<Integer> readWinnerNumbers() {
        String winnerNumbers = Console.readLine();
        
    }
}
