package vendingmachine;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView output = new OutputView();
        int coinTotalPrice= getCoinPrice();
        VendingMachine vendingMachine = new VendingMachine(coinTotalPrice);
        System.out.println("설치완료");
        generateCoins(coinTotalPrice);
        System.out.println("동전생성");
        output.printCoins();
        generateStock(vendingMachine);
        int change=chooseItem(vendingMachine);
//        System.out.println("change = " + change);;
        List<Integer> changeCount=calculateChange(vendingMachine,change);
//        System.out.println("changeCount = " + changeCount);
        output.printChange(changeCount);




    }
    public static List<Integer> calculateChange(VendingMachine vendingMachine,int change){
        List<Integer> changeCount=Arrays.asList(0,0,0,0);
        List<Integer> num=Arrays.asList(500,100,50,10);
        int index=0;
        for(int price:num){
            if(change>price){
                int left=Coin.valueOf("COIN_"+price).getCount();
                int wanted=change/price;
                if(left>=wanted){
                    changeCount.set(index,wanted);
                    change-=wanted*price;
                }
                if(left<wanted){
                    changeCount.set(index,left);
                    change-=left*price;
                }
            }
            index++;
        }
        return changeCount;
    }
    public static int chooseItem(VendingMachine vendingMachine){
        InputView input = new InputView();
        int inputPrice= input.getCash();
        int change=input.chooseItem(vendingMachine,inputPrice);
        return change;
    }

    public static int getCoinPrice(){
        InputView input = new InputView();
        int price= input.coin_inside();
        return price;
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
            if(totalPrice-count*coinPrice>0){
                String coinName="COIN_"+coinPrice;
                Coin.valueOf(coinName).setCount(count);
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
            totalPrice%=100;
        }
        if(totalPrice>50){
            newCount=Coin.COIN_50.getCount()+totalPrice/50;
            Coin.COIN_50.setCount(newCount);
            totalPrice%=50;
        }
        if(totalPrice>10){
            newCount=Coin.COIN_10.getCount()+totalPrice/10;
            Coin.COIN_10.setCount(newCount);
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
