package vendingmachine.domain;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private final Integer amountOfMoney;
    private final List<Coin> coins = new ArrayList<>();

    public VendingMachine(Integer amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
        initCoin(amountOfMoney);
    }

    public List<Coin> initCoin(Integer amountOfMoney) {
        return coins;
    }

}
