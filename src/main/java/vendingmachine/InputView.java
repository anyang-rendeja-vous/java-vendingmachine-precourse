package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private static final String ERROR_MESSAGE = "[ERROR]";
    PrintCommand print = new PrintCommand();
    Validator validate =new Validator();
    public int coin_inside(){
        int coinPrice;
        while(true){
            print.coinPosession();
            coinPrice = validate.coin_possession();
            if(coinPrice!=0){
                break;
            }
        }
        return coinPrice;
    }
    public List<List<String>> addStock(){
        List<List<String>> stock = new ArrayList<>();
        print.addStock();
        String[] input = Console.readLine().split(";");
        for(int loop=0;loop<input.length;loop++){
            input[loop]=input[loop].replace("[","");
            input[loop]=input[loop].replace("]","");
            String[] aboutItem = input[loop].split(",");
            List<String> item = new ArrayList<>();
            for(String info : aboutItem){
                item.add(info);

            }
            stock.add(item);
        }
        return stock;

    }
    public void chooseItem(){

        while(true){
            print.inputCash();
            int buyPrice= validate.cashToBuy();
            print.wantedItem();
            String wantedItem=Console.readLine();
            //없으면 예외처리

//            if(inputPrice)
        }
    }

}
