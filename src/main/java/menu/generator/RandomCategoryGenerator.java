package menu.generator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.constant.Category;

public final class RandomCategoryGenerator {

    public static String generateCategory() {
        int index = Randoms.pickNumberInRange(1, 5);
        return Category.fromIndex(index).getName();
    }
}
