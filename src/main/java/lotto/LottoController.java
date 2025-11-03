package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

/**
 * Controller class that coordinates the lotto application flow.
 */
public class LottoController {
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoService lottoService = new LottoService();

    public void run() {
        purchaseLotto();
        printLotto();
        setWinnerLottoNumber();
        setWinnerLottoBonusNumber();
        printStatistics();
        closeConsole();
    }

    private void purchaseLotto(){
        retryUntilSuccess(() -> {
            outputView.printPurchasePrompt();
            Long purchaseAmount = inputView.readPurchaseAmount();
            lottoService.purchaseLotto(purchaseAmount);
        });
    }

    private void printLotto() {
        String purchaseCount = lottoService.getPurchaseCountMessage();
        outputView.printFormattedMessage(purchaseCount);

        String purchaseLottoNumber = lottoService.getLottoNumber();
        outputView.printFormattedMessage(purchaseLottoNumber);
    }

    private void setWinnerLottoNumber() {
        retryUntilSuccess(() -> {
            outputView.printWinnerNumberPrompt();
            List<Integer> winnerNumbers = inputView.readWinnerNumbers();
            lottoService.saveWinnerNumbers(winnerNumbers);
        });
    }

    private void setWinnerLottoBonusNumber() {
        retryUntilSuccess(() -> {
            outputView.printBonusNumberPrompt();
            Integer bonusNumber = inputView.readBonusNumber();
            lottoService.saveBonusNumber(bonusNumber);
        });
    }

    private void printStatistics() {
        String statisticMessage = lottoService.generateStatisticsMessage();
        outputView.printFormattedMessage(statisticMessage);
    }

    private void closeConsole() {
        Console.close();
    }

    private void retryUntilSuccess(Runnable action) {
        while(true){
            try {
                action.run();
                break;
            } catch (NumberFormatException | IllegalStateException exception) {
                outputView.printExceptionMessage(exception.getMessage());
            } catch (IllegalArgumentException illegalArgumentException) {
                outputView.printExceptionMessage(illegalArgumentException.getMessage());

            }
        }
    }
}
