package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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
        cleanResource();
    }

    private void purchaseLotto(){
        while (true) {
            try {
                outputView.printPurchasePrompt();
                Long purchaseAmount = inputView.readPurchaseAmount();
                lottoService.purchaseLotto(purchaseAmount);
                break;
            } catch (NumberFormatException e) {
                outputView.printExceptionMessage(e.getMessage());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }

    }

    private void printLotto() {
        String purchaseCount = lottoService.getPurchaseCountMessage();
        outputView.printFormattedMessage(purchaseCount);

        String purchaseLottoNumber = lottoService.getLottoNumber();
        outputView.printFormattedMessage(purchaseLottoNumber);
    }

    private void setWinnerLottoNumber() {
        while (true) {
            try {
                outputView.printWinnerNumberPrompt();
                List<Integer> winnerNumbers = inputView.readWinnerNumbers();
                lottoService.saveWinnerNumbers(winnerNumbers);
                break;
            } catch (NumberFormatException e) {
                outputView.printExceptionMessage(e.getMessage());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }
    }

    private void setWinnerLottoBonusNumber() {
        while (true) {
            try {
                outputView.printBonusNumberPrompt();
                Integer bonusNumber = inputView.readBonusNumber();
                lottoService.saveBonusNumber(bonusNumber);
                break;
            } catch (NumberFormatException e) {
                outputView.printExceptionMessage(e.getMessage());
            } catch (IllegalArgumentException e) {
                outputView.printExceptionMessage(e.getMessage());
            }
        }

    }

    private void printStatistics() {
        String statisticMessage = lottoService.generateStatisticMessage();
        outputView.printFormattedMessage(statisticMessage);
    }

    private void cleanResource() {
        Console.close();
    }
}
