import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RegexTest {

    @ParameterizedTest
    @ValueSource(strings = {"[콜,1500,20]", "[사이,1000,10]"})
    void regex(String input){
        assertThat(input.matches("^\\[[^0-9]+,[1-9][0-9][0-9]+,[0-9]+\\]$"))
                .isEqualTo(true);
    }

}
