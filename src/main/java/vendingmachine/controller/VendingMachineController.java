package vendingmachine.controller;

import java.util.function.Supplier;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Change;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    private final InputView inputView;
    private final OutputView outputView;

    public VendingMachineController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void run() {
        VendingMachine vendingMachine = createVendingMachine();
        outputView.printVendingMachineCoins(vendingMachine);

        String productGroup = repeat(inputView::inputProduct);
        Products products = new Products(productGroup);
        vendingMachine.setProducts(products);

        String inputUserMoney = repeat(inputView::inputUserMoney);

        vendingMachine.setInputMoney(Integer.parseInt(inputUserMoney));

        int inputMoney = 0;
        while (true) {
            if (vendingMachine.getInputMoney() < products.getMinimumPrice()) {
                break;
            }
            if (products.isOutOfStock()) {
                break;
            }
            inputMoney = vendingMachine.getInputMoney();
            outputView.printInputMoney(inputMoney);

            String inputProductName;
            while(true) {
                inputProductName = inputView.inputProductName();
                try {
                    vendingMachine.sell(inputProductName);
                    break;
                } catch (IllegalArgumentException ex) {
                    outputView.printError(ex.getMessage());
                }
            }
        }

        Change change = new Change();
        change.calculateChange(vendingMachine);
        outputView.printInputMoney(inputMoney);
        outputView.printRemainder(change);
    }

    private VendingMachine createVendingMachine() {
        String amountOfMoney = repeat(inputView::inputMachineMoney);
        return new VendingMachine(amountOfMoney);
    }

    private <T> T repeat(Supplier<T> inputReader) {
        try {
            return inputReader.get();
        } catch (IllegalArgumentException ex) {
            outputView.printError(ex.getMessage());
            return repeat(inputReader);
        }
    }
}
