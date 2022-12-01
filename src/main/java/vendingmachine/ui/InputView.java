package vendingmachine.ui;

import static vendingmachine.ui.MessageUtils.INPUT_MACHINE_MONEY;
import static vendingmachine.ui.MessageUtils.INPUT_MERCHANDISE_INFO;
import static vendingmachine.ui.MessageUtils.INPUT_USERS_MONEY;
import static vendingmachine.ui.MessageUtils.INPUT_USERS_STOCK_CHOICE;

public class InputView {

    public void printMachineMoneyInputOpening() {
        System.out.println(INPUT_MACHINE_MONEY.msg());
    }

    public void printMerchandiseInfoOpening() {
        System.out.println();
        System.out.println(INPUT_MERCHANDISE_INFO.msg());
    }

    public void printUserMoneyInputOpening() {
        System.out.println();
        System.out.println(INPUT_USERS_MONEY.msg());
    }

    public void printUsersStockChoiceOpening() {
        System.out.println(INPUT_USERS_STOCK_CHOICE.msg());
    }
}
