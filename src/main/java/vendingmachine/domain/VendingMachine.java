package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final List<Coin> coins = new ArrayList<>();
    private final List<Product> products = new ArrayList<>();

    public VendingMachine(String amountOfMoney, String products) {
        initCoin(amountOfMoney);
        initProduct(products);
    }

    public List<Coin> initCoin(String amountOfMoney) {
        return coins;
    }

    public List<Product> initProduct(String product) {
        return products;
    }
}
