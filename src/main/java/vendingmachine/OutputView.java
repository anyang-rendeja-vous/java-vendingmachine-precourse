package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    private static final String MAINTENANCE_MESSAGE = "자판기가 보유한 동전";
    private static final String CHANGE_MESSAGE = "잔돈";
    private static final String UNIT_MESSAGE = "원 - ";
    private static final String LAST_UNIT_MESSAGE = "개";
    public void printCoins(){
        System.out.println(MAINTENANCE_MESSAGE);
        System.out.println(Coin.COIN_500.getAmount()+UNIT_MESSAGE+Coin.COIN_500.getCount()+LAST_UNIT_MESSAGE);
        System.out.println(Coin.COIN_100.getAmount()+UNIT_MESSAGE+Coin.COIN_100.getCount()+LAST_UNIT_MESSAGE);
        System.out.println(Coin.COIN_50.getAmount()+UNIT_MESSAGE+Coin.COIN_50.getCount()+LAST_UNIT_MESSAGE);
        System.out.println(Coin.COIN_10.getAmount()+UNIT_MESSAGE+Coin.COIN_10.getCount()+LAST_UNIT_MESSAGE);
    }
    public void printChange(List<Integer> change){
        System.out.println(CHANGE_MESSAGE);
        List<Integer> coinPrice = Arrays.asList(500,100,50,10);
        for(int loop=0;loop<4;loop++){
            int changeNum = change.get(loop);
            if(changeNum!=0){
                System.out.println(coinPrice.get(loop)+UNIT_MESSAGE+changeNum+LAST_UNIT_MESSAGE);
            }
        }
    }
}
