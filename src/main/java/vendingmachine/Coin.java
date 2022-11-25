package vendingmachine;

public enum Coin {
    COIN_500(500),
    COIN_100(100),
    COIN_50(50),
    COIN_10(10);

    private final int amount;
    public int count;

    Coin(final int amount) {
        this.amount = amount;
        this.count=count;
    }



    // 추가 기능 구현
}
