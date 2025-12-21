package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomCategoryNumberGenerator implements RandomNumberGenerator{
    private final static int RANDOM_LOWER_INCLUSIVE = 1;
    private final static int RANDOM_UPPER_INCLUSIVE = 5;


    @Override
    public int generate() {
        return Randoms.pickNumberInRange(RANDOM_LOWER_INCLUSIVE, RANDOM_UPPER_INCLUSIVE);
    }
}
