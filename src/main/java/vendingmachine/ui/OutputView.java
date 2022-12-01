package vendingmachine.ui;

import static vendingmachine.ui.MessageUtils.MACHINE_COIN_INFO;
import static vendingmachine.ui.MessageUtils.MONEY_REMAINING;

import java.util.EnumMap;
import vendingmachine.domain.Coin;
import vendingmachine.domain.RemainingCoins;

public class OutputView {
    private static final String WON = "원";
    private static final String AMT = "개";

    private static final String DELIMITER = " - ";

    private static final String ERROR = "[ERROR]";

    public void printErrorMessage(String errorMsg){
        System.out.println(ERROR + " " + errorMsg);
    }

    public void printMachineCoinInfo(RemainingCoins remainingCoins) {
        System.out.println();
        System.out.println(MACHINE_COIN_INFO.msg());
        EnumMap<Coin, Integer> coinMap = remainingCoins.getRemainingCoins();
        for (Coin coin : coinMap.keySet()) {
            System.out.println(coin.amount() + WON + DELIMITER + coinMap.get(coin) + AMT);
        }
    }

    public void printLeftovers(int money) {
        System.out.println();
        System.out.println(MONEY_REMAINING.msg() + money + WON);
    }

    public void printRemainingCoins(EnumMap<Coin, Integer> change) {
        System.out.println(MACHINE_COIN_INFO.msg());
        for (Coin coin : change.keySet()) {
            System.out.println(coin.amount() + WON + DELIMITER + change.get(coin) + AMT);
        }
    }
}
