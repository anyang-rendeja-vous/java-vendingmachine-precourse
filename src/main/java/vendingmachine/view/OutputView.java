package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.Coin;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.coin.Change;

public class OutputView {

    private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String INPUT_MONEY = "투입 금액: ";
    private static final String WON = "원";
    private static final String CHANGE = "잔돈";
    private static final String ERROR_PREFIX = "[ERROR] ";

    public void printVendingMachineCoins(VendingMachine vendingMachine) {
        System.out.println();
        System.out.println(VENDING_MACHINE_COINS);
        Map<Coin, Integer> coinCounts = vendingMachine.getVendingMachineCoin().getVendingMachineCoin();
        printCoinCounts(coinCounts);
    }

    private void printCoinCounts(Map<Coin, Integer> coinCounts) {
        for (Entry<Coin, Integer> entry : coinCounts.entrySet()) {
            System.out.println(String.format(entry.getKey().toString(), entry.getValue()));
        }
    }

    public void printInputMoney(int inputMoney) {
        System.out.println();
        System.out.print(INPUT_MONEY);
        System.out.println(inputMoney + WON);
    }

    public void printChange(Change change) {
        System.out.println(CHANGE);
        Map<Coin, Integer> coinCounts = change.getChange();
        printCoinCounts(coinCounts);
    }

    public void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }
}
