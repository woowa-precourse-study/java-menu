package menu.domain.categorygenerator;

import camp.nextstep.edu.missionutils.Randoms;
import menu.domain.Category;
import menu.domain.CategoryGenerator;

public class RandomCategoryGenerator implements CategoryGenerator {
    private static final int MINIMUM_CATEGORY_VALUE = 1;
    private static final int MAXIMUM_CATEGORY_VALUE = 5;

    @Override
    public Category generate() {
        int randomValue = Randoms.pickNumberInRange(MINIMUM_CATEGORY_VALUE, MAXIMUM_CATEGORY_VALUE);

        return Category.valueOf(randomValue);
    }
}
