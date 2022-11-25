package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.util.MoneyGenerator;

public class VendingMachine {

    private final List<Coin> coinGroup = new ArrayList<>();
    private final List<Product> products;

    public VendingMachine(String amountOfMoney, List<Product> products) {
        initCoin(amountOfMoney);
        this.products = products;
    }

    public void initCoin(String amountOfMoney) {
        int amount = Integer.parseInt(amountOfMoney);

        List<Integer> coins = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());

        int pick;
        while (amount > 0) {
            pick = MoneyGenerator.generate(coins);
            if (pick <= amount) {
                coinGroup.add(Coin.getCoin(pick));
                amount -= pick;
            }
        }

    }

    public List<Integer> countEachCoin() {
        List<Integer> count = Arrays.asList(0, 0, 0, 0);
        coinGroup.forEach(coin -> {
            if (coin.getAmount() == 500) {
                count.set(0, count.get(0) + 1);
            }
            if (coin.getAmount() == 100) {
                count.set(1, count.get(1) + 1);
            }
            if (coin.getAmount() == 50) {
                count.set(2, count.get(2) + 1);
            }
            if (coin.getAmount() == 10) {
                count.set(3, count.get(3) + 1);
            }
        });
        return count;
    }
}
