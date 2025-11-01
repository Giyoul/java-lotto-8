package lotto;

public class OutputView {
    private static final String ASK_PURCHASE = "구입금액을 입력해 주세요.";

    public void printPurchasePrompt(){
        System.out.println(ASK_PURCHASE);
    }

    public void printFormattedMessage(String message) {
        System.out.println(message);
    }
}
