package vendingmachine.domain;

import static java.lang.Math.*;
import static vendingmachine.ui.MessageUtils.INVALID_STOCK_INFO;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Stocks {
    private List<Stock> stocks = new ArrayList<>();

    public Stocks(String input) {
        List<String> parsedInputs = parseStockInput(input);
        for (String parsedInput : parsedInputs) {
            stocks.add(new Stock(parsedInput));
        }
    }

    private List<String> parseStockInput(String input) throws IllegalArgumentException {
        List<String> stocks = new ArrayList<>();

        StringTokenizer tokenizer = new StringTokenizer(input, ";");
        while (tokenizer.hasMoreTokens()) {
            stocks.add(tokenizer.nextToken());
        }

        return stocks;
    }

    public Stock getMatchingStock(String userInput) {
        for (Stock stock : stocks) {
            if (stock.getMerchandise().equals(userInput)) {
                return stock;
            }
        }
        throw new IllegalArgumentException(INVALID_STOCK_INFO.msg());
    }

    public boolean exists(Stock stock) {
        return stock.hasStock();
    }

    public boolean exists() {
        int existingStockCount = 0;
        for (Stock stock : stocks) {
            if (stock.hasStock()){
                existingStockCount++;
            }
        }
        return existingStockCount > 0;
    }

    public boolean canAfford(int usersMoney, Stock stock) {
        return usersMoney >= stock.getPrice();
    }

    public boolean canAfford(int usersMoney) {
        int cheapest = Integer.MAX_VALUE;
        for (Stock stock : stocks) {
            cheapest = min(stock.getPrice(), cheapest);
        }
        return usersMoney >= cheapest;
    }

    public void purchaseStock(Stock stock) {
        stock.purchase();
    }


}
