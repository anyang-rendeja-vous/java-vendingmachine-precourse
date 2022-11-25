package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.util.MoneyGenerator;

public class VendingMachine {

    private static final String NOT_EXISTED_PRODUCTION = "존재하지 않는 상품입니다.";
    private final List<Coin> coinGroup = new ArrayList<>();
    private List<Product> products;
    private Integer inputMoney;

    public VendingMachine(String amountOfMoney) {
        initCoin(amountOfMoney);
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setInputMoney(int inputMoney) { // TODO: setter
        this.inputMoney = inputMoney;
    }

    public boolean sell(String inputProduct) {
        if (products.stream()
                .map(Product::getName)
                .collect(Collectors.toList())
                .contains(inputProduct)) {
            Product prod = products.stream()
                    .filter(product -> product.getName().equals(inputProduct))
                    .findAny()
                    .orElse(null);
            if (prod == null) {
                throw new IllegalArgumentException(NOT_EXISTED_PRODUCTION);
            }
            if (inputMoney >= prod.getPrice()) {
                inputMoney -= prod.getPrice();
                return true;
            }
        }
        return false;
    }

    public int getInputMoney() { // TODO: getter
        return inputMoney;
    }

    public void initCoin(String amountOfMoney) {
        int pick;
        int amount = Integer.parseInt(amountOfMoney);
        List<Integer> coins = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
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
