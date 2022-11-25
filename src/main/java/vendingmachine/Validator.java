package vendingmachine;

import camp.nextstep.edu.missionutils.Console;

public class Validator {
    public int coin_possession(){
        int coinPrice;
        try{
            coinPrice = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            try {
                throw new IllegalArgumentException();
            }catch (IllegalArgumentException error){
                System.out.println("ERROR_MESSAGE");
                return 0;
            }
        }
        return coinPrice;
    }
    public int inputCash(){
        int inputPrice;
        try{
            inputPrice = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e){
            try {
                throw new IllegalArgumentException();
            }catch (IllegalArgumentException error){
                System.out.println("ERROR_MESSAGE");
                return 0;
            }
        }
        return inputPrice;
    }
}
