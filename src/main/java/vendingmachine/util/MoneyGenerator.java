package vendingmachine.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class MoneyGenerator {

    public static Integer generate(List<Integer> coins) {
        return Randoms.pickNumberInList(coins);
    }
}
