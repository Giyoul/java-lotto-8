package lotto;

public class OutputView {
    private static final String ASK_PURCHASE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNER_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public void printPurchasePrompt(){
        System.out.println(ASK_PURCHASE);
    }

    public void printWinnerNumberPrompt() {
        System.out.println(ASK_WINNER_NUMBER);
    }

    public void printBonusNumberPrompt() {
        System.out.println(ASK_BONUS_NUMBER);
    }

    public void printFormattedMessage(String message) {
        System.out.println(message);
    }

    public void printExceptionMessage(String message) {
        System.out.println(message);
    }
}
