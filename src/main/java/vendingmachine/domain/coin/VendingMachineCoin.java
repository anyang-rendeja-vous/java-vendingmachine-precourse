package vendingmachine.domain.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import vendingmachine.Coin;

public class VendingMachineCoin {

    private final Map<Coin, Integer> numberOfCoins = new EnumMap<>(Coin.class); // 자판기 돈

    public VendingMachineCoin() {
        for (Coin coin : Coin.values()) {
            numberOfCoins.put(coin, 0);
        }
    }

    public Map<Coin, Integer> getNumberOfCoins() { // TODO: getter
        return numberOfCoins;
    }

    // coinGroup 을 통해 EnumMap 을 초기화한다
    public void countEachCoin(List<Coin> coinGroup) {
        coinGroup.forEach(coin -> {
            numberOfCoins.put(coin, numberOfCoins.get(coin) + 1);
        });
    }
}
