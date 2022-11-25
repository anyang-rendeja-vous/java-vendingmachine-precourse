package vendingmachine;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    int minPrice;
    private final int inputPrice;
    public List<List<String>> stocks;

    public VendingMachine(int inputPrice) {
        this.inputPrice = inputPrice;
    }

    public void setStocks(List<List<String>> stocks) {
        this.stocks = stocks;
    }

    //
//    public void wrongAnswer() {
//        step++;
//        howFar=step;
//        step = 0;
//    }
//    public void rightAnswer() {
//        step++;
//        howFar=step;
//    }
//
//    public List<String> setMyRoute(int index, String uD) {
//        if (index == 0) {
//            myRoute = new ArrayList<>();
//        }
//        myRoute.add(uD);
//        return myRoute;
//    }


}
