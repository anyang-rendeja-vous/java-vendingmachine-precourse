package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class VendingMachine {

    private final List<Coin> coinGroup = new ArrayList<>();
    private final List<Product> products;

    public VendingMachine(String amountOfMoney, List<Product> products) {
        initCoin(amountOfMoney);
        this.products = products;
    }

    public void initCoin(String amountOfMoney) {
        List<Coin> coins = Arrays.stream(Coin.values())
                .collect(Collectors.toList());
        coins.forEach(coin ->
                coinGroup.add(Coin.getCoin(Integer.parseInt(amountOfMoney) / coin.getAmount()))
        );
    }
}
