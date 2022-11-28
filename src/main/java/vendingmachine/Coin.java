package vendingmachine;

import java.util.Arrays;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;

    Coin(final int amount) {
        this.amount = amount;
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

}
