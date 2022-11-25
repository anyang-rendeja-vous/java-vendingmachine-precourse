package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.InputValidator;

public class InputView {

    private static final String ENTER_VENDING_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ENTER_PRODUCT_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ENTER_INPUT_MONEY = "투입 금액을 입력해 주세요.";
    private static final String ENTER_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    private static final String PRODUCT_INPUT_FORMAT_ERROR = "[콜라,1500,20];[사이다,1000,10] 과 같은 형식으로 입력해 주세요.";

    private String input() {
        return Console.readLine();
    }

    public String inputMachineMoney() {
        System.out.println(ENTER_VENDING_MACHINE_MONEY);
        return input();
    }

    public String inputProduct() {
        System.out.println();
        System.out.println(ENTER_PRODUCT_INFORMATION);
        String products = input();
        if (!InputValidator.checkProduct(products)) {
            throw new IllegalArgumentException(PRODUCT_INPUT_FORMAT_ERROR);
        }
        return products;
    }

    public String inputUserMoney() {
        System.out.println();
        System.out.println(ENTER_INPUT_MONEY);
        return input();
    }

    public String inputProductName() {
        System.out.println(ENTER_PRODUCT_NAME);
        return input();
    }
}
