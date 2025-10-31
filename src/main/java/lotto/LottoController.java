package lotto;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();

    public void run() {
        outputView.printPurchaseMessage();
        Long purchaseAmount = inputView.readPurchaseAmount();
    }
}
