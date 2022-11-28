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

        Products products = createProducts();
        vendingMachine.setProducts(products);

        String inputUserMoney = repeat(inputView::inputUserMoney);
        vendingMachine.setInputMoney(Integer.parseInt(inputUserMoney));

        int inputMoney = 0;
        while (true) {
            if (isStop(vendingMachine, products)) {
                break;
            }
            inputMoney = vendingMachine.getInputMoney();
            outputView.printInputMoney(inputMoney);

            String inputProductName;
            while (true) {
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
        outputView.printChange(change);
    }

    private boolean isStop(VendingMachine vendingMachine, Products products) {
        return products.isOutOfStock() || vendingMachine.getInputMoney() < products.getMinimumPrice();
    }

    private VendingMachine createVendingMachine() {
        String amountOfMoney = repeat(inputView::inputMachineMoney);
        return new VendingMachine(amountOfMoney);
    }

    private Products createProducts() {
        String productGroup = repeat(inputView::inputProduct);
        return new Products(productGroup);
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
