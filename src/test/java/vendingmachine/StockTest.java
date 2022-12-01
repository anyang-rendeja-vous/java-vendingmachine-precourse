package vendingmachine;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static vendingmachine.ui.MessageUtils.INVALID_STOCKS_INPUT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.Stock;

class StockTest {

    @DisplayName("잘못된 상품 형식 입력 시, 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"kkk,400,3]", "sk,300,3", "[jjj,-1,2], [xx, ,10]"})
    void 생성_예외테스트(String input){
        assertThatThrownBy(() -> new Stock(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_STOCKS_INPUT.msg());
    }

    @DisplayName("정상 입력 시, Stock 생성")
    @Test
    void 정상입력시_생성(){
        Stock stock = new Stock("[cola,100,5]");
        assertThat(stock.hasStock()).isEqualTo(true);
    }

}