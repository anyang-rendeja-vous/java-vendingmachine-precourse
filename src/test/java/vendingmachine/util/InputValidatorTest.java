package vendingmachine.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class InputValidatorTest {

    @DisplayName("물품이 올바른 형식이 아니면 예외가 발생합니다.")
    @ParameterizedTest
    @CsvSource({
            "'[콜라,1500,20][사이다,1000,10]'",
            "'[콜라,150020]'",
            "'[콜라,1500,20'"
    })
    void inputValidator_invalid(String product) {
        InputValidator inputValidator = new InputValidator();
        assertThatThrownBy(() -> inputValidator.isFormatValid(product))
                .isInstanceOf(IllegalArgumentException.class);
    }
}