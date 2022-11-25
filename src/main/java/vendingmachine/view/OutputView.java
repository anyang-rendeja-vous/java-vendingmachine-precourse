package vendingmachine.view;

import java.util.List;
import vendingmachine.domain.VendingMachine;

public class OutputView {

    private static final String VENDING_MACHINE_COINS = "자판기가 보유한 동전";
    private static final String NUMBER_OF_500 = "500원 - ";
    private static final String NUMBER_OF_100 = "100원 - ";
    private static final String NUMBER_OF_50 = "50원 - ";
    private static final String NUMBER_OF_10 = "10원 - ";
    private static final String NUMBER = "개";

    public void printVendingMachineCoins(VendingMachine vendingMachine) {
        System.out.println(VENDING_MACHINE_COINS);
        List<Integer> coinCounts = vendingMachine.countEachCoin();
        System.out.println(NUMBER_OF_500 + coinCounts.get(0) + NUMBER);
        System.out.println(NUMBER_OF_100 + coinCounts.get(1) + NUMBER);
        System.out.println(NUMBER_OF_50 + coinCounts.get(2) + NUMBER);
        System.out.println(NUMBER_OF_10 + coinCounts.get(3) + NUMBER);
    }
}
