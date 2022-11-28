package vendingmachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public enum Coin {
    COIN_500(500, "500원 - %d개"),
    COIN_100(100, "100원 - %d개"),
    COIN_50(50, "50원 - %d개"),
    COIN_10(10, "10원 - %d개");

    private final int amount;
    private final String message;

    Coin(final int amount, final String message) {
        this.amount = amount;
        this.message = message;
    }

    // 추가 기능 구현
    public static Coin getCoin(int value) {
        return Arrays.stream(Coin.values())
                .filter(coin -> coin.amount == value)
                .findAny()
                .orElse(null);
    }

    public int getAmount() { // TODO: getter 제거
        return amount;
    }

    public static List<String> getCoinMessage(Map<Coin, Integer> coin) {
        List<String> messages = new ArrayList<>();
        for (Entry<Coin, Integer> entry : coin.entrySet()) {
            messages.add(String.format(entry.getKey().message, entry.getValue()));
        }
        return messages;
    }
}
