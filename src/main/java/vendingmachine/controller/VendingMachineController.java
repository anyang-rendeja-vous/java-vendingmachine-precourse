package vendingmachine.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        String amountOfMoney = inputView.inputAmountOfMoney();

        String products = inputView.inputProduct();
        List<Product> productGroup = new ArrayList<>();
        if (products.contains(";")) {
            Arrays.asList(products.split(";"))
                    .forEach(product -> productGroup.add(new Product(product)));
        }

        VendingMachine vendingMachine = new VendingMachine(amountOfMoney, productGroup);
        outputView.printVendingMachineCoins(vendingMachine);

    }
}
