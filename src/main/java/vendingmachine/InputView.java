package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

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
    public void addStock(){
        print.addStock();

    }

}
