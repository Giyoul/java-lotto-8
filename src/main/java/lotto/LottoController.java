package lotto;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        outputView.printPurchaseMessage();
        Long purchaseAmount = inputView.readPurchaseAmount();
        lottoService.purchaseLotto(purchaseAmount);

        String purchaseCount = lottoService.getPurchaseCount();
        outputView.printFormattedMessage(purchaseCount);
    }
}
