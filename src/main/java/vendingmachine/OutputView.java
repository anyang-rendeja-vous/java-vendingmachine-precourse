package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class OutputView {
    private static final String UNIT_MESSAGE = "원 - ";
    private static final String LAST_UNIT_MESSAGE = "개";
    public void printCoins(){
        System.out.println(Coin.COIN_500.getAmount()+UNIT_MESSAGE+Coin.COIN_500.getCount()+LAST_UNIT_MESSAGE);
        System.out.println(Coin.COIN_100.getAmount()+UNIT_MESSAGE+Coin.COIN_100.getCount()+LAST_UNIT_MESSAGE);
        System.out.println(Coin.COIN_50.getAmount()+UNIT_MESSAGE+Coin.COIN_50.getCount()+LAST_UNIT_MESSAGE);
        System.out.println(Coin.COIN_10.getAmount()+UNIT_MESSAGE+Coin.COIN_10.getCount()+LAST_UNIT_MESSAGE);
    }
}
