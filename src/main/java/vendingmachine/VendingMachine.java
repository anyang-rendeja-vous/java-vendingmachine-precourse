package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    int minPrice;
    private final int inputPrice;
    public List<List<String>> stocks;
    public Coin coins;

    public VendingMachine(int inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void setStocks(List<List<String>> stocks) {
        this.stocks = stocks;
    }
    public void setCoins(Coin coins){
        this.coins=coins;
    }

    //
    public int setStockNum(String itemName){
        for(List<String>item: stocks){
            if(item.get(0).equals(itemName)){
                int leftStock=Integer.parseInt(item.get(2))-1;
                item.set(2,String.valueOf(leftStock));
                return Integer.parseInt(item.get(1));
            }
        }
        return 0;
    }

}
