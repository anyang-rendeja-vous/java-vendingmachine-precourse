package vendingmachine.controller;

import vendingmachine.domain.Stock;
import vendingmachine.ui.InputView;
import vendingmachine.ui.OutputView;
import vendingmachine.domain.RemainingCoins;
import vendingmachine.domain.Stocks;
import vendingmachine.domain.UsersMoney;
import vendingmachine.VendingMachine;

public class MachineController {
    private final InputView inputView;
    private final OutputView outputView;
    private VendingMachine vendingMachine;

    public MachineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        RemainingCoins coins = generateCoins();
        outputView.printMachineCoinInfo(coins);

        Stocks stock = addStocks();
        UsersMoney usersMoney = insertMoney();
        vendingMachine = new VendingMachine(coins, stock, usersMoney);

        purchase();
    }

    private RemainingCoins generateCoins() {
        outputView.printMachineMoneyInputOpening();
        try {
            return new RemainingCoins(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return generateCoins();
        }
    }

    private Stocks addStocks() {
        outputView.printMerchandiseInfoOpening();
        try {
            return new Stocks(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return addStocks();
        }
    }

    private UsersMoney insertMoney() {
        outputView.printUserMoneyInputOpening();
        try {
            return new UsersMoney(inputView.userInput());
        } catch (IllegalArgumentException exception) {
            outputView.printErrorMessage(exception.getMessage());
            return insertMoney();
        }
    }

    private void purchase() {
        while (true) {
            outputView.printLeftovers(vendingMachine.getUsersMoney());
            outputView.printUsersStockChoiceOpening();
            try {
                Stock existingStock = vendingMachine.checkStock(inputView.userInput());
                if (!vendingMachine.isPurchasable(existingStock)) {
                    break;
                }
                vendingMachine.purchase(existingStock);
            } catch (IllegalArgumentException exception) {
                outputView.printErrorMessage(exception.getMessage());
            }
        }
    }


}
