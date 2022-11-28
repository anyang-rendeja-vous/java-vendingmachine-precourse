package vendingmachine.view;

import java.util.Map;
import vendingmachine.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Change;

public class OutputView {

    private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String INPUT_MONEY = "투입 금액: ";
    private static final String WON = "원";
    private static final String REMAINDER = "잔돈";
    private static final String DELIMITER = "\n";

//    public void printNewLine() {
//        System.out.println();
//    }

    public void printVendingMachineCoins(VendingMachine vendingMachine) {
        System.out.println();
        System.out.println(VENDING_MACHINE_COINS);
        Map<Coin, Integer> coinCounts = vendingMachine.getVendingMachineCoin().getNumberOfCoins();
        System.out.println(String.join(DELIMITER, Coin.getCoinMessage(coinCounts)));
    }

    public void printInputMoney(int inputMoney) {
        System.out.println();
        System.out.print(INPUT_MONEY);
        System.out.println(inputMoney + WON);
    }

    public void printRemainder(Change remainedCoin) {
        System.out.println(REMAINDER);
        Map<Coin, Integer> coinCounts = remainedCoin.getRemainedCoins();
        System.out.println(String.join(DELIMITER, Coin.getCoinMessage(coinCounts)));
    }
}
