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
        Products products = getProducts();
        String inputUserMoney = repeat(inputView::inputUserMoney);
        setVendingMachine(vendingMachine, products, inputUserMoney);
        int inputMoney = getInputMoney(vendingMachine, products);
        Change change = createChange(vendingMachine);
        printResult(inputMoney, change);
    }

    private void makePurchase(VendingMachine vendingMachine) {
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

    private boolean isStop(VendingMachine vendingMachine, Products products) {
        return products.isOutOfStock() || vendingMachine.getInputMoney() < products.getMinimumPrice();
    }

    private VendingMachine createVendingMachine() {
        String amountOfMoney = repeat(inputView::inputMachineMoney);
        return new VendingMachine(amountOfMoney);
    }

    public Products getProducts() {
        Products products;
        do {
            products = createProducts();
        } while (products == null);
        return products;
    }

    private Products createProducts() {
        try {
            return new Products(repeat(inputView::inputProduct));
        } catch (IllegalArgumentException ex) {
            outputView.printError(ex.getMessage());
        }
        return null;
    }

    private void setVendingMachine(VendingMachine vendingMachine, Products products, String inputUserMoney) {
        vendingMachine.setProducts(products);
        vendingMachine.setInputMoney(Integer.parseInt(inputUserMoney));
    }

    private int getInputMoney(VendingMachine vendingMachine, Products products) {
        while (!isStop(vendingMachine, products)) {
            outputView.printInputMoney(vendingMachine.getInputMoney());
            makePurchase(vendingMachine);
        }
        return vendingMachine.getInputMoney();
    }

    private Change createChange(VendingMachine vendingMachine) {
        return new Change(vendingMachine);
    }

    private void printResult(int inputMoney, Change change) {
        outputView.printInputMoney(inputMoney);
        outputView.printChange(change);
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
