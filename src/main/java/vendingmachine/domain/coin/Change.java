package vendingmachine.domain.coin;

import java.util.EnumMap;
import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.Coin;
import vendingmachine.domain.VendingMachine;

public class Change {

    private final Map<Coin, Integer> change = new EnumMap<>(Coin.class); // 잔돈

    public Map<Coin, Integer> getChange() { // TODO: getter
        return change;
    }

    public void calculateChange(VendingMachine vendingMachine) {
        int inputMoney =  vendingMachine.getInputMoney();
        Map<Coin, Integer> vendingMachineCoin = vendingMachine.getVendingMachineCoin().getVendingMachineCoin();
        for (Entry<Coin, Integer> coinEntry : vendingMachineCoin.entrySet()) {
            inputMoney = updateInputMoney(inputMoney, vendingMachineCoin, coinEntry);
        }
    }

    private int updateInputMoney(int inputMoney, Map<Coin, Integer> vendingMachineCoin, Entry<Coin, Integer> coin) {
        while (coin.getValue() > 0) {
            if (coin.getKey().getAmount() > inputMoney) {
                break;
            }
            inputMoney -= coin.getKey().getAmount();
            updateCoin(vendingMachineCoin, coin);
        }
        return inputMoney;
    }

    private void updateCoin(Map<Coin, Integer> vendingMachineCoin, Entry<Coin, Integer> coin) {
        vendingMachineCoin.put(coin.getKey(), vendingMachineCoin.get(coin.getKey()) - 1);
        change.put(coin.getKey(), change.getOrDefault(coin.getKey(), 0) + 1);
    }
}
