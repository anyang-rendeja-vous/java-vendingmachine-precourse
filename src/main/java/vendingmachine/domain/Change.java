package vendingmachine.domain;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;

public class Change {

    private final Map<Coin, Integer> numberOfCoins = new EnumMap<>(Coin.class); // 자판기 돈
    private final Map<Coin, Integer> remainedCoins = new EnumMap<>(Coin.class); // 잔돈

    public Change() {
        for (Coin coin : Coin.values()) {
            numberOfCoins.put(coin, 0);
        }
    }

    public Map<Coin, Integer> getNumberOfCoins() { // TODO: getter
        return numberOfCoins;
    }

    public Map<Coin, Integer> getRemainedCoins() { // TODO: getter
        return remainedCoins;
    }

    // coinGroup 을 통해 EnumMap 을 초기화한다
    public void countEachCoin(VendingMachine vendingMachine) {
        vendingMachine.getCoinGroup().forEach(coin -> {
            numberOfCoins.put(coin, numberOfCoins.get(coin) + 1);
        });
    }

    // 잔돈의 수가 최소가 되도록 계산한다
    public void calculateRemainder(VendingMachine vendingMachine) {
        int inputMoney =  vendingMachine.getInputMoney();
        for (Entry<Coin, Integer> coin : numberOfCoins.entrySet()) {
            while (coin.getValue() > 0) {
                if (coin.getKey().getAmount() > inputMoney) {
                    break;
                }
                inputMoney -= coin.getKey().getAmount();
                numberOfCoins.put(coin.getKey(), numberOfCoins.get(coin.getKey()) - 1);
                remainedCoins.put(coin.getKey(), remainedCoins.getOrDefault(coin.getKey(), 0) + 1); // 잔액
            }
        }
    }
}
