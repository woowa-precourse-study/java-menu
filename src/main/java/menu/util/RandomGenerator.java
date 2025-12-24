package menu.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomGenerator {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 5;

    public static int getRandomNumber() {
        return Randoms.pickNumberInRange(START_NUMBER, END_NUMBER);
    }

    public static String getRandomMenu(List<String> menus) {
        return Randoms.shuffle(menus).get(0);
    }



}
