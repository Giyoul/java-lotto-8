package lotto;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Long readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return Long.parseLong(purchaseAmount);
    }
}
