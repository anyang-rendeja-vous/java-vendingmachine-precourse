package vendingmachine.domain;

import java.util.Arrays;
import java.util.List;

public class Product {

    private static final Integer DIVISOR = 10;
    private static final Integer MINIMUM_PRICE = 100;
    private static final String PRICE_RANGE_ERROR = "상품 가격은 100원부터 시작해야 합니다.";
    private static final String PRICE_DIVISOR_ERROR = "상품 가격은 10원으로 나누어 떨어져야 합니다.";
    private String name;
    private Integer price;
    private Integer quantity;

    public Product(String products) {
        setProducts(split(products));
        validate(price);
    }

    public void updateQuantity() {
        quantity -= 1;
    }

    public boolean canBuy() {
        return quantity > 0;
    }

    public List<String> split(String products) {
        String substring = products.substring(1, products.length() - 1);
        return Arrays.asList(substring.split(","));
    }

    public void setProducts(List<String> products) {
        name = products.get(0);
        price = Integer.parseInt(products.get(1));
        quantity = Integer.parseInt(products.get(2));
    }

    private void validate(Integer inputPrice) {
        checkPriceRange(inputPrice);
        checkPriceDivisor(inputPrice);
    }

    private void checkPriceRange(Integer inputPrice) {
        if (inputPrice < MINIMUM_PRICE) {
            throw new IllegalArgumentException(PRICE_RANGE_ERROR);
        }
    }

    private void checkPriceDivisor(Integer inputPrice) {
        if (inputPrice % DIVISOR != 0) {
            throw new IllegalArgumentException(PRICE_DIVISOR_ERROR);
        }
    }

    public int sold(int inputMoney) {
        if (inputMoney >= price) {
            inputMoney -= price;
            updateQuantity();
        }
        return inputMoney;
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
