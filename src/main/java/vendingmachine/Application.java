package vendingmachine;

public class Application {
    public static void main(String[] args) {
        int coinTotalPrice= getCoinPrice();

    }
    public static int getCoinPrice(){
        InputView input = new InputView();
        return input.coin_inside();
    }
    public static void generateCoins(){

    }
}
