package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import vendingmachine.domain.coin.Change;
import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
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
        String amountOfMoney = repeat(inputView::inputMachineMoney);

        VendingMachine vendingMachine = new VendingMachine(amountOfMoney);
        outputView.printVendingMachineCoins(vendingMachine);

        String products = repeat(inputView::inputProduct);

        List<Product> productGroup = new ArrayList<>();
        Arrays.asList(products.split(";"))
                .forEach(product -> productGroup.add(new Product(product)));
        vendingMachine.setProducts(productGroup);

        String inputUserMoney = repeat(inputView::inputUserMoney);

        vendingMachine.setInputMoney(Integer.parseInt(inputUserMoney));

        int inputMoney = 0;
        while (true) {
            if (vendingMachine.getInputMoney() < vendingMachine.minimumPriceOfProduct()) {
                break;
            }
            // 모든 상품이 소진된 경우
            boolean isOutOfStock = false;
            for (Product product : productGroup) {
                if (!product.canBuy()) {
                    isOutOfStock = true;
                }
            }
            if (isOutOfStock) {
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
        change.calculateRemainder(vendingMachine);
        outputView.printInputMoney(inputMoney);
        outputView.printRemainder(change);
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
