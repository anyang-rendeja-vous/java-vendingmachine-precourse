package vendingmachine.domain.coin;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import vendingmachine.Coin;

public class VendingMachineCoin {

    private final Map<Coin, Integer> vendingMachineCoin = new EnumMap<>(Coin.class);

    public VendingMachineCoin() {
        initializeCoin();
    }

    private void initializeCoin() {
        for (Coin coin : Coin.values()) {
            vendingMachineCoin.put(coin, 0);
        }
    }

    public Map<Coin, Integer> getVendingMachineCoin() {
        return vendingMachineCoin;
    }

    public void countCoin(List<Coin> coinGroup) {
        coinGroup.forEach(coin -> {
            vendingMachineCoin.put(coin, vendingMachineCoin.get(coin) + 1);
        });
    }
}
