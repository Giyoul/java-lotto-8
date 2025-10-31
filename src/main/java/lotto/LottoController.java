package lotto;

public class LottoController {
    private final OutputView outputView = new OutputView();

    public void run() {
        outputView.printPurchaseMessage();
    }
}
