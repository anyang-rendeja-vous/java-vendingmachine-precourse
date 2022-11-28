package vendingmachine.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Products {

    private static final String NOT_EXISTED_PRODUCTION = "존재하지 않는 상품입니다.";
    private final List<Product> products = new ArrayList<>();

    public Products(String products) {
        initialize(products);
    }

    public Product getProduct(String productName) {
        return products.stream()
                .filter(product -> product.getName().equals(productName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(NOT_EXISTED_PRODUCTION));
    }

    public void initialize(String products) {
        Arrays.asList(products.split(";"))
                .forEach(product -> this.products.add(new Product(product)));
    }

    public boolean isOutOfStock() {
        return products.size() == products.stream()
                .filter(product -> !product.canBuy())
                .count();
    }

    public Integer getMinimumPrice() {
        return products.stream()
                .map(Product::getPrice)
                .min(Integer::compareTo)
                .orElse(null);
    }
}
