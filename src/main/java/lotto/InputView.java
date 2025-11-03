package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private static final Long LOTTO_UNIT_PRICE = 1000L;
    private static final String NUMBER_DELIMITER = ",";

    public Long readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        return purchaseAmountValidation(purchaseAmount);
    }

    public List<Integer> readWinnerNumbers() {
        String winnerNumber = Console.readLine();
        validateNotEmpty(winnerNumber, "[ERROR] 당첨 번호는 빈 입력이면 안됩니다.");
        return parseWinnerNumber(winnerNumber);
    }

    public Integer readBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumberValidation(bonusNumber);
    }

    public Long purchaseAmountValidation(String purchaseAmount) {
        validateNotEmpty(purchaseAmount, "[ERROR] 구입 금액은 빈 입력이면 안됩니다.");
        Long parsedNumber = parsePurchaseAmount(purchaseAmount);
        numberBoundaryCheck(parsedNumber);
        divisibleCheck(parsedNumber);
        return parsedNumber;
    }

    Long parsePurchaseAmount(String input) {
        try {
            return Long.parseLong(input);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }
    }

    void numberBoundaryCheck(Long parsedNumber) {
        if (parsedNumber < LOTTO_UNIT_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상이어야 합니다.");
        }
    }

    void divisibleCheck(Long parsedNumber) {
        if (parsedNumber % LOTTO_UNIT_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }

    List<Integer> parseWinnerNumber(String winnerNumber) {
        try {
            return Arrays.stream(winnerNumber.split(NUMBER_DELIMITER))
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 당첨 번호는 숫자여야 합니다.");
        }
    }

    Integer bonusNumberValidation(String bonusNumber) {
        validateNotEmpty(bonusNumber, "[ERROR] 보너스 번호는 빈 입력이면 안됩니다.");
        return parseBonusNumber(bonusNumber);
    }

    void validateNotEmpty(String input, String errorMessage) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    private Integer parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }
}
