package lotto;

import java.util.List;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        outputView.printPurchasePrompt();
        Long purchaseAmount = inputView.readPurchaseAmount();
        lottoService.purchaseLotto(purchaseAmount);

        String purchaseCount = lottoService.getPurchaseCountMessage();
        outputView.printFormattedMessage(purchaseCount);

        String purchaseLottoNumber = lottoService.getLottoNumber();
        outputView.printFormattedMessage(purchaseLottoNumber);

        outputView.printWinnerNumberPrompt();
        List<Integer> winnerNumbers = inputView.readWinnerNumbers();
        lottoService.saveWinnerNumbers(winnerNumbers);

        outputView.printBonusNumberPrompt();
        Integer bonusNumber = inputView.readBonusNumber();
        lottoService.saveBonusNumber(bonusNumber);

        String statisticMessage = lottoService.generateStatisticMessage();
    }
}
