package vendingmachine.domain;

import static vendingmachine.ui.MessageUtils.MONEY_INPUT_ERROR;

public class UsersMoney {
    private int money;

    public UsersMoney(String moneyInput) {
        if (!isValidMoney(moneyInput)) {
            throw new IllegalArgumentException(MONEY_INPUT_ERROR.msg());
        }

        this.money = Integer.parseInt(moneyInput);
    }

    private boolean isValidMoney(String amount) {
        if (!isNull(amount) && isNumeric(amount)) {
            return true;
        }
        return false;
    }

    private boolean isNull(String amount) {
        return amount.isEmpty();
    }

    private boolean isNumeric(String amount) {
        return amount.chars().allMatch(Character::isDigit) && Integer.parseInt(amount) > 0;
    }

    public void buy(int price){
        money -= price;
    }

    public int getMoney() {
        return money;
    }
}
