package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.util.MoneyGenerator;

public class VendingMachine {

    private static final String NOT_EXISTED_PRODUCTION = "존재하지 않는 상품입니다.";
    private List<Product> products;
    private Integer inputMoney;
    private final VendingMachineCoin vendingMachineCoin = new VendingMachineCoin();

    public VendingMachine(String amountOfMoney) {
        initVendingMachineCoin(amountOfMoney);
    }

    public VendingMachineCoin getVendingMachineCoin() {
        return vendingMachineCoin;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setInputMoney(int inputMoney) { // TODO: setter
        this.inputMoney = inputMoney;
    }

    public void sell(String inputProduct) {
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
            }
        }
    }

    public int getInputMoney() { // TODO: getter
        return inputMoney;
    }

    // 자판기의 보유 금액으로 동전을 세팅한다
    public void initVendingMachineCoin(String amountOfMoney) {
        List<Coin> coinGroup = new ArrayList<>();
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
        vendingMachineCoin.countEachCoin(coinGroup);
    }

    // 상품의 최저 가격을 반환한다
    public Integer minimumPriceOfProduct() {
        return products.stream()
                .map(Product::getPrice)
                .min(Integer::compareTo)
                .orElse(null);
    }
}
