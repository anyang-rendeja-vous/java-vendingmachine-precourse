package vendingmachine.util;

import java.util.regex.Pattern;

public class InputValidator {

    public static boolean checkProduct(String product) {
        return isFormatValid(product);
    }

    public static boolean isFormatValid(String product) {
        return Pattern.matches("^(\\[.+,[0-9]+,[0-9]+])(;(\\[.+,[0-9]+,[0-9]+]))*$", product);
    }
}
