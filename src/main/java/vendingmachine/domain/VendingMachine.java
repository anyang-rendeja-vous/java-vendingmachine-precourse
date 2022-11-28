package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.Coin;
import vendingmachine.domain.coin.VendingMachineCoin;
import vendingmachine.util.MoneyGenerator;

public class VendingMachine {

    private Products products;
    private Integer inputMoney;
    private final VendingMachineCoin vendingMachineCoin = new VendingMachineCoin();

    public VendingMachine(String amountOfMoney) {
        initVendingMachineCoin(amountOfMoney);
    }

    public VendingMachineCoin getVendingMachineCoin() {
        return vendingMachineCoin;
    }

    public void setProducts(Products products) {
        this.products = products;
    }

    public void setInputMoney(int inputMoney) { // TODO: setter
        this.inputMoney = inputMoney;
    }

    public void sell(String inputProduct) {
        Product product = products.getProduct(inputProduct);
        inputMoney = product.sold(inputMoney);
    }

    public int getInputMoney() { // TODO: getter
        return inputMoney;
    }

    // 자판기의 보유 금액으로 동전을 세팅한다
    public void initVendingMachineCoin(String amountOfMoney) {
        List<Coin> coinGroup = new ArrayList<>();
        int amount = Integer.parseInt(amountOfMoney);
        List<Integer> coins = Arrays.stream(Coin.values())
                .map(Coin::getAmount)
                .collect(Collectors.toList());
        createCoinGroup(coinGroup, amount, coins);
        vendingMachineCoin.countCoin(coinGroup);
    }

    private void createCoinGroup(List<Coin> coinGroup, int amount, List<Integer> coins) {
        int coinValue;
        while (amount > 0) {
            coinValue = MoneyGenerator.generate(coins);
            if (coinValue <= amount) {
                coinGroup.add(Coin.getCoin(coinValue));
                amount -= coinValue;
            }
        }
    }
}
