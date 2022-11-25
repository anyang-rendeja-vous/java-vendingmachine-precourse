package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        int coinTotalPrice= getCoinPrice();
        VendingMachine vendingMachine = new VendingMachine(coinTotalPrice);
        generateCoins(coinTotalPrice);
//        generateStock(vendingMachine);
//        System.out.println(Coin.COIN_10.getCount(10));


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
        while(true){
            int count=Randoms.pickNumberInList(numbers);
            coinPrice=coins.get(index);
//            System.out.println("totalPrice = " + totalPrice);
//            System.out.println("count = " + count);
//            System.out.println("coinPrice = " + coinPrice);
            if(totalPrice-count*coinPrice>0){
                String coinName="COIN_"+coinPrice;
                //check
//                System.out.println("coinPrice = " + coinPrice);
                Coin.valueOf(coinName).setCount(count);
//                if(coinPrice==500){
//                    Coin.COIN_500.setCount(count);
//                }
//                if(coinPrice==100){
//                    Coin.COIN_100.setCount(count);
//                }
//                if(coinPrice==50){
//                    Coin.COIN_50.setCount(count);
//                }
//                if(coinPrice==10){
//                    Coin.COIN_10.setCount(count);
//                }
                index++;
                totalPrice-=count*coinPrice;
            }
            if(index==4){
                break;
            }
        }
        int newCount;
        if(totalPrice>500){
            newCount=Coin.COIN_500.getCount()+totalPrice/500;
            Coin.COIN_500.setCount(newCount);
            totalPrice%=500;
        }
        if(totalPrice>100){
            newCount=Coin.COIN_100.getCount()+totalPrice/100;
            Coin.COIN_100.setCount(newCount);
//            Coin.valueOf("COIN_100").count+=totalPrice/100;
            totalPrice%=100;
        }
        if(totalPrice>50){
            newCount=Coin.COIN_50.getCount()+totalPrice/50;
            Coin.COIN_50.setCount(newCount);
//            Coin.valueOf("COIN_50").count+=totalPrice/50;
            totalPrice%=50;
        }
        if(totalPrice>10){
            newCount=Coin.COIN_10.getCount()+totalPrice/10;
            Coin.COIN_10.setCount(newCount);
//            Coin.valueOf("COIN_10").count+=totalPrice/10;
//            totalPrice%=10;
        }


    }
    public static void generateStock(VendingMachine vendingMachine){
        InputView input = new InputView();
        vendingMachine.setStocks(input.addStock());
        setMinPrice(vendingMachine);
    }
    public static void setMinPrice(VendingMachine vendingMachine){
        List<List<String>> stocks = vendingMachine.stocks;
        int minPrice=999999;
        for(List<String> item : stocks){
            int itemPrice = Integer.parseInt(item.get(1));
            if(itemPrice<minPrice){
                minPrice=itemPrice;
            }
        }
        vendingMachine.minPrice=minPrice;
    }
}
