package vendingmachine.domain.coin;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class Change {

    private final Map<Coin, Integer> remainedCoins = new EnumMap<>(Coin.class); // 잔돈

    public Map<Coin, Integer> getRemainedCoins() { // TODO: getter
        return remainedCoins;
    }

    // 잔돈의 수가 최소가 되도록 계산한다
    public void calculateRemainder(VendingMachine vendingMachine) {
        int inputMoney =  vendingMachine.getInputMoney();
        Map<Coin, Integer> numberOfCoins = vendingMachine.getVendingMachineCoin().getNumberOfCoins();
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
