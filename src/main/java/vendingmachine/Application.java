package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        int coinTotalPrice= getCoinPrice();
        VendingMachine vendingMachine = new VendingMachine(coinTotalPrice);
        generateCoins(coinTotalPrice);
        generateStock(vendingMachine);


    }
    public static int getCoinPrice(){
        InputView input = new InputView();
        return input.coin_inside();
    }
    public static void generateCoins(int price){
        int totalPrice = price;
        List<Integer> numbers =Arrays.asList(0,1,2,3);
        List<Integer> coins =Arrays.asList(500,100,50,10);
        int index=0;
        int coinPrice;
//        while(true){
//            int count=Randoms.pickNumberInList(numbers);
//            coinPrice=coins.get(index);
//            if(totalPrice-count*coinPrice>0){
//                //check
//                Coin.valueOf("COIN_"+coinPrice).count=count;
//                index++;
//                totalPrice-=count*coinPrice;
//            }
//        }
    }
    public static void generateStock(VendingMachine vendingMachine){
        InputView input = new InputView();
        vendingMachine.setStocks(input.addStock());
    }
}
