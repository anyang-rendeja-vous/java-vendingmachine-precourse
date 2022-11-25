package vendingmachine;

public class PrintCommand {
    private static final String COIN_POSSESSION_MESSAGE = "자판기가 보유하고 있는 금액을 입력해 주세요.";

    public void coinPosession(){
        System.out.println(COIN_POSSESSION_MESSAGE);
    }
}
