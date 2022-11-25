package vendingmachine;

public class PrintCommand {
    private static final String COIN_POSSESSION_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String STOCK_MESSAGE = "상품명과 가격, 수량을 입력해 주세요.";
    public void coinPosession(){
        System.out.println(COIN_POSSESSION_MESSAGE);
    }
    public void addStock(){
        System.out.println(STOCK_MESSAGE);
    }
}
