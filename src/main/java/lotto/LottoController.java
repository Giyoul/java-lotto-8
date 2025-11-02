package lotto;

import java.util.List;

public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        purchaseLotto();
        printLotto();
        setWinnerLottoNumber();
        printStatistics();
    }

    private void purchaseLotto(){
        outputView.printPurchasePrompt();
        Long purchaseAmount = inputView.readPurchaseAmount();
        lottoService.purchaseLotto(purchaseAmount);
    }

    private void printLotto() {
        String purchaseCount = lottoService.getPurchaseCountMessage();
        outputView.printFormattedMessage(purchaseCount);

        String purchaseLottoNumber = lottoService.getLottoNumber();
        outputView.printFormattedMessage(purchaseLottoNumber);
    }

    private void setWinnerLottoNumber(){
        outputView.printWinnerNumberPrompt();
        List<Integer> winnerNumbers = inputView.readWinnerNumbers();
        lottoService.saveWinnerNumbers(winnerNumbers);

        outputView.printBonusNumberPrompt();
        Integer bonusNumber = inputView.readBonusNumber();
        lottoService.saveBonusNumber(bonusNumber);
    }

    private void printStatistics() {
        String statisticMessage = lottoService.generateStatisticMessage();
        outputView.printFormattedMessage(statisticMessage);
    }
}
