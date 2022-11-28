package vendingmachine.view;

import static vendingmachine.domain.Coin.COIN_10;
import static vendingmachine.domain.Coin.COIN_100;
import static vendingmachine.domain.Coin.COIN_50;
import static vendingmachine.domain.Coin.COIN_500;

import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.Change;
import vendingmachine.domain.Coin;
import vendingmachine.domain.VendingMachine;

public class OutputView {

    private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String NUMBER_OF_500 = "500원 - ";
    private static final String NUMBER_OF_100 = "100원 - ";
    private static final String NUMBER_OF_50 = "50원 - ";
    private static final String NUMBER_OF_10 = "10원 - ";
    private static final String NUMBER = "개";
    private static final String INPUT_MONEY = "투입 금액: ";
    private static final String WON = "원";
    private static final String REMAINDER = "잔돈";

//    public void printNewLine() {
//        System.out.println();
//    }

    public void printVendingMachineCoins(VendingMachine vendingMachine) {
        System.out.println();
        System.out.println(VENDING_MACHINE_COINS);
        Map<Coin, Integer> coinCounts = vendingMachine.getVendingMachineCoin().getNumberOfCoins();
        System.out.println(NUMBER_OF_500 + coinCounts.get(COIN_500) + NUMBER);
        System.out.println(NUMBER_OF_100 + coinCounts.get(COIN_100) + NUMBER);
        System.out.println(NUMBER_OF_50 + coinCounts.get(COIN_50) + NUMBER);
        System.out.println(NUMBER_OF_10 + coinCounts.get(COIN_10) + NUMBER);
    }

    public void printInputMoney(int inputMoney) {
        System.out.println();
        System.out.print(INPUT_MONEY);
        System.out.println(inputMoney + WON);
    }

    public void printRemainder(Change remainedCoin) {
        System.out.println();
        System.out.println(REMAINDER);
        Map<Coin, Integer> coinCounts = remainedCoin.getRemainedCoins();
        for (Entry<Coin, Integer> coin : coinCounts.entrySet()) {
            System.out.println(coin);
        }
    }
}
