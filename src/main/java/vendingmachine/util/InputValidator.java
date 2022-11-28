package vendingmachine.util;

import java.util.regex.Pattern;

public class InputValidator {

    private static final String PRODUCT_FORMAT_ERROR = "상품명, 가격, 수량은 [콜라,1500,20];[사이다,1000,10] 와 같은 형식이어야 합니다.";
    private static final String MACHINE_DIGIT_ERROR = "자판기 금액은 숫자여야 합니다.";
    private static final String MACHINE_RANGE_ERROR = "자판기 금액은 10원 미만일 수 없습니다.";

    public void checkProduct(String product) {
        isFormatValid(product);
    }

    public void isFormatValid(String product) {
        if (!Pattern.matches("^(\\[.+,[0-9]+,[0-9]+])(;(\\[.+,[0-9]+,[0-9]+]))*$", product)) { // TODO: [,,];[,,] 형식 검증
            throw new IllegalArgumentException(PRODUCT_FORMAT_ERROR);
        }
    }

    public void checkMachineMoney(String machineMoney) {
        isDigit(machineMoney);
        isRangeValid(machineMoney);
    }

    public void isDigit(String machineMoney) {
        if (!Pattern.matches("^[-]*[0-9]+$", machineMoney)) {
            throw new IllegalArgumentException(MACHINE_DIGIT_ERROR);
        }
    }

    public void isRangeValid(String machineMoney) {
        if (Integer.parseInt(machineMoney) < 10) {
            throw new IllegalArgumentException(MACHINE_RANGE_ERROR);
        }
    }
}
