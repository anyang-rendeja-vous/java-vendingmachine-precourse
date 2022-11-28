package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        String amountOfMoney = inputView.inputMachineMoney();

        VendingMachine vendingMachine = new VendingMachine(amountOfMoney);
        outputView.printVendingMachineCoins(vendingMachine);

        String products = inputView.inputProduct();
        List<Product> productGroup = new ArrayList<>();
        Arrays.asList(products.split(";"))
                .forEach(product -> productGroup.add(new Product(product)));
        vendingMachine.setProducts(productGroup);

        String inputUserMoney = inputView.inputUserMoney();
        vendingMachine.setInputMoney(Integer.parseInt(inputUserMoney));

        int inputMoney;
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
            String inputProductName = inputView.inputProductName();
            vendingMachine.sell(inputProductName);
        }

        Change change = new Change();
        change.calculateRemainder(vendingMachine);
        outputView.printRemainder(change);
    }
}
