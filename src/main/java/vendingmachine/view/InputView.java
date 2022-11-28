package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.util.InputValidator;

public class InputView {

    private static final String ENTER_VENDING_MACHINE_MONEY = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String ENTER_PRODUCT_INFORMATION = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String ENTER_INPUT_MONEY = "투입 금액을 입력해 주세요.";
    private static final String ENTER_PRODUCT_NAME = "구매할 상품명을 입력해 주세요.";
    private final InputValidator inputValidator;

    public InputView() {
        this.inputValidator = new InputValidator();
    }

    private String input() {
        return Console.readLine();
    }

    public String inputMachineMoney() {
        System.out.println(ENTER_VENDING_MACHINE_MONEY);
        String machineMoney = input();
        inputValidator.checkMachineMoney(machineMoney);
        return machineMoney;
    }

    public String inputProduct() {
        System.out.println();
        System.out.println(ENTER_PRODUCT_INFORMATION);
        String products = input();
        inputValidator.checkProduct(products);
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
